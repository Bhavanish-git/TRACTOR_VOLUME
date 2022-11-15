
package com.project.model;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

@Generated("jsonschema2pojo")
public class CaseRequest {

	@JsonProperty("outcomes")
    @Expose
    private List<String> outcomes = null;
	@JsonProperty("cases")
    @Expose
    private List<Case> cases = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CaseRequest() {
    }

    /**
     * 
     * @param cases
     * @param outcomes
     */
    public CaseRequest(List<String> outcomes, List<Case> cases) {
        super();
        this.outcomes = outcomes;
        this.cases = cases;
    }

    public List<String> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<String> outcomes) {
        this.outcomes = outcomes;
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CaseRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("outcomes");
        sb.append('=');
        sb.append(((this.outcomes == null)?"<null>":this.outcomes));
        sb.append(',');
        sb.append("cases");
        sb.append('=');
        sb.append(((this.cases == null)?"<null>":this.cases));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
