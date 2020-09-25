package br.edu.insper.mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private Connection connection = null;
	
	public DAO () throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados", "root", "sua_senha");
	}
	
	public List<Tarefa> getLista() throws SQLException {
		
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tarefa");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("nome"));
			tarefa.setStatus(rs.getInt("status"));
			tarefas.add(tarefa);
			
			
		}
		
		rs.close();
		stmt.close();
		return tarefas;
		
	}
	
	public void adiciona (Tarefa tarefa) throws SQLException {
		
		String sql = "INSERT INTO Tarefa (nome, status) VALUES (?,?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getNome());
		stmt.setInt(2, tarefa.getStatus());
		stmt.execute();
		stmt.close();
		
				
	}
	
	public void remove (Integer id) throws SQLException {
				
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Tarefa WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
		
	}
	
	public void edita(Tarefa tarefa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("UPDATE Tarefa SET nome=?, status=? WHERE id=?");
		stmt.setString(1, tarefa.getNome());
		stmt.setInt(2, tarefa.getStatus());
		stmt.setInt(3, tarefa.getId());
		stmt.execute();
		stmt.close();
	}
	
	public void close() throws SQLException {
		connection.close();
	}

}
