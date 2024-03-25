package com.personal.depository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personal.depository.entity.PolicyIssuer;

@Repository
public interface PolicyIssuerRepository extends JpaRepository<PolicyIssuer, Integer> {

}
