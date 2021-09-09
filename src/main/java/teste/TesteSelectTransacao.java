package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import carteira.Transacao;
import dao.TransacaoDAO;
import java.util.List;


public class TesteSelectTransacao {

	public static void main(String[] args) throws SQLException {
		
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
		List<Transacao> transacoes = tDAO.listar();
		
		transacoes.forEach(System.out::println);
		
	}
	
}
