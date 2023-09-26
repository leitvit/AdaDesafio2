package com.ada.prospect;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Swagger OpenAPI",
				version = "1",
				description = "Projeto desafio do bootcamp fullstack Cielo"
		)
)
public class ProspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProspectApplication.class, args);
	}

}
