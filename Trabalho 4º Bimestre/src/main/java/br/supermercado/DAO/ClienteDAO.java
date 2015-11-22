package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.supermercado.Cliente;

public class ClienteDAO implements EstrururaDAO<Cliente>{

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
	public void gravar(Cliente cliente) throws SQLException {

		ps = conexao.prepareStatement(
				"INSERT INTO CLIENTE (ID, NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

		ps.setInt(1, cliente.getId());
		ps.setString(2, cliente.getNome());
		ps.setString(3, cliente.getTelefone());
		ps.setString(4, cliente.getEndereco());
		ps.setString(5, cliente.getCidade());
		ps.setString(6, cliente.getEstado());
		ps.setString(7, cliente.getEmail());
		ps.setString(8, cliente.getGenero());

		ps.executeUpdate();

		ps.close();
	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException {
	
		ps = conexao.prepareStatement("UPDATE CLIENTE SET NOME = '"+cliente.getNome()
				+"', TELEFONE = '"+cliente.getTelefone()
				+"', ENDERECO = '"+cliente.getEndereco()
				+"', CIDADE   = '"+cliente.getCidade()
				+"', ESTADO   = '"+cliente.getEstado()
				+"', EMAIL    = '"+cliente.getEmail()
				+"', GENERO   = '"+cliente.getGenero()
				+"' WHERE ID = '"+cliente.getId()+"'");

		ps.execute();

		ps.close();


	}

	@Override
	public void excluir(int id) throws SQLException {

		ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE ID = ?");

		ps.setInt(1, id);

		ps.execute();

		ps.close();

	}

	@Override
	public List<Cliente> listar(String sql) throws SQLException {

		List<Cliente> clientes = new ArrayList<Cliente>();

		// Atributo que faz a busca no banco.
		ResultSet result;

		ps = conexao.prepareStatement(sql);

		result = ps.executeQuery();

		// Enquanto existe próximo, faça..
		while (result.next()) {
			Cliente novo = new Cliente();

			novo.setId(result.getInt("id"));
			novo.setNome(result.getString("nome"));
			novo.setTelefone(result.getString("telefone"));
			novo.setEndereco(result.getString("endereco"));
			novo.setCidade(result.getString("cidade"));
			novo.setEstado(result.getString("estado"));
			novo.setEmail(result.getString("email"));
			novo.setGenero(result.getString("genero"));
			clientes.add(novo);

		}

		result.close();

		ps.close();

		return clientes;	

	}

	@Override
	public void fecharConexao() throws SQLException {
		conexao.close();
	}


}