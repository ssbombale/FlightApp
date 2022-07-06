package com.user.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PassangerDetails")
public class PassangerDetails {

	private Long passangerId;
	private String passangerName;
	private String pnrNumber;
	private String gender;
	private Integer age;
	private String mealType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PassangerId")
	public Long getPassangerId() {
		return passangerId;
	}

	public void setPassangerId(Long passangerId) {
		this.passangerId = passangerId;
	}

	@Column(name = "PassangerName")
	public String getPassangerName() {
		return passangerName;
	}

	public void setPassangerName(String passangerName) {
		this.passangerName = passangerName;
	}

	@Column(name = "PnrNumber")
	public String getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	@Column(name = "Gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "Age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "MealType")
	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	
	public PassangerDetails(Long passangerId, String passangerName, String pnrNumber, String gender, Integer age,
			String mealType) {
		super();
		this.passangerId = passangerId;
		this.passangerName = passangerName;
		this.pnrNumber = pnrNumber;
		this.gender = gender;
		this.age = age;
		this.mealType = mealType;
	}

	
	
	public PassangerDetails(String passangerName, String pnrNumber, String gender, Integer age,
			String mealType) {
		super();
		this.passangerName = passangerName;
		this.pnrNumber = pnrNumber;
		this.gender = gender;
		this.age = age;
		this.mealType = mealType;
	}

	public PassangerDetails() {
		super();
	}

}
