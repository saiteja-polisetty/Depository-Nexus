package com.personal.depository.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.depository.dto.PolicyPaymentsDTO;
import com.personal.depository.entity.PolicyPayments;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.service.PolicyPaymentsService;

@RestController
@RequestMapping("/policy-payments")
public class PolicyPaymentsController {
	
	@Autowired
	private PolicyPaymentsService policyPaymentsService;
	
	@PostMapping
	public ResponseEntity<PolicyPayments> savePayment(@RequestBody PolicyPaymentsDTO policyPaymentsDTO) throws DepositoryException, ParseException{
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		PolicyPayments policyPayment = policyPaymentsService.savePayment(policyPaymentsDTO,username);
		return new ResponseEntity<PolicyPayments>(policyPayment, HttpStatus.CREATED);
	}
	
	@GetMapping("/{policyId}")
	public ResponseEntity<List<PolicyPayments>> getPayments(@PathVariable Integer policyId) throws DepositoryException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<PolicyPayments> policyPaymentsList = policyPaymentsService.getPayments(policyId, username);
		return new ResponseEntity<List<PolicyPayments>>(policyPaymentsList, HttpStatus.OK);
	}
}
