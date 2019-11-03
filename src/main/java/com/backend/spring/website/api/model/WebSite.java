package com.backend.spring.website.api.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;


@Document(collection = "WebSites")
public class WebSite implements Serializable{

	@Id
	private long id;
	
	private Long ownerId;
	private String domain;
	private int leadCount;
	private String plan;
	private List<String> labels;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getLeadCount() {
		return leadCount;
	}
	public void setLeadCount(int leadCount) {
		this.leadCount = leadCount;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public List<String> getLabels() {
		return labels;
	}
	public void setLabels(List<String> labels) {
		this.labels = labels;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
