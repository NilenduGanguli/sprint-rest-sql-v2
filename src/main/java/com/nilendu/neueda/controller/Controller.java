package com.nilendu.neueda.controller;


//import com.nilendu.neueda.exception.ResourceNotFoundException;
import com.nilendu.neueda.model.*;
import com.nilendu.neueda.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.ArrayList;
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
    
    // Get All transactions
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
		//check if the transaction buyOrSell parameter is good
		if(trans.getBuyOrSell().equals("buy") || trans.getBuyOrSell().equals("sell")) {}
		else {
			flag=false;
		}
		//finding the quantity for the specific entity
		double entityQuantity = 0;
		List<EntityData> entityDataCheck = entityDataRepo.findByEntityID(entityID);
		if(entityDataCheck.size() != 0) {
			entityQuantity = entityDataCheck.get(0).getQuantity();
		}
		//System.out.println(trans.getBuyOrSell());
		if(trans.getBuyOrSell().equals("sell")) {
			//System.out.println(trans.getQuantity());
			//System.out.println(entityQuantity);
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
  
    //get value of portfolio for cash
	@GetMapping("/value/cash")
	public String getCashValue() {
		
		List<EntityData> entityList = entityDataRepo.findAll();
		double totalValue = 0.0;
		for(EntityData i : entityList) {
			String temp = i.getEntityName().split("-")[0];//hardcoding
			//System.out.println(i.getEntityName().split("-")[1]);
			if(temp.equals("cash")) { 
				String temp2 = i.getEntityName().split("-")[1];
				totalValue+= i.getQuantity()*GetCurrent.cashValue(temp2);
			}
		}
		//System.out.println(totalValue);
		return Double.toString(totalValue);//working
	}
	
	//get value of portfolio for cash
	@GetMapping("/value/crypto")
	public String getCryptoValue() {
		
		List<EntityData> entityList = entityDataRepo.findAll();
		double totalValue = 0.0;
		for(EntityData i : entityList) {
			String temp = i.getEntityName().split("-")[0];//hardcoding
			if(temp.equals("crypto")) { 
				String temp2 = i.getEntityName().split("-")[1];
				totalValue+= i.getQuantity()*GetCurrent.cryptoValue(temp2);
			}
		}
		//System.out.println(totalValue);
		return Double.toString(totalValue);//working
	}
	
	//get value of portfolio for cash
	@GetMapping("/value/stocks")
	public String getStocksValue() {
		
		List<EntityData> entityList = entityDataRepo.findAll();
		double totalValue = 0.0;
		for(EntityData i : entityList) {
			String temp = i.getEntityName().split("-")[0];//hardcoding
			if(temp.equals("stock")) { 
				String temp2 = i.getEntityName().split("-")[1];
				totalValue+= i.getQuantity()*GetCurrent.stocksValue(temp2);
			}
		}
		//System.out.println(totalValue);
		return Double.toString(totalValue);//working
	}
	
	//get total portfolio
	@GetMapping("/value/portfolio")
	public String getportfolioValue() {
		
		List<EntityData> entityList = entityDataRepo.findAll();
		double totalValue = 0.0;
		for(EntityData i : entityList) {
			String temp = i.getEntityName().split("-")[0];//hardcoding
			if(temp.equals("cash")) { 
				String temp2 = i.getEntityName().split("-")[1];
				//System.out.println(temp2);
				totalValue+= i.getQuantity()*GetCurrent.cashValue(temp2);
			}
			else if(temp.equals("crypto")) { 
				String temp2 = i.getEntityName().split("-")[1];
				//System.out.println(temp2);
				totalValue+= i.getQuantity()*GetCurrent.cryptoValue(temp2);
			}
			else if(temp.equals("stock")) { 
				String temp2 = i.getEntityName().split("-")[1];
				//System.out.println(temp2);
				totalValue+= i.getQuantity()*GetCurrent.stocksValue(temp2);
			}
		}
		//System.out.println(totalValue);
		return Double.toString(totalValue);//working
	}
    
}

