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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.bouncycastle.mail.smime.handlers.pkcs7_mime;

import br.supermercado.Produto;
import br.supermercado.DAO.ProdutoDAO;
import br.supermercado.Enum.Categoria;
import br.supermercado.Enum.Unidade;
import br.supermercado.ModelTabelas.TabelaProdutos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class TelaCadastroProduto extends JPanel {
	private JTextField txtId;
	private JTextField txtCodigoBarras;
	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtMargemLucro;
	
	private JComboBox cbCategoria;
	private JComboBox cbUnidade;
	
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	
	private JTable tblProdutos;

	/**
	 * Create the panel.
	 */
	public TelaCadastroProduto() {
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
		tblProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtId.setText(String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0)));
				txtCodigoBarras.setText(String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 1)));			
				txtDescricao.setText(String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 3)));
				txtCusto.setText(String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 5)));
				txtMargemLucro.setText(String.valueOf(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 6)));
				
			}
		});
		
		try {
			produtoDAO.abrirConexao();
			
			tblProdutos.setModel(new TabelaProdutos(produtoDAO.listar()));
			
			produtoDAO.fecharConexao();
		} catch (SQLException g) {
			// TODO Auto-generated catch block
			g.printStackTrace();
		}
		
		scrollPane.setViewportView(tblProdutos);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					produtoDAO.abrirConexao();
					
					BigDecimal vlrCusto = new BigDecimal(txtCusto.getText());
					BigDecimal vlrLucro = new BigDecimal(txtMargemLucro.getText());		
					
					Produto produto = new Produto(Integer.parseInt(txtId.getText()),
							txtCodigoBarras.getText(), cbCategoria.getSelectedItem().toString(),
							txtDescricao.getText(), cbUnidade.getSelectedItem().toString(),
							vlrCusto, vlrLucro);
					
					produtoDAO.gravar(produto);					
					tblProdutos.setModel(new TabelaProdutos(produtoDAO.listar()));
					limparCampos();
					
					produtoDAO.fecharConexao();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(887, 102, 99, 29);
		add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					produtoDAO.abrirConexao();
					
					BigDecimal vlrCusto = new BigDecimal(txtCusto.getText());
					BigDecimal vlrLucro = new BigDecimal(txtMargemLucro.getText());		
					
					Produto produto = new Produto(Integer.parseInt(txtId.getText()),
							txtCodigoBarras.getText(), cbCategoria.getSelectedItem().toString(),
							txtDescricao.getText(), cbUnidade.getSelectedItem().toString(),
							vlrCusto, vlrLucro);
					
					produtoDAO.atualizar(produto);
					tblProdutos.setModel(new TabelaProdutos(produtoDAO.listar()));
					limparCampos();
					
					produtoDAO.fecharConexao();
				} catch (SQLException f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				}
			}
		});
		btnAtualizar.setBounds(778, 102, 99, 29);
		add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					produtoDAO.abrirConexao();
					
					produtoDAO.excluir(Integer.parseInt(txtId.getText()));
					tblProdutos.setModel(new TabelaProdutos(produtoDAO.listar()));
					limparCampos();
					
					produtoDAO.fecharConexao();
				} catch (SQLException g) {
					// TODO Auto-generated catch block
					g.printStackTrace();
				}
			}
		});
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
