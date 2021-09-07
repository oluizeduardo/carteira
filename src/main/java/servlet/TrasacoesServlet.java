package servlet;


import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carteira.Transacao;
import modelo.TipoTransacao;

@WebServlet("/transacoes")
public class TrasacoesServlet extends HttpServlet {

	private List<Transacao> transacoes = new ArrayList<>();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Transacao t1 = new Transacao("XPTO1", new BigDecimal("152.60"), 10,LocalDate.now(), TipoTransacao.COMPRA);
		Transacao t2 = new Transacao("XPTO2", new BigDecimal("2.60"), 50,LocalDate.now(), TipoTransacao.VENDA);
		Transacao t3 = new Transacao("XPTO3", new BigDecimal("18.00"), 6,LocalDate.now(), TipoTransacao.COMPRA);
		
		transacoes.add(t1);
		transacoes.add(t2);
		transacoes.add(t3);
		
		req.setAttribute("transacoes", transacoes);
		
		req.getRequestDispatcher("Transacoes.jsp").forward(req, resp);
	}
	
	
}
