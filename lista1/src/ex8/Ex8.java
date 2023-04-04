package ex8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex8 {
	public static void main(String[] args) {
		try {
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/","root","aluno");
		
		Statement stm = conexao.createStatement();
		String WSQL;
		
		WSQL = "create database if not exists nog";
		stm.executeUpdate(WSQL);
		
		WSQL = "use nog";
		stm.executeUpdate(WSQL);
		
		WSQL = "create table if not exists Pessoa ("
				+ "	cpf int not null primary key,"
				+ "    nome varchar(50)"
				+ ")";
		stm.executeUpdate(WSQL);
		
		
		
		
		conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
