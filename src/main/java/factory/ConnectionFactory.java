package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.TransacaoDAO;

public class ConnectionFactory {

	public Connection getConnection() {
		
		Connection conexao = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) { 
			System.err.println("Erro ao carregar o driver do banco de dados.");
		}
		
		try {
			String url = "jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimezone=UTC";
			String usuario = "root";
			String senha = "root";
			conexao = DriverManager.getConnection(url, usuario, senha);
			
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro ao conectar com o banco de dados.");
			e.printStackTrace();
		}
		return conexao;
	}
	
}
