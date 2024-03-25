package com.personal.depository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.depository.entity.PolicyPayments;

@Repository
public interface PolicyPaymentsRepository extends JpaRepository<PolicyPayments, Integer> {

	List<PolicyPayments> findAllByPolicyId(Integer policyId);

}
