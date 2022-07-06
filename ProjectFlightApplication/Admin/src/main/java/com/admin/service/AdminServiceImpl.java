package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.AirLine;
import com.admin.entity.FlightDetails;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private IAirLineRepostiory iairlineRepostiory;

	@Autowired
	private IFlightDetailsRepostiory iflightDetailsRepostiory;

	@Override
	public AirLine saveAirLine(AirLine airLine) {
		try {
			return iairlineRepostiory.save(airLine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AirLine> getAllAirLine() {
		return iairlineRepostiory.findAll();
	}

	@Override
	public FlightDetails saveFliehtDetails(FlightDetails flightDetails) {

		try {
			return iflightDetailsRepostiory.save(flightDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<FlightDetails> getAllflightDetails() {
		return iflightDetailsRepostiory.findAll();
	}

	@Override
	public List<AirLine> getSearchByAirLineName(String airLineName) {
		// TODO Auto-generated method stub
		return iairlineRepostiory.findByAirlineName(airLineName);
	}

	@Override
	public List<FlightDetails> getSearchByFlightName(String flightName) {
		// TODO Auto-generated method stub
		return iflightDetailsRepostiory.findByFlightName(flightName);
	}

	@Override
	public AirLine getAirLineByAirLineId(Long airlineId) {
		// TODO Auto-generated method stub
		return iairlineRepostiory.findById(airlineId).orElseThrow();
	}

	@Override
	public FlightDetails getFlightDetailsBuFlightId(Long flightId) {
		// TODO Auto-generated method stub
		return iflightDetailsRepostiory.findById(flightId).orElseThrow();
	}

	@Override
	public List<FlightDetails> getFlightByAirlineName(String airlineName) {
		// TODO Auto-generated method stub
		return iflightDetailsRepostiory.findByAirlineName(airlineName);
	}

	@Override
	public String greet() {
		// TODO Auto-generated method stub
		return "Hello";
	}

	@Override
	public AirLine geteAirlineByCode(String airlineCode) {
		// TODO Auto-generated method stub
		return iairlineRepostiory.findByAirlineCode(airlineCode);
	}

}
