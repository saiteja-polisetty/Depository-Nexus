package com.personal.depository.dto;

import java.sql.Date;
import java.util.Objects;


public class PolicyPaymentsDTO {
	
	private String paidOn;
	private String modeOfPayment;
	private Float amountPaid;
	private Integer policyId;
	
	public PolicyPaymentsDTO () {}

	public PolicyPaymentsDTO(String paidOn, String modeOfPayment, Float amountPaid, Integer policyId) {
		super();
		this.paidOn = paidOn;
		this.modeOfPayment = modeOfPayment;
		this.amountPaid = amountPaid;
		this.policyId = policyId;
	}

	public String getPaidOn() {
		return paidOn;
	}

	public void setPaidOn(String paidOn) {
		this.paidOn = paidOn;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Float getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Float amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountPaid, modeOfPayment, paidOn, policyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolicyPaymentsDTO other = (PolicyPaymentsDTO) obj;
		return Objects.equals(amountPaid, other.amountPaid) && Objects.equals(modeOfPayment, other.modeOfPayment)
				&& Objects.equals(paidOn, other.paidOn) && Objects.equals(policyId, other.policyId);
	}

	@Override
	public String toString() {
		return "PolicyPaymentsDTO [paidOn=" + paidOn + ", modeOfPayment=" + modeOfPayment + ", amountPaid=" + amountPaid
				+ ", policyId=" + policyId + "]";
	}
	
	
}
