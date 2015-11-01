package br.supermercado.Telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.supermercado.Categoria;
import br.supermercado.Unidade;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class CadastroProduto extends JPanel {
	private JTextField txtId;
	private JTextField txtCodigoBarras;
	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtMargemLucro;
	
	private JComboBox cbCategoria;
	private JComboBox cbUnidade;
	
	private JTable tblProdutos;

	/**
	 * Create the panel.
	 */
	public CadastroProduto() {
		setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(65, 33, 21, 14);
		add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(96, 30, 86, 20);
		add(txtId);
		txtId.setColumns(10);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo de Barras");
		lblCdigoDeBarras.setBounds(192, 33, 99, 14);
		add(lblCdigoDeBarras);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(299, 30, 170, 20);
		add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(479, 33, 70, 14);
		add(lblCategoria);
		
		cbCategoria = new JComboBox(Categoria.values());
		cbCategoria.setBounds(544, 30, 234, 20);
		add(cbCategoria);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(65, 69, 70, 14);
		add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(130, 66, 500, 20);
		add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(834, 33, 56, 14);
		add(lblUnidade);
		
		cbUnidade = new JComboBox(Unidade.values());
		cbUnidade.setBounds(900, 30, 86, 20);
		add(cbUnidade);
		
		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setBounds(640, 69, 41, 14);
		add(lblCusto);
		
		txtCusto = new JTextField();
		txtCusto.setBounds(692, 66, 86, 20);
		add(txtCusto);
		txtCusto.setColumns(10);
		
		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro");
		lblMargemDeLucro.setBounds(788, 69, 115, 14);
		add(lblMargemDeLucro);
		
		txtMargemLucro = new JTextField();
		txtMargemLucro.setBounds(900, 66, 86, 20);
		add(txtMargemLucro);
		txtMargemLucro.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 142, 921, 342);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblProdutos = new JTable();
		scrollPane.setViewportView(tblProdutos);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(887, 102, 99, 29);
		add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(778, 102, 99, 29);
		add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(669, 102, 99, 29);
		add(btnExcluir);

	}
	
	private void limparCampos() {
		
		txtId.setText("");
		txtCodigoBarras.setText("");
		txtDescricao.setText("");
		txtCusto.setText("");
		txtMargemLucro.setText("");
		
		cbCategoria.setSelectedIndex(0);
		cbUnidade.setSelectedIndex(0);
	}

}
