package br.supermercado.Telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroUsuario extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public CadastroUsuario() {
		setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(30, 63, 30, 14);
		add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(60, 60, 94, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(189, 63, 71, 14);
		add(lblIdCliente);
		
		textField = new JTextField();
		textField.setBounds(254, 60, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(350, 63, 49, 14);
		add(lblSenha);
		
		textField_2 = new JTextField();
		textField_2.setBounds(401, 60, 288, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(595, 91, 94, 20);
		add(btnSalvar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(486, 91, 94, 20);
		add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(373, 91, 94, 20);
		add(btnExcluir);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 122, 659, 372);
		add(panel);

	}
}
