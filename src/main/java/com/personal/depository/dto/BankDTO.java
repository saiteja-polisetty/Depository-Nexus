package com.personal.depository.dto;

import java.util.Objects;

public class BankDTO {

	private String bankName;
	private String branch;

	public BankDTO() {
	}

	public BankDTO(String bankName, String branch) {
		super();
		this.bankName = bankName;
		this.branch = branch;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankName, branch);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankDTO other = (BankDTO) obj;
		return Objects.equals(bankName, other.bankName) && Objects.equals(branch, other.branch);
	}

	@Override
	public String toString() {
		return "BankDTO [bankName=" + bankName + ", branch=" + branch + "]";
	}

}
