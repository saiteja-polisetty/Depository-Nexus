package com.personal.depository.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.depository.dto.PolicyDTO;
import com.personal.depository.entity.Nominee;
import com.personal.depository.entity.Policy;
import com.personal.depository.entity.PolicyIssuer;
import com.personal.depository.entity.User;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.repository.NomineeRepository;
import com.personal.depository.repository.PolicyIssuerRepository;
import com.personal.depository.repository.PolicyRepository;
import com.personal.depository.repository.UserRepository;

@Service
public class PolicyService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NomineeRepository nomineeRepository;
	
	@Autowired 
	private PolicyRepository policyRepository;
	
	@Autowired
	private PolicyIssuerRepository policyIssuerRepository;
	
	public Policy savePolicy(PolicyDTO policyDTO, String username) throws DepositoryException, ParseException {
		User user = userRepository.findByUsername(username);
		
		Optional<Nominee> nominee = nomineeRepository.findById(policyDTO.getNomineeId());
		if (!nominee.isPresent())
			throw new DepositoryException("Please check the nomineeId passed..!!");
		
		Optional<PolicyIssuer> policyIssuer = policyIssuerRepository.findById(policyDTO.getPolicyIssuerId());
		if(!policyIssuer.isPresent())
			throw new DepositoryException("Please check the policyIssuerId passed..!!");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		
		Policy policy = new Policy();
		policy.setPolicyNumber(policyDTO.getPolicyNumber());
		policy.setPremium(policyDTO.getPremium());
		policy.setSumAssured(policyDTO.getSumAssured());
		policy.setIssuedOn(new Date(dateFormat.parse(policyDTO.getIssuedOn()).getTime()));
		policy.setMaturityOn(new Date(dateFormat.parse(policyDTO.getMaturityOn()).getTime()));
		
		policy.setUser(user);
		policy.setNominee(nominee.get());
		policy.setPolicyIssuer(policyIssuer.get());
		return policyRepository.save(policy);
	}

	public List<Policy> getAllPolicies(String username) throws DepositoryException {
		
		User user = userRepository.findByUsername(username);
		Integer userId = user.getId();
		
		List<Policy> policyList = policyRepository.findAllByUserId(userId);
		if(policyList.isEmpty())
			throw new DepositoryException("No policies found for the user..!!");
		
		return policyList;
	}
	
	

}
