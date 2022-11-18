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
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.model.Case;
import com.project.model.CaseRequest;
import com.project.dbConnect.POJO;
import com.project.dbConnect.service;


@Component
public class ControllerService {
	
	
	@Value("${spring.datasource.url}")
	private String url ;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Autowired Environment env ;
	
    String status="";

    public String Response(@RequestBody String json) throws Exception {
    	
    	//System.out.println("request--------->"+json);
    	RestTemplate restTemplate2 = new RestTemplate();
    	
    	String urlString2 = "https://cholamandalam--tst1.custhelp.com/determinations-server/batch/12.2.7/policy-models/VF_Volume_Payout/assessor/";
        URI uri = new URI(urlString2);
    	
    	HttpHeaders headers2 = new HttpHeaders();
    	headers2.setContentType(MediaType.APPLICATION_JSON);

    	HttpEntity<String> entity2 = new HttpEntity<String>(json,headers2);
    	String answer = restTemplate2.postForObject(uri, entity2, String.class);
    	//System.out.println(answer);
    	
   	
    	try 
    	{
    		//Class.forName("oracle.jdbc.driver.OracleDriver");
			//String mysqlUrl = "jdbc:oracle:thin:@mexacscifcl-sqmcv-scan.dbprimarysn.dbexacsvcn01.oraclevcn.com:1625/SITFIN_SITFIN_PDB.paas.oracle.com";
    		url = env.getProperty("spring.datasource.url");
    		username = env.getProperty("spring.datasource.username");
    		password = env.getProperty("spring.datasource.password");
    		
    		Connection con = DriverManager.getConnection(url,username,password);
    		
			System.out.println("Connection established......");
			
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
					  System.out.println(jsonz);
					RULE.add (jsonz.get("RULE_ID_TRACTOR"));
					TOTAL.add(jsonz.get("TOTAL_INCENTIVE_TRACTOR"));
					INCENTIVE.add(jsonz.get("INCENTIVE_SLAB_TRACTOR"));
					REFEREAL.add(jsonz.get("REFEREAL_FEE_SLAB_TRACTOR"));
					id.add(jsonz.getString("@id"));
				}
				System.out.println("Copied.........");
				int size=id.size();
				//System.out.println("Size : "+size);
				int count=0;
				PreparedStatement ps_processing,ps_pro,ps_unpro;
				
				try
				{
					System.out.println("...........Records Processing.........");
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
						ps_processing.executeUpdate();
						count++;
						//System.out.rintln(count+" row updated");
					}
					ps_processing.close();
					
					ps_pro=con.prepareStatement("UPDATE PAYOUT_TRACTOR_VOLUME_TBL SET OSB_STATUS ='PROCESSED' WHERE OSB_STATUS = 'PROCESSING'");
					ps_pro.executeUpdate();
					ps_pro.close();
					
					System.out.println("............Records Processed.........");
					
				} 
				catch(Exception e3)
				{
					ps_unpro=con.prepareStatement("UPDATE PAYOUT_TRACTOR_VOLUME_TBL SET OSB_STATUS='FAILED' WHERE OSB_STATUS = 'PROCESSING' ");
					ps_unpro.executeUpdate();
					ps_unpro.close();
														
					System.out.println("*******Failed*********");
					System.out.println(e3.getLocalizedMessage());
				}
								
				System.out.println(count+" >>>>>>>>>>>>>Records Updated....."); 
							
			} 
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			finally {
				try {
					con.close();
					System.out.println("Connection closed..........");
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

    
   // ==========================================REQUEST=====================================
    
  @Autowired(required = true) service serv;
    
  @Autowired(required = true) POJO pojo;

//@Scheduled(fixedRate = 5000 )

public String Request() throws IOException {
			
    	String apiResponse="";
    	
    	CaseRequest caseRequest=new CaseRequest();
    	
    	List <Case> casesList=new ArrayList<Case>();
    	casesList.add(serv.Fetch_Data());
    	caseRequest.setCases(casesList);
    	
    	List <String> outcome=new ArrayList<String>();
    	outcome.add("RULE_ID_TRACTOR");
    	outcome.add("TOTAL_INCENTIVE_TRACTOR");
    	outcome.add("INCENTIVE_SLAB_TRACTOR");
    	outcome.add("REFEREAL_FEE_SLAB_TRACTOR");
    	caseRequest.setOutcomes(outcome);
    	
    	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();    	
    	String json = gson.toJson(caseRequest);
    	
    	//String json2 = gson.toJson(caseRequest.getCases().get(0).getRelTractorVolumeMon().get(0).getLmsAuthDate());
    	//System.out.println(caseRequest.getCases().get(0).getRelTractorVolumeMon().get(0).getLmsAuthDate());
    	//System.out.println(json.toString());
    	//System.out.println("***************request*********"+"\n"+ json);
    	
		try
		{
			apiResponse =  Response(json);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			apiResponse="";
		}    	
    	//return json;
		return apiResponse;		
	}
    

}

