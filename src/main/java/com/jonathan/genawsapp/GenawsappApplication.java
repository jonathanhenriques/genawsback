package com.jonathan.genawsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "genaws", version = "1", description = "API desenvolvida para gestao basica de uma escola"))
public class GenawsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenawsappApplication.class, args);
	}

}
