package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		
	ps = conexao.prepareStatement(
				"INSERT INTO venda (IdVenda, idCliente, dataVenda, horaVenda, tatalCompra)"
						+ "VALUES (?, ?, ?, ?, ?)");

		ps.setInt(1, venda.getIdVenda());
		ps.setInt(2, venda.getIdClinte());
		
		java.util.Date utilDate = venda.getData();  
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
		
		ps.setDate(3, sqlDate);
		ps.setString(4, venda.getHora());
		ps.setBigDecimal(5, venda.getTotalCompra());

		ps.executeUpdate();

		ps.close();	
		
	}

	
	@Override
	public void atualizar(Venda venda) {
		
	}

	
	@Override
	public void excluir(int id) {
		
	}

	
	@Override
	public List<Venda> listar(String sql) {
		return null;
	}


	@Override
	public void fecharConexao() throws SQLException {
		conexao.close();
	}
	
	

}