package teste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import carteira.Transacao;
import modelo.TipoTransacao;

public class Teste {
	public static void main(String[] args) {
		Transacao t = new Transacao();
		
		t.setTicker("ITSA4");
		t.setPreco(new BigDecimal("10.0"));
		t.setQuantidade(100);
		t.setData(LocalDate.now());
		t.setTipo(TipoTransacao.COMPRA);
		
		System.out.println(t.getTicker());
		System.out.println(t.getPreco());
		System.out.println(t.getQuantidade());
		System.out.println(t.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(t.getTipo());
		
		System.out.println("===================");
		
		System.out.println(t);
	}
	
}
