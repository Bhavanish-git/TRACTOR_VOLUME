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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.project.model.Case;
import com.project.model.CaseRequest;
import com.project.dbConnect.service;


@Component
public class ControllerService {
	
	String status="";
	
    @PostMapping(path = "status",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public String Request(@RequestBody String json) throws Exception {
    	
    	System.out.println("request--------->"+json);
    	RestTemplate restTemplate2 = new RestTemplate();
    	
    	String urlString2 = "https://cholamandalam--tst1.custhelp.com/determinations-server/batch/12.2.7/policy-models/VF_Volume_Payout/assessor/";
        URI uri = new URI(urlString2);
    	
    	HttpHeaders headers2 = new HttpHeaders();
    	headers2.setContentType(MediaType.APPLICATION_JSON);

    	HttpEntity<String> entity2 = new HttpEntity<String>(json,headers2);
    	String answer = restTemplate2.postForObject(uri, entity2, String.class);
    	
    	System.out.println(answer);
    	
   	
    	/*try {
    		
    		Class.forName("oracle.jdbc.driver.OracleDriver");
			String mysqlUrl = "jdbc:oracle:thin:@mexacscifcl-sqmcv-scan.dbprimarysn.dbexacsvcn01.oraclevcn.com:1625/SITFIN_SITFIN_PDB.paas.oracle.com";
			Connection con = DriverManager.getConnection(mysqlUrl, "cholabre", "Welcome_789");
			System.out.println("Connection established......");
			
			    try {
									
					JSONObject jsonObj = new JSONObject(answer);
					JSONArray ja_data = jsonObj.getJSONArray("cases");
				            
					JSONObject jsonObj1 = ja_data.getJSONObject(0);
					JSONArray ja = jsonObj1.getJSONArray("statusentity");
					int len = ja.length();
						
					ArrayList<String> id = new ArrayList<>();
					ArrayList<String> status = new ArrayList<>();
					//System.out.println("Len  = "+len);
						
					for(int j=0; j<len; j++)
					{
						JSONObject jsonz = ja.getJSONObject(j);
				        //  System.out.println(jsonz);
				        status.add(jsonz.getString("ACTIVE_STATUS"));
				        id.add(jsonz.getString("@id"));
					}
						
					System.out.println("Copied.........");
					int size=id.size();
					//System.out.println("Size : "+size);
					int count=0;
					PreparedStatement ps_processing,ps_pro,ps_unpro;
		
						try {
							System.out.println("...........Records Processing.........");
							ps_processing = con.prepareStatement("UPDATE SAMPLE_TABLE1 SET ACTIVE_STATUS = ?, STAMP = current_timestamp ,WSO2_STATUS = 'PROCESSING' WHERE AGREEMENT_NO = ?");		          
									
							for(int i=0;i<size;i++)
							{
								String agreement_no = id.get(i) ;
								//System.out.println("no : "+agreement_no);
								String active_status = status.get(i);
								//System.out.println("as : "+active_status);
								ps_processing.setString(1, active_status);
								ps_processing.setString(2, agreement_no);
								ps_processing.executeUpdate();
								count++;
								//System.out.rintln(count+" row updated");
							}
								ps_processing.close();
											
								ps_pro=con.prepareStatement("update sample_table1 set WSO2_status ='PROCESSED' where WSO2_STATUS = 'PROCESSING'");
								ps_pro.executeUpdate();
								ps_pro.close();
										
								System.out.println("............Records Processed.........");
									
					     } catch(Exception e3)
							{
								ps_unpro=con.prepareStatement("UPDATE SAMPLE_TABLE1 SET WSO2_STATUS='UNPROCESSED' where WSO2_STATUS = 'PROCESSING' ");
								ps_unpro.executeUpdate();
								ps_unpro.close();
														
								System.out.println("*******Failed*********");
							}
								
					System.out.println(count+" >>>>>>>>>>>>>Records Updated....."); 
							
				} catch(Exception e1){
						e1.printStackTrace();
				   }
			    	 finally {
								try {
									  con.close();
									  System.out.println("Connection closed..........");
									} catch (SQLException sqlException)
								      {
									                sqlException.printStackTrace();
									  }
			    	          }
	     }  catch(Exception e2){
	    	e2.printStackTrace();
	        }*/
    	
    return answer;
    	
    }

    
   // ==========================================JDBC=====================================
    
    @Autowired(required = true) service serv;
	//@Scheduled(fixedRate = 5000 )
    
		public String Response() throws IOException {
    	
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
    	
    	Gson gson = new Gson();
    	String json = gson.toJson(caseRequest);
    	
    	System.out.println(json);
    	
		try
		{
			apiResponse=  Request(json);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			apiResponse="";
		}
		//jsontodb.update();
    	
    	//return json;
		return apiResponse;		
	}
   

		

    /*====================================  working code for get method  =====================================================
    			
    	ResponseEntity<String> responseEntity = null ;
    	
    	String urlString = "http://127.0.0.1:8080/gallop/";

    	RestTemplate restTemplate = new RestTemplate();
        
    	URI uri = new URI(urlString);
    	 
    	ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
    	     
    	return result;
    	
    ==========================================================================================================================*/
    

}

