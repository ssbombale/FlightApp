package com.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FlightDetails")
public class FlightDetails {

	private Long flightId;
	private String flightName;
	private String flightCode;
	private boolean flightActiveStatus;
	private String StartPoint;
	private String endPoint;
	private String midStop;
	private String flightStartTime;
	private String flightEndTime;
	private String travelHours;
	private String flighttravelDays;
	private String airlineName;
	private Long totalNumberOfSeats;
	private Double priceDetails;
	private Long avalibleSeats;
	private Long totalNumberOfEconamySeats;
		private Double priceEconamySeats; 
private String mealType;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FlightId")
	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	@Column(name = "FlightName")
	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	@Column(name = "FlightCode")
	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	@Column(name = "FlightActiveStatus")
	public boolean isFlightActiveStatus() {
		return flightActiveStatus;
	}

	public void setFlightActiveStatus(boolean flightActiveStatus) {
		this.flightActiveStatus = flightActiveStatus;
	}

	@Column(name = "StartPoint")
	public String getStartPoint() {
		return StartPoint;
	}

	public void setStartPoint(String startPoint) {
		StartPoint = startPoint;
	}

	@Column(name = "EndPoint")
	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	@Column(name = "MidStop")
	public String getMidStop() {
		return midStop;
	}

	public void setMidStop(String midStop) {
		this.midStop = midStop;
	}

	@Column(name = "FlightStartTime")
	public String getFlightStartTime() {
		return flightStartTime;
	}

	public void setFlightStartTime(String flightStartTime) {
		this.flightStartTime = flightStartTime;
	}

	@Column(name = "FlightEndTime")
	public String getFlightEndTime() {
		return flightEndTime;
	}

	public void setFlightEndTime(String flightEndTime) {
		this.flightEndTime = flightEndTime;
	}

	@Column(name = "TravelHours")
	public String getTravelHours() {
		return travelHours;
	}

	public void setTravelHours(String travelHours) {
		this.travelHours = travelHours;
	}

	@Column(name = "FlighttravelDays")
	public String getFlighttravelDays() {
		return flighttravelDays;
	}

	public void setFlighttravelDays(String flighttravelDays) {
		this.flighttravelDays = flighttravelDays;
	}

	@Column(name = "AirlineName")
	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	@Column(name = "TotalNumberOfSeats")
	public Long getTotalNumberOfSeats() {
		return totalNumberOfSeats;
	}

	public void setTotalNumberOfSeats(Long totalNumberOfSeats) {
		this.totalNumberOfSeats = totalNumberOfSeats;
	}

	@Column(name = "PriceDetails")
	public Double getPriceDetails() {
		return priceDetails;
	}

	public void setPriceDetails(Double priceDetails) {
		this.priceDetails = priceDetails;
	}

	@Column(name = "TotalAvalbileSeats")
	public Long getAvalibleSeats() {
		return avalibleSeats;
	}

	public void setAvalibleSeats(Long avalibleSeats) {
		this.avalibleSeats = avalibleSeats;
	}

	public FlightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="TotalNumberOfEconamySeats")
	public Long getTotalNumberOfEconamySeats() {
		return totalNumberOfEconamySeats;
	}

	public void setTotalNumberOfEconamySeats(Long totalNumberOfEconamySeats) {
		this.totalNumberOfEconamySeats = totalNumberOfEconamySeats;
	}

	@Column(name="PriceEconamySeats")
	public Double getPriceEconamySeats() {
		return priceEconamySeats;
	}

	public void setPriceEconamySeats(Double priceEconamySeats) {
		this.priceEconamySeats = priceEconamySeats;
	}

	@Column(name="MealType")
	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public FlightDetails(String flightName, String flightCode, boolean flightActiveStatus, String startPoint,
			String endPoint, String midStop, String flightStartTime, String flightEndTime, String travelHours,
			String flighttravelDays, String airlineName, Long totalNumberOfSeats, Double priceDetails,
			Long avalibleSeats, Long totalNumberOfEconamySeats, Double priceEconamySeats, String mealType) {
		super();
		this.flightName = flightName;
		this.flightCode = flightCode;
		this.flightActiveStatus = flightActiveStatus;
		StartPoint = startPoint;
		this.endPoint = endPoint;
		this.midStop = midStop;
		this.flightStartTime = flightStartTime;
		this.flightEndTime = flightEndTime;
		this.travelHours = travelHours;
		this.flighttravelDays = flighttravelDays;
		this.airlineName = airlineName;
		this.totalNumberOfSeats = totalNumberOfSeats;
		this.priceDetails = priceDetails;
		this.avalibleSeats = avalibleSeats;
		this.totalNumberOfEconamySeats = totalNumberOfEconamySeats;
		this.priceEconamySeats = priceEconamySeats;
		this.mealType = mealType;
	}
	
	
	public FlightDetails(String flightName, String flightCode, boolean flightActiveStatus, String startPoint,
			String endPoint, String midStop, String flightStartTime, String flightEndTime, String travelHours,
			String flighttravelDays, String airlineName) {
		super();
		this.flightName = flightName;
		this.flightCode = flightCode;
		this.flightActiveStatus = flightActiveStatus;
		StartPoint = startPoint;
		this.endPoint = endPoint;
		this.midStop = midStop;
		this.flightStartTime = flightStartTime;
		this.flightEndTime = flightEndTime;
		this.travelHours = travelHours;
		this.flighttravelDays = flighttravelDays;
		this.airlineName = airlineName;
	}

	public FlightDetails(Long flightId,String flightName, String flightCode, boolean flightActiveStatus, String startPoint,
			String endPoint, String midStop, String flightStartTime, String flightEndTime, String travelHours,
			String flighttravelDays, String airlineName) {
		super();
		this.flightId=flightId;
		this.flightName = flightName;
		this.flightCode = flightCode;
		this.flightActiveStatus = flightActiveStatus;
		StartPoint = startPoint;
		this.endPoint = endPoint;
		this.midStop = midStop;
		this.flightStartTime = flightStartTime;
		this.flightEndTime = flightEndTime;
		this.travelHours = travelHours;
		this.flighttravelDays = flighttravelDays;
		this.airlineName = airlineName;
	}


}
