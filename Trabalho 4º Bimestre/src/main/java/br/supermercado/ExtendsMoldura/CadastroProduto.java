package br.supermercado.ExtendsMoldura;

import java.awt.BorderLayout;
import java.sql.SQLException;

import br.supermercado.Moldura.MolduraAba;
import br.supermercado.Telas.TelaCadastroProduto;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class CadastroProduto extends MolduraAba {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public CadastroProduto() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new TelaCadastroProduto(), BorderLayout.CENTER);		
	}

}
