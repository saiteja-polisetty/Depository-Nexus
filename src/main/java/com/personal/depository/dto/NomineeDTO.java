package com.personal.depository.dto;

import java.util.Objects;

public class NomineeDTO {

	private String name;
	private Integer age;
	private String relationship;

	public NomineeDTO() {
	}

	public NomineeDTO(String name, Integer age, String relationship) {
		super();
		this.name = name;
		this.age = age;
		this.relationship = relationship;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, relationship);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NomineeDTO other = (NomineeDTO) obj;
		return Objects.equals(age, other.age) && Objects.equals(name, other.name)
				&& Objects.equals(relationship, other.relationship);
	}

	@Override
	public String toString() {
		return "NomineeDTO [name=" + name + ", age=" + age + ", relationship=" + relationship + "]";
	}

}
