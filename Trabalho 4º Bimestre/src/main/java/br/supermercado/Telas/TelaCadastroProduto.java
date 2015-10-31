package br.supermercado.Telas;

import java.awt.BorderLayout;

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
