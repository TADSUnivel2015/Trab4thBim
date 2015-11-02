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

import br.supermercado.Categoria;
import br.supermercado.Produto;
import br.supermercado.Unidade;
import br.supermercado.Tabelas.TabelaProdutos;

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

public class CadastroProduto extends JPanel {
	private JTextField txtId;
	private JTextField txtCodigoBarras;
	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtMargemLucro;
	
	private JComboBox cbCategoria;
	private JComboBox cbUnidade;
	
	private Produto produto = new Produto();
	
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
			abrirConexao();
			tblProdutos.setModel(new TabelaProdutos(listarProdutos()));
			fecharConexao();
		} catch (SQLException g) {
			// TODO Auto-generated catch block
			g.printStackTrace();
		}
		
		scrollPane.setViewportView(tblProdutos);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirConexao();
					gravar();
					tblProdutos.setModel(new TabelaProdutos(listarProdutos()));
					limparCampos();
					fecharConexao();
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
					abrirConexao();
					atualizar();
					limparCampos();
					tblProdutos.setModel(new TabelaProdutos(listarProdutos()));
					fecharConexao();
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
					abrirConexao();
					excluir();
					tblProdutos.setModel(new TabelaProdutos(listarProdutos()));
					limparCampos();
					fecharConexao();
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
	
	/**
	 * Daqui para baixo é feito a parte de comunicação com o Banco de Dados....
	 */
	
	Connection conexao = null;
	private PreparedStatement ps;
	
	public void abrirConexao() throws SQLException{ 
		String url = "jdbc:postgresql://localhost:5432/Trabalho4thBim";
		String user = "postgres";
		String pass = "tezza";
		
		conexao = DriverManager.getConnection(url, user, pass);
		
	}
	
	public void fecharConexao() throws SQLException {
		conexao.close();
	}
	
	public void gravar() throws SQLException{
		
		produto.setId(Integer.parseInt(txtId.getText()));
		produto.setCodBarras(new BigDecimal(txtCodigoBarras.getText()));
		produto.setCategoria(cbCategoria.getSelectedItem().toString());
		produto.setDescricao(txtDescricao.getText());
		produto.setUnidade(cbUnidade.getSelectedItem().toString());	
		produto.setCusto(new BigDecimal(txtCusto.getText()));
		produto.setMargemLucro(new BigDecimal(txtMargemLucro.getText()));
		
		String aux1 = txtCusto.getText();
		String aux2 = txtMargemLucro.getText();	
		
		BigDecimal valor1 = new BigDecimal(aux1);
		BigDecimal valor2 = new BigDecimal(aux2);
		
		BigDecimal valorFinal = valorTotal(valor1, valor2);
		
		produto.setValorFinal(valorFinal);
		
		ps = conexao.prepareStatement(
				"INSERT INTO produto (ID, CODBARRAS, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGEMLUCRO, VALORFINAL)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		
		ps.setInt(1, produto.getId());
		ps.setBigDecimal(2, produto.getCodBarras());
		ps.setString(3, produto.getCategoria());
		ps.setString(4, produto.getDescricao());
		ps.setString(5, produto.getUnidade());
		ps.setBigDecimal(6, produto.getCusto());
		ps.setBigDecimal(7, produto.getMargemLucro());
		ps.setBigDecimal(8, produto.getValorFinal());
		
		int res = ps.executeUpdate();
		
		ps.close();
	}
	
	public void atualizar() throws SQLException{
		
		produto.setId(Integer.parseInt(txtId.getText()));
		
		produto.setCodBarras(new BigDecimal(txtCodigoBarras.getText()));
		produto.setCategoria(cbCategoria.getSelectedItem().toString());
		produto.setDescricao(txtDescricao.getText());
		produto.setUnidade(cbUnidade.getSelectedItem().toString());	
		produto.setCusto(new BigDecimal(txtCusto.getText().toString()));
		produto.setMargemLucro(new BigDecimal(txtMargemLucro.getText()));
		
		ps = conexao.prepareStatement("UPDATE produto SET CODBARRAS = '"+produto.getCodBarras()
				+"', CATEGORIA = '"+produto.getCategoria()
				+"', DESCRICAO = '"+produto.getDescricao()
				+"', UNIDADE   = '"+produto.getUnidade()
				+"', CUSTO   = '"+produto.getCusto()
				+"', MARGEMLUCRO    = '"+produto.getMargemLucro()
				+"' WHERE ID = '"+produto.getId()+"'");

		ps.execute();
		
		ps.close();
		
	}
	
	public void excluir() throws SQLException{
		
		produto.setId(Integer.parseInt(txtId.getText()));
		
		ps = conexao.prepareStatement("DELETE FROM produto WHERE ID = ?");
		
		ps.setInt(1, produto.getId());
		
		ps.execute();
		
		ps.close();
		
	}
	
	public List listarProdutos() throws SQLException {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		// Atributo que faz a busca no banco.
		ResultSet result;
		
		ps = conexao.prepareStatement("SELECT * FROM produto");
		
		result = ps.executeQuery();
		
		// Enquanto existe próximo, faça..
		while (result.next()) {
			
			Produto novo = new Produto();
			
			novo.setId(result.getInt("id"));
			novo.setCodBarras(result.getBigDecimal("codbarras"));
			novo.setCategoria(result.getString("categoria"));
			novo.setDescricao(result.getString("descricao"));
			novo.setUnidade(result.getString("unidade"));
			novo.setCusto(result.getBigDecimal("custo"));
			novo.setMargemLucro(result.getBigDecimal("margemlucro"));
			
			BigDecimal total = valorTotal(result.getBigDecimal("custo"), result.getBigDecimal("margemlucro"));
			
			novo.setValorFinal(total);
			produtos.add(novo);
			
		}
		
		result.close();
		
		ps.close();
			
		return produtos;		
	}
	
	public BigDecimal valorTotal(BigDecimal valor1,BigDecimal valor2){
		return valor2.multiply(valor1);
	}
}
