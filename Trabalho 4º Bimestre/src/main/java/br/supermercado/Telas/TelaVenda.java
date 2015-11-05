package br.supermercado.Telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.supermercado.DAO.ClienteDAO;
import br.supermercado.DAO.ProdutoDAO;
import br.supermercado.ModelTabelas.TabelaConsultaCliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class TelaVenda extends JPanel {
	
	private JTable tblVenda;
	private JTable tblGenerica;
	
	private ClienteDAO clienteDAO = new ClienteDAO();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
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
	

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public TelaVenda() throws SQLException {
		setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(45, 33, 120, 14);
		add(lblNomeDoCliente);		
		
		JLabel lblNomeDoProduto = new JLabel("Descri\u00E7\u00E3o do Produto");
		lblNomeDoProduto.setBounds(662, 33, 132, 14);
		add(lblNomeDoProduto);
		
		JLabel lblValorTotal = new JLabel("Valor Unidade");
		lblValorTotal.setBounds(1021, 172, 110, 14);
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
		btnNewButton.setBounds(948, 251, 352, 36);
		add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(45, 298, 1255, 239);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		tblVenda = new JTable();
		scrollPane_1.setViewportView(tblVenda);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(175, 30, 378, 20);
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
		btnNewButton_1.setBounds(563, 30, 89, 20);
		add(btnNewButton_1);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setBounds(804, 30, 397, 20);
		add(txtNomeProduto);
		txtNomeProduto.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setBounds(1211, 29, 89, 23);
		add(btnNewButton_2);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(1021, 136, 89, 14);
		add(lblQuantidade);
		
		txtValorUnidade = new JTextField();
		txtValorUnidade.setBounds(1131, 169, 86, 20);
		add(txtValorUnidade);
		txtValorUnidade.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(1131, 133, 86, 20);
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
		lblIdCliente.setBounds(45, 65, 68, 14);
		add(lblIdCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setBounds(123, 62, 86, 20);
		add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		JLabel lblIdProduto = new JLabel("Id Produto");
		lblIdProduto.setBounds(662, 65, 68, 14);
		add(lblIdProduto);
		
		txtIdProduto = new JTextField();
		txtIdProduto.setEditable(false);
		txtIdProduto.setBounds(729, 62, 89, 20);
		add(txtIdProduto);
		txtIdProduto.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(45, 115, 893, 172);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblGenerica = new JTable();
		scrollPane.setViewportView(tblGenerica);

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
}
