package br.supermercado.ExtendsMoldura;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.supermercado.Moldura.MolduraAba;
import br.supermercado.Telas.TelaRelatorioCliente;

public class RelatorioCliente extends MolduraAba{

	public RelatorioCliente() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new TelaRelatorioCliente(), BorderLayout.CENTER);
	}
	
	

}
