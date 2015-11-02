package br.supermercado.Telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;

import br.supermercado.Usuario;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class CadastroUsuario extends JPanel {
	
	private JTextField txtIdCliente;
	private JTextField txtId;
	private JTextField txtSenha;
	private JTable tblUsuarios;
	
	private Usuario usuario = new Usuario();
	
	private JComboBox cbNomeCliente;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public CadastroUsuario() throws SQLException {
		setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(30, 63, 30, 14);
		add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(60, 60, 94, 20);
		add(txtId);
		txtId.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(682, 63, 59, 14);
		add(lblIdCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setBounds(748, 60, 86, 20);
		add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(844, 63, 49, 14);
		add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(892, 60, 288, 20);
		add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(1086, 91, 94, 30);
		add(btnSalvar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(982, 91, 94, 30);
		add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(878, 91, 94, 30);
		add(btnExcluir);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 133, 1150, 372);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblUsuarios = new JTable();
		scrollPane.setViewportView(tblUsuarios);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(164, 63, 46, 14);
		add(lblNome);
		
		abrirConexao();
		
		cbNomeCliente = new JComboBox<Usuario>(new Vector<Usuario>(listarUsuarios()));
		cbNomeCliente.setBounds(220, 60, 437, 20);
		add(cbNomeCliente);
		
		fecharConexao();
		

	}
	
	private void limparCampos(){
		
		txtIdCliente.setText("");
		txtId.setText("");
		txtSenha.setText("");
		
		cbNomeCliente.setSelectedIndex(0);
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
		
		usuario.setId(Integer.parseInt(txtId.getText()));
		usuario.setNomeCliente(cbNomeCliente.getSelectedItem().toString());
		usuario.setIdCliente(txtIdCliente.getText());
		usuario.setSenha(txtSenha.getText());
		
		ps = conexao.prepareStatement(
				"INSERT INTO CLIENTE (ID, NOMEUSUARIO, IdCliente, SENHA)"
						+ "VALUES (?, ?, ?, ?)");
		
		ps.setInt(1, usuario.getId());
		ps.setString(2, usuario.getNomeCliente());
		ps.setString(3, usuario.getIdCliente());
		ps.setString(4, usuario.getSenha());
		
		int res = ps.executeUpdate();
		
		ps.close();
	}
	
	public void atualizar() throws SQLException{
		
		usuario.setId(Integer.parseInt(txtId.getText()));
		
		usuario.setNomeCliente(cbNomeCliente.getSelectedItem().toString());
		usuario.setIdCliente(txtIdCliente.getText());
		usuario.setSenha(txtSenha.getText());
		
		ps = conexao.prepareStatement("UPDATE usuario SET NOMEcliente = '"+usuario.getNomeCliente()
				+"', IdCLIENTE = '"+usuario.getIdCliente()
				+"', SENHA = '"+usuario.getSenha()
				+"' WHERE ID = '"+usuario.getId()+"'");
		
		ps.execute();
		
		ps.close();
		
	}
	
	public void excluir() throws SQLException{
		
		usuario.setId(Integer.parseInt(txtId.getText()));
		
		ps = conexao.prepareStatement("DELETE FROM usuario WHERE ID = ?");
		
		ps.setInt(1, usuario.getId());
		
		ps.execute();
		
		ps.close();
		
	}
	
	public List listarUsuarios() throws SQLException {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		// Atributo que faz a busca no banco.
		ResultSet result;
		
		ps = conexao.prepareStatement("SELECT * FROM usuario");
		
		result = ps.executeQuery();
		
		// Enquanto existe próximo, faça..
		while (result.next()) {
			Usuario novo = new Usuario();
			
			novo.setId(result.getInt("id"));
			novo.setNomeCliente(result.getString("NOMEUSUARIO"));
			novo.setIdCliente(result.getString("IdCLIENTE"));
			novo.setSenha(result.getString("SENHA"));
			
			usuarios.add(novo);
			
		}
		
		result.close();
		
		ps.close();
			
		return usuarios;		
	}
}
