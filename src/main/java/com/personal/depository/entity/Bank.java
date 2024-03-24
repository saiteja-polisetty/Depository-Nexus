package com.personal.depository.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bankName;
	private String branch;

	public Bank() {
	}

	public Bank(Integer id, String bankName, String branch) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.branch = branch;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return Objects.hash(bankName, branch, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(bankName, other.bankName) && Objects.equals(branch, other.branch)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", bankName=" + bankName + ", branch=" + branch + "]";
	}

}
