package br.supermercado.Telas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

import br.supermercado.DAO.ClienteDAO;
import br.supermercado.DAO.VendaDAO;
import br.supermercado.Enum.Categoria;
import br.supermercado.Enum.Mes;
import br.supermercado.ModelTabelas.TabelaClientes;
import br.supermercado.ModelTabelas.TabelaProdutos;
import br.supermercado.ModelTabelas.TabelaVendas;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaRelatorioVenda extends JPanel {
	
	private JTable tblGenerica;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNomeCliente;
	
	private int flag = 1;
	private JFormattedTextField txtDia;
	private JComboBox cbMes;
	
	private String consultaSQL = null;
	
	private VendaDAO vendaDAO = new VendaDAO();
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	private int idCliente;

	/**
	 * Create the panel.
	 */
	public TelaRelatorioVenda() {
		setLayout(null);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(36, 50, 76, 14);
		add(lblFiltrarPor);
		
		JRadioButton rbDia = new JRadioButton("Por dia");
		buttonGroup.add(rbDia);
		rbDia.setBounds(118, 46, 69, 23);
		add(rbDia);
		
		JRadioButton rbMes = new JRadioButton("Por m\u00EAs");
		buttonGroup.add(rbMes);
		rbMes.setBounds(290, 46, 81, 23);
		add(rbMes);
		
		JRadioButton rbCategoria = new JRadioButton("Categoria de produto");
		buttonGroup.add(rbCategoria);
		rbCategoria.setBounds(536, 46, 145, 23);
		add(rbCategoria);
		
		JRadioButton rbNomeCliente = new JRadioButton("Nome cliente");
		buttonGroup.add(rbNomeCliente);
		rbNomeCliente.setBounds(817, 46, 99, 23);
		add(rbNomeCliente);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 144, 1217, 441);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.SOUTH);
		
		tblGenerica = new JTable();
		tblGenerica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (flag == 1) {
					
					txtNomeCliente.setText(String.valueOf(tblGenerica.getValueAt(tblGenerica.getSelectedRow(), 1)));
					
					idCliente = (int) tblGenerica.getValueAt(tblGenerica.getSelectedRow(), 0);
					
				}
				
			}
		});
		scrollPane.setViewportView(tblGenerica);
		
		cbMes = new JComboBox(Mes.values());
		cbMes.setMaximumRowCount(12);
		cbMes.setBounds(377, 46, 153, 23);
		add(cbMes);
		
		JComboBox cbCategoria = new JComboBox(Categoria.values());
		cbCategoria.setMaximumRowCount(12);
		cbCategoria.setBounds(687, 46, 120, 23);
		add(cbCategoria);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(922, 46, 228, 23);
		add(txtNomeCliente);
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				flag = 1;
				
				String consultaSQL = "select * from cliente where nome like '%" + txtNomeCliente.getText() + "%' order by id";
				
				try {
					clienteDAO.abrirConexao();
					
					tblGenerica.setModel(new TabelaClientes(clienteDAO.listar(consultaSQL)));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		btnNewButton.setBounds(1160, 46, 93, 23);
		add(btnNewButton);
		
		JButton button = new JButton("Exportar para PDF");
		button.setBounds(1078, 92, 175, 31);
		add(button);
		
		JButton button_1 = new JButton("Pesquisar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				flag = 2;
				
				if (!rbDia.isSelected() == false
						|| !rbMes.isSelected() == false
						|| !rbCategoria.isSelected() == false
						|| !rbNomeCliente.isSelected() == false){
					
					if (rbDia.isSelected()) {

						String dia = txtDia.getText();
						consultaSQL = "SELECT * FROM venda WHERE DAY(datavenda) = '" + dia + "'";
					}
					
					if (rbMes.isSelected()) {

						int mes = cbMes.getSelectedIndex() + 1;
						
						consultaSQL = "SELECT * FROM venda WHERE MONTH(datavenda) = '" + mes + "'";
					}
					
					if (rbCategoria.isSelected()) {

						String categoria = cbCategoria.getSelectedItem().toString();
						consultaSQL = "SELECT * FROM venda NATURAL JOIN itemvenda WHERE itemvenda.categoria =  '" + categoria + "'";
					}
					
					if (rbNomeCliente.isSelected()) {

						String nomeCliente = txtNomeCliente.getText();
						
						consultaSQL = "SELECT * FROM venda NATURAL JOIN cliente WHERE cliente.nome = '" + nomeCliente + "' AND venda.idcliente = cliente.id";
					}
					
					try {

						vendaDAO.abrirConexao();

						tblGenerica.setModel(new TabelaVendas(vendaDAO.listar(consultaSQL)));

	//					limparcampos();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Por gentileza, selecione um filtro de pesquisa!");
				}
//				
			}

			private void limparcampos() {
				
				txtDia.setText("");
				txtNomeCliente.setText("");
				
				cbMes.setSelectedIndex(0);
				cbCategoria.setSelectedIndex(0);
				
			}
		});
		button_1.setBounds(893, 92, 175, 31);
		add(button_1);
		
		txtDia = new JFormattedTextField();
		txtDia.setBounds(193, 47, 93, 20);
		add(txtDia);

	}
}
