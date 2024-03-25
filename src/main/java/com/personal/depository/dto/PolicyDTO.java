package com.personal.depository.dto;

import java.sql.Date;
import java.util.Objects;

public class PolicyDTO {
	
	private String policyNumber;
	private String issuedOn;
	private String maturityOn;
	private Float premium;
	private Float sumAssured;
	private Integer policyIssuerId;
	private Integer nomineeId;
	
	public PolicyDTO() {}

	public PolicyDTO(String policyNumber, String issuedOn, String maturityOn, Float premium, Float sumAssured,
			Integer policyIssuerId, Integer nomineeId) {
		super();
		this.policyNumber = policyNumber;
		this.issuedOn = issuedOn;
		this.maturityOn = maturityOn;
		this.premium = premium;
		this.sumAssured = sumAssured;
		this.policyIssuerId = policyIssuerId;
		this.nomineeId = nomineeId;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(String issuedOn) {
		this.issuedOn = issuedOn;
	}

	public String getMaturityOn() {
		return maturityOn;
	}

	public void setMaturityOn(String maturityOn) {
		this.maturityOn = maturityOn;
	}

	public Float getPremium() {
		return premium;
	}

	public void setPremium(Float premium) {
		this.premium = premium;
	}

	public Float getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(Float sumAssured) {
		this.sumAssured = sumAssured;
	}

	public Integer getPolicyIssuerId() {
		return policyIssuerId;
	}

	public void setPolicyIssuerId(Integer policyIssuerId) {
		this.policyIssuerId = policyIssuerId;
	}

	public Integer getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(Integer nomineeId) {
		this.nomineeId = nomineeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(issuedOn, maturityOn, nomineeId, policyIssuerId, policyNumber, premium, sumAssured);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolicyDTO other = (PolicyDTO) obj;
		return Objects.equals(issuedOn, other.issuedOn) && Objects.equals(maturityOn, other.maturityOn)
				&& Objects.equals(nomineeId, other.nomineeId) && Objects.equals(policyIssuerId, other.policyIssuerId)
				&& Objects.equals(policyNumber, other.policyNumber) && Objects.equals(premium, other.premium)
				&& Objects.equals(sumAssured, other.sumAssured);
	}

	@Override
	public String toString() {
		return "PolicyDTO [policyNumber=" + policyNumber + ", issuedOn=" + issuedOn + ", maturityOn=" + maturityOn
				+ ", premium=" + premium + ", sumAssured=" + sumAssured + ", policyIssuerId=" + policyIssuerId
				+ ", nomineeId=" + nomineeId + "]";
	}
	
	
}
