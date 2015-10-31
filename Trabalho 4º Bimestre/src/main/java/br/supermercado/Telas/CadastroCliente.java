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
import java.text.Format;
import java.text.ParseException;
import java.util.Formatter;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.supermercado.Estado;
import br.supermercado.Genero;

import javax.swing.JFormattedTextField;

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
	private JTable tabelaClientes;
	
	private MaskFormatter fmtTelefone;

	public CadastroCliente() {
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
		
		JFormattedTextField txtTelefone = new JFormattedTextField(fmtTelefone);
		txtTelefone.setBounds(984, 16, 163, 20);
		add(txtTelefone);
		
		

	}
}
