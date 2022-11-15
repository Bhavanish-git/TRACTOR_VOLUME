package com.project.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dbConnect.POJO;
import com.project.dbConnect.service;

@RestController
public class MainController {
	
	@Autowired(required=true) ControllerService cont;
	
	@Autowired(required=true) service serv;
	
	
	@PostMapping(path = "response")
//	@Scheduled(fixedRate = 5000 )
	public String response() throws IOException {
		return cont.Response();
	}
	
	
	@RequestMapping("/test")
//	@Scheduled(fixedRate = 5000 )
	public List<POJO> test() throws IOException {
		return serv.hello();
	}
	
	
	

}
