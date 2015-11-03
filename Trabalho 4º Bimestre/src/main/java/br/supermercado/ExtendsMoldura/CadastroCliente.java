package br.supermercado.ExtendsMoldura;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import br.supermercado.Moldura.MolduraAba;
import br.supermercado.Telas.TelaCadastroCliente;

/**
 * 
 * @author Alex Tezza
 * Dia 30 de outubro de 2015
 */

public class CadastroCliente extends MolduraAba {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public CadastroCliente() throws SQLException {
		
		super();

	}

	// Este método só é abstrato na moldura, aqui ele deve ser concreto!
	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new TelaCadastroCliente(), BorderLayout.CENTER);
		
	}

}
