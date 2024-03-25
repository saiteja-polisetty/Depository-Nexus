package com.personal.depository.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.depository.dto.PolicyPaymentsDTO;
import com.personal.depository.entity.Policy;
import com.personal.depository.entity.PolicyPayments;
import com.personal.depository.entity.User;
import com.personal.depository.exception.DepositoryException;
import com.personal.depository.repository.PolicyPaymentsRepository;
import com.personal.depository.repository.PolicyRepository;
import com.personal.depository.repository.UserRepository;

@Service
public class PolicyPaymentsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private PolicyPaymentsRepository policyPaymentsRepository;

	public PolicyPayments savePayment(PolicyPaymentsDTO policyPaymentsDTO, String username) throws DepositoryException, ParseException {
		User user = userRepository.findByUsername(username);
		Integer userId = user.getId();
		
		Policy policy = policyRepository.findByIdAndUserId(policyPaymentsDTO.getPolicyId(), userId);
		if(policy == null)
			throw new DepositoryException("No Policy Found to make Payments..!!");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		
		PolicyPayments policyPayments = new PolicyPayments();
		policyPayments.setPaidOn(new Date(dateFormat.parse(policyPaymentsDTO.getPaidOn()).getTime()));
		policyPayments.setAmountPaid(policyPaymentsDTO.getAmountPaid());;
		policyPayments.setModeOfPayment(policyPaymentsDTO.getModeOfPayment());
		policyPayments.setPolicy(policy);
		
		
		return policyPaymentsRepository.save(policyPayments);
	}

	public List<PolicyPayments> getPayments(Integer policyId, String username) throws DepositoryException {
		User user = userRepository.findByUsername(username);
		Integer userId = user.getId();
		
		Policy policy = policyRepository.findByIdAndUserId(policyId, userId);
		if(policy == null)
			throw new DepositoryException("No policies found..!!");
		
		List<PolicyPayments> policyPaymentsList = policyPaymentsRepository.findAllByPolicyId(policyId);
		
		if(policyPaymentsList.isEmpty())
			throw new DepositoryException("No Payments Available for Policy");
		
		return policyPaymentsList;
	}

}
