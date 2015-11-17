package br.supermercado.ExtendsMoldura;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.supermercado.Moldura.MolduraAba;
import br.supermercado.Telas.TelaRelatorioProduto;

public class RelatorioProduto extends MolduraAba{

	public RelatorioProduto() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new TelaRelatorioProduto(), BorderLayout.CENTER);
	}
	
	
	
	

}
