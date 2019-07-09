package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public interface EnvConfiguration {
	String getDBName();

	String getDBDriver();

	String getDBPort();

	String getDBIp();

	String getDBUser();

	String getDBPass();
	
	

}
