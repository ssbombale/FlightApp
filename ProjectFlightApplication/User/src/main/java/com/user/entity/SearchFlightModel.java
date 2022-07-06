package com.user.entity;

public class SearchFlightModel {

	private Long flightId;
	private String flightName;
	private String airlineName;
	private String startPoint;
	private String endPoint;
	private String startTime;
	private String endTime;
	private String searchDate;
	private String searchType;
	private String returnDate;
	private Double ticketFare;
	private String avalibleTicket;
	private String travelHours;
	private String flightCode;
	private String userEmail;
	private Double economyFare;

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

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Double getTicketFare() {
		return ticketFare;
	}

	public void setTicketFare(Double ticketFare) {
		this.ticketFare = ticketFare;
	}

	public String getAvalibleTicket() {
		return avalibleTicket;
	}

	public void setAvalibleTicket(String avalibleTicket) {
		this.avalibleTicket = avalibleTicket;
	}

	public String getTravelHours() {
		return travelHours;
	}

	public void setTravelHours(String travelHours) {
		this.travelHours = travelHours;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public SearchFlightModel(String flightName, String airlineName, String startPoint, String endPoint,
			String startTime, String endTime, String searchDate, String searchType, String returnDate,
			Double ticketFare, String avalibleTicket, String travelHours, String flightCode, String userEmail) {
		super();
		this.flightName = flightName;
		this.airlineName = airlineName;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.startTime = startTime;
		this.endTime = endTime;
		this.searchDate = searchDate;
		this.searchType = searchType;
		this.returnDate = returnDate;
		this.ticketFare = ticketFare;
		this.avalibleTicket = avalibleTicket;
		this.travelHours = travelHours;
		this.flightCode = flightCode;
		this.userEmail = userEmail;
	}

	public SearchFlightModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchFlightModel(String flightName, String airlineName, String startPoint, String endPoint,
			String startTime, String endTime, String searchDate, String searchType, String returnDate) {
		super();
		this.flightName = flightName;
		this.airlineName = airlineName;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.startTime = startTime;
		this.endTime = endTime;
		this.searchDate = searchDate;
		this.searchType = searchType;
		this.returnDate = returnDate;
	}

	public Double getEconomyFare() {
		return economyFare;
	}

	public void setEconomyFare(Double economyFare) {
		this.economyFare = economyFare;
	}

}
