package br.supermercado.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.supermercado.Produto;

public class ProdutoDAO implements EstrururaDAO<Produto>{

	private Connection conexao = null;

	private PreparedStatement ps;

	@Override
	public void abrirConexao() throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/Trabalho4thBim";
		String user = "postgres";
		String pass = "tezza";

		conexao = DriverManager.getConnection(url, user, pass);
	}


	@Override
	public void gravar(Produto produto) throws SQLException {

		ps = conexao.prepareStatement(
				"INSERT INTO produto (ID, CODBARRAS, CATEGORIA, DESCRICAO, UNIDADE, CUSTO, MARGEMLUCRO)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)");

		ps.setInt(1, produto.getId());
		ps.setString(2, produto.getCodBarras());
		ps.setString(3, produto.getCategoria());
		ps.setString(4, produto.getDescricao());
		ps.setString(5, produto.getUnidade());
		ps.setBigDecimal(6, produto.getCusto());
		ps.setBigDecimal(7, produto.getMargemLucro());
		
		int res = ps.executeUpdate();

		ps.close();

	}


	@Override
	public void atualizar(Produto produto) throws SQLException {

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


	@Override
	public void excluir(int id) throws SQLException {

		ps = conexao.prepareStatement("DELETE FROM produto WHERE ID = ?");

		ps.setInt(1, id);

		ps.execute();

		ps.close();

	}


	@Override
	public List<Produto> listar() throws SQLException {

		List<Produto> produtos = new ArrayList<Produto>();

		// Atributo que faz a busca no banco.
		ResultSet result;

		ps = conexao.prepareStatement("SELECT * FROM produto");

		result = ps.executeQuery();

		// Enquanto existe pr�ximo, fa�a..
		while (result.next()) {

			Produto novo = new Produto();

			novo.setId(result.getInt("id"));
			novo.setCodBarras(result.getString("codbarras"));
			novo.setCategoria(result.getString("categoria"));
			novo.setDescricao(result.getString("descricao"));
			novo.setUnidade(result.getString("unidade"));
			novo.setCusto(result.getBigDecimal("custo"));
			novo.setMargemLucro(result.getBigDecimal("margemlucro"));

			produtos.add(novo);

		}

		result.close();

		ps.close();

		return produtos;		

	}


	@Override
	public void fecharConexao() throws SQLException {
		conexao.close();		
	}



}