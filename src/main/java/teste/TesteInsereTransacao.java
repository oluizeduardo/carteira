package teste;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import carteira.Transacao;
import dao.TransacaoDAO;
import modelo.TipoTransacao;

public class TesteInsereTransacao {

	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimezone=UTC";
			String usuario = "root";
			String senha = "root";
			
			conexao = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro ao conectar com o banco de dados.");
			e.printStackTrace();
		}
		
		TransacaoDAO tDAO = new TransacaoDAO(conexao);
		tDAO.cadastrar(new Transacao("XCCM15", 
				 new BigDecimal("8.20"), 5, 
				 LocalDate.now(), 
				 TipoTransacao.VENDA));
		
	}
	
}
