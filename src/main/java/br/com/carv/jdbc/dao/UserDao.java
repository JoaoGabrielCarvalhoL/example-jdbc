package br.com.carv.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.carv.jdbc.entity.BeanUserFone;
import br.com.carv.jdbc.entity.Telefone;
import br.com.carv.jdbc.entity.User;
import br.com.carv.jdbc.util.ConnectionFactory;

public class UserDao {
	
	private Connection connection;
	
	public UserDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void salvar(User user) throws SQLException {
		
		String sql = "INSERT INTO tb_user(nome, email) VALUES (?, ?, ?)"; 
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(2, user.getNome());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.execute();
		connection.commit();
	}
	
	public void atualizar(User user) throws SQLException {
		
		String sql = "UPDATE tb_user SET nome = ?, email = ? WHERE id = ?"; 
		PreparedStatement preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setString(1, user.getNome());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.setLong(3, user.getId());
		preparedStatement.execute();
		connection.commit();
	}
	
	public void apagar(User user) throws SQLException {
		
		String sql = "DELETE from tb_user WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setLong(1, user.getId());
		preparedStatement.execute();
		connection.commit();
	}
	
	public List<User> buscarTodos() throws SQLException {
		
		String sql = "SELECT * FROM tb_user ORDER BY nome";
		PreparedStatement preparedStatement = connection.prepareStatement(sql); 
		ResultSet resultSet = preparedStatement.executeQuery(); 
		
		List<User> users = new ArrayList<User>();
		
		while (resultSet.next()) {
			User user = new User(); 
			user.setId(resultSet.getLong("id"));
			user.setNome(resultSet.getString("nome"));
			user.setEmail(resultSet.getString("email"));
			users.add(user);
		}
		
		return users;
	}
	
	public User buscarPorId(Long id) throws SQLException {
		
		String sql = "SELECT * FROM tb_user WHERE id = ?";
		//String sql = "SELECT * FROM user WHERE id = " + id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setLong(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		User user = new User(); 
		
		while(resultSet.next()) {
			user.setId(resultSet.getLong("id"));
			user.setNome(resultSet.getString("nome"));
			user.setEmail(resultSet.getString("email"));			
		}
		return user;
	}
	
	public void salvarTelefone(Telefone telefone) throws SQLException {
		String sql = "INSERT INTO telefone_user(numero, tipo, user_id) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setString(1, telefone.getNumero());
		preparedStatement.setString(2, telefone.getTipo());
		preparedStatement.setLong(3, telefone.getIdUser());
		preparedStatement.execute();
		connection.commit();
	}
	
	public List<BeanUserFone> listarUserFone(Long idUser) throws SQLException {
		
		List<BeanUserFone> result = new ArrayList<BeanUserFone>();
		
		String sql = "select nome, numero, email from telefone_user as fone"
				+ " inner join tb_user as userp on fone.user_id = userp.id where userp.id = ?" ;
		PreparedStatement preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setLong(1, idUser);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			BeanUserFone bean = new BeanUserFone();
			bean.setNome(resultSet.getString("nome"));
			bean.setEmail(resultSet.getString("email"));
			bean.setNumero(resultSet.getString("numero"));
			result.add(bean);
		}
		
		return result;
	}
	
	public void deletarTelefonesPorUsuario(Long idUser) throws SQLException {
		
		String sql = "delete from telefone_user where user_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql); 
		preparedStatement.setLong(1, idUser);
		preparedStatement.execute();
		connection.commit();
	}

}
