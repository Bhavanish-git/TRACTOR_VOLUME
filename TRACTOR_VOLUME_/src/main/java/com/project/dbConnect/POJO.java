package com.project.dbConnect;



import java.sql.Date;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)


public class POJO {

	@JsonProperty("@id")
	private String agreementno;
	
	@JsonProperty("ZONE")
	private String zone;
	
	@JsonProperty("ASSET_TYPE")
	private String  assettype;
	
	private String AREA,
	REGION,
	BRANCH,
	PAYOUT_PERIODICITY,
	SCHEME,
	DEALER_PAN_NUMBER,
	PRODUCT;

    
	private Date LMS_AUTH_DATE;
	private Integer TOTAL_SOURCED_QUANTITY_MFG;
	
	@JsonProperty("FINANCED_AMOUNT")
	private Integer amount_financed;
	
	private String MANUFACTURER_ID;
	private Integer TOTAL_SOURCED_VOLUME_MFG;
	
	@JsonProperty("MODEL_ID")
	private String model_no;
	
	private String MAKE_ID;
	private Integer BUSINESS_IRR;
	
	@JsonProperty("TOTAL_SOURCED_QUANTITY_REGION")
	private Integer total_sourced_qty_region;
	
	@JsonProperty("TOTAL_SOURCED_QUANTITY")
	private Integer total_sourced_qty;
	
	private Integer TOTAL_SOURCED_VOLUME,
	TOTAL_SOURCED_VOLUME_REGION;
	
	/*private Integer TOTAL_INCENTIVE_TRACTOR,
	REFEREAL_FEE_SLAB_TRACTOR,
	RULE_ID_TRACTOR,
	INCENTIVE_SLAB_TRACTOR;*/

	


	public POJO() {
		 
    }

	public POJO(String id,String ZONE,Integer TOTAL_SOURCED_QUANTITY_MFG,String assettype,
			String AREA,String REGION,String BRANCH,String PAYOUT_PERIODICITY,
			Integer amount_financed,String MANUFACTURER_ID,String SCHEME,Integer TOTAL_SOURCED_VOLUME_MFG,
			String DEALER_PAN_NUMBER,Date LMS_AUTH_DATE,String model_no,String PRODUCT,String MAKE_ID,
			Integer BUSINESS_IRR,Integer total_sourced_qty_region,Integer total_sourced_qty,Integer TOTAL_SOURCED_VOLUME,
			Integer TOTAL_SOURCED_VOLUME_REGION)//	Integer TOTAL_INCENTIVE_TRACTOR,Integer REFEREAL_FEE_SLAB_TRACTOR,Integer RULE_ID_TRACTOR,Integer INCENTIVE_SLAB_TRACTOR)
	{
		this.agreementno=id;
		this.zone=ZONE;
		this.TOTAL_SOURCED_QUANTITY_MFG=TOTAL_SOURCED_QUANTITY_MFG;
		this.assettype=assettype;
		this.AREA=AREA;
		this.REGION=REGION;
		this.BRANCH=BRANCH;
		this.PAYOUT_PERIODICITY=PAYOUT_PERIODICITY;
		this.amount_financed=amount_financed;
		this.MANUFACTURER_ID=MANUFACTURER_ID;
		this.SCHEME=SCHEME;
		this.TOTAL_SOURCED_VOLUME_MFG=TOTAL_SOURCED_VOLUME_MFG;
		this.DEALER_PAN_NUMBER=DEALER_PAN_NUMBER;
		this.LMS_AUTH_DATE=LMS_AUTH_DATE;
		this.model_no=model_no;
		this.PRODUCT=PRODUCT;
		this.MAKE_ID=MAKE_ID;
		this.BUSINESS_IRR=BUSINESS_IRR;
		this.total_sourced_qty_region=total_sourced_qty_region;
		this.total_sourced_qty=total_sourced_qty;
		this.TOTAL_SOURCED_VOLUME=TOTAL_SOURCED_VOLUME;
		this.TOTAL_SOURCED_VOLUME_REGION=TOTAL_SOURCED_VOLUME_REGION;
		/*this.TOTAL_INCENTIVE_TRACTOR=TOTAL_INCENTIVE_TRACTOR;
		this.REFEREAL_FEE_SLAB_TRACTOR=REFEREAL_FEE_SLAB_TRACTOR;
		this.RULE_ID_TRACTOR=RULE_ID_TRACTOR;
		this.INCENTIVE_SLAB_TRACTOR=INCENTIVE_SLAB_TRACTOR;*/
	}
	
	public String getagreementno() {
		return agreementno;
	}

	public void setagreementno(String aGREEMENTNO) {
		agreementno = aGREEMENTNO;
	}

	public String getZONE() {
		return zone;
	}

	public void setZONE(String zONE) {
		zone = zONE;
	}
	
	public String getassettype() {
		return assettype;
	}

	public void setassettype(String aSSETTYPE) {
		assettype = aSSETTYPE;
	}

	public String getAREA() {
		return AREA;
	}

	public void setAREA(String aREA) {
		AREA = aREA;
	}

	public String getREGION() {
		return REGION;
	}

	public void setREGION(String rEGION) {
		REGION = rEGION;
	}

	public String getBRANCH() {
		return BRANCH;
	}

	public void setBRANCH(String bRANCH) {
		BRANCH = bRANCH;
	}

	public String getPAYOUT_PERIODICITY() {
		return PAYOUT_PERIODICITY;
	}

	public void setPAYOUT_PERIODICITY(String pAYOUT_PERIODICITY) {
		PAYOUT_PERIODICITY = pAYOUT_PERIODICITY;
	}

