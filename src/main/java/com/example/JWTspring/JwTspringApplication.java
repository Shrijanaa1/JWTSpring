package com.example.JWTspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "com.example.JWTspring.repository")
@SpringBootApplication
public class JwTspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwTspringApplication.class, args);
	}

}
