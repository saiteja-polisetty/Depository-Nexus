package com.personal.depository.dto;

import java.util.Objects;

public class PolicyIssuerDTO {

	private String company;
	private String agentName;
	private String agentContact;
	
	public PolicyIssuerDTO() {}

	public PolicyIssuerDTO(String company, String agentName, String agentContact) {
		super();
		this.company = company;
		this.agentName = agentName;
		this.agentContact = agentContact;
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
		return Objects.hash(agentContact, agentName, company);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolicyIssuerDTO other = (PolicyIssuerDTO) obj;
		return Objects.equals(agentContact, other.agentContact) && Objects.equals(agentName, other.agentName)
				&& Objects.equals(company, other.company);
	}

	@Override
	public String toString() {
		return "PolicyIssuerDTO [company=" + company + ", agentName=" + agentName + ", agentContact=" + agentContact
				+ "]";
	}
	
	
}
