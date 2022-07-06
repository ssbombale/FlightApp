package com.user.ticket.entity;

import java.util.List;

public class ShowticketDetails {

	private TicketBooking ticketBooking;
	private List<PassangerDetails> passangeDetails;
	private boolean status;
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public TicketBooking getTicketBooking() {
		return ticketBooking;
	}
	public void setTicketBooking(TicketBooking ticketBooking) {
		this.ticketBooking = ticketBooking;
	}
	public List<PassangerDetails> getPassangeDetails() {
		return passangeDetails;
	}
	public void setPassangeDetails(List<PassangerDetails> passangeDetails) {
		this.passangeDetails = passangeDetails;
	}
	
	public ShowticketDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowticketDetails(TicketBooking ticketBooking, List<PassangerDetails> passangeDetails, boolean status) {
		super();
		this.ticketBooking = ticketBooking;
		this.passangeDetails = passangeDetails;
		this.status = status;
	}
	


	
}
