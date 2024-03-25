package com.personal.depository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.depository.entity.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer> {

	List<Deposit> findAllByBankId(Integer bankId);

	List<Deposit> findAllByBankIdAndUserId(Integer bankId, Integer userId);

	List<Deposit> findAllByUserId(Integer userId);

}
