
package com.project.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelTractorVolumeMon {
	
    @SerializedName("@id")

    @JsonProperty("@id")
    @Expose
    private String id;
    
    @SerializedName("ZONE")
    @JsonProperty("ZONE")
    @Expose
    private String zone;
    
    @JsonProperty("TOTAL_SOURCED_QUANTITY_MFG")
    @SerializedName("TOTAL_SOURCED_QUANTITY_MFG")

    @Expose
    private Integer totalSourcedQuantityMfg;
    
    @JsonProperty("ASSET_TYPE")
    @SerializedName("ASSET_TYPE")

    @Expose
    private String assetType;
    
    @JsonProperty("AREA")
    @SerializedName("AREA")

    @Expose
    private String area;
    
    
    @JsonProperty("REGION")
    @SerializedName("REGION")

    @Expose
    private String region;
    
    
    @JsonProperty("BRANCH")
    @SerializedName("BRANCH")

    @Expose
    private String branch;
    
    
    @JsonProperty("PAYOUT_PERIODICITY")
    @SerializedName("PAYOUT_PERIODICITY")

    @Expose
    private String payoutPeriodicity;
    
    
    @JsonProperty("FINANCED_AMOUNT")
    @SerializedName("FINANCED_AMOUNT")

    @Expose
    private Integer financedAmount;
    
    
    @JsonProperty("MANUFACTURER_ID")
    @SerializedName("MANUFACTURER_ID")

    @Expose
    private String manufacturerId;
    
    @SerializedName("SCHEME")
    @JsonProperty("SCHEME")
    @Expose
    private String scheme;
    
    
    @JsonProperty("TOTAL_SOURCED_VOLUME_MFG")
    @SerializedName("TOTAL_SOURCED_VOLUME_MFG")

    @Expose
    private Integer totalSourcedVolumeMfg;
    
    
    @JsonProperty("DEALER_PAN_NUMBER")
    @SerializedName("DEALER_PAN_NUMBER")

    @Expose
    private String dealerPanNumber;
    
    
    @JsonProperty("LMS_AUTH_DATE")
    @SerializedName("LMS_AUTH_DATE")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Expose
    private Date lmsAuthDate;
    
    
    @JsonProperty("MODEL_ID")
    @SerializedName("MODEL_ID")

    @Expose
    private String modelId;
    
    
    @JsonProperty("PRODUCT")
    @SerializedName("PRODUCT")

    @Expose
    private String product;
    
    
    @JsonProperty("MAKE_ID")
    @SerializedName("MAKE_ID")

    @Expose
    private String makeId;
    
    
    @JsonProperty("BUSINESS_IRR")
    @SerializedName("BUSINESS_IRR")

    @Expose
    private Integer businessIrr;
    
    
    @JsonProperty("TOTAL_SOURCED_QUANTITY")
    @SerializedName("TOTAL_SOURCED_QUANTITY")

    @Expose
    private Integer totalSourcedQuantity;
    
    
    @JsonProperty("TOTAL_SOURCED_VOLUME")
    @SerializedName("TOTAL_SOURCED_VOLUME")

    @Expose
    private Integer totalSourcedVolume;
    
    
    @JsonProperty("TOTAL_SOURCED_QUANTITY_REGION")
    @SerializedName("TOTAL_SOURCED_QUANTITY_REGION")

    @Expose
    private Integer totalSourcedQuantityRegion;
    
    
    @JsonProperty("TOTAL_SOURCED_VOLUME_REGION")
    @SerializedName("TOTAL_SOURCED_VOLUME_REGION")

    @Expose
    private Integer totalSourcedVolumeRegion;
    
    

    public RelTractorVolumeMon() {
    }

    public RelTractorVolumeMon(String id, String zone, Integer totalSourcedQuantityMfg,String assetType, String area, String region, String branch, String payoutPeriodicity, Integer financedAmount, String manufacturerId, String scheme, Integer totalSourcedVolumeMfg, String dealerPanNumber, Date lmsAuthDate, String modelId, String product, String makeId, Integer businessIrr, Integer totalSourcedQuantity, Integer totalSourcedVolume, Integer totalSourcedQuantityRegion, Integer totalSourcedVolumeRegion) {
        
        this.id = id;
        this.zone = zone;
        this.totalSourcedQuantityMfg = totalSourcedQuantityMfg;
        this.assetType = assetType;
        this.area = area;
        this.region = region;
        this.branch = branch;
        this.payoutPeriodicity = payoutPeriodicity;
        this.financedAmount = financedAmount;
        this.manufacturerId = manufacturerId;
        this.scheme = scheme;
        this.totalSourcedVolumeMfg = totalSourcedVolumeMfg;
        this.dealerPanNumber = dealerPanNumber;
        this.lmsAuthDate = lmsAuthDate;
        this.modelId = modelId;
        this.product = product;
        this.makeId = makeId;
        this.businessIrr = businessIrr;
        this.totalSourcedQuantity = totalSourcedQuantity;
        this.totalSourcedVolume = totalSourcedVolume;
        this.totalSourcedQuantityRegion = totalSourcedQuantityRegion;
        this.totalSourcedVolumeRegion = totalSourcedVolumeRegion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Integer getTotalSourcedQuantityMfg() {
        return totalSourcedQuantityMfg;
    }

    public void setTotalSourcedQuantityMfg(Integer totalSourcedQuantityMfg) {
        this.totalSourcedQuantityMfg = totalSourcedQuantityMfg;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPayoutPeriodicity() {
        return payoutPeriodicity;
    }

    public void setPayoutPeriodicity(String payoutPeriodicity) {
        this.payoutPeriodicity = payoutPeriodicity;
    }

    public Integer getFinancedAmount() {
        return financedAmount;
    }

    public void setFinancedAmount(Integer financedAmount) {
        this.financedAmount = financedAmount;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public Integer getTotalSourcedVolumeMfg() {
        return totalSourcedVolumeMfg;
    }

    public void setTotalSourcedVolumeMfg(Integer totalSourcedVolumeMfg) {
        this.totalSourcedVolumeMfg = totalSourcedVolumeMfg;
    }

    public String getDealerPanNumber() {
        return dealerPanNumber;
    }

    public void setDealerPanNumber(String dealerPanNumber) {
        this.dealerPanNumber = dealerPanNumber;
    }
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getLmsAuthDate() {
        return lmsAuthDate;
    }

    public void setLmsAuthDate(Date lmsAuthDate) {
        this.lmsAuthDate = lmsAuthDate;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMakeId() {
        return makeId;
    }

    public void setMakeId(String makeId) {
        this.makeId = makeId;
    }

    public Integer getBusinessIrr() {
        return businessIrr;
    }

    public void setBusinessIrr(Integer businessIrr) {
        this.businessIrr = businessIrr;
    }

    public Integer getTotalSourcedQuantity() {
        return totalSourcedQuantity;
    }

    public void setTotalSourcedQuantity(Integer totalSourcedQuantity) {
        this.totalSourcedQuantity = totalSourcedQuantity;
    }

    public Integer getTotalSourcedVolume() {
        return totalSourcedVolume;
    }

    public void setTotalSourcedVolume(Integer totalSourcedVolume) {
        this.totalSourcedVolume = totalSourcedVolume;
    }

    public Integer getTotalSourcedQuantityRegion() {
        return totalSourcedQuantityRegion;
    }

    public void setTotalSourcedQuantityRegion(Integer totalSourcedQuantityRegion) {
        this.totalSourcedQuantityRegion = totalSourcedQuantityRegion;
    }

    public Integer getTotalSourcedVolumeRegion() {
        return totalSourcedVolumeRegion;
    }

    public void setTotalSourcedVolumeRegion(Integer totalSourcedVolumeRegion) {
        this.totalSourcedVolumeRegion = totalSourcedVolumeRegion;
    }

}
