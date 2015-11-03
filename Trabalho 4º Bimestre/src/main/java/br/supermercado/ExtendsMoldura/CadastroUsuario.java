package br.supermercado.ExtendsMoldura;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;

import br.supermercado.Moldura.MolduraAba;
import br.supermercado.Telas.TelaCadastroUsuario;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class CadastroUsuario extends MolduraAba {

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public CadastroUsuario() throws SQLException {
		super();
	}

	@Override
	protected void configuraMiolo() throws SQLException {
		super.add(new TelaCadastroUsuario(), BorderLayout.CENTER);
	}

}
