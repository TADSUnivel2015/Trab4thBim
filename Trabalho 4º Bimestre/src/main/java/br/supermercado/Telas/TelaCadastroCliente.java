package br.supermercado.Telas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * @author Alex Tezza
 * Dia 29 de outubro de 2015
 * Horário: 20:54
 */

public class TelaCadastroCliente extends MolduraAbas{
	
	public TelaCadastroCliente() {
		super();
	}

	@Override
	protected void configuraCentro() {
		super.add(new TelaCadastroCliente(), BorderLayout.CENTER);
		
	}
	
	

}
