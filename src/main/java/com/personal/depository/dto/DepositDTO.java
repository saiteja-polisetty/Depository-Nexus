package com.personal.depository.dto;

import java.util.Objects;

public class DepositDTO {

	private String depositNumber;
	private String depositedOn;
	private Float depositValue;
	private String maturityOn;
	private Float maturityValue;
	private Integer bankId;
	private Integer nomineeId;

	public DepositDTO() {
	}

	public DepositDTO(String depositNumber, String depositedOn, Float depositValue, String maturityOn,
			Float maturityValue, Integer bankId, Integer nomineeId) {
		super();
		this.depositNumber = depositNumber;
		this.depositedOn = depositedOn;
		this.depositValue = depositValue;
		this.maturityOn = maturityOn;
		this.maturityValue = maturityValue;
		this.bankId = bankId;
		this.nomineeId = nomineeId;
	}

	public String getDepositNumber() {
		return depositNumber;
	}

	public void setDepositNumber(String depositNumber) {
		this.depositNumber = depositNumber;
	}

	public String getDepositedOn() {
		return depositedOn;
	}

	public void setDepositedOn(String depositedOn) {
		this.depositedOn = depositedOn;
	}

	public Float getDepositValue() {
		return depositValue;
	}

	public void setDepositValue(Float depositValue) {
		this.depositValue = depositValue;
	}

	public String getMaturityOn() {
		return maturityOn;
	}

	public void setMaturityOn(String maturityOn) {
		this.maturityOn = maturityOn;
	}

	public Float getMaturityValue() {
		return maturityValue;
	}

	public void setMaturityValue(Float maturityValue) {
		this.maturityValue = maturityValue;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public Integer getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(Integer nomineeId) {
		this.nomineeId = nomineeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankId, depositNumber, depositValue, depositedOn, maturityOn, maturityValue, nomineeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepositDTO other = (DepositDTO) obj;
		return Objects.equals(bankId, other.bankId) && Objects.equals(depositNumber, other.depositNumber)
				&& Objects.equals(depositValue, other.depositValue) && Objects.equals(depositedOn, other.depositedOn)
				&& Objects.equals(maturityOn, other.maturityOn) && Objects.equals(maturityValue, other.maturityValue)
				&& Objects.equals(nomineeId, other.nomineeId);
	}

	@Override
	public String toString() {
		return "DepositDTO [depositNumber=" + depositNumber + ", depositedOn=" + depositedOn + ", depositValue="
				+ depositValue + ", maturityOn=" + maturityOn + ", maturityValue=" + maturityValue + ", bankId="
				+ bankId + ", nomineeId=" + nomineeId + "]";
	}

	

}
