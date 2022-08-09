package com.nilendu.neueda.repository;


import com.nilendu.neueda.model.Index;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexRepository extends JpaRepository<Index, Long> {
	
	public List<Index> findByEntityName(String entityName);

}

