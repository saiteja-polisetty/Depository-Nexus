package com.personal.depository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.depository.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

}
