package com.nilendu.neueda.repository;


import com.nilendu.neueda.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

}

