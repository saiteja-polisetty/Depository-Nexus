package com.personal.depository.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.depository.dto.DepositDTO;
import com.personal.depository.entity.Bank;
import com.personal.depository.entity.Deposit;
import com.personal.depository.entity.Nominee;
import com.personal.depository.entity.User;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.repository.BankRepository;
import com.personal.depository.repository.DepositRepository;
import com.personal.depository.repository.NomineeRepository;
import com.personal.depository.repository.UserRepository;

@Service
public class DepositService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private NomineeRepository nomineeRepository;

	@Autowired
	private DepositRepository depositRepository;

	public Deposit addDeposit(DepositDTO depositDTO) throws DepositoryException, ParseException {
		Optional<User> user = userRepository.findById(depositDTO.getUserId());
		if (!user.isPresent())
			throw new DepositoryException("Please check the userId passed..!!");

		Optional<Bank> bank = bankRepository.findById(depositDTO.getBankId());
		if (!bank.isPresent())
			throw new DepositoryException("Please check the bankId passed..!!");

		Optional<Nominee> nominee = nomineeRepository.findById(depositDTO.getNomineeId());
		if (!nominee.isPresent())
			throw new DepositoryException("Please check the nomineeId passed..!!");

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		
		Deposit deposit = new Deposit();
		deposit.setDepositNumber(depositDTO.getDepositNumber());
		deposit.setDepositedOn(new Date(dateFormat.parse(depositDTO.getDepositedOn()).getTime()));
		deposit.setDepositValue(depositDTO.getDepositValue());
		deposit.setMaturityOn(new Date(dateFormat.parse(depositDTO.getMaturityOn()).getTime()));
		deposit.setMaturityValue(depositDTO.getMaturityValue());
		deposit.setNominee(nominee.get());
		deposit.setBank(bank.get());
		deposit.setUser(user.get());

		return depositRepository.save(deposit);
	}

	public void deleteDeposit(Integer depositId) throws DepositoryException {
		Optional<Deposit> deposit = depositRepository.findById(depositId);
		if(!deposit.isPresent())
			throw new DepositoryException("Invalid DepositId passed..!!");
		
		depositRepository.deleteById(depositId);
	}

}
