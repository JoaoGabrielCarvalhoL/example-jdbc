package br.com.carv.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import br.com.carv.jdbc.entity.BeanUserFone;
import br.com.carv.jdbc.entity.User;

public class UserDaoTest {

	private User user = new User("João Gabriel Test", "27.joaogabriel@gmail.com");

	private UserDao userDao = new UserDao();

	@Test
	@Disabled
	public void should_save_user() {

		try {
			userDao.salvar(this.user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	@Disabled
	public void should_update_user() {

		user.setEmail("testemail@gmail.com");
		
		try {
			userDao.atualizar(this.user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Disabled
	public void should_delete_user() {
		
		try {
			userDao.apagar(user);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Disabled
	public void should_return_list_users() {
		
		try {
			List<User> users = userDao.buscarTodos();
			Assertions.assertNotNull(users); 
			
			for (User u : users) {
				System.out.println(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Disabled
	public void should_return_user() {
		
		try {
			
			User user = userDao.buscarPorId(10L);
			System.out.println(user);
			Assertions.assertNotNull(user);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void should_return_user_with_fone() {
		
		try {
			List<BeanUserFone> result  = userDao.listarUserFone(1L);
			Assertions.assertNotNull(result);
			
			for (BeanUserFone bean : result) {
				System.out.println(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
