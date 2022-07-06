package com.user.ticket.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.ticket.entity.TicketBooking;

public interface ITicketBookingRepostiory extends JpaRepository<TicketBooking, Long> {

	TicketBooking findByPnrNumber(String pnrNumber);

	List<TicketBooking> findByUserName(String userName);

	@Query("DELETE FROM PassangerDetails WHERE pnrNumber = :pnrNumber")
	void deleteByPnrNumber(String pnrNumber);

	
}