	public String getSCHEME() {
		return SCHEME;
	}

	public void setSCHEME(String sCHEME) {
		SCHEME = sCHEME;
	}

	public String getDEALER_PAN_NUMBER() {
		return DEALER_PAN_NUMBER;
	}

	public void setDEALER_PAN_NUMBER(String dEALER_PAN_NUMBER) {
		DEALER_PAN_NUMBER = dEALER_PAN_NUMBER;
	}

	public String getPRODUCT() {
		return PRODUCT;
	}

	public void setPRODUCT(String pRODUCT) {
		PRODUCT = pRODUCT;
	}

	public Date getLMS_AUTH_DATE() {
		return LMS_AUTH_DATE;
	}

	public void setLMS_AUTH_DATE(Date lMS_AUTH_DATE) {
		LMS_AUTH_DATE = lMS_AUTH_DATE;
	}

	public Integer getTOTAL_SOURCED_QUANTITY_MFG() {
		return TOTAL_SOURCED_QUANTITY_MFG;
	}

	public void setTOTAL_SOURCED_QUANTITY_MFG(Integer tOTAL_SOURCED_QUANTITY_MFG) {
		TOTAL_SOURCED_QUANTITY_MFG = tOTAL_SOURCED_QUANTITY_MFG;
	}

	public Integer getamount_financed() {
		return amount_financed;
	}

	public void setamount_financed(Integer aMOUNT_FINANCED) {
		amount_financed = aMOUNT_FINANCED;
	}

	public String getMANUFACTURER_ID() {
		return MANUFACTURER_ID;
	}

	public void setMANUFACTURER_ID(String mANUFACTURER_ID) {
		MANUFACTURER_ID = mANUFACTURER_ID;
	}

	public Integer getTOTAL_SOURCED_VOLUME_MFG() {
		return TOTAL_SOURCED_VOLUME_MFG;
	}

	public void setTOTAL_SOURCED_VOLUME_MFG(Integer tOTAL_SOURCED_VOLUME_MFG) {
		TOTAL_SOURCED_VOLUME_MFG = tOTAL_SOURCED_VOLUME_MFG;
	}

	public String getmodel_no() {
		return model_no;
	}

	public void setmodel_no(String mODEL_NO) {
		model_no = mODEL_NO;
	}

	public String getMAKE_ID() {
		return MAKE_ID;
	}

	public void setMAKE_ID(String mAKE_ID) {
		MAKE_ID = mAKE_ID;
	}

	public Integer getBUSINESS_IRR() {
		return BUSINESS_IRR;
	}

	public void setBUSINESS_IRR(Integer bUSINESS_IRR) {
		BUSINESS_IRR = bUSINESS_IRR;
	}

	public Integer gettotal_sourced_qty_region() {
		return total_sourced_qty_region;
	}

	public void settotal_sourced_qty_region(Integer tOTAL_SOURCED_QTY_REGION) {
		total_sourced_qty_region = tOTAL_SOURCED_QTY_REGION;
	}

	public Integer gettotal_sourced_qty() {
		return total_sourced_qty;
	}

	public void settotal_sourced_qty(Integer tOTAL_SOURCED_QTY) {
		total_sourced_qty = tOTAL_SOURCED_QTY;
	}

	public Integer getTOTAL_SOURCED_VOLUME() {
		return TOTAL_SOURCED_VOLUME;
	}

	public void setTOTAL_SOURCED_VOLUME(Integer tOTAL_SOURCED_VOLUME) {
		TOTAL_SOURCED_VOLUME = tOTAL_SOURCED_VOLUME;
	}

	public Integer getTOTAL_SOURCED_VOLUME_REGION() {
		return TOTAL_SOURCED_VOLUME_REGION;
	}

	public void setTOTAL_SOURCED_VOLUME_REGION(Integer tOTAL_SOURCED_VOLUME_REGION) {
		TOTAL_SOURCED_VOLUME_REGION = tOTAL_SOURCED_VOLUME_REGION;
	}

	/*public Integer getTOTAL_INCENTIVE_TRACTOR() {
		return TOTAL_INCENTIVE_TRACTOR;
	}

	public void setTOTAL_INCENTIVE_TRACTOR(Integer tOTAL_INCENTIVE_TRACTOR) {
		TOTAL_INCENTIVE_TRACTOR = tOTAL_INCENTIVE_TRACTOR;
	}

	public Integer getREFEREAL_FEE_SLAB_TRACTOR() {
		return REFEREAL_FEE_SLAB_TRACTOR;
	}

	public void setREFEREAL_FEE_SLAB_TRACTOR(Integer rEFEREAL_FEE_SLAB_TRACTOR) {
		REFEREAL_FEE_SLAB_TRACTOR = rEFEREAL_FEE_SLAB_TRACTOR;
	}

	public Integer getRULE_ID_TRACTOR() {
		return RULE_ID_TRACTOR;
	}

	public void setRULE_ID_TRACTOR(Integer rULE_ID_TRACTOR) {
		RULE_ID_TRACTOR = rULE_ID_TRACTOR;
	}

	public Integer getINCENTIVE_SLAB_TRACTOR() {
		return INCENTIVE_SLAB_TRACTOR;
	}

	public void setINCENTIVE_SLAB_TRACTOR(Integer iNCENTIVE_SLAB_TRACTOR) {
		INCENTIVE_SLAB_TRACTOR = iNCENTIVE_SLAB_TRACTOR;
	}*/
}

