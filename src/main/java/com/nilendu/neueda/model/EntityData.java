/**
 * 
 */
package com.nilendu.neueda.model;

/**
 * @author nilen
 *
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="entityData")
public class EntityData implements Serializable {
	
	//the eID refers to type of entity
	//all stocks have same eID,etc
	@Id
	private Long entityID;
	
	//name of the entity e.g. which bank stock or what type of crypto coin
	private String entityName;
	
	//this is the quantity of each entity present currently
	private int quantity;
	
	public Long getEntityID() {
		return this.entityID;
	}
	
	public String getEntityName() {
		return this.entityName;
	}
	
	public int getQuantity() {
		return this.quantity;
	}

}