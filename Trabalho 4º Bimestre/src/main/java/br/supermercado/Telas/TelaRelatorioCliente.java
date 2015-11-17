package br.supermercado.Telas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import br.supermercado.DAO.ClienteDAO;
import br.supermercado.Enum.Estado;
import br.supermercado.ModelTabelas.TabelaClientes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaRelatorioCliente extends JPanel {
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCidade;
	private JComboBox cbEstado;
	
	private String consultaSQL;
	private JTable tblClientes;
	
	private ClienteDAO clienteDAO = new ClienteDAO();

	/**
	 * Create the panel.
	 */
	public TelaRelatorioCliente() {
		setLayout(null);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFiltrarPor.setBounds(33, 58, 91, 14);
		add(lblFiltrarPor);
		
		JRadioButton rbCidade = new JRadioButton("Cidade");
		rbCidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				cbEstado.setEnabled(false);
				
				txtCidade.setEnabled(true);
				
			}
		});
		buttonGroup.add(rbCidade);
		rbCidade.setBounds(130, 55, 74, 23);
		add(rbCidade);
		
		JRadioButton rbEstado = new JRadioButton("Estado");
		rbEstado.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				txtCidade.setEnabled(false);
				
				cbEstado.setEnabled(true);
				
			}
		});
		buttonGroup.add(rbEstado);
		rbEstado.setBounds(549, 55, 81, 23);
		add(rbEstado);
		
		cbEstado = new JComboBox(Estado.values());
		cbEstado.setEnabled(false);
		cbEstado.setBounds(636, 56, 81, 20);
		add(cbEstado);
		
		txtCidade = new JTextField();
		txtCidade.setEnabled(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(212, 55, 317, 20);
		add(txtCidade);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 108, 1254, 425);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblClientes = new JTable();
		scrollPane.setViewportView(tblClientes);
		
		JButton button = new JButton("Pesquisar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (rbCidade.isSelected() || rbEstado.isSelected()){
					
					if (rbCidade.isSelected()){
						
						consultaSQL = "select * from cliente where cidade = '" + txtCidade.getText() + "'";
						
					} else {
						
						consultaSQL = "select * from cliente where estado = '" +  cbEstado.getSelectedItem().toString() + "'";
						
					}
					
					try {
						clienteDAO.abrirConexao();
						
						tblClientes.setModel(new TabelaClientes(clienteDAO.listar(consultaSQL)));
						
						limparCampos();
						
						clienteDAO.fecharConexao();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Por gentileza, selecione um filtro de pesquisa.");
				}
				
			}

			private void limparCampos() {
			
				txtCidade.setText("");
				
				cbEstado.setSelectedIndex(0);
				
			}
		});
		button.setBounds(927, 51, 175, 31);
		add(button);
		
		JButton button_1 = new JButton("Exportar para PDF");
		button_1.setBounds(1112, 51, 175, 31);
		add(button_1);

	}
}
