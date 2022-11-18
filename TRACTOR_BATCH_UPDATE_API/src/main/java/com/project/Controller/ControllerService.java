package com.project.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerService {
	
	@Autowired JdbcTemplate jdbc;
	
	
	@RequestMapping(path="/batch/{batchid}")
    public String batchprocess(@PathVariable("batchid") String batchid)   {
		
		String osbquery = "UPDATE PAYOUT_TRACTOR_VOLUME_TBL SET OSB_STATUS='UNPROCESSED' WHERE OSB_BATCH_ID = '"+ batchid +"' ";
		  
				jdbc.update(osbquery)	;
	    
				return "batch : " + batchid + " updated to UNPROCESSED";
	}
	
	
	
	
	  	
} 

  