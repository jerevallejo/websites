package com.backend.spring.website.api.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Sequence")
public class Sequence implements Serializable{

	@Id
	private String id;
	
	private Long seq;
	
	public Sequence(String id, long seq) {
		
		this.id= id;
		this.seq= seq;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
