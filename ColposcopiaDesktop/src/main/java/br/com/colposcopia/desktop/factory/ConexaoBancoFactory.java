package br.com.colposcopia.desktop.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConexaoBancoFactory {
	static Optional<Connection> conn = Optional.empty();
	{
		
	}
	public static Optional<Connection> getConexao() {
		try {
			
			conn = Optional.ofNullable(
					DriverManager.getConnection("jdbc:sqlite:/home/edu/banco/banco.db"));
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		ConexaoBancoFactory.getConexao().ifPresent((con) ->{
			try {
				System.out.println(con.isClosed());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
	}
}
