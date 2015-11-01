package br.supermercado.Telas;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class TelaVenda extends MolduraAba {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public TelaVenda() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new Venda(), BorderLayout.CENTER);		
	}

}
