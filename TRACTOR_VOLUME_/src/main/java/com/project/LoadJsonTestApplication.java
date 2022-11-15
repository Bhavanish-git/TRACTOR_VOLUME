package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication
//(scanBasePackages= {"com.project"})

@SpringBootApplication(scanBasePackages= {"com.project"})
@EntityScan("com.project")
@EnableScheduling

public class LoadJsonTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadJsonTestApplication.class, args);
	}

}
