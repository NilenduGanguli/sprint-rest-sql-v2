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
		Long entityID = Long.MAX_VALUE;
		List<Index> listOfEntityIndex = indexRepo.findByEntityName(trans.getEntityName());
		if(listOfEntityIndex.size() != 0) {
			entityID = listOfEntityIndex.get(0).getEntityID();
		}
		if(entityID== Long.MAX_VALUE) {
			Random rand = new Random();
			entityID = rand.nextLong(Long.MAX_VALUE-2);	
		}
		Index index =new Index();
		index.setEntityID(entityID);
		index.setEntityName(trans.getEntityName());
		index.setUUID(trans.getUUID());
		Index indexReturn = indexRepo.save(index);
		//System.out.println(indexReturn.getEntityName());
		return transRepo.save(trans);
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

