package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conexao;
	private static Conexao instancia;
	//tem que usar sempre maiusculo nessa, regra de nomenclatura
	private static final String DATABASE = "hr";
	private static final String USER = "aluno";
	private static final String PSW = "aluno";
	
	//padrao single connection, para n gastar memoria ram
	private Conexao() {
		
	}
	
	public Conexao getInstancia() {
		if(instancia == null) {
			instancia = new Conexao();
		}
		
		return instancia;
	}
	//
	
	//conexao do banco de dados em si, por enquanto é um servidor que roda apenas na nossa maquina
	public static Connection conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/" 
					+ DATABASE + "?severTimezone=UTC", USER, PSW);
		} catch (SQLException e) { //tratamento de excessao
			e.printStackTrace();
		}
		
		return conexao;
	}
	//
	
	//fechamento da conexao
	public static boolean fecharConexao() {
	
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	//
		
}
