package teste;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import carteira.Transacao;
import modelo.TipoTransacao;

public class TesteInsereTransacao {

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			Transacao t = new Transacao("BBSE3",  
					new BigDecimal("23.50"), 
					20,
					LocalDate.of(2021, 2, 1),
					TipoTransacao.COMPRA);
			
			String sql = "INSERT INTO transacoes (id, ticker, preco, quantidade, data, tipo) VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setInt(1, 1);
			ps.setString(2, t.getTicker());
			ps.setBigDecimal(3, t.getPreco());
			ps.setInt(4, t.getQuantidade());
			ps.setDate(5, Date.valueOf(t.getData()));
			ps.setString(6, t.getTipo().toString());
			
			ps.execute();
			
		} catch (SQLException e) {
			System.err.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		}
		
	}
	
}
