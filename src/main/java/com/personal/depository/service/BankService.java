package com.personal.depository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.depository.dto.BankDTO;
import com.personal.depository.entity.Bank;
import com.personal.depository.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;
	
	public Bank saveBank(BankDTO bankDTO) {
		Bank bank = new Bank();
		bank.setBankName(bankDTO.getBankName());
		bank.setBranch(bankDTO.getBranch());
		
		Bank bankSaved = bankRepository.save(bank);
		return bankSaved;
	}

	public List<Bank> getAllBanks() {
		
		return bankRepository.findAll();
	}

}
