package controle;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Pessoa;

public class PessoaDAO {
	
	//conexao com o banco
	private Conexao con;
	
	
	public boolean inserir(Pessoa p) { //crud = letra c - create
		
		//instanciar a classe conexao
		con = Conexao.getInstancia();
		
		//abrir a conexao
		Connection c = con.conectar();
		try {
			String query = "insert into pessoa(cpf, nome) values (?, ?);";
			PreparedStatement stm = c.prepareStatement(null);
			
			
		    stm.setInt(1, 123);
		    stm.setString(2, "nog");
		    int valida = stm.executeUpdate();
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//fechar a conexao
		con.fecharConexao();
		
		return false;
	}
	
	public boolean atualizar(Pessoa p) {
		return false;
	}
	
	public boolean deletar(Pessoa p) {
		return false;
	}
	
	
	//crud -R- READ
	public ArrayList<Pessoa> listarPessoas() {
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		//instanciar a classe conexao
		con = Conexao.getInstancia();
		
		//abrir a conexao
		Connection c = con.conectar();
		try {
			Statement stm = c.createStatement();
			String query = "select * from pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int cpf = rs.getInt("cpf");
				String nome = rs.getString("nome");
				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);
				pessoas.add(p);
				
			}
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//fechar a conexao
		con.fecharConexao();
		
		
		return pessoas;
	}
	

}
