package com.pi.spring.ppmtool;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class PpmtoolApplication {

	/**
	 * Should be able to access h2 database through the http://localhost:8080/h2-console URL logged in as
	 * Driver Class org.h2.Driver
	 * JDBC URL jdbc:h2:mem:testdb
	 * User Name sa
	 * Password <BLANK>
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PpmtoolApplication.class, args);
	}

}

