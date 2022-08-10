/**
 * 
 */
package com.nilendu.neueda.model;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author nilen
 *
 */

@Entity
@Table(name="transaction")
public class Transaction implements Serializable {
	
	//the eID refers to type of entity
	//all stocks have same eID,etc
	//entityName that is name of stock or company or crypto
	//entity name should be in the format: "<type> <name>"
	//where the type is : crypto,cash,stock
	//name is the name of the company/etc
	private String entityName;
	
	//uuid corresponds to the transaction unique id to map transactions
	//all transactions have different uuid
	@Id
	private String uuid;
	
	//date of transaction
	private Date date;
	
	//transaction is buy or sell
	private String buyOrSell;
	
	//quantity of transaction
	private double quantity;
	
	//total value of transaction
	private double price;
	
	public double getQuantity() {
		return this.quantity;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getBuyOrSell() {
		return this.buyOrSell;
	}
	
	public String getEntityName() {
		return this.entityName;
	}
	
	public String getUUID() {
		return this.uuid;
	}
	
	public void setUUID(UUID uuid) {
		this.uuid = uuid.toString();
	}
	

}
