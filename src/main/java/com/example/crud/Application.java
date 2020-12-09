package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication(scanBasePackages={
		"com.example.repository.UserRepository", "com.example.UserController"})
@ComponentScan({"com.example.controller"})

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
//		@ComponentScan({"com.yawintutor.controller"})

		SpringApplication.run(Application.class,  args);
		
	}

}
