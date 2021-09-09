package teste;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import carteira.Transacao;
import java.time.LocalDate;

import com.mysql.cj.protocol.Resultset;

import modelo.TipoTransacao;

public class TesteSelectTransacao {

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			String sql = "SELECT * FROM transacoes";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getLong("id"));
				System.out.println(rs.getString("ticker"));
				System.out.println(rs.getDate("data"));
				System.out.println(rs.getBigDecimal("preco"));
				System.out.println(rs.getInt("quantidade"));
				System.out.println(rs.getString("tipo"));
				System.out.println("========================================");
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao conectar com o banco de dados!\n"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
