package com.bytecode.core.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.bytecode.core.model.Connection;

@Component
public class CreateConnection {

	@Bean(name="beanConnection")
	public Connection getConnection() {
		Connection connection = new Connection();
		connection.setDb("mySql");
		connection.setUrl("localhost");
		return connection;
	}
}
