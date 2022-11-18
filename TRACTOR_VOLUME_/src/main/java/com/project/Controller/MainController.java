package com.project.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@Autowired JdbcTemplate jdbc;
	
	@Autowired(required=true) ControllerService cont;
		
	
	@PostMapping(path = "response")
	@Scheduled(fixedRate = 15000 )
	public String response() throws IOException {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cont.Request();
	}
	
	


}
