package com.personal.depository.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	public Deposit addDeposit(DepositDTO depositDTO, String username) throws DepositoryException, ParseException {
		User user = userRepository.findByUsername(username);

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
		deposit.setUser(user);

		return depositRepository.save(deposit);
	}

	public void deleteDeposit(Integer depositId) throws DepositoryException {
		Optional<Deposit> deposit = depositRepository.findById(depositId);
		if (!deposit.isPresent())
			throw new DepositoryException("Invalid DepositId passed..!!");

		depositRepository.deleteById(depositId);
	}

	private List<Deposit> filterByFinancialYear(List<Deposit> deposits, String financialYear) {
		List<Deposit> depositList = new ArrayList<>();
		String yearRange = financialYear.substring(2);

		String[] years = yearRange.split("-");

		int startYear = Integer.parseInt("20" + years[0]);
		int endYear = Integer.parseInt("20" + years[1]);

		LocalDate startDate = LocalDate.of(startYear, 4, 1); // 1st April of start year
		LocalDate endDate = LocalDate.of(endYear, 3, 31);

		deposits.forEach((deposit) -> {
			LocalDate depositDate = deposit.getDepositedOn().toLocalDate();
			if (depositDate.isAfter(startDate) && depositDate.isBefore(endDate)) {
				depositList.add(deposit);
			}
		});

		return depositList;
	}

	public List<Deposit> filterDeposits(String username, String financialYear, Integer bankId)
			throws DepositoryException {
		User user = userRepository.findByUsername(username);
		Integer userId = user.getId();
		List<Deposit> depositList = new ArrayList<>();
		if (bankId == null && (financialYear == null || financialYear.equals(""))) {
			depositList = depositRepository.findAllByUserId(userId);
		} else if (bankId != null && (financialYear == null || financialYear.equals(""))) {
			depositList = depositRepository.findAllByBankIdAndUserId(bankId, userId);
		} else if (bankId == null && !financialYear.equals("")) {
			depositList = depositRepository.findAllByUserId(userId);
			if (!depositList.isEmpty())
				depositList = filterByFinancialYear(depositList, financialYear);
		} else {
			depositList = depositRepository.findAllByBankIdAndUserId(bankId, userId);
			if (!depositList.isEmpty())
				depositList = filterByFinancialYear(depositList, financialYear);
		}

		if (depositList.isEmpty())
			throw new DepositoryException("No Deposits found..!!");

		return depositList;
	}

	public Map<String, Map<String, Float>> fetchSummaryByBank(String username) throws DepositoryException {
		User user = userRepository.findByUsername(username);
		List<Deposit> depositList = new ArrayList<>();
		depositList = depositRepository.findAllByUserId(user.getId());

		if (depositList.isEmpty())
			throw new DepositoryException("No Deposits found..!!");

		Map<String, Map<String, Float>> summaryReport = new HashMap<>();
		Map<String, Float> bankReport = new HashMap<>();

		bankReport.put("Deposit Value", 0F);
		bankReport.put("Maturity Value", 0F);
		depositList.forEach((deposit) -> {

			summaryReport.putIfAbsent(deposit.getBank().getBankName(), new HashMap<>());
			System.out.println(summaryReport);
			Map<String, Float> localBankReport = summaryReport.get(deposit.getBank().getBankName());
			localBankReport.putIfAbsent("Deposit Value", 0F);
			localBankReport.put("Deposit Value", localBankReport.get("Deposit Value") + deposit.getDepositValue());
			localBankReport.putIfAbsent("Maturity Value", 0F);
			localBankReport.put("Maturity Value", localBankReport.get("Maturity Value") + deposit.getMaturityValue());

			summaryReport.put(deposit.getBank().getBankName(), localBankReport);

			System.out.println(summaryReport);
		});

		Float totalDepositValue = 0F;
		Float totalMaturityValue = 0F;

		for (Map.Entry<String, Map<String, Float>> entry : summaryReport.entrySet()) {
			totalDepositValue += entry.getValue().get("Deposit Value");
			totalMaturityValue += entry.getValue().get("Maturity Value");
		}
		Map<String, Float> totalReport = new HashMap<>();
		totalReport.put("Deposit Value", totalDepositValue);
		totalReport.put("Maturity Value", totalMaturityValue);
		summaryReport.put("Total Summary", totalReport);

		return summaryReport;
	}

	public Map<String, Map<String, Float>> fetchSummaryByNominee(String username) throws DepositoryException {
		User user = userRepository.findByUsername(username);
		List<Deposit> depositList = new ArrayList<>();
		depositList = depositRepository.findAllByUserId(user.getId());

		if (depositList.isEmpty())
			throw new DepositoryException("No Deposits found..!!");

		Map<String, Map<String, Float>> summaryReport = new HashMap<>();
		Map<String, Float> bankReport = new HashMap<>();

		bankReport.put("Deposit Value", 0F);
		bankReport.put("Maturity Value", 0F);
		depositList.forEach((deposit) -> {

			summaryReport.putIfAbsent(deposit.getNominee().getName(), new HashMap<>());
			System.out.println(summaryReport);
			Map<String, Float> localBankReport = summaryReport.get(deposit.getNominee().getName());
			localBankReport.putIfAbsent("Deposit Value", 0F);
			localBankReport.put("Deposit Value", localBankReport.get("Deposit Value") + deposit.getDepositValue());
			localBankReport.putIfAbsent("Maturity Value", 0F);
			localBankReport.put("Maturity Value", localBankReport.get("Maturity Value") + deposit.getMaturityValue());

			summaryReport.put(deposit.getNominee().getName(), localBankReport);

			System.out.println(summaryReport);
		});

		Float totalDepositValue = 0F;
		Float totalMaturityValue = 0F;

		for (Map.Entry<String, Map<String, Float>> entry : summaryReport.entrySet()) {
			totalDepositValue += entry.getValue().get("Deposit Value");
			totalMaturityValue += entry.getValue().get("Maturity Value");
		}
		Map<String, Float> totalReport = new HashMap<>();
		totalReport.put("Deposit Value", totalDepositValue);
		totalReport.put("Maturity Value", totalMaturityValue);
		summaryReport.put("Total Summary", totalReport);

		return summaryReport;
	}

}
