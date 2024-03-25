package com.personal.depository.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "policy_paymentss")
public class PolicyPayments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date paidOn;
	private String modeOfPayment;
	private Float amountPaid;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;
	
	public PolicyPayments() {}

	public PolicyPayments(Integer id, Date paidOn, String modeOfPayment, Float amountPaid, Policy policy) {
		super();
		this.id = id;
		this.paidOn = paidOn;
		this.modeOfPayment = modeOfPayment;
		this.amountPaid = amountPaid;
		this.policy = policy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPaidOn() {
		return paidOn;
	}

	public void setPaidOn(Date paidOn) {
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

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountPaid, id, modeOfPayment, paidOn, policy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolicyPayments other = (PolicyPayments) obj;
		return Objects.equals(amountPaid, other.amountPaid) && Objects.equals(id, other.id)
				&& Objects.equals(modeOfPayment, other.modeOfPayment) && Objects.equals(paidOn, other.paidOn)
				&& Objects.equals(policy, other.policy);
	}

	@Override
	public String toString() {
		return "PolicyPayments [id=" + id + ", paidOn=" + paidOn + ", modeOfPayment=" + modeOfPayment + ", amountPaid="
				+ amountPaid + ", policy=" + policy + "]";
	}
	
	
}
