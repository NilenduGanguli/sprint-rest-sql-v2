package com.nilendu.neueda.repository;


import com.nilendu.neueda.model.EntityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityDataRepository extends JpaRepository<EntityData, Long> {

}
