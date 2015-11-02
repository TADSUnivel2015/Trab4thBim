package br.supermercado.Telas;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import br.supermercado.Estado;
import br.supermercado.Genero;
import br.supermercado.Tabelas.TabelaClientes;

import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Alex Tezza
 * Dia 30 de outubro de 2015
 */

public class CadastroCliente extends JPanel {
	
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
	
	private Cliente cliente = new Cliente();
	
	private long idControle;
	
	public CadastroCliente() throws SQLException {
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
//				setText(String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0)));
//				ID, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO
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
			abrirConexao();
			tblClientes.setModel((TableModel)new TabelaClientes(listarClientes()));
			fecharConexao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					abrirConexao();
					gravar();
					tblClientes.setModel((TableModel)new TabelaClientes(listarClientes()));
					fecharConexao();
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
					abrirConexao();
					atualizar();
					tblClientes.setModel((TableModel)new TabelaClientes(listarClientes()));
					fecharConexao();
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
				try {
					abrirConexao();
					excluir();
					tblClientes.setModel((TableModel)new TabelaClientes(listarClientes()));
					fecharConexao();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				limparCampos();
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
	
	
	/**
	 * Daqui para baixo é feito a parte de comunicação com o Banco de Dados....
	 */
	
	Connection conexao = null;
	private PreparedStatement ps;
	
	public void abrirConexao() throws SQLException{ 
		String url = "jdbc:postgresql://localhost:5432/Trabalho4thBim";
		String user = "postgres";
		String pass = "tezza";
		
		conexao = DriverManager.getConnection(url, user, pass);
		
	}
	
	public void fecharConexao() throws SQLException {
		conexao.close();
	}
	
	public void gravar() throws SQLException{
		
		cliente.setId(Integer.parseInt(txtId.getText()));
		cliente.setNome(txtNome.getText());
		cliente.setTelefone(txtTelefone.getText());
		cliente.setEndereco(txtEndereco.getText());
		cliente.setCidade(txtCidade.getText());
		cliente.setEstado(cbEstado.getSelectedItem().toString());
		cliente.setEmail(txtEmail.getText());
		cliente.setGenero(cbGenero.getSelectedItem().toString());
		
		ps = conexao.prepareStatement(
				"INSERT INTO CLIENTE (ID, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		
		ps.setInt(1, cliente.getId());
		ps.setString(2, cliente.getNome());
		ps.setString(3, cliente.getTelefone());
		ps.setString(4, cliente.getEndereco());
		ps.setString(5, cliente.getCidade());
		ps.setString(6, cliente.getEstado());
		ps.setString(7, cliente.getEmail());
		ps.setString(8, cliente.getGenero());
		
		int res = ps.executeUpdate();
		
		ps.close();
	}
	
	public void atualizar() throws SQLException{
		
		cliente.setId(Integer.parseInt(txtId.getText()));
		
		cliente.setNome(txtNome.getText());
		cliente.setTelefone(txtTelefone.getText());
		cliente.setEndereco(txtEndereco.getText());
		cliente.setCidade(txtCidade.getText());
		cliente.setEstado(cbEstado.getSelectedItem().toString());
		cliente.setEmail(txtEmail.getText());
		cliente.setGenero(cbGenero.getSelectedItem().toString());
		
		ps = conexao.prepareStatement("UPDATE CLIENTE SET NOME = '"+cliente.getNome()
				+"', TELEFONE = '"+cliente.getTelefone()
				+"', ENDERECO = '"+cliente.getEndereco()
				+"', CIDADE   = '"+cliente.getCidade()
				+"', ESTADO   = '"+cliente.getEstado()
				+"', EMAIL    = '"+cliente.getEmail()
				+"', GENERO   = '"+cliente.getGenero()
				+"' WHERE ID = '"+cliente.getId()+"'");
		
		ps.execute();
		
		ps.close();
		
	}
	
	public void excluir() throws SQLException{
		
		cliente.setId(Integer.parseInt(txtId.getText()));
		
		ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE ID = ?");
		
		ps.setInt(1, cliente.getId());
		
		ps.execute();
		
		ps.close();
		
	}
	
	public List listarClientes() throws SQLException {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		// Atributo que faz a busca no banco.
		ResultSet result;
		
		ps = conexao.prepareStatement("SELECT * FROM cliente");
		
		result = ps.executeQuery();
		
		// Enquanto existe próximo, faça..
		while (result.next()) {
			Cliente novo = new Cliente();
			
			novo.setId(result.getInt("id"));
			novo.setNome(result.getString("nome"));
			novo.setTelefone(result.getString("telefone"));
			novo.setEndereco(result.getString("endereco"));
			novo.setCidade(result.getString("cidade"));
			novo.setEstado(result.getString("estado"));
			novo.setEmail(result.getString("email"));
			novo.setGenero(result.getString("genero"));
			clientes.add(novo);
			
		}
		
		result.close();
		
		ps.close();
			
		return clientes;		
	}
}
