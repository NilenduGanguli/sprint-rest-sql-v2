/**
 * 
 */
package com.nilendu.neueda.model;

/**
 * @author nilen
 *
 */

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="entityDefinition")
public class EntityDefinition implements Serializable {
	
	//the eID refers to type of entity
	//all stocks have same eID,etc
	@Id
	private Long entityID;
	
	//name of the entity e.g. which bank stock or what type of crypto coin
	//entity name should be in the format: "<type> <name>"
	//where the type is : crypto,cash,stock
	//name is the name of the company/etc
	private String entityName;
	
	//Description of entity
	private String entityDescription;
	
	

	public Long getEntityID() {
		return this.entityID;
	}
	
	public String getEntityName() {
		return this.entityName;
	}
	
	public String getEntityDescription() {
		return this.entityDescription;
	}
	
	public void setEntityID(long entityID) {
		this.entityID = entityID;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	public void setEntityDescription(String entityDesc) {
		this.entityDescription = entityDesc;
	}
	

}

