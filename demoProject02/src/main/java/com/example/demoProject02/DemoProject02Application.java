package com.example.demoProject02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoProject02Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoProject02Application.class, args);
	}

}
