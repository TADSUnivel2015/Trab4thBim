package br.supermercado.Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.function.Function;

/**
 * 
 * @author Alex Tezza
 * Dia 30 de outubro de 2015
 */

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private PainelBloqueio glass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setResizable(false);
					
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
		
		bloqueioTelaPrincipal();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);

		JMenuItem mntmCliente = new JMenuItem("Cadastro de cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaCadastroCliente();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		mnCadastros.add(mntmCliente);
		
		JMenuItem mntmCadastroDeFuncionrio = new JMenuItem("Cadastro de usu\u00E1rio");
		mntmCadastroDeFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaCadastroUsuario();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnCadastros.add(mntmCadastroDeFuncionrio);
		
		JMenuItem mntmCadastroDeProduto = new JMenuItem("Cadastro de produto");
		mntmCadastroDeProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaCadastroProduto();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnCadastros.add(mntmCadastroDeProduto);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmRealizarVenda = new JMenuItem("Realizar venda");
		mntmRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					abrirTelaVenda();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			private void abrirTelaVenda() throws SQLException {
				
				TelaVenda telaVenda = new TelaVenda();
				ActionListener action = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tabbedPane.remove(telaVenda);						
					}
				};
				telaVenda.setCloseAction(action);
				
				tabbedPane.addTab("Tela De Venda", telaVenda);
			}
		});
		mnVendas.add(mntmRealizarVenda);
		
		JMenu mnBloquear = new JMenu("Bloquear");
		menuBar.add(mnBloquear);
		
		JMenuItem mntmCliqueParaBloquear = new JMenuItem("Clique para Bloquear!");
		mntmCliqueParaBloquear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bloqueioTelaPrincipal();
			}
		});
		mnBloquear.add(mntmCliqueParaBloquear);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	private void bloqueioTelaPrincipal() {
		Runnable acaoOk = new Runnable() {
			@Override
			public void run() {
				glass.setVisible(false);
				glass = new PainelBloqueio();
			}
		};

		Login painelLogin = new Login(acaoOk);

		glass = new PainelBloqueio(painelLogin);

		setGlassPane(glass);

		glass.setVisible(true);
	}
	

	private void abrirTelaCadastroCliente() throws SQLException {
		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroCliente);			
			}
		};
		telaCadastroCliente.setCloseAction(action);

		tabbedPane.addTab("Cadastro de Cliente ", telaCadastroCliente);
	}

	private void abrirTelaCadastroUsuario() throws SQLException {
		
		TelaCadastroUsuario telaCadastroUsuario = new TelaCadastroUsuario();
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroUsuario);
			}
		};
		
		telaCadastroUsuario.setCloseAction(action);
		
		tabbedPane.addTab("Cadastro de Usuário", telaCadastroUsuario);
		
	}
	
	private void abrirTelaCadastroProduto() throws SQLException {
		
		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroProduto);						
			}
		};
		telaCadastroProduto.setCloseAction(action);
		
		tabbedPane.addTab("Cadastro de Produto", telaCadastroProduto);
	}
}
