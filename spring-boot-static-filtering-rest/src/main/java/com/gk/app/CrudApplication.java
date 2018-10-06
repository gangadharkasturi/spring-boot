package com.gk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.gk.dao")
@EntityScan("com.gk.*") 
@ComponentScan(basePackages = "com.gk.*")
/**
 * 
 * @author Gangadhar
 *hit localhost:8081 to see HAL browser 
 */
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}
