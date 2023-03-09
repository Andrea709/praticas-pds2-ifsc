package exercicio8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CriaBanco {
	public static void main(String[] args) {
		try {
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost" + "?severTimezone=UTC", "root", "aluno");
			
			//statement
			Statement stm = conexao.createStatement();
			//query com create database
			String WSQL = "create database nog";
			//execute query
			stm.executeQuery(WSQL);
			//query create table
			WSQL = "create table sapinhos";
			stm.executeQuery(WSQL);
			
			conexao.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}