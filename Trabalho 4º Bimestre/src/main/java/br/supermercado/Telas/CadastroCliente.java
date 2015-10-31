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

import javax.swing.JTextField;

import br.supermercado.Estado;
import br.supermercado.Genero;

/**
 * 
 * @author Alex Tezza
 * Dia 30 de outubro de 2015
 */

public class CadastroCliente extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTable tabelaClientes;

	public CadastroCliente() {
		setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(30, 19, 10, 14);
		add(lblId);
		
		textField = new JTextField();
		textField.setBounds(99, 16, 72, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(181, 19, 37, 14);
		add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(249, 16, 513, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(914, 19, 58, 14);
		add(lblTelefone);
		
		textField_2 = new JTextField();
		textField_2.setBounds(982, 16, 200, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(30, 69, 72, 14);
		add(lblEndereo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(99, 66, 329, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(438, 69, 45, 14);
		add(lblCidade);
		
		textField_4 = new JTextField();
		textField_4.setBounds(481, 66, 281, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(776, 69, 72, 14);
		add(lblEstado);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 119, 59, 14);
		add(lblEmail);
		
		textField_6 = new JTextField();
		textField_6.setBounds(99, 116, 341, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setBounds(776, 19, 59, 14);
		add(lblGnero);
		
		JComboBox cbEstado = new JComboBox(Estado.values());
		cbEstado.setBounds(832, 66, 200, 20);
		add(cbEstado);
		
		JComboBox cbGenero = new JComboBox(Genero.values());
		cbGenero.setBounds(832, 16, 72, 20);
		add(cbGenero);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 154, 1152, 220);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tabelaClientes = new JTable();
		panel.add(tabelaClientes, BorderLayout.CENTER);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(673, 115, 89, 23);
		add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(574, 115, 89, 23);
		add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(475, 115, 89, 23);
		add(btnExcluir);
		
		

	}
}
