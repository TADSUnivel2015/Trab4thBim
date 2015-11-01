package br.supermercado.Telas;

import java.awt.BorderLayout;
import java.sql.SQLException;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class TelaCadastroProduto extends MolduraAba {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public TelaCadastroProduto() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new CadastroProduto(), BorderLayout.CENTER);		
	}

}
