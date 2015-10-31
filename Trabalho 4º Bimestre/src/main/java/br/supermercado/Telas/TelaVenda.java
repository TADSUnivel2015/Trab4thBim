package br.supermercado.Telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class TelaVenda extends MolduraAba {

	/**
	 * Create the panel.
	 */
	public TelaVenda() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new Venda(), BorderLayout.CENTER);		
	}

}
