package com.user.ticket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.ticket.entity.PassangerDetails;
import com.user.ticket.entity.TicketBooking;
import com.user.ticket.entity.TicketBookingModel;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

	@Autowired
	private ITicketBookingRepostiory repostiory;

	@Autowired
	private IPassangerDetailsRepostiory passangerDetailsRepostiory;

	@Override
	public TicketBooking ticketBookSave(TicketBookingModel ticketBookingModel) {
		TicketBooking ticketBooking = new TicketBooking();
		ticketBooking.setAirlineName(ticketBookingModel.getAirlineName());
		ticketBooking.setFlightName(ticketBookingModel.getFlightName());
		ticketBooking.setStartTime(ticketBookingModel.getStartTime());
		ticketBooking.setEndTime(ticketBookingModel.getEndTime());
		ticketBooking.setFromCity(ticketBookingModel.getStartPoint());
		ticketBooking.setEndCity(ticketBookingModel.getEndPoint());
		ticketBooking.setTravelDate(ticketBookingModel.getSearchDate());
		ticketBooking.setUserName(ticketBookingModel.getUserEmail());
		ticketBooking.setPnrNumber(pnrGenerate());
		ticketBooking.setFlightCode(ticketBookingModel.getFlightCode());
		ticketBooking.setTotalPriceAmount(ticketBookingModel.getTicketFare());
		
		return repostiory.save(ticketBooking);
	}

	private static String pnrGenerate() {
		Random rand = new Random();
		int int1 = rand.nextInt(100000);
		String pnrNumber = "PNR000" + Integer.toString(int1);
		return pnrNumber;
	}

	@Override
	public List<PassangerDetails> savePassangerDetails(TicketBookingModel ticketBookingModel) {
		List<PassangerDetails> passangerDetails = new ArrayList<>();
		for (PassangerDetails details : ticketBookingModel.getPassangerList()) {
			details.setPnrNumber(ticketBookingModel.getPnrNumber());
			PassangerDetails passangerDetail = passangerDetailsRepostiory.save(details);
			passangerDetails.add(passangerDetail);
		}
		return passangerDetails;
	}

	@Override
	public TicketBooking getTicketDetailsByPnr(String pnrNumber) {
		// TODO Auto-generated method stub
		return repostiory.findByPnrNumber(pnrNumber);
	}

	@Override
	public List<PassangerDetails> getPassangersDetails(String pnrNumber) {
		// TODO Auto-generated method stub
		return passangerDetailsRepostiory.findByPnrNumber(pnrNumber);
	}

	@Override
	public List<TicketBooking> getTicketDetailsByUserName(String userName) {
		// TODO Auto-generated method stub
		return repostiory.findByUserName(userName);
	}

	@Override
	public void deleteTicketDetailsByPNR(String pnrNumber) {
		// TODO Auto-generated method stub
		repostiory.deleteByPnrNumber(pnrNumber);
	}

	@Override
	public void deletePassangerByPNR(String pnrNumber) {
		// TODO Auto-generated method stub
		passangerDetailsRepostiory.deleteByPnrNumber(pnrNumber);
	}

	@Override
	public void deleteTicketDetailsById(Long ticketBookingId) {
		repostiory.deleteById(ticketBookingId);

	}

	@Override
	public void deletePassangerById(List<PassangerDetails> details) {
		// TODO Auto-generated method stub
		for (PassangerDetails passangerDetails : details) {
			passangerDetailsRepostiory.deleteById(passangerDetails.getPassangerId());
		}

	}
}
