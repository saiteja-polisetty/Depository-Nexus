package com.personal.depository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.depository.dto.NomineeDTO;
import com.personal.depository.entity.Nominee;
import com.personal.depository.entity.User;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.repository.NomineeRepository;
import com.personal.depository.repository.UserRepository;

@Service
public class NomineeService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public NomineeRepository nomineeRepository;

	public Nominee saveNominee(NomineeDTO nomineeDTO, String username) {
		User user = userRepository.findByUsername(username);

		Nominee nominee = new Nominee();
		nominee.setName(nomineeDTO.getName());
		nominee.setAge(nomineeDTO.getAge());
		nominee.setRelationship(nomineeDTO.getRelationship());

		nominee.setUser(user);

		return nomineeRepository.save(nominee);
	}

	public List<Nominee> getNomineesForUser(String username) throws DepositoryException {

		User user = userRepository.findByUsername(username);

		List<Nominee> nomineesList = nomineeRepository.findAllByUserId(user.getId());

		if (nomineesList.isEmpty())
			throw new DepositoryException("No Nominees added by User so far..!!");

		return nomineesList;
	}

	public void deleteNominee(Integer nomineeId) throws DepositoryException {

		Optional<Nominee> nominee = nomineeRepository.findById(nomineeId);
		if (!nominee.isPresent())
			throw new DepositoryException("Invalid NomineeId passed..!!");

		nomineeRepository.deleteById(nomineeId);

	}

}
