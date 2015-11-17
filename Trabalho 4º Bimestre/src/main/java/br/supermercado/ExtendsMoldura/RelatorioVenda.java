package br.supermercado.ExtendsMoldura;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.supermercado.Moldura.MolduraAba;
import br.supermercado.Telas.TelaRelatorioVenda;

public class RelatorioVenda extends MolduraAba{

	public RelatorioVenda() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new TelaRelatorioVenda(), BorderLayout.CENTER);
	}

}
