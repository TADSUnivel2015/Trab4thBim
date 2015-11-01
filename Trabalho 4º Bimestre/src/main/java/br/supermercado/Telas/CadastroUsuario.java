package br.supermercado.Telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;

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
	
	private JComboBox cbNomeCliente;

	/**
	 * Create the panel.
	 */
	public CadastroUsuario() {
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
		
		cbNomeCliente = new JComboBox();
		cbNomeCliente.setBounds(220, 60, 437, 20);
		add(cbNomeCliente);

	}
	
	private void limparCampos(){
		
		txtIdCliente.setText("");
		txtId.setText("");
		txtSenha.setText("");
		
		cbNomeCliente.setSelectedIndex(0);
	}
}
