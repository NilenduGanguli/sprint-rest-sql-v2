package com.nilendu.neueda.util;


import com.nilendu.neueda.model.*;
import com.nilendu.neueda.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



public class FindEntityID {
	
	public static Long byName(String entityName,IndexRepository indexRepo) {
		Long entityID = Long.MAX_VALUE;
		List<Index> listOfEntityIndex = indexRepo.findByEntityName(entityName);
		if(listOfEntityIndex.size() != 0) {
			entityID = listOfEntityIndex.get(0).getEntityID();
		}
		return entityID;
	}
	

}
