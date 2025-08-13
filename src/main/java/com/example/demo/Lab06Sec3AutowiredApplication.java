package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages=
{"com.example.services",
		"com.example.model", "com.example.controller"})
public class Lab06Sec3AutowiredApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab06Sec3AutowiredApplication.class, args);
	}

}
