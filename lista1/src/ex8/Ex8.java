package ex8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex8 {
	public static void main(String[] args) {
		try {
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+"?serverTimezone=UTC","root","aluno");
		
		Statement stm = conexao.createStatement();
		String WSQL = "create database Nog";
		stm.executeQuery(WSQL);
		WSQL = "create table Pessoa";
		stm.executeQuery(WSQL);
		
		
		
		conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
