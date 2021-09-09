package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carteira.Transacao;
import modelo.TipoTransacao;

public class TransacaoDAO {

	private Connection conexao = null;
	
	public TransacaoDAO(Connection conn) {
		this.conexao = conn;
	}
	
	public void cadastrar(Transacao novaTransacao) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) { 
			System.err.println("Erro ao carregar o driver do banco de dados.");
		}
		
		try {
			
			String sql = "INSERT INTO transacoes (ticker, preco, quantidade, data, tipo) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, novaTransacao.getTicker());
			ps.setBigDecimal(2, novaTransacao.getPreco());
			ps.setInt(3, novaTransacao.getQuantidade());
			ps.setDate(4, Date.valueOf(novaTransacao.getData()));
			ps.setString(5, novaTransacao.getTipo().toString());
			
			ps.execute();
			
		} catch (SQLException e) {
			System.err.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		}
	}
	
	
	public List<Transacao> listar(){
		String url = "jdbc:mysql://localhost:3306/carteira?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "root";
		
		List<Transacao> transacoes = new ArrayList<Transacao>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) { 
			System.err.println("Erro ao carregar o driver do banco de dados.");
		}
		
		try {
			
			String sql = "SELECT * FROM transacoes";
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transacao t = new Transacao();
				
				t.setTicker(rs.getString("ticker"));
				t.setData(rs.getDate("data").toLocalDate());
				t.setPreco(rs.getBigDecimal("preco"));
				t.setQuantidade(rs.getInt("quantidade"));
				t.setTipo(TipoTransacao.valueOf(rs.getString("tipo")));
				
				transacoes.add(t);
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao conectar com o banco de dados!\n"+e.getMessage());
			e.printStackTrace();
		}
		return transacoes;
	}
	
}
