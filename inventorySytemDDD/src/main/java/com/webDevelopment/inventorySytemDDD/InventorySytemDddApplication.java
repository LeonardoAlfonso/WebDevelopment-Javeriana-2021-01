package com.webDevelopment.inventorySytemDDD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class InventorySytemDddApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventorySytemDddApplication.class, args);
	}
}
