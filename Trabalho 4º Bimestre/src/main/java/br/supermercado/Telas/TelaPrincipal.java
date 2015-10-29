package br.supermercado.Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Supermercado Volte Sempre!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmCliente = new JMenuItem("Cadastro de cliente");
		mnCadastros.add(mntmCliente);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastro de usu\u00E1rio");
		mnCadastros.add(mntmNewMenuItem);
		
		JMenu mnVenda = new JMenu("Venda");
		menuBar.add(mnVenda);
		
		JMenuItem mntmRealizarVenda = new JMenuItem("Realizar venda");
		mnVenda.add(mntmRealizarVenda);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenu mnPorCliente = new JMenu("Relat\u00F3rio de cliente");
		mnRelatrios.add(mnPorCliente);
		
		JMenuItem mntmFiltrarPorCidade = new JMenuItem("Filtrar por cidade");
		mnPorCliente.add(mntmFiltrarPorCidade);
		
		JMenuItem mntmFiltrarPorEstado = new JMenuItem("Filtrar por estado");
		mnPorCliente.add(mntmFiltrarPorEstado);
		
		JMenu mnPor = new JMenu("Relat\u00F3rio de produto");
		mnRelatrios.add(mnPor);
		
		JMenuItem mntmFiltrarPorCategoria = new JMenuItem("Filtrar por categoria");
		mnPor.add(mntmFiltrarPorCategoria);
		
		JMenuItem mntmFiltrarPorMargem = new JMenuItem("Filtrar por margem de lucro");
		mnPor.add(mntmFiltrarPorMargem);
		
		JMenu mnRelatrioDeVenda = new JMenu("Relat\u00F3rio de venda");
		mnRelatrios.add(mnRelatrioDeVenda);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Filtrar por dia");
		mnRelatrioDeVenda.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Filtrar por m\u00EAs");
		mnRelatrioDeVenda.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Filtrar por categoria de produto");
		mnRelatrioDeVenda.add(mntmNewMenuItem_3);
		
		JMenuItem mntmFiltrarPorCliente = new JMenuItem("Filtrar por cliente");
		mnRelatrioDeVenda.add(mntmFiltrarPorCliente);
		
		setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblSejaBemVindo = new JLabel("Seja bem vindo usu\u00E1rio!");
		panel_1.add(lblSejaBemVindo);
	}

}
