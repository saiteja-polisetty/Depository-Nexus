package com.personal.depository.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.depository.dto.DepositDTO;
import com.personal.depository.entity.Deposit;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.service.DepositService;

@RestController
@RequestMapping("/deposit")
public class DepositController {
	
	@Autowired
	private DepositService depositService;
	
	@PostMapping("/add")
	public ResponseEntity<Deposit> addDeposit(@RequestBody DepositDTO depositDTO) throws DepositoryException, ParseException{
		 Deposit depositSaved = depositService.addDeposit(depositDTO);
		 return new ResponseEntity<Deposit>(depositSaved, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{depositId}")
	public ResponseEntity<String> deleteDeposit(@PathVariable Integer depositId) throws DepositoryException{
		depositService.deleteDeposit(depositId);
		return new ResponseEntity<String>("Deposit deleted Successfully..!!", HttpStatus.OK);
	}
	
}
