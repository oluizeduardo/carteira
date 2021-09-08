package servlet;


import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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


	private static final long serialVersionUID = 1L;
	
	private List<Transacao> transacoes = new ArrayList<>();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("transacoes", transacoes);
		
		req.getRequestDispatcher("WEB-INF/jsp/Transacoes.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ticker = req.getParameter("ticker");
		LocalDate data = LocalDate.parse(req.getParameter("data"));
		BigDecimal preco = new BigDecimal(req.getParameter("preco").replace(",", "."));
		int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		TipoTransacao tipo = TipoTransacao.valueOf(req.getParameter("tipo"));

		Transacao transacao = new Transacao(ticker, preco, quantidade, data, tipo);
		
		transacoes.add(transacao);
		
		resp.sendRedirect("transacoes");
	}
	
	
}
