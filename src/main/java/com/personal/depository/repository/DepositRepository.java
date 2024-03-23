package com.personal.depository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.depository.entity.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer> {

}
