package br.com.carv.jdbc.util;

import java.sql.Connection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectionFactoryTest {
	
	@Test
	public void should_connect() {
		Connection connection = ConnectionFactory.getConnection();
		Assertions.assertNotNull(connection);
	}

}
