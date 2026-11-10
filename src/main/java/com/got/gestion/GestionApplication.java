package com.got.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
 
@OpenAPIDefinition(info = @Info(
    title = "API gestion",
    version = "1.0",
    description = "Grandes casas, casas vasallas, fortalezas y regimientos"))
@SpringBootApplication
public class GestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionApplication.class, args);
	}

}
