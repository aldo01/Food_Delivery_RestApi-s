package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DevelopmentEnv implements EnvConfiguration {
	
	@Value("${starterApp.db.name.dev}")
	private String dbName;
	@Value("${starterApp.db.driver}")
	private String dbDriverName;
	@Value("${starterApp.db.port.dev}")
	private String dbPort;
	@Value("${starterApp.db.ip.dev}")
	private String dbIpName;
	@Value("${starterApp.db.auth.dev.user}")
	private String dbUserName;
	@Value("${starterApp.db.auth.dev.pass}")
	private String dbPassword;

	
	

	@Override
	public String getDBName() {
		return dbName;
	}

	@Override
	public String getDBDriver() {
		return dbDriverName;
	}

	@Override
	public String getDBPort() {
		return dbPort;
	}

	@Override
	public String getDBIp() {
		return dbIpName;
	}

	@Override
	public String getDBUser() {
		return dbUserName;
	}

	@Override
	public String getDBPass() {
		return dbPassword;
	}
}
	
	