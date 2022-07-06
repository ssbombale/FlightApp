package com.user.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TicketBooking")
public class TicketBooking {

	private Long ticketBookingId;
	private String fromCity;
	private String endCity;
	private String flightName;
	private String airlineName;
	private String travelDate;
	private String startTime;
	private String endTime;
	private String pnrNumber;
	private String totalPriceAmount;
	private String flightCode;
	private String userName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TicketBookingId")
	public Long getTicketBookingId() {
		return ticketBookingId;
	}

	public void setTicketBookingId(Long ticketBookingId) {
		this.ticketBookingId = ticketBookingId;
	}

	@Column(name = "FromCity")
	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	@Column(name = "EndCity")
	public String getEndCity() {
		return endCity;
	}

	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

	@Column(name = "PnrNumber")
	public String getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	@Column(name = "TotalPriceAmount")
	public String getTotalPriceAmount() {
		return totalPriceAmount;
	}

	public void setTotalPriceAmount(String totalPriceAmount) {
		this.totalPriceAmount = totalPriceAmount;
	}

	public TicketBooking(Long ticketBookingId, String fromCity, String endCity, String pnrNumber,
			String totalPriceAmount) {
		super();
		this.ticketBookingId = ticketBookingId;
		this.fromCity = fromCity;
		this.endCity = endCity;
		this.pnrNumber = pnrNumber;
		this.totalPriceAmount = totalPriceAmount;
	}

	public TicketBooking() {
		super();
	}

	@Column(name = "FlightName")
	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	@Column(name = "AirlineName")
	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	@Column(name = "TravelDate")
	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	@Column(name = "StartTime")
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name = "EndTime")
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Column(name = "FlightCode")
	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	@Column(name = "UserName")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
}
