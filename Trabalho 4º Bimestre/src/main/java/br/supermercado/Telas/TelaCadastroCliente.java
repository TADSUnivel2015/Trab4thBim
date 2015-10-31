package br.supermercado.Telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * 
 * @author Alex Tezza
 * Dia 30 de outubro de 2015
 */

public class TelaCadastroCliente extends MolduraAba {

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
