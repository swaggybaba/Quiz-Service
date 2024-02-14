package com.prafful.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class Response {
	Integer id;
	String response;
	public Response(Integer id, String response) {
		this.id = id;
		this.response = response;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
}
