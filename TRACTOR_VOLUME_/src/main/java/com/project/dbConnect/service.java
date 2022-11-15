package com.project.dbConnect;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.model.Case;
import com.project.model.RelTractorVolumeMon;


@Repository
public class service {
	
	List<POJO> data = null;

	@Autowired
	 JdbcTemplate dataTemplate;
	
	@Autowired
	Case cases;
	
	
	
	String query1 = "SELECT AGREEMENTNO,ZONE,TOTAL_SOURCED_QUANTITY_MFG,ASSETTYPE,AREA,REGION,BRANCH,PAYOUT_PERIODICITY,AMOUNT_FINANCED,MANUFACTURER_ID,SCHEME,TOTAL_SOURCED_VOLUME_MFG,DEALER_PAN_NUMBER,to_char(to_date(LMS_AUTH_DATE),'yyyy-MM-dd') as LMS_AUTH_DATE,MODEL_NO,PRODUCT,MAKE_ID,BUSINESS_IRR,TOTAL_SOURCED_QTY_REGION,TOTAL_SOURCED_QTY,TOTAL_SOURCED_VOLUME,TOTAL_SOURCED_VOLUME_REGION FROM PAYOUT_TRACTOR_VOLUME_TBL WHERE OSB_STATUS='PROCESSED'  AND AGREEMENTNO = 'TEST0001'";
	String query2 = "SELECT LMS_AUTH_DATE FROM PAYOUT_TRACTOR_VOLUME_TBL WHERE OSB_STATUS='PROCESSED'  AND AGREEMENTNO = 'TEST0001' ";
	
	      
	public Case Fetch_Data() {
				
		    List<POJO> data = dataTemplate.query(query1,new BeanPropertyRowMapper<POJO>(POJO.class));
		    
			List<RelTractorVolumeMon> RelTractorVolumeMonList=new ArrayList<>();
			Case cases=new Case();
			
				for (POJO obj:data)
				{
					System.out.println("list : "+obj.getagreementno()+" "+obj.getZONE()+" "+obj.getTOTAL_SOURCED_QUANTITY_MFG() + " " + obj.getLMS_AUTH_DATE());

					RelTractorVolumeMon entity=new RelTractorVolumeMon(obj.getagreementno(), obj.getZONE(),obj.getTOTAL_SOURCED_QUANTITY_MFG(),obj.getassettype(),obj.getAREA(),obj.getREGION(),obj.getBRANCH(),obj.getPAYOUT_PERIODICITY(),obj.getamount_financed(),obj.getMANUFACTURER_ID(),obj.getSCHEME(),obj.getTOTAL_SOURCED_VOLUME_MFG(),obj.getDEALER_PAN_NUMBER(),obj.getLMS_AUTH_DATE(),obj.getmodel_no(),obj.getPRODUCT(),obj.getMAKE_ID(),obj.getBUSINESS_IRR(),obj.gettotal_sourced_qty_region(),obj.gettotal_sourced_qty(),obj.getTOTAL_SOURCED_VOLUME(),obj.getTOTAL_SOURCED_VOLUME_REGION());
					RelTractorVolumeMonList.add(entity);
					
				}
				cases.setId("Batch1");
				cases.setDealerId(1);
				cases.setManufacturerDesc("text value");
				cases.setRelTractorVolumeMon(RelTractorVolumeMonList);
				
				return cases;
	}
	
	public List<POJO> hello() {
	    List<POJO> test = dataTemplate.query(query2,new BeanPropertyRowMapper<POJO>(POJO.class));

		return test;
	}
	
	public List<POJO> save(POJO user) {
		return dataTemplate.query("SELECT * FROM SAMPLE_TABLE1 ",
				new BeanPropertyRowMapper<POJO>(POJO.class));
	}	
	
	 
}
