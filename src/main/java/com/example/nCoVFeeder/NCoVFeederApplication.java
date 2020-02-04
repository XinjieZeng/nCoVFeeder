package com.example.nCoVFeeder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NCoVFeederApplication {

	public static void main(String[] args) {
		SpringApplication.run(NCoVFeederApplication.class, args);
	}

}
