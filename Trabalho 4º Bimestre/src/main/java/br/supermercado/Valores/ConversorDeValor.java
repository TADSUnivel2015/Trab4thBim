package br.supermercado.Valores;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ConversorDeValor {
	
	public String transformaValor(String valor) throws ParseException{
		
		Number numero = NumberFormat.getNumberInstance(Locale.US).parse(valor);
		BigDecimal numeroAux = new BigDecimal(numero.floatValue());
		
		NumberFormat formatoPtBr = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	
		return formatoPtBr.format(numeroAux);
	}

}
