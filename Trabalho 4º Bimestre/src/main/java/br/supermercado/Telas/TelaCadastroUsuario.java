package br.supermercado.Telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class TelaCadastroUsuario extends MolduraAba {

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario() {
		super();
	}

	@Override
	protected void configuraMiolo() {
		super.add(new CadastroUsuario(), BorderLayout.CENTER);
	}

}
