package br.supermercado.Telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class TelaRelatorioCliente extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCidade;

	/**
	 * Create the panel.
	 */
	public TelaRelatorioCliente() {
		setLayout(null);
		
		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
		lblFiltrarPor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFiltrarPor.setBounds(33, 58, 91, 14);
		add(lblFiltrarPor);
		
		JRadioButton rbCidade = new JRadioButton("Cidade");
		buttonGroup.add(rbCidade);
		rbCidade.setBounds(130, 55, 74, 23);
		add(rbCidade);
		
		JRadioButton rbEstado = new JRadioButton("Estado");
		buttonGroup.add(rbEstado);
		rbEstado.setBounds(549, 55, 81, 23);
		add(rbEstado);
		
		JComboBox cbEstado = new JComboBox(new Object[]{});
		cbEstado.setEnabled(false);
		cbEstado.setBounds(636, 56, 81, 20);
		add(cbEstado);
		
		txtCidade = new JTextField();
		txtCidade.setEnabled(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(212, 55, 317, 20);
		add(txtCidade);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 108, 1254, 425);
		add(panel);
		
		JButton button = new JButton("Pesquisar");
		button.setBounds(927, 51, 175, 31);
		add(button);
		
		JButton button_1 = new JButton("Exportar para PDF");
		button_1.setBounds(1112, 51, 175, 31);
		add(button_1);

	}
}
