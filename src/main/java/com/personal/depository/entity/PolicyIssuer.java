package com.personal.depository.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policy_issuer")
public class PolicyIssuer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String company;
	private String agentName;
	private String agentContact;

	public PolicyIssuer() {
	}

	public PolicyIssuer(Integer id, String company, String agentName, String agentContact) {
		super();
		this.id = id;
		this.company = company;
		this.agentName = agentName;
		this.agentContact = agentContact;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentContact() {
		return agentContact;
	}

	public void setAgentContact(String agentContact) {
		this.agentContact = agentContact;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agentContact, agentName, company, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolicyIssuer other = (PolicyIssuer) obj;
		return Objects.equals(agentContact, other.agentContact) && Objects.equals(agentName, other.agentName)
				&& Objects.equals(company, other.company) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PolicyIssuer [id=" + id + ", company=" + company + ", agentName=" + agentName + ", agentContact="
				+ agentContact + "]";
	}

}
