package br.supermercado.Telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroCliente extends MolduraAbstrata {

	/**
	 * Create the panel.
	 */
	public TelaCadastroCliente() {
		
		super();

	}

	// Este método só é abstrato na moldura, aqui ele deve ser concreto!
	@Override
	protected void configuraMiolo() {
		super.add(new CadastroCliente(), BorderLayout.CENTER);
		
	}

}
