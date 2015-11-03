package br.supermercado.DAO;

import java.util.List;

public interface EstrururaDAO {
	
	public void abrirConexao();
	
	public void gravar();
	
	public void atualizar();
	
	public void excluir();
	
	public List<Object> listar();
	
	public void fecharConexao();

}
