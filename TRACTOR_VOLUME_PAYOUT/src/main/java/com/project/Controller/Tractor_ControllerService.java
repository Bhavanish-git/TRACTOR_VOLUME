package com.project.Controller;

import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.dbConnect.Tractor_POJO;
import com.project.dbConnect.Tractor_Service;
import com.project.request.model.Case;
import com.project.request.model.CaseRequest;


@Component
@Service
public class Tractor_ControllerService {
	
	
	@Value("${spring.datasource.url}")
	private String db_url ;
	
	@Value("${spring.datasource.username}")
	private String db_username;
	
	@Value("${spring.datasource.password}")
	private String db_password;
	
	@Value("${opa.auth.url}")
	private String token_url;
	
	@Value("${opa.auth.username}")
	private String token_username;

	@Value("${opa.auth.password}")
	private String token_password;
	
	@Value("${opa.tractor.url}")
	private String opa_tractor_url;

	
	//@Autowired Environment env ;
	
    String status="";
    
    //==============================================================AUTH_TOKEN==============================================================
    
    public String generateToken() throws Exception{
    	
    	String tokenstr="";
    	
    	try {
        RestTemplate restTemplate = new RestTemplate();
        URI token_uri = new URI(token_url);
    	
    	HttpHeaders headers1 = new HttpHeaders();
    	
      	headers1.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      	
      	MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
      	map.add("grant_type", "client_credentials");										
      	map.add("client_id", token_username);														//opa token username
      	map.add("client_secret", token_password);													//opa token password
      	
      	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers1);
      	ResponseEntity<String>  token = restTemplate.exchange( token_uri,HttpMethod.POST, request , String.class);
      
      	System.out.println("\n Token generation status code : " + token.getStatusCode());
      	
      	JSONObject object=new JSONObject(token.getBody());
      	
      //	System.out.println(object);
      	
      	if(object.has("access_token")) {

          //	Object token_type = object.get("token_type");
          	Object access_token =  object.get("access_token");
         	//System.out.println("\n Authorization Value = " + token_type + " " + access_token);
          	
          	tokenstr=  access_token.toString();                         //token invalid check --> if valid token value  is assigned
          	
      	}else {
      		
      		tokenstr= "";											//if invalid token value ""
      		
      	}
    	}catch (Exception e) {
	
    		e.printStackTrace();
    		tokenstr= "";											//any exception token value ""
      		
		}
      	
      	return tokenstr;
    	
    }

    
   // =================================================  REQUEST  ====================================================
    
  @Autowired(required = true) Tractor_Service serv;
    
  @Autowired(required = true) Tractor_POJO pojo;

//@Scheduled(fixedRate = 5000 )

public String Request() throws IOException {
			
    	String apiResponse="";
    	
    	CaseRequest caseRequest = new CaseRequest();
    	
    	List <Case> casesList=new ArrayList<Case>();
    	casesList.add(serv.casesInput());
    	caseRequest.setCases(casesList);
    	
    	List <String> outcome=new ArrayList<String>();
    	outcome.add("RULE_ID_TRACTOR");
    	outcome.add("TOTAL_INCENTIVE_TRACTOR");
    	outcome.add("INCENTIVE_SLAB_TRACTOR");
    	outcome.add("REFEREAL_FEE_SLAB_TRACTOR");
    	caseRequest.setOutcomes(outcome);
    	
    	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();         	//for json date format
    	String json = gson.toJson(caseRequest);

    	//System.out.println("\n REQUEST >>>>>> " +json);

		try
		{
			String auth_token = generateToken();                						//call generate token method

	    	if(auth_token.isEmpty()) {
	    		System.out.println("\n Token invalid ");											//if empty --> invalid
	    	}
	    	else {
	    		
	    		System.out.println("\n Token validation success");
	    		apiResponse =  Response(json,auth_token);     						    //else send request to response method --> opa url hit
	    	}
			
			//apiResponse =  Response(json);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			apiResponse="";
		}    	
    	//return json;
		return apiResponse;		
	}
//=======================================================RESPONSE===================================================================

