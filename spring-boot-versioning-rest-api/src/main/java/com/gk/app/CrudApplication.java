package com.gk.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
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
