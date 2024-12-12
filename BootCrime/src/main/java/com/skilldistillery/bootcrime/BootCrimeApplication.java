package com.skilldistillery.bootcrime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan("com.skilldistillery.jpacrime")
@SpringBootApplication
public class BootCrimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCrimeApplication.class, args);
	}

}
