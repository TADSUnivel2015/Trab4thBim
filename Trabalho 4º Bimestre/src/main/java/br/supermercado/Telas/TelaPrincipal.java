package br.supermercado.Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TabExpander;
import javax.swing.JLabel;

import java.awt.Window.Type;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.function.Function;

import javax.swing.JTabbedPane;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

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
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirTelaCadastroCliente();
			}

		});
		mnCadastros.add(mntmCliente);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Usu\u00E1rio");
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblSejaBemVindo = new JLabel("Seja bem vindo usu\u00E1rio!");
		panel_1.add(lblSejaBemVindo);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	private void abrirTelaCadastroCliente() {
		
	}
}
