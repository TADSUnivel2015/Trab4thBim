package br.supermercado.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.supermercado.Produto;
import br.supermercado.Usuario;

public class UsuarioDAO implements EstrururaDAO<Usuario>{

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
	public void gravar(Usuario usuario) throws SQLException {

		ps = conexao.prepareStatement(
				"INSERT INTO usuario (ID, NOMECLIENTE, IDCLIENTE, SENHA)"
						+ "VALUES (?, ?, ?, ?)");

		ps.setInt(1, usuario.getId());
		ps.setString(2, usuario.getNomeCliente());
		ps.setInt(3, usuario.getIdCliente());
		ps.setString(4, usuario.getSenha());

		ps.executeUpdate();

		ps.close();

	}


	@Override
	public void atualizar(Usuario usuario) throws SQLException {

		ps = conexao.prepareStatement("UPDATE usuario SET NOMEcliente = '"+usuario.getNomeCliente()
				+"', IdCLIENTE = '"+usuario.getIdCliente()
				+"', SENHA = '"+usuario.getSenha()
				+"' WHERE ID = '"+usuario.getId()+"'");

		ps.execute();

		ps.close();

	}


	@Override
	public void excluir(int id) throws SQLException {

		ps = conexao.prepareStatement("DELETE FROM usuario WHERE ID = ?");

		ps.setInt(1, id);

		ps.execute();

		ps.close();

	}


	@Override
	public List<Usuario> listar() throws SQLException {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		// Atributo que faz a busca no banco.
		ResultSet result;

		ps = conexao.prepareStatement("SELECT * FROM usuario");

		result = ps.executeQuery();

		// Enquanto existe próximo, faça..
		while (result.next()) {
			Usuario novo = new Usuario();

			novo.setId(result.getInt("id"));
			novo.setNomeCliente(result.getString("NOMEcliente"));
			novo.setIdCliente(result.getInt("IdCLIENTE"));
			novo.setSenha(result.getString("SENHA"));

			usuarios.add(novo);

		}

		result.close();

		ps.close();

		return usuarios;		

	}

	@Override
	public void fecharConexao() throws SQLException {
		conexao.close();		
	}

}