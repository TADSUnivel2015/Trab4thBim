package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.supermercado.ItemVenda;
import br.supermercado.conexao.ConexaoMySQL;

public class ItemVendaDAO implements EstrururaDAO<ItemVenda> {

	private Connection conexao = null;
	private PreparedStatement ps;

	@Override
	public void abrirConexao() throws SQLException {

		conexao = ConexaoMySQL.getConexaoMySQL(); //DriverManager.getConnection(url, user, pass);
		
	}

	@Override
	public void gravar(ItemVenda itemVenda) throws SQLException {

		ps = conexao.prepareStatement(
				"INSERT INTO itemVenda (IDItemVenda, idVenda, descricao, categoria, quantidade, vlrUnidade, vlrTotal)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)");

		ps.setInt(1, itemVenda.getIdProduto());
		ps.setInt(2, itemVenda.getIdVenda());
		ps.setString(3, itemVenda.getDescricao());
		ps.setString(4, itemVenda.getCategoria());
		ps.setInt(5, itemVenda.getQtd());
		ps.setBigDecimal(6, itemVenda.getVlrUnidade());
		ps.setBigDecimal(7, itemVenda.getVlrTotal());

		ps.executeUpdate();

		ps.close();

	}

	@Override
	public void atualizar(ItemVenda itemVenda) throws SQLException {
		// TODO Auto-generated method stub

	}
	@Override
	public void excluir(int id) throws SQLException {

		ps = conexao.prepareStatement("DELETE FROM itemVenda WHERE ID = ?");

		ps.setInt(1, id);

		ps.execute();

		ps.close();

	}

	@Override
	public List<ItemVenda> listar(String sql) throws SQLException {

		List<ItemVenda> itensVenda = new ArrayList<ItemVenda>();

		// Atributo que faz a busca no banco.
		ResultSet result;

		ps = conexao.prepareStatement(sql);

		result = ps.executeQuery();

		// Enquanto existe pr�ximo, fa�a..
		while (result.next()) {
			ItemVenda novo = new ItemVenda();

			novo.setId(result.getInt("id"));
			novo.setIdProduto(result.getInt("IdItemVenda"));
			novo.setIdVenda(result.getInt("idVenda"));
			novo.setDescricao(result.getString("descricao"));
			novo.setCategoria(result.getString("categoria"));
			novo.setQtd(result.getInt("quantidade"));
			novo.setVlrUnidade(result.getBigDecimal("vlrUnidade"));
			novo.setVlrTotal(result.getBigDecimal("vlrTotal"));
			itensVenda.add(novo);

		}

		result.close();

		ps.close();

		return itensVenda;
	}
}