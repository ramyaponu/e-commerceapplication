package com.example.webproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
@ComponentScan(basePackages = "com.example.webproject.repository2")
public class ECommercewebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercewebApplication.class, args);
	}

}
