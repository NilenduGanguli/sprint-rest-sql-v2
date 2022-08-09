package com.nilendu.neueda.repository;


import com.nilendu.neueda.model.EntityData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityDataRepository extends JpaRepository<EntityData, Long> {
	
	public List<EntityData> findByEntityID(Long entityID);

}
