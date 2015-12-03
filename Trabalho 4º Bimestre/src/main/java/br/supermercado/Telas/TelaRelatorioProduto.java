package br.supermercado.Telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JRadioButton;

import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.sf.jasperreports.engine.JRException;
import br.supermercado.DAO.ProdutoDAO;
import br.supermercado.Enum.Categoria;
import br.supermercado.ModelTabelas.TabelaProdutos;
import br.supermercado.RelatorioJasper.JasperReportExemple;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class TelaRelatorioProduto extends JPanel {

	private JTextField txtMargemLucro;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cbCategoria;
	private JTable tblProduto;
	
	private Boolean status = false;

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	JasperReportExemple jasperReport = new JasperReportExemple();
	
	private String localArquivoRelatorio = "C:\\Users\\Alex Tezza\\git\\Trab4thBim\\Trabalho 4º Bimestre"
			+ "\\src\\main\\resources\\Relatorios\\RelatorioProdutos.jrxml";

	private String consultaSQL;

	/**
	 * Create the panel.
	 */
	public TelaRelatorioProduto() {
		setLayout(null);

		JLabel lblFiltrarProdutoPor = new JLabel("Filtrar Produto por:");
		lblFiltrarProdutoPor.setBounds(38, 49, 142, 14);
		add(lblFiltrarProdutoPor);

		JRadioButton rbCategoria = new JRadioButton("Categoria");
		rbCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				txtMargemLucro.setEnabled(false);

				cbCategoria.setEnabled(true);
			}
		});
		buttonGroup.add(rbCategoria);
		rbCategoria.setBounds(186, 45, 119, 23);
		add(rbCategoria);

		JRadioButton rbMargemLucro = new JRadioButton("Margem de lucro maior que:");
		rbMargemLucro.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				cbCategoria.setEnabled(false);

				txtMargemLucro.setEnabled(true);
			}
		});
		buttonGroup.add(rbMargemLucro);
		rbMargemLucro.setBounds(546, 45, 193, 23);
		add(rbMargemLucro);

		cbCategoria = new JComboBox(Categoria.values());
		cbCategoria.setEnabled(false);
		cbCategoria.setBounds(311, 46, 193, 20);
		add(cbCategoria);

		txtMargemLucro = new JTextField();
		txtMargemLucro.setEnabled(false);
		txtMargemLucro.setBounds(745, 46, 73, 20);
		add(txtMargemLucro);
		txtMargemLucro.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(38, 98, 1193, 403);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		tblProduto = new JTable();
		scrollPane.setViewportView(tblProduto);

		JButton btnExportarParaPdf = new JButton("Exportar para PDF");
		btnExportarParaPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (status == true) {
				
					try {
						jasperReport.gerar(localArquivoRelatorio, consultaSQL, "RelatórioProdutos");
					} catch (ClassNotFoundException | JRException | SQLException
							| IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Clique em Pesquisar antes de Exportar para PDF!");
				}
				
				status = false;
			}
		});
		btnExportarParaPdf.setBounds(1056, 37, 175, 31);
		add(btnExportarParaPdf);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				status = true;
				
				if (rbCategoria.isSelected() == false || rbMargemLucro.isSelected() == false){
					
					if (rbCategoria.isSelected()) {

						String categoria = cbCategoria.getSelectedItem().toString();
						consultaSQL = "select * from produto where categoria = '" + categoria + "'";
					}
					else{

						String margemLucro = txtMargemLucro.getText();
						consultaSQL = "select * from produto where margemlucro >= '" + margemLucro + "'";

					}

					try {

						produtoDAO.abrirConexao();

						tblProduto.setModel(new TabelaProdutos(produtoDAO.listar(consultaSQL)));

						limparcampos();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Por gentileza, selecione Categoria ou Margem de lucro!");
				}
			}

			private void limparcampos() {

				cbCategoria.setSelectedIndex(0);
				txtMargemLucro.setText("");

			}
		});
		btnPesquisar.setBounds(871, 37, 175, 31);
		add(btnPesquisar);

	}
}
