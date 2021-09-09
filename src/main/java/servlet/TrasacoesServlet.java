package servlet;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carteira.Transacao;
import dao.TransacaoDAO;
import factory.ConnectionFactory;
import modelo.TipoTransacao;

@WebServlet("/transacoes")
public class TrasacoesServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	private TransacaoDAO dao = null;
	
	
	
	public TrasacoesServlet() {
		this.dao = new TransacaoDAO(new ConnectionFactory().getConnection());
	}
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("transacoes", dao.listar());
		
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
		
		this.dao.cadastrar(transacao);
		
		resp.sendRedirect("transacoes");
	}
	
	
}
