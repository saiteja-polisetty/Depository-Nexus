package com.personal.depository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.depository.dto.PolicyIssuerDTO;
import com.personal.depository.entity.PolicyIssuer;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.service.PolicyIssuerService;

@RestController
@RequestMapping("/policy-issuer")
public class PolicyIssuerController {

	@Autowired
	private PolicyIssuerService policyIssuerService;
	
	@PostMapping
	public ResponseEntity<PolicyIssuer> savePolicyIssuer(@RequestBody PolicyIssuerDTO policyIssuerDTO){
		PolicyIssuer policyIssuer = policyIssuerService.savePolicyIssuer(policyIssuerDTO);
		return new ResponseEntity<PolicyIssuer>(policyIssuer, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PolicyIssuer>> getAllPolicyIssuers() throws DepositoryException{
		List<PolicyIssuer> policyIssuersList = policyIssuerService.getAllPolicyIssuers();
		return new ResponseEntity<List<PolicyIssuer>>(policyIssuersList, HttpStatus.OK);
	}
}
