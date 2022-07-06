package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AirLine")
public class AirLine {

	@Id
	private Long airlineId;
	private String airlineName;
	private String airlineContactNumber;
	private boolean airlineActiveStatus;
	private String airlineCode;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AirlineId")
	public Long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}

	@Column(name = "AirlineName")
	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	@Column(name = "AirlineContactNumber")
	public String getAirlineContactNumber() {
		return airlineContactNumber;
	}

	public void setAirlineContactNumber(String airlineContactNumber) {
		this.airlineContactNumber = airlineContactNumber;
	}

	@Column(name = "AirlineActiveStatus")
	public boolean isAirlineActiveStatus() {
		return airlineActiveStatus;
	}

	public void setAirlineActiveStatus(boolean airlineActiveStatus) {
		this.airlineActiveStatus = airlineActiveStatus;
	}

	@Column(name="AirlineCode")
	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public AirLine(Long airlineId, String airlineName, String airlineContactNumber, boolean airlineActiveStatus,
			String airlineCode) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.airlineContactNumber = airlineContactNumber;
		this.airlineActiveStatus = airlineActiveStatus;
		this.airlineCode = airlineCode;
	}

	public AirLine(String airlineName, String airlineContactNumber, boolean airlineActiveStatus, String airlineCode) {
		// TODO Auto-generated constructor stub
		super();
		this.airlineName = airlineName;
		this.airlineContactNumber = airlineContactNumber;
		this.airlineActiveStatus = airlineActiveStatus;
		this.airlineCode = airlineCode;
	}

	public AirLine() {
		// TODO Auto-generated constructor stub
		super();
	}

	
	
}
