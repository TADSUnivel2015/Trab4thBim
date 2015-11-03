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
import javax.swing.table.TableModel;

import br.supermercado.Cliente;
import br.supermercado.Usuario;
import br.supermercado.Tabelas.TabelaProdutos;
import br.supermercado.Tabelas.TabelaUsuarios;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	public CadastroUsuario() throws SQLException{
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
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirConexao();
					gravar();
					tblUsuarios.setModel(new TabelaUsuarios(listarUsuarios()));
					limparCampos();
					fecharConexao();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(1086, 91, 94, 30);
		add(btnSalvar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrirConexao();
					atualizar();
					tblUsuarios.setModel((TableModel)new TabelaUsuarios(listarUsuarios()));
					limparCampos();
					fecharConexao();
				} catch (SQLException f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
			}
		});
		btnAtualizar.setBounds(982, 91, 94, 30);
		add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrirConexao();
					excluir();
					tblUsuarios.setModel((TableModel)new TabelaUsuarios(listarUsuarios()));
					limparCampos();
					fecharConexao();
				} catch (SQLException g) {
					// TODO Auto-generated catch block
					g.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(878, 91, 94, 30);
		add(btnExcluir);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 133, 1150, 372);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tblUsuarios = new JTable();
		tblUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtId.setText(String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0)));
				txtIdCliente.setText(String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 2)));
				txtSenha.setText(String.valueOf(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 3)));
			}
		});
		scrollPane.setViewportView(tblUsuarios);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(164, 63, 46, 14);
		add(lblNome);
		
		
		
		CadastroCliente cliente = new CadastroCliente();
		cliente.abrirConexao();
		
		Object[] lista = cliente.listarClientes().toArray();
		
		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(lista);
		
		cbNomeCliente = new JComboBox(model);		
		cbNomeCliente.setBounds(220, 60, 437, 20);
		add(cbNomeCliente);
		
		cliente.fecharConexao();
		try {
			abrirConexao();
			
			tblUsuarios.setModel((TableModel)new TabelaUsuarios(listarUsuarios()));
			
			fecharConexao();
		} catch (SQLException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	
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
		usuario.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
		usuario.setSenha(txtSenha.getText());
		
		ps = conexao.prepareStatement(
				"INSERT INTO usuario (ID, NOMECLIENTE, IDCLIENTE, SENHA)"
						+ "VALUES (?, ?, ?, ?)");
		
		ps.setInt(1, usuario.getId());
		ps.setString(2, usuario.getNomeCliente());
		ps.setInt(3, usuario.getIdCliente());
		ps.setString(4, usuario.getSenha());
		
		int res = ps.executeUpdate();
		
		ps.close();
	}
	
	public void atualizar() throws SQLException{
		
		usuario.setId(Integer.parseInt(txtId.getText()));
		
		usuario.setNomeCliente(cbNomeCliente.getSelectedItem().toString());
		usuario.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
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
	
	public List<Usuario> listarUsuarios() throws SQLException{
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		// Atributo que faz a busca no banco.
		ResultSet result;
		
		ps = conexao.prepareStatement("SELECT * FROM usuario");
		
		result = ps.executeQuery();
		
		// Enquanto existe próximo, faça..
		while (result.next()) {
			Usuario novo = new Usuario();
			
			novo.setId(result.getInt("id"));
			novo.setNomeCliente(result.getString("NOMEcliente"));
			novo.setIdCliente(result.getInt("IdCLIENTE"));
			novo.setSenha(result.getString("SENHA"));
			
			usuarios.add(novo);
			
		}
		
		result.close();
		
		ps.close();
			
		return usuarios;		
	}
}
