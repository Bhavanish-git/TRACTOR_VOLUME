
package com.project.request.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Component
public class Case {

	@SerializedName("@id")
	@JsonProperty("@id")
    @Expose
    private String id;
	@SerializedName("DEALER_ID")
	@JsonProperty("DEALER_ID")
    @Expose
    private Integer dealerId;
	@SerializedName("MANUFACTURER_DESC")
	@JsonProperty("MANUFACTURER_DESC")
    @Expose
    private String manufacturerDesc;
	@SerializedName("Rel_Tractor_Volume_Mon")
	@JsonProperty("Rel_Tractor_Volume_Mon")
    @Expose
    private List<RelTractorVolumeMon> relTractorVolumeMon = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Case() {
    }

    /**
     * 
     * @param manufacturerDesc
     * @param dealerId
     * @param relTractorVolumeMon
     * @param id
     */
    public Case(String id, Integer dealerId, String manufacturerDesc, List<RelTractorVolumeMon> relTractorVolumeMon) {
        super();
        this.id = id;
        this.dealerId = dealerId;
        this.manufacturerDesc = manufacturerDesc;
        this.relTractorVolumeMon = relTractorVolumeMon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getManufacturerDesc() {
        return manufacturerDesc;
    }

    public void setManufacturerDesc(String manufacturerDesc) {
        this.manufacturerDesc = manufacturerDesc;
    }

    public List<RelTractorVolumeMon> getRelTractorVolumeMon() {
        return relTractorVolumeMon;
    }

    public void setRelTractorVolumeMon(List<RelTractorVolumeMon> relTractorVolumeMon) {
        this.relTractorVolumeMon = relTractorVolumeMon;
    }

    

}