public String Response(@RequestBody String json , String auth_token) throws Exception {
	

	
	RestTemplate restTemplate2 = new RestTemplate();
	URI uri = new URI(opa_tractor_url);
	
	HttpHeaders headers2 = new HttpHeaders();
	headers2.setContentType(MediaType.APPLICATION_JSON);          
	headers2.setBearerAuth(auth_token);                                  //set auth token 
	
   
	HttpEntity<String> entity2 = new HttpEntity<String>(json,headers2);
	String answer = restTemplate2.postForObject(uri, entity2, String.class);
	//System.out.println(answer);
	
	
	try 
	{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//String mysqlUrl = "jdbc:oracle:thin:@mexacscifcl-sqmcv-scan.dbprimarysn.dbexacsvcn01.oraclevcn.com:1625/SITFIN_SITFIN_PDB.paas.oracle.com";
		
		Connection con = DriverManager.getConnection(db_url,db_username,db_password);
		
		System.out.println("\nConnection established......");
		
		try
		{
			JSONObject jsonObj = new JSONObject(answer);
			
			JSONArray ja_data = jsonObj.getJSONArray("cases");
			//int ja_len = ja_data.length();
			//System.out.println( "ja_data length ===================" + ja_len);
			
			JSONObject jsonObj1 = ja_data.getJSONObject(0);
			JSONArray ja = jsonObj1.getJSONArray("Rel_Tractor_Volume_Mon");
			int len = ja.length();

			ArrayList<String> id = new ArrayList<>();
			ArrayList<Object> RULE = new ArrayList<>();
			ArrayList<Object> TOTAL = new ArrayList<>();
			ArrayList<Object> INCENTIVE = new ArrayList<>();
			ArrayList<Object> REFEREAL = new ArrayList<>();
			//System.out.println("ja.Len  ================== "+len);
			
			
			for(int j=0; j<len; j++)
			{
				JSONObject jsonz = ja.getJSONObject(j);
				 // System.out.println(jsonz);
				RULE.add (jsonz.get("RULE_ID_TRACTOR"));
				TOTAL.add(jsonz.get("TOTAL_INCENTIVE_TRACTOR"));
				INCENTIVE.add(jsonz.get("INCENTIVE_SLAB_TRACTOR"));
				REFEREAL.add(jsonz.get("REFEREAL_FEE_SLAB_TRACTOR"));
				id.add(jsonz.getString("@id"));
			}
			System.out.println("\n Copied.........");
			int size=id.size();
			//System.out.println("Size : "+size);
			int count=0;
			PreparedStatement ps_processing,ps_pro,ps_unpro;
			
			try
			{
				System.out.println("............Records Processing.........");
				ps_processing = con.prepareStatement("UPDATE PAYOUT_TRACTOR_VOLUME_TBL SET RULE_ID_TRACTOR = ?, TOTAL_INCENTIVE_TRACTOR = ? ,INCENTIVE_SLAB_TRACTOR = ?,REFEREAL_FEE_SLAB_TRACTOR = ?,OSB_STATUS = 'PROCESSING' WHERE AGREEMENTNO = ?");		          
					
			String agreementno = "";
			String ruleid = "";
			String TOTALINCENTIVE = "";
			String INCENTIVESLAB = "";
			String REFEREALFEESLAB = "";
			
				for(int i=0;i<size;i++)
				{
					 agreementno = id.get(i) ;
					 System.out.println("agreementno : "+agreementno);
					
					if(RULE.get(i).toString().equals("{}")) {
						
						ruleid = "0";

						 }else {
								ruleid = RULE.get(i).toString();

						 }  
					
					System.out.println("RULE_ID === " + ruleid);
					
					if(TOTAL.get(i).toString().equals("{}")) {
						 TOTALINCENTIVE = "0";


					 }else {
						 TOTALINCENTIVE = TOTAL.get(i).toString();

					 }
					//System.out.println("total incentive ==== "+TOTAL.get(i));
					System.out.println("TOTALINCENTIVE === "+TOTALINCENTIVE);


					if(INCENTIVE.get(i).toString().equals("{}")) {
						INCENTIVESLAB =  "0";


						 }else {
								INCENTIVESLAB = INCENTIVE.get(i).toString();

						 }
					System.out.println("INCENTIVESLAB  ===  "+INCENTIVESLAB);

					if(REFEREAL.get(i).toString().equals("{}")) {  
						REFEREALFEESLAB =  "0";

						 }else {
								
								REFEREALFEESLAB = REFEREAL.get(i).toString();

						 }
					
					System.out.println("REFEREALFEESLAB  ===  "+REFEREALFEESLAB);

					ps_processing.setDouble(1, Double.parseDouble(ruleid));
					//System.out.println(ps_processing.setInt(1, (Integer) ruleid));
					
					ps_processing.setDouble(2,Double.parseDouble(TOTALINCENTIVE) );
					ps_processing.setDouble(3, Double.parseDouble(INCENTIVESLAB));
					ps_processing.setDouble(4, Double.parseDouble(REFEREALFEESLAB));
					ps_processing.setString(5, agreementno);
					//ps_processing.executeUpdate();
					count++;
					//System.out.rintln(count+" row updated");
				}
				ps_processing.close();
				
				ps_pro=con.prepareStatement("UPDATE PAYOUT_TRACTOR_VOLUME_TBL SET OSB_STATUS ='PROCESSED' WHERE OSB_STATUS = 'PROCESSING'");
				//ps_pro.executeUpdate();
				ps_pro.close();
				
				System.out.println("............Records Processed.........");
				
			} 
			catch(Exception e3)
			{
				ps_unpro=con.prepareStatement("UPDATE PAYOUT_TRACTOR_VOLUME_TBL SET OSB_STATUS='FAILED' WHERE OSB_STATUS = 'PROCESSING' ");
				//ps_unpro.executeUpdate();
				ps_unpro.close();
													
				System.out.println("*******Failed*********");
				System.out.println(e3.getLocalizedMessage());
			}
							
			System.out.println("............" +count + " Records Updated........."); 
						
		} 
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
				System.out.println("\nConnection closed..........");
			} 
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
		}
		    	
	} 
	catch(Exception e2)
	{
		e2.printStackTrace();
	}
	return answer;
	
}
    

}

