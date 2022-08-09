package com.nilendu.neueda.repository;


import com.nilendu.neueda.model.EntityDefinition;
import com.nilendu.neueda.model.Index;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntityDefinitionRepository extends JpaRepository<EntityDefinition, Long> {
	
	public List<EntityDefinition> findByEntityName(String entityName);

}