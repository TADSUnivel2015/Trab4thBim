package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.supermercado.ItemVenda;

public class ItemVendaDAO implements EstrururaDAO<ItemVenda> {

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
	public void gravar(ItemVenda itemVenda) throws SQLException {

		ps = conexao.prepareStatement(
				"INSERT INTO itemVenda (IDItemVenda, idVenda, descricao, categoria, quantidade, vlrUnidade, vlrTotal)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)");

		ps.setInt(1, itemVenda.getIdItem());
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
		// TODO Auto-generated method stub

	}

	@Override
	public List<ItemVenda> listar(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fecharConexao() throws SQLException {
		conexao.close();
	}
}