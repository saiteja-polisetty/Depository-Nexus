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
@Table
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String policyNumber;
	private Date issuedOn;
	private Date maturityOn;
	private Float premium;
	private Float sumAssured;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "policy_issuer_id")
	private PolicyIssuer policyIssuer;
	
	@ManyToOne
	@JoinColumn(name = "nominee_id")
	private Nominee nominee;
	
	public Policy() {}

	public Policy(Integer id, String policyNumber, Date issuedOn, Date maturityOn, Float premium, Float sumAssured,
			User user, PolicyIssuer policyIssuer, Nominee nominee) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.issuedOn = issuedOn;
		this.maturityOn = maturityOn;
		this.premium = premium;
		this.sumAssured = sumAssured;
		this.user = user;
		this.policyIssuer = policyIssuer;
		this.nominee = nominee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Date getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(Date issuedOn) {
		this.issuedOn = issuedOn;
	}

	public Date getMaturityOn() {
		return maturityOn;
	}

	public void setMaturityOn(Date maturityOn) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PolicyIssuer getPolicyIssuer() {
		return policyIssuer;
	}

	public void setPolicyIssuer(PolicyIssuer policyIssuer) {
		this.policyIssuer = policyIssuer;
	}

	public Nominee getNominee() {
		return nominee;
	}

	public void setNominee(Nominee nominee) {
		this.nominee = nominee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, issuedOn, maturityOn, nominee, policyIssuer, policyNumber, premium, sumAssured, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Policy other = (Policy) obj;
		return Objects.equals(id, other.id) && Objects.equals(issuedOn, other.issuedOn)
				&& Objects.equals(maturityOn, other.maturityOn) && Objects.equals(nominee, other.nominee)
				&& Objects.equals(policyIssuer, other.policyIssuer) && Objects.equals(policyNumber, other.policyNumber)
				&& Objects.equals(premium, other.premium) && Objects.equals(sumAssured, other.sumAssured)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", policyNumber=" + policyNumber + ", issuedOn=" + issuedOn + ", maturityOn="
				+ maturityOn + ", premium=" + premium + ", sumAssured=" + sumAssured + ", user=" + user
				+ ", policyIssuer=" + policyIssuer + ", nominee=" + nominee + "]";
	}
	
	
}
