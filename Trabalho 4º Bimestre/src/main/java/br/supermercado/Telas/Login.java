package br.supermercado.Telas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JButton;

public class Login extends JPanel {
	
	private JTextField textField;
	private JPasswordField txtPass;
	private JButton btnEntrar;

	public Login() {
		setBackground(Color.LIGHT_GRAY);
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setLayout(null);

		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(22, 67, 36, 14);
		add(lblUsurio);

		textField = new JTextField();
		textField.setBounds(63, 64, 365, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setBounds(22, 134, 30, 14);
		add(lblNewLabel);

		txtPass = new JPasswordField();
		txtPass.setBounds(63, 131, 365, 20);
		add(txtPass);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(199, 162, 63, 50);
		add(btnEntrar);
	}

	public Login(Runnable acaoOk) {
		this();
		btnEntrar.addActionListener(e -> {
			if (textField.getText().trim().equals("admin")
					&& new String(txtPass.getPassword()).equals("admin")) {
				acaoOk.run();
			} else {
				JOptionPane.showMessageDialog(Login.this,
						"Usuário e/ou senha inválidos!");
			}
		});

	}

}
