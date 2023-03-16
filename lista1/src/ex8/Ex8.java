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
//		WSQL = "create database Nog01";
//		stm.executeUpdate(WSQL);
		
		WSQL = "use Nog01";
		stm.executeUpdate(WSQL);
		
		WSQL = "create table Pessoa ("
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
