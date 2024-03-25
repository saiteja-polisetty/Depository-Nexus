package com.personal.depository.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.depository.dto.PolicyDTO;
import com.personal.depository.entity.Policy;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	@PostMapping
	public ResponseEntity<Policy> savePolicy(@RequestBody PolicyDTO policyDTO) throws DepositoryException, ParseException{
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		Policy policy = policyService.savePolicy(policyDTO, username);
		return new ResponseEntity<Policy>(policy, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Policy>> getAllPolicies() throws DepositoryException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<Policy> policyList = policyService.getAllPolicies(username);
		
		return new ResponseEntity<List<Policy>>(policyList, HttpStatus.OK);
	}
}
