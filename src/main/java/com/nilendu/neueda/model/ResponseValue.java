package com.nilendu.neueda.model;


/**
 * @author nilen
 *
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="ResponseValue")
public class ResponseValue implements Serializable{
	
	@Id
	private String id;
	
	private Date date;
	
	private double value;
	private String request;
	
	public void setId(UUID uuid) {
		this.id = uuid.toString();
	}
	
	public void setValue(double value) {
		this.value=value;
	}
	public void setRequest(String req) {
		this.request = req;
	}
	
	public void setDate(Date date) {
		this.date=date;
	}
	public String getId() {
		return this.id.toString();
	}
	public String getRequest() {
		return this.request;
	}
	
	public Double getValue() {
		return this.value;
	}
	
	public Date getDate() {
		return this.date;
	}
	

}
