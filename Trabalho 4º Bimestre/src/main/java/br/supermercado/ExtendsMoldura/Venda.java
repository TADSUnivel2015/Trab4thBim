package br.supermercado.ExtendsMoldura;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import br.supermercado.Moldura.MolduraAba;
import br.supermercado.Telas.TelaVenda;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class Venda extends MolduraAba {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public Venda() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new TelaVenda(), BorderLayout.CENTER);		
	}

}
