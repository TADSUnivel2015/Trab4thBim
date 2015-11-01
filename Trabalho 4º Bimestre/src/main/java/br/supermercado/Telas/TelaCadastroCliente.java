package br.supermercado.Telas;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

/**
 * 
 * @author Alex Tezza
 * Dia 30 de outubro de 2015
 */

public class TelaCadastroCliente extends MolduraAba {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public TelaCadastroCliente() throws SQLException {
		
		super();

	}

	// Este método só é abstrato na moldura, aqui ele deve ser concreto!
	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new CadastroCliente(), BorderLayout.CENTER);
		
	}

}
