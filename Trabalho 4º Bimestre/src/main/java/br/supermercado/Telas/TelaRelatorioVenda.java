package br.supermercado.Telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaRelatorioVenda extends JPanel {
	private JTextField textField;
	private JTable tblVendas;

	/**
	 * Create the panel.
	 */
	public TelaRelatorioVenda() {
		setLayout(null);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(36, 50, 76, 14);
		add(lblFiltrarPor);
		
		JRadioButton rdbtnPorDia = new JRadioButton("Por dia");
		rdbtnPorDia.setBounds(118, 46, 76, 23);
		add(rdbtnPorDia);
		
		JRadioButton rdbtnPorMs = new JRadioButton("Por m\u00EAs");
		rdbtnPorMs.setBounds(306, 46, 81, 23);
		add(rdbtnPorMs);
		
		JRadioButton rdbtnCategoriaDeProduto = new JRadioButton("Categoria de produto");
		rdbtnCategoriaDeProduto.setBounds(548, 46, 145, 23);
		add(rdbtnCategoriaDeProduto);
		
		JRadioButton rdbtnNomeCliente = new JRadioButton("Nome cliente");
		rdbtnNomeCliente.setBounds(871, 46, 109, 23);
		add(rdbtnNomeCliente);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 93, 1051, 354);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblVendas = new JTable();
		scrollPane.setViewportView(tblVendas);
		
		textField = new JTextField();
		textField.setBounds(200, 46, 100, 23);
		add(textField);
		textField.setColumns(10);

	}
}
