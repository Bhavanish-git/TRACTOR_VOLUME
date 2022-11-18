package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication(scanBasePackages= {"com.project"})
@EntityScan("com.project")

public class LoadJsonTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadJsonTestApplication.class, args);
	}

}
