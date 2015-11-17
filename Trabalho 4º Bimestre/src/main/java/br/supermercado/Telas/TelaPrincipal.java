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

import br.supermercado.ExtendsMoldura.CadastroCliente;
import br.supermercado.ExtendsMoldura.CadastroProduto;
import br.supermercado.ExtendsMoldura.CadastroUsuario;
import br.supermercado.ExtendsMoldura.RelatorioCliente;
import br.supermercado.ExtendsMoldura.RelatorioProduto;
import br.supermercado.ExtendsMoldura.RelatorioVenda;
import br.supermercado.ExtendsMoldura.Venda;
import br.supermercado.Login.Login;
import br.supermercado.Login.PainelBloqueio;

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
		});
		mnVendas.add(mntmRealizarVenda);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);

		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrirRelatorioCliente();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRelatrios.add(mntmCliente_1);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrirTelaRelatorioProduto();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRelatrios.add(mntmProduto);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrirTelaRelatorioVenda();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRelatrios.add(mntmVenda);

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

	private void abrirTelaVenda() throws SQLException {

		Venda telaVenda = new Venda();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaVenda);						
			}
		};
		telaVenda.setCloseAction(action);

		tabbedPane.addTab("Tela De Venda", telaVenda);

		mostrarUltima();
	}


	private void abrirTelaCadastroCliente() throws SQLException {
		CadastroCliente telaCadastroCliente = new CadastroCliente();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroCliente);			
			}
		};
		telaCadastroCliente.setCloseAction(action);

		tabbedPane.addTab("Cadastro de Cliente ", telaCadastroCliente);

		mostrarUltima();
	}

	private void abrirTelaCadastroUsuario() throws SQLException {

		CadastroUsuario telaCadastroUsuario = new CadastroUsuario();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroUsuario);
			}
		};

		telaCadastroUsuario.setCloseAction(action);

		tabbedPane.addTab("Cadastro de Usuário", telaCadastroUsuario);

		mostrarUltima();
	}

	private void abrirTelaCadastroProduto() throws SQLException {

		CadastroProduto telaCadastroProduto = new CadastroProduto();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaCadastroProduto);						
			}
		};
		telaCadastroProduto.setCloseAction(action);

		tabbedPane.addTab("Cadastro de Produto", telaCadastroProduto);

		mostrarUltima();
	}

	private void abrirRelatorioCliente() throws SQLException {

		RelatorioCliente telaRelatorioCliente = new RelatorioCliente();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorioCliente);				
			}
		};

		telaRelatorioCliente.setCloseAction(action);

		tabbedPane.addTab("Relatório de Cliente", telaRelatorioCliente);

		mostrarUltima();		
	}

	private void abrirTelaRelatorioProduto() throws SQLException {

		RelatorioProduto telaRelatorioProduto = new RelatorioProduto();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorioProduto);				
			}
		};

		telaRelatorioProduto.setCloseAction(action);

		tabbedPane.addTab("Relatório de Produto", telaRelatorioProduto);

		mostrarUltima();		
	}

	private void abrirTelaRelatorioVenda() throws SQLException {
		
		RelatorioVenda telaRelatorioVenda = new RelatorioVenda();
		ActionListener action = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(telaRelatorioVenda);			
			}
		};
		telaRelatorioVenda.setCloseAction(action);
		
		tabbedPane.addTab("Relatório de Venda", telaRelatorioVenda);
		
		mostrarUltima();
	}

	private void mostrarUltima() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}
}
