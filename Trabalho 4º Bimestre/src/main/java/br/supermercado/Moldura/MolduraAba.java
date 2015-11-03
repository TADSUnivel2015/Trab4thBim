package br.supermercado.Moldura;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.sql.SQLException;

/**
 * 
 * @author Alex Tezza
 * Dia 30 de outubro de 2015
 */

public abstract class MolduraAba extends JPanel {
	private JButton btnFechar;

	protected abstract void configuraMiolo() throws SQLException;
	
	public void setCloseAction(ActionListener action){
		btnFechar.addActionListener(action);
	}
	
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public MolduraAba() throws SQLException {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblOl = new JLabel("Supermercado Volte Sempre!");
		lblOl.setFont(new Font("Microsoft JhengHei", Font.BOLD, 14));
		panel.add(lblOl);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		add(panel_1, BorderLayout.SOUTH);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panel_1.add(btnFechar);
		
		configuraMiolo();

	}

}
