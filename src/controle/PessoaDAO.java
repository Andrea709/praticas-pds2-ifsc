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
			String query = "INSERT INTO pessoa(cpf, nome) VALUES (?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			
		    stm.setInt(1, 123);
		    stm.setString(2, "nog");
		    stm.executeUpdate();
		    return true;
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//fechar a conexao
		con.fecharConexao();
		return false;
	}
	
	public boolean atualizar(Pessoa p) {
		Connection conn = Conexao.getInstancia().conectar();
		
		try {
			String query = "UPDATE pessoa SET nome = ? WHERE cpf = ?";
			PreparedStatement stm = conn.prepareStatement(query);
			stm.setString(1, p.getNome());
			stm.setInt(2, p.getCpf());
			stm.executeUpdate();
			return true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
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
