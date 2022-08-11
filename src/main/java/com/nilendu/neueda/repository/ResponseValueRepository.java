package com.nilendu.neueda.repository;


import com.nilendu.neueda.model.ResponseValue;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResponseValueRepository extends JpaRepository<ResponseValue, String> {
	

}
