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
@Table(name="entityIndex")
public class Index implements Serializable {
	
	//the eID refers to type of entity
	//all stocks have same eID,etc
	@Id
	private Long entityID;
	
	//name of the entity e.g. which bank stock or what type of crypto coin
	private String entityName;
	
	//uuid corresponds to the transaction unique id to map transactions
	//all transactions have different uuid
	private String uuid;
	
//	public Index(Long entityID, String entityName, String uuid) {
//		this.entityID = entityID;
//		this.entityName = entityName;
//		this.uuid = uuid;
//	}
	

	public Long getEntityID() {
		return this.entityID;
	}
	
	public String getEntityName() {
		return this.entityName;
	}
	
	public String getUUID() {
		return this.uuid;
	}
	
	public void setEntityID(long entityID) {
		this.entityID = entityID;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	public void setUUID(String uuid) {
		this.uuid = uuid;
	}
	

}
