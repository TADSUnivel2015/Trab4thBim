package br.supermercado.Telas;

import java.awt.BorderLayout;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class TelaCadastroProduto extends MolduraAba {

	/**
	 * Create the panel.
	 */
	public TelaCadastroProduto() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new CadastroProduto(), BorderLayout.CENTER);		
	}

}
