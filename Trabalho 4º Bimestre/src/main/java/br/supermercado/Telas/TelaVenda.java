package br.supermercado.Telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.supermercado.ItemVenda;
import br.supermercado.Venda;
import br.supermercado.DAO.ClienteDAO;
import br.supermercado.DAO.ItemVendaDAO;
import br.supermercado.DAO.ProdutoDAO;
import br.supermercado.DAO.VendaDAO;
import br.supermercado.ModelTabelas.TabelaConsultaCliente;
import br.supermercado.ModelTabelas.TabelaConsultaProduto;
import br.supermercado.ModelTabelas.TabelaItensVenda;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class TelaVenda extends JPanel {

	private JTable tblItensVenda;
	private JTable tblGenerica;

	private ClienteDAO clienteDAO = new ClienteDAO();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private VendaDAO vendaDAO = new VendaDAO();
	private ItemVendaDAO itemVendaDAO = new ItemVendaDAO();

	private JTextField txtNomeCliente;
	private JTextField txtNomeProduto;
	private JTextField txtValorUnidade;
	private JTextField txtQuantidade;
	private JTextField txtValorTotal;
	private JTextField txtIdCliente;
	private JTextField txtIdProduto;
	private JTextField txtValorPagamento;
	private JTextField txtTroco;

	private int flag = 1;
	private JTextField txtCategoriaProduto;
	private JTextField txtIdVenda;


	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public TelaVenda() throws SQLException {
		setLayout(null);

		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(45, 59, 120, 14);
		add(lblNomeDoCliente);		

		JLabel lblNomeDoProduto = new JLabel("Descri\u00E7\u00E3o do Produto");
		lblNomeDoProduto.setBounds(662, 59, 132, 14);
		add(lblNomeDoProduto);

		JLabel lblValorTotal = new JLabel("Valor Unidade");
		lblValorTotal.setBounds(1020, 200, 110, 14);
		add(lblValorTotal);

		JLabel lblValorPagamento = new JLabel("VALOR PAGAMENTO");
		lblValorPagamento.setBounds(265, 554, 120, 14);
		add(lblValorPagamento);

		txtValorPagamento = new JTextField();
		txtValorPagamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtValorPagamento.setBounds(395, 548, 110, 24);
		add(txtValorPagamento);
		txtValorPagamento.setColumns(10);

		JLabel lblTroco = new JLabel("TROCO");
		lblTroco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTroco.setBounds(515, 553, 53, 14);
		add(lblTroco);

		txtTroco = new JTextField();
		txtTroco.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTroco.setBounds(578, 547, 146, 23);
		add(txtTroco);
		txtTroco.setColumns(10);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlConsultaItens = "SELECT * FROM itemvenda where idvenda = " + Integer.parseInt(txtIdVenda.getText());

				txtValorTotal.setText("0.0");
				txtValorUnidade.setText("0.0");				

				BigDecimal vlrUnidade = new BigDecimal(txtValorUnidade.getText());
				BigDecimal vlrTotal = new BigDecimal(txtValorTotal.getText());	

				try {

					itemVendaDAO.abrirConexao();

					ItemVenda intemVenda = new ItemVenda(Integer.parseInt(txtIdVenda.getText())
							, Integer.parseInt(txtIdProduto.getText())
							, txtNomeProduto.getText()
							, txtCategoriaProduto.getText()
							, vlrUnidade
							, Integer.parseInt(txtQuantidade.getText())
							, vlrTotal);

					itemVendaDAO.gravar(intemVenda);

					tblItensVenda.setModel((TableModel)new TabelaItensVenda(itemVendaDAO.listar(sqlConsultaItens)));

					itemVendaDAO.fecharConexao();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(948, 251, 352, 36);
		add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(45, 298, 1255, 239);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		tblItensVenda = new JTable();
		scrollPane_1.setViewportView(tblItensVenda);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(156, 56, 397, 20);
		add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				flag = 1;

				String sqlConsultaUsuario = "select * from cliente where nome like '%" + txtNomeCliente.getText() + "%'";

				try {
					clienteDAO.abrirConexao();

					tblGenerica.setModel((TableModel)new TabelaConsultaCliente(clienteDAO.listar(sqlConsultaUsuario)));

					clienteDAO.fecharConexao();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				


			}
		});
		btnNewButton_1.setBounds(563, 56, 89, 20);
		add(btnNewButton_1);

		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(793, 56, 408, 20);
		add(txtNomeProduto);
		txtNomeProduto.setColumns(10);

		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				flag = 2;

				String sqlConsultaProduto = "select * from produto where descricao like '%" + txtNomeProduto.getText() + "%'";

				try {
					produtoDAO.abrirConexao();

					tblGenerica.setModel((TableModel)new TabelaConsultaProduto(produtoDAO.listar(sqlConsultaProduto)));

					produtoDAO.fecharConexao();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		btnNewButton_2.setBounds(1211, 55, 89, 23);
		add(btnNewButton_2);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(1020, 161, 89, 14);
		add(lblQuantidade);

		txtValorUnidade = new JTextField();
		txtValorUnidade.setEditable(false);
		txtValorUnidade.setBounds(1131, 197, 86, 20);
		add(txtValorUnidade);
		txtValorUnidade.setColumns(10);

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(1131, 158, 86, 20);
		add(txtQuantidade);

		JLabel lblValorTotal_1 = new JLabel("Valor Total");
		lblValorTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorTotal_1.setBounds(45, 543, 89, 33);
		add(lblValorTotal_1);

		txtValorTotal = new JTextField();
		txtValorTotal.setBounds(145, 548, 110, 25);
		add(txtValorTotal);
		txtValorTotal.setColumns(10);

		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(45, 87, 68, 14);
		add(lblIdCliente);

		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setBounds(123, 84, 86, 20);
		add(txtIdCliente);
		txtIdCliente.setColumns(10);

		JLabel lblIdProduto = new JLabel("Id Produto");
		lblIdProduto.setBounds(662, 87, 68, 14);
		add(lblIdProduto);

		txtIdProduto = new JTextField();
		txtIdProduto.setEditable(false);
		txtIdProduto.setBounds(729, 84, 77, 20);
		add(txtIdProduto);
		txtIdProduto.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(45, 115, 893, 172);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		tblGenerica = new JTable();
		tblGenerica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(flag == 1) {

					txtIdCliente.setText(String.valueOf(tblGenerica.getValueAt(tblGenerica.getSelectedRow(), 0)));
					txtNomeCliente.setText(String.valueOf(tblGenerica.getValueAt(tblGenerica.getSelectedRow(), 1)));

				} else {

					txtIdProduto.setText(String.valueOf(tblGenerica.getValueAt(tblGenerica.getSelectedRow(), 0)));
					txtNomeProduto.setText(String.valueOf(tblGenerica.getValueAt(tblGenerica.getSelectedRow(), 1)));
					txtValorUnidade.setText(String.valueOf(tblGenerica.getValueAt(tblGenerica.getSelectedRow(), 2)));
					txtCategoriaProduto.setText(String.valueOf(tblGenerica.getValueAt(tblGenerica.getSelectedRow(), 3)));

				}

			}
		});
		scrollPane.setViewportView(tblGenerica);

		JLabel lblNewLabel = new JLabel("Categoria");
		lblNewLabel.setBounds(816, 87, 68, 14);
		add(lblNewLabel);

		txtCategoriaProduto = new JTextField();
		txtCategoriaProduto.setEditable(false);
		txtCategoriaProduto.setBounds(880, 84, 179, 20);
		add(txtCategoriaProduto);
		txtCategoriaProduto.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Id Venda");
		lblNewLabel_1.setBounds(45, 34, 61, 14);
		add(lblNewLabel_1);

		txtIdVenda = new JTextField();
		txtIdVenda.setBounds(123, 28, 86, 20);
		add(txtIdVenda);
		txtIdVenda.setColumns(10);

		JButton btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BigDecimal totalCompra = new BigDecimal(txtValorTotal.getText());
				BigDecimal vlrPagamento = new BigDecimal(txtValorPagamento.getText());
				BigDecimal vlrTroco = new BigDecimal(txtTroco.getText());

				int resp = JOptionPane.showConfirmDialog(null, "Deseja realmente finalizar a compra?");

				if (resp == JOptionPane.YES_OPTION == true) {

					try {
						vendaDAO.abrirConexao();

						Venda venda = new Venda(Integer.parseInt(txtIdVenda.getText())
								, txtNomeCliente.getText()
								, Integer.parseInt(txtIdCliente.getText())
								, totalCompra
								, vlrPagamento
								, vlrTroco
								, getDate()
								, getTime());
						
						vendaDAO.gravar(venda);
						
						limparCampos();
						
						vendaDAO.fecharConexao();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnFinalizarVenda.setBounds(1083, 543, 217, 29);
		add(btnFinalizarVenda);

	}

	private void limparCampos(){

		txtNomeCliente.setText("");
		txtNomeProduto.setText("");
		txtValorUnidade.setText("");
		txtQuantidade.setText("");
		txtValorTotal.setText("");
		txtIdCliente.setText("");
		txtIdProduto.setText("");
		txtValorPagamento.setText("");
		txtTroco.setText("");

	}

	private Date getDate() {

		//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = new Date(); 

		return date; 
	}
	
	private String getTime() {

		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(); 

		return dateFormat.format(date); 
	}


}
