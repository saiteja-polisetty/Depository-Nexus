package com.personal.depository.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.personal.depository.dto.NomineeDTO;
import com.personal.depository.entity.Nominee;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.service.NomineeService;

@RestController
@RequestMapping("/nominee")
public class NomineeController {

	@Autowired
	private NomineeService nomineeService;

	@PostMapping("/add")
	public ResponseEntity<Nominee> saveNominee(@RequestBody NomineeDTO nomineeDTO) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Nominee nomineeSaved = nomineeService.saveNominee(nomineeDTO, username);
		return new ResponseEntity<Nominee>(nomineeSaved, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<Nominee>> getNominees() throws DepositoryException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		List<Nominee> nomineesList = nomineeService.getNomineesForUser(username);
		return new ResponseEntity<List<Nominee>>(nomineesList, HttpStatus.OK);
	}

	@DeleteMapping("/{nomineeId}")
	public ResponseEntity<String> deleteNominee(@PathVariable Integer nomineeId) throws DepositoryException {
		nomineeService.deleteNominee(nomineeId);
		return new ResponseEntity<String>("Nominee deleted successfully..!!", HttpStatus.OK);
	}
}
