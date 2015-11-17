package br.supermercado.Telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

import br.supermercado.Enum.Categoria;
import br.supermercado.Enum.Mes;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class TelaRelatorioVenda extends JPanel {
	private JTable tblGenerica;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNomeCliente;

	/**
	 * Create the panel.
	 */
	public TelaRelatorioVenda() {
		setLayout(null);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setBounds(36, 50, 76, 14);
		add(lblFiltrarPor);
		
		JRadioButton rdDia = new JRadioButton("Por dia");
		buttonGroup.add(rdDia);
		rdDia.setBounds(118, 46, 69, 23);
		add(rdDia);
		
		JRadioButton rbMes = new JRadioButton("Por m\u00EAs");
		buttonGroup.add(rbMes);
		rbMes.setBounds(290, 46, 81, 23);
		add(rbMes);
		
		JRadioButton rbCategoria = new JRadioButton("Categoria de produto");
		buttonGroup.add(rbCategoria);
		rbCategoria.setBounds(536, 46, 145, 23);
		add(rbCategoria);
		
		JRadioButton rbNomeCliente = new JRadioButton("Nome cliente");
		buttonGroup.add(rbNomeCliente);
		rbNomeCliente.setBounds(817, 46, 99, 23);
		add(rbNomeCliente);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 144, 1217, 441);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.NORTH);
		
		tblGenerica = new JTable();
		scrollPane.setViewportView(tblGenerica);
		
		JComboBox cbMes = new JComboBox(Mes.values());
		cbMes.setMaximumRowCount(12);
		cbMes.setBounds(377, 46, 153, 23);
		add(cbMes);
		
		JComboBox cbCategoria = new JComboBox(Categoria.values());
		cbCategoria.setMaximumRowCount(12);
		cbCategoria.setBounds(687, 46, 124, 23);
		add(cbCategoria);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(922, 46, 228, 23);
		add(txtNomeCliente);
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.setBounds(1160, 46, 93, 23);
		add(btnNewButton);
		
		JButton button = new JButton("Exportar para PDF");
		button.setBounds(1078, 92, 175, 31);
		add(button);
		
		JButton button_1 = new JButton("Pesquisar");
		button_1.setBounds(893, 92, 175, 31);
		add(button_1);
		
		JFormattedTextField txtDia = new JFormattedTextField();
		txtDia.setBounds(193, 47, 93, 20);
		add(txtDia);

	}
}
