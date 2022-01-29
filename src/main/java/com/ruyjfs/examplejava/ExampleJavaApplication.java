package com.ruyjfs.examplejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExampleJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleJavaApplication.class, args);
	}

}
