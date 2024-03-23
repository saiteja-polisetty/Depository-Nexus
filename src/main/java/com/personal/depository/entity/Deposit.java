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

@Entity
@Table(name = "deposit")
public class Deposit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String depositNumber;
	private Date depositedOn;
	private Float depositValue;
	private Date maturityOn;
	private Float maturityValue;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Bank bank;

	@ManyToOne
	@JoinColumn(name = "nominee_id")
	private Nominee nominee;

	public Deposit() {
	}

	public Deposit(Integer id, String depositNumber, Date depositedOn, Float depositValue, Date maturityOn,
			Float maturityValue, User user, Bank bank, Nominee nominee) {
		super();
		this.id = id;
		this.depositNumber = depositNumber;
		this.depositedOn = depositedOn;
		this.depositValue = depositValue;
		this.maturityOn = maturityOn;
		this.maturityValue = maturityValue;
		this.user = user;
		this.bank = bank;
		this.nominee = nominee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepositNumber() {
		return depositNumber;
	}

	public void setDepositNumber(String depositNumber) {
		this.depositNumber = depositNumber;
	}

	public Date getDepositedOn() {
		return depositedOn;
	}

	public void setDepositedOn(Date depositedOn) {
		this.depositedOn = depositedOn;
	}

	public Float getDepositValue() {
		return depositValue;
	}

	public void setDepositValue(Float depositValue) {
		this.depositValue = depositValue;
	}

	public Date getMaturityOn() {
		return maturityOn;
	}

	public void setMaturityOn(Date maturityOn) {
		this.maturityOn = maturityOn;
	}

	public Float getMaturityValue() {
		return maturityValue;
	}

	public void setMaturityValue(Float maturityValue) {
		this.maturityValue = maturityValue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Nominee getNominee() {
		return nominee;
	}

	public void setNominee(Nominee nominee) {
		this.nominee = nominee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bank, depositNumber, depositValue, depositedOn, id, maturityOn, maturityValue, nominee,
				user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposit other = (Deposit) obj;
		return Objects.equals(bank, other.bank) && Objects.equals(depositNumber, other.depositNumber)
				&& Objects.equals(depositValue, other.depositValue) && Objects.equals(depositedOn, other.depositedOn)
				&& Objects.equals(id, other.id) && Objects.equals(maturityOn, other.maturityOn)
				&& Objects.equals(maturityValue, other.maturityValue) && Objects.equals(nominee, other.nominee)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Deposit [id=" + id + ", depositNumber=" + depositNumber + ", depositedOn=" + depositedOn
				+ ", depositValue=" + depositValue + ", maturityOn=" + maturityOn + ", maturityValue=" + maturityValue
				+ ", user=" + user + ", bank=" + bank + ", nominee=" + nominee + "]";
	}

}
