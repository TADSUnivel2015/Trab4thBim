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
import br.supermercado.DAO.ClienteDAO;
import br.supermercado.DAO.UsuarioDAO;
import br.supermercado.ModelTabelas.TabelaProdutos;
import br.supermercado.ModelTabelas.TabelaUsuarios;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class TelaCadastroUsuario extends JPanel {
	
	private JTextField txtIdCliente;
	private JTextField txtId;
	private JTextField txtSenha;
	private JTable tblUsuarios;
	
	private JComboBox cbNomeCliente;
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public TelaCadastroUsuario() throws SQLException{
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
					usuarioDAO.abrirConexao();
					
					Usuario usuario = new Usuario(Integer.parseInt(txtId.getText()),
							cbNomeCliente.getSelectedItem().toString(),
							Integer.parseInt(txtIdCliente.getText()),
							txtSenha.getText());
					
					usuarioDAO.gravar(usuario);
					tblUsuarios.setModel(new TabelaUsuarios(usuarioDAO.listar()));
					limparCampos();
					
					usuarioDAO.fecharConexao();
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
					usuarioDAO.abrirConexao();
					
					Usuario usuario = new Usuario(Integer.parseInt(txtId.getText()),
							cbNomeCliente.getSelectedItem().toString(),
							Integer.parseInt(txtIdCliente.getText()),
							txtSenha.getText());
					
					usuarioDAO.atualizar(usuario);
					tblUsuarios.setModel((TableModel)new TabelaUsuarios(usuarioDAO.listar()));
					limparCampos();
					
					usuarioDAO.fecharConexao();
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
					usuarioDAO.abrirConexao();
					
					usuarioDAO.excluir(Integer.parseInt(txtId.getText()));
					tblUsuarios.setModel((TableModel)new TabelaUsuarios(usuarioDAO.listar()));
					limparCampos();
					
					usuarioDAO.fecharConexao();
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
		
		clienteDAO.abrirConexao();
		
		Object[] lista = clienteDAO.listar().toArray();
		
		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(lista);
		
		cbNomeCliente = new JComboBox(model);		
		cbNomeCliente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String part = cbNomeCliente.getSelectedItem().toString();
				txtIdCliente.setText(part.substring(part.length()-7,part.length()).trim());
			}
		});
		
		cbNomeCliente.setBounds(220, 60, 437, 20);
		add(cbNomeCliente);
		
		clienteDAO.fecharConexao();
				
		
		try {
			usuarioDAO.abrirConexao();
			
			tblUsuarios.setModel((TableModel)new TabelaUsuarios(usuarioDAO.listar()));
			
			usuarioDAO.fecharConexao();
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
}
