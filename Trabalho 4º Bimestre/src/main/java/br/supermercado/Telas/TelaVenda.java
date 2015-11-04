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

import br.supermercado.DAO.ClienteDAO;

/**
 * 
 * @author Alex Tezza
 * Dia 31 de outubro de 2015
 */

public class TelaVenda extends JPanel {
	
	private JTextField txtValorTotal;
	private JTextField txtValorPagamento;
	private JTextField txtTroco;
	private JTable tblProduto;
	private JTable tblVenda;
	
	private JComboBox cbNomeCliente;
	private JComboBox cbDescricaoProduto;
	
	private ClienteDAO clienteDAO = new ClienteDAO();

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public TelaVenda() throws SQLException {
		setLayout(null);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(45, 33, 120, 14);
		add(lblNomeDoCliente);
		

		clienteDAO.abrirConexao();
		
		Object[] clientesComboBox = clienteDAO.listar().toArray();
		
		DefaultComboBoxModel<Object> modelClientes = new DefaultComboBoxModel<>(clientesComboBox);
		
		cbNomeCliente = new JComboBox(clientesComboBox);
		cbNomeCliente.setBounds(175, 30, 500, 20);
		add(cbNomeCliente);
	
		clienteDAO.fecharConexao();
		
		
		JLabel lblNomeDoProduto = new JLabel("Descri\u00E7\u00E3o do Produto");
		lblNomeDoProduto.setBounds(45, 58, 132, 14);
		add(lblNomeDoProduto);
	
		
		
		TelaCadastroProduto produto = new TelaCadastroProduto();
		produto.abrirConexao();
		
		Object[] produtosComboBox = produto.listarProdutos().toArray();
		
		DefaultComboBoxModel<Object> modelProdutos = new DefaultComboBoxModel<>(produtosComboBox);
		
		cbDescricaoProduto = new JComboBox(modelProdutos);
		cbDescricaoProduto.setBounds(175, 55, 500, 20);
		add(cbDescricaoProduto);

		
		
		JLabel lblValorTotal = new JLabel("VALOR TOTAL");
		lblValorTotal.setBounds(175, 128, 89, 14);
		add(lblValorTotal);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtValorTotal.setBounds(274, 117, 110, 36);
		add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		JLabel lblValorPagamento = new JLabel("VALOR PAGAMENTO");
		lblValorPagamento.setBounds(433, 128, 122, 14);
		add(lblValorPagamento);
		
		txtValorPagamento = new JTextField();
		txtValorPagamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtValorPagamento.setBounds(565, 117, 110, 36);
		add(txtValorPagamento);
		txtValorPagamento.setColumns(10);
		
		JLabel lblTroco = new JLabel("TROCO");
		lblTroco.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTroco.setBounds(45, 185, 53, 14);
		add(lblTroco);
		
		txtTroco = new JTextField();
		txtTroco.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTroco.setBounds(108, 170, 146, 47);
		add(txtTroco);
		txtTroco.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(175, 83, 500, 20);
		add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(685, 30, 529, 156);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblProduto = new JTable();
		scrollPane.setViewportView(tblProduto);
		
		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.setBounds(685, 197, 529, 20);
		add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(45, 286, 1169, 276);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);
		
		tblVenda = new JTable();
		scrollPane_1.setViewportView(tblVenda);
		
		JButton btnRealizarVenda = new JButton("Realizar Venda");
		btnRealizarVenda.setBounds(1014, 230, 200, 50);
		add(btnRealizarVenda);
		
		JButton btnExcluirVenda = new JButton("Excluir Venda");
		btnExcluirVenda.setBounds(808, 230, 200, 50);
		add(btnExcluirVenda);

	}
	
	private void limparCampos(){
		
		txtValorTotal.setText("");
		txtValorPagamento.setText("");
		txtTroco.setText("");
		
//		tblProduto
		
		cbNomeCliente.setSelectedIndex(0);
		cbDescricaoProduto.setSelectedIndex(0);
		
	}

}
