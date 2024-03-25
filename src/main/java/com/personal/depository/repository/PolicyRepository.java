package com.personal.depository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.depository.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer>{

	List<Policy> findAllByUserId(Integer userId);

	Policy findByIdAndUserId(Integer policyId, Integer userId);

}
