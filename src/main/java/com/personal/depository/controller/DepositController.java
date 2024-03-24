package com.personal.depository.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Deposit> addDeposit(@RequestBody DepositDTO depositDTO)
			throws DepositoryException, ParseException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		Deposit depositSaved = depositService.addDeposit(depositDTO, username);
		return new ResponseEntity<Deposit>(depositSaved, HttpStatus.CREATED);
	}

	@DeleteMapping("/{depositId}")
	public ResponseEntity<String> deleteDeposit(@PathVariable Integer depositId) throws DepositoryException {
		depositService.deleteDeposit(depositId);
		return new ResponseEntity<String>("Deposit deleted Successfully..!!", HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Deposit>> filterDeposits(@RequestParam("financialYear") String financialYear,
			@RequestParam("bankId") Integer bankId) throws DepositoryException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		List<Deposit> depositsList = depositService.filterDeposits(username, financialYear, bankId);

		return new ResponseEntity<List<Deposit>>(depositsList, HttpStatus.OK);
	}

	@GetMapping("/summary")
	public ResponseEntity<Map<String, Map<String, Float>>> fetchSummary() throws DepositoryException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		Map<String, Map<String, Float>> summaryReport = depositService.fetchSummary(username);
		return new ResponseEntity<Map<String, Map<String, Float>>>(summaryReport, HttpStatus.OK);
	}

}
