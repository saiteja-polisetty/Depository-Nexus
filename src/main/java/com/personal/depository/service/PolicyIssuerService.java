package com.personal.depository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.depository.dto.PolicyIssuerDTO;
import com.personal.depository.entity.PolicyIssuer;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.repository.PolicyIssuerRepository;

@Service
public class PolicyIssuerService {

	@Autowired
	private PolicyIssuerRepository policyIssuerRepository;
	
	public PolicyIssuer savePolicyIssuer(PolicyIssuerDTO policyIssuerDTO) {
		
		PolicyIssuer policyIssuer = new PolicyIssuer();
		policyIssuer.setCompany(policyIssuerDTO.getCompany());
		policyIssuer.setAgentName(policyIssuerDTO.getAgentName());
		policyIssuer.setAgentContact(policyIssuerDTO.getAgentContact());
		
		PolicyIssuer policyIssuerSaved = policyIssuerRepository.save(policyIssuer);
		return policyIssuerSaved;
	}

	public List<PolicyIssuer> getAllPolicyIssuers() throws DepositoryException {
		List<PolicyIssuer> policyIssuersList = policyIssuerRepository.findAll();
		if(policyIssuersList.isEmpty())
			throw new DepositoryException("No Policy Issuers Found, Please request Admin to support");
		return policyIssuersList;
	}
	
	

}
