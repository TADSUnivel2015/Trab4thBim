package br.supermercado.Telas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import br.supermercado.Cliente;
import br.supermercado.DAO.ClienteDAO;
import br.supermercado.Enum.Estado;
import br.supermercado.Enum.Genero;
import br.supermercado.ModelTabelas.TabelaClientes;
import br.supermercado.conexao.ConexaoMySQL;

import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;

import org.jfree.ui.tabbedui.RootPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Alex Tezza
 * Dia 30 de outubro de 2015
 */

public class TelaCadastroCliente extends JPanel {
	
	private static TelaCadastroCliente telaCadatroCliente = null;
	
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEmail;
	
	private JFormattedTextField txtTelefone;
	
	private JComboBox cbEstado;
	private JComboBox cbGenero;
	
	private MaskFormatter fmtTelefone;
	private JTable tblClientes;
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	private String sql = "select * from cliente";

	
	public TelaCadastroCliente() throws SQLException {
		setLayout(null);
		
		try {
			fmtTelefone =  new MaskFormatter("(##)####-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(30, 19, 10, 14);
		add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(99, 16, 72, 20);
		add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(181, 19, 37, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(249, 16, 513, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(914, 19, 60, 14);
		add(lblTelefone);

		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(30, 69, 72, 14);
		add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(99, 66, 329, 20);
		add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(438, 69, 45, 14);
		add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(481, 66, 281, 20);
		add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(776, 69, 72, 14);
		add(lblEstado);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 119, 59, 14);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(99, 116, 341, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setBounds(776, 19, 59, 14);
		add(lblGnero);
		
		cbEstado = new JComboBox(Estado.values());
		cbEstado.setBounds(832, 66, 200, 20);
		add(cbEstado);
		
		cbGenero = new JComboBox(Genero.values());
		cbGenero.setBounds(832, 16, 72, 20);
		add(cbGenero);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 154, 1152, 364);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblClientes = new JTable();
		tblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtId.setText(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0)));
				txtNome.setText(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 1)));
				txtTelefone.setText(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 2)));
				txtEndereco.setText(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 3)));
				txtCidade.setText(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 4)));
				txtEmail.setText(String.valueOf(tblClientes.getValueAt(tblClientes.getSelectedRow(), 6)));
				
			}
		});
		scrollPane.setViewportView(tblClientes);
		
		try {
			clienteDAO.abrirConexao();
			tblClientes.setModel((TableModel)new TabelaClientes(clienteDAO.listar(sql)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					clienteDAO.abrirConexao();
					
					Cliente cliente = new Cliente(txtNome.getText(),
							txtTelefone.getText(), txtEndereco.getText(), txtCidade.getText(),
						    cbEstado.getSelectedItem().toString(), txtEmail.getText(),
						    cbGenero.getSelectedItem().toString());
					
					clienteDAO.gravar(cliente);
					tblClientes.setModel((TableModel)new TabelaClientes(clienteDAO.listar(sql)));
					
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				limparCampos();

			}
		});
		btnSalvar.setBounds(1093, 109, 89, 29);
		add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					clienteDAO.abrirConexao();
					
					Cliente cliente = new Cliente(txtNome.getText(),
							txtTelefone.getText(), txtEndereco.getText(), txtCidade.getText(),
						    cbEstado.getSelectedItem().toString(), txtEmail.getText(),
						    cbGenero.getSelectedItem().toString());
					
					clienteDAO.atualizar(cliente);
					tblClientes.setModel((TableModel)new TabelaClientes(clienteDAO.listar(sql)));
					
					JOptionPane.showMessageDialog(null, "Dados do cliente atualizados com sucesso!");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				limparCampos();
			}
		});
		btnAlterar.setBounds(994, 109, 89, 29);
		add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir " + txtNome.getText() + "?");
				
				if (resp == JOptionPane.YES_OPTION == true) {
					
					try {
						clienteDAO.abrirConexao();
						
						clienteDAO.excluir(Integer.parseInt(txtId.getText()));
						tblClientes.setModel((TableModel)new TabelaClientes(clienteDAO.listar(sql)));
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					limparCampos();
					}
			}
		});
		btnExcluir.setBounds(895, 109, 89, 29);
		add(btnExcluir);
		
		txtTelefone = new JFormattedTextField(fmtTelefone);
		txtTelefone.setBounds(984, 16, 163, 20);
		add(txtTelefone);

	}
	
	public void limparCampos(){
		
		txtId.setText("");
		txtNome.setText("");
		txtEndereco.setText("");
		txtCidade.setText("");
		txtEmail.setText("");
		
		txtTelefone.setText("");
		
		cbEstado.setSelectedIndex(0);
		cbGenero.setSelectedIndex(0);
		
	}	

}