package com.user.ticket.entity;

import java.util.List;

public class TicketBookingModel {

	private String startPoint;
	private String endPoint;
	private String flightName;
	private String airlineName;
	private String searchDate;
	private String startTime;
	private String endTime;
	private String pnrNumber;
	private String ticketFare;
	private String flightCode;
	private String userEmail;
	private List<PassangerDetails> passangerList;



	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}


	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}


	public List<PassangerDetails> getPassangerList() {
		return passangerList;
	}

	public void setPassangerList(List<PassangerDetails> passangerList) {
		this.passangerList = passangerList;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public String getTicketFare() {
		return ticketFare;
	}

	public void setTicketFare(String ticketFare) {
		this.ticketFare = ticketFare;
	}

	public TicketBookingModel(String startPoint, String endPoint, String flightName, String airlineName,
			String searchDate, String startTime, String endTime, String pnrNumber, String ticketFare, String flightCode,
			String userEmail, List<PassangerDetails> passangerList) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.flightName = flightName;
		this.airlineName = airlineName;
		this.searchDate = searchDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.pnrNumber = pnrNumber;
		this.ticketFare = ticketFare;
		this.flightCode = flightCode;
		this.userEmail = userEmail;
		this.passangerList = passangerList;
	}

	public TicketBookingModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
