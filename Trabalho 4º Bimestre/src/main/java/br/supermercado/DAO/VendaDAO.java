package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.supermercado.Usuario;
import br.supermercado.Venda;

public class VendaDAO implements EstrururaDAO<Venda>{

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
	public void gravar(Venda venda) throws SQLException {

		ps = conexao.prepareStatement("INSERT INTO venda (IdVenda, idCliente, dataVenda, horaVenda, totalcompra)"
				+ "VALUES (?, ?, ?, ?, ?)");

		java.util.Date utilDate = venda.getData();  
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  
		
		ps.setInt(1, venda.getIdVenda());
		ps.setInt(2, venda.getIdClinte());
		ps.setDate(3, sqlDate);
		ps.setString(4, venda.getHora());
		ps.setBigDecimal(5, venda.getTotalCompra());

		ps.executeUpdate();

		ps.close();

	}


	@Override
	public void atualizar(Venda venda) {
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
	public List<Venda> listar(String sql) throws SQLException {
		
		List<Venda> vendas = new ArrayList<Venda>();

		// Atributo que faz a busca no banco.
		ResultSet result;

		ps = conexao.prepareStatement(sql);

		result = ps.executeQuery();

		// Enquanto existe próximo, faça..
		while (result.next()) {
			Venda novo = new Venda();

			novo.setIdVenda(result.getInt("idvenda"));
			novo.setIdClinte(result.getInt("idcliente"));
			novo.setHora(result.getString("horavenda"));
			novo.setData(result.getDate("datavenda"));
			novo.setTotalCompra(result.getBigDecimal("totalcompra"));

			vendas.add(novo);

		}

		result.close();

		ps.close();

		return vendas;	
	}


	@Override
	public void fecharConexao() throws SQLException {
		conexao.close();
	}



}