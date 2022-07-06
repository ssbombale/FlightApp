package com.admin.service;

import java.util.List;

import com.admin.entity.AirLine;
import com.admin.entity.FlightDetails;

public interface AdminService {

	AirLine saveAirLine(AirLine airLine);
	
	public List<AirLine> getAllAirLine();
	
	FlightDetails saveFliehtDetails(FlightDetails flightDetails);
	
	public List<FlightDetails> getAllflightDetails();

	List<AirLine> getSearchByAirLineName(String airLineName);

	List<FlightDetails> getSearchByFlightName(String flightName);

	AirLine getAirLineByAirLineId(Long airlineId);

	FlightDetails getFlightDetailsBuFlightId(Long flightId);

	List<FlightDetails> getFlightByAirlineName(String airlineName);

	String greet();

	AirLine geteAirlineByCode(String string);
	
}
