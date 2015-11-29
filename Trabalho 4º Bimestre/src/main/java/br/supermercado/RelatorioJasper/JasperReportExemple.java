package br.supermercado.RelatorioJasper;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.HashMap; 
import java.util.Map; 

import javax.swing.JOptionPane;

import br.supermercado.conexao.ConexaoMySQL;
import net.sf.jasperreports.engine.JRException; 
import net.sf.jasperreports.engine.JRResultSetDataSource; 
import net.sf.jasperreports.engine.JasperCompileManager; 
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.JasperPrint; 
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign; 
import net.sf.jasperreports.engine.xml.JRXmlLoader; 
import net.sf.jasperreports.view.JasperViewer;



public class JasperReportExemple {
	
	private static String OUT_PDF = null;
	Connection conexao;

	public JasperReportExemple() {

	} 

	public void gerar(String layout, String query, String nomeArquivo) throws JRException , SQLException, ClassNotFoundException, IOException { 

		OUT_PDF = nomeArquivo;
		
		//gerando o jasper design
		JasperDesign desenho = JRXmlLoader.load( layout );

		//compila o relatório
		JasperReport relatorio = JasperCompileManager.compileReport( desenho );

		//estabelece conexão
		
		conexao = ConexaoMySQL.getConexaoMySQL(); 
		
		Statement stm = conexao.createStatement();
		ResultSet rs = stm.executeQuery( query );

		//implementação da interface JRDataSource para DataSource ResultSet 
		JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );

		//executa o relatório 
		Map parametros = new HashMap(); 
		 parametros.put("", null);

		JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
		
		JasperExportManager.exportReportToPdfFile(impressao, OUT_PDF);

		JOptionPane
				.showMessageDialog(
						null,
						"<html>Arquivo exportado para PDF!<br><br>O arquivo será aberto!.");

		Desktop.getDesktop().open(new File(OUT_PDF));

//		Exibe o resultado 
		
//		JasperViewer viewer = new JasperViewer( impressao , true );
//		viewer.show();
	} 
}


