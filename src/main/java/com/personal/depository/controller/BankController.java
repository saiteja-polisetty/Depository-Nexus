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

import com.personal.depository.dto.BankDTO;
import com.personal.depository.entity.Bank;
import com.personal.depository.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@PostMapping("/add")
	public ResponseEntity<Bank> saveBank(@RequestBody BankDTO bankDTO){
		Bank bank = bankService.saveBank(bankDTO);
		
		return new ResponseEntity<Bank>(bank, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Bank>> getAllBanks(){
		List<Bank> banks = bankService.getAllBanks();
		return new ResponseEntity<List<Bank>>(banks, HttpStatus.OK);
	}

}
