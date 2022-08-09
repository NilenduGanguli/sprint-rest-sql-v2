package com.nilendu.neueda.controller;


//import com.nilendu.neueda.exception.ResourceNotFoundException;
import com.nilendu.neueda.model.*;
import com.nilendu.neueda.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

//import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import com.nilendu.neueda.util.*;



@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    TransactionRepository transRepo;
    @Autowired
    IndexRepository indexRepo;
    @Autowired
    EntityDataRepository entityDataRepo;
    @Autowired
    EntityDefinitionRepository entityDefRepo;
    
    // Get All stocks
    @GetMapping("/transaction/all")
    public List<Transaction> getAllTransactions() { 
    	List<Transaction> transAll = transRepo.findAll();
        return transRepo.findAll();
    }
    
	// Create a new Transaction Entry
	@PostMapping("/transaction/entry")
	public Transaction enterStock(@Valid @RequestBody Transaction trans) {
		//generates uuid for each transaction
		UUID uuid = UUID.randomUUID();
		trans.setUUID(uuid);
		
		
		
		//finding entity ID corresponding to entityName
		//if not present then create a new entityid in EntityDefinition
		Long entityID;
		List<EntityDefinition> listOfEntityIndex = entityDefRepo.findByEntityName(trans.getEntityName());
		if(listOfEntityIndex.size() != 0) {
			entityID = listOfEntityIndex.get(0).getEntityID();
		}
		else {
			Random rand = new Random();
			entityID = rand.nextLong(Long.MAX_VALUE-2);
			EntityDefinition entityDef =new EntityDefinition();
			entityDef.setEntityID(entityID);
			entityDef.setEntityName(trans.getEntityName());
			entityDef.setEntityDescription("NA");
			EntityDefinition entityDefReturn = entityDefRepo.save(entityDef);
		}
	
		
		//updating the entitydata table with every transaction
		boolean flag = true; // transaction validity
		//finding the quantity for the specific entity
		int entityQuantity = 0;
		List<EntityData> entityDataCheck = entityDataRepo.findByEntityID(entityID);
		if(entityDataCheck.size() != 0) {
			entityQuantity = entityDataCheck.get(0).getQuantity();
		}
		if(trans.getBuyOrSell()=="sell") {
			if(entityQuantity >= trans.getQuantity()) {
				entityQuantity-=trans.getQuantity();
			}
			else {
				flag=false;
			}
		}
		else {
			entityQuantity+=trans.getQuantity();
		}
		EntityData entityData = new EntityData();
		entityData.setEntityID(entityID);
		entityData.setEntityName(trans.getEntityName());
		entityData.setQuantity(entityQuantity);
		EntityData entityDataReturn = entityDataRepo.save(entityData);
		
		
		
		//if the transaction updation is valid
		if(flag==true) {
			//updating the index table and transaction with current transaction
			Index index =new Index();
			index.setEntityID(entityID);
			index.setEntityName(trans.getEntityName());
			index.setUUID(trans.getUUID());
			Index indexReturn = indexRepo.save(index);
			return transRepo.save(trans);
			
		}
		else {
			return new Transaction();
		}
	}
  
    
    
    
//    @GetMapping("/stocks/{name}")
//    public List<Stocks> getStock(@PathVariable(value = "name") String name) { 
//    	List<Stocks> stocksAll = stockRepo.findAll();
//    	
//        return stockRepo.findAll();
//    }
//
//    // Create a new Note
//    @PostMapping("/stocks")
//    public Stocks enterStock(@Valid @RequestBody Stocks stock) {
//    	System.out.println("Post Triggered...."+ Double.toString(stock.getTotalPrice()));
//        return stockRepo.save(stock);
//    }
    
}

