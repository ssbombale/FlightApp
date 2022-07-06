package com.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.FlightDetails;
import com.user.entity.SearchFlightDetails;
import com.user.entity.SearchFlightModel;
import com.user.entity.User;
import com.user.util.DateUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	IUserAccountRepostiory userAccountRepostiory;

	@Autowired
	IFlightDetailsRepostiory iflightDetailsRepostiory;

	@Override
	public User saveUser(User user) {
		return userAccountRepostiory.save(user);
	}

	@Override
	public SearchFlightDetails getSearchFlightList(SearchFlightModel searchFlightModel) {
		// TODO Auto-generated method stub new ArrayList<FlightDetails>();
		List<FlightDetails> list = iflightDetailsRepostiory
				.findByStartPointAndEndPoint(searchFlightModel.getStartPoint(), searchFlightModel.getEndPoint());
		List<SearchFlightModel> searchmodel = new ArrayList<>();
		SearchFlightDetails searchFlightDetails = new SearchFlightDetails();
		for (FlightDetails flightDetails : list) {
			if (flightDetails.isFlightActiveStatus()) {

				SearchFlightModel flightModel = new SearchFlightModel();

				boolean chkStatus = getSearchFlieghtStatus(flightDetails.getFlighttravelDays(),
						searchFlightModel.getSearchDate());

				if (chkStatus) {
					flightModel.setFlightId(flightDetails.getFlightId());
					flightModel.setAirlineName(flightDetails.getAirlineName());
					flightModel.setFlightName(flightDetails.getFlightName());
					flightModel.setStartTime(flightDetails.getFlightStartTime());
					flightModel.setEndTime(flightDetails.getFlightEndTime());
					flightModel.setStartPoint(flightDetails.getStartPoint());
					flightModel.setEndPoint(flightDetails.getEndPoint());
					flightModel.setAvalibleTicket(String.valueOf(flightDetails.getTotalNumberOfSeats()));
					flightModel.setTravelHours(flightDetails.getTravelHours());
					flightModel.setTicketFare(flightDetails.getPriceEconamySeats());
					flightModel.setSearchDate(searchFlightModel.getSearchDate());
					flightModel.setFlightCode(flightDetails.getFlightCode());
					flightModel.setEconomyFare(flightDetails.getPriceDetails());
					searchmodel.add(flightModel);
				}
			}
		}
		searchFlightDetails.setOneWayTrip(searchmodel);

		if (searchFlightModel.getSearchType().equalsIgnoreCase("roundtrip")) {
			List<SearchFlightModel> roundTrip = getSearchFlightforRound(searchFlightModel);
			searchFlightDetails.setReturnTrip(roundTrip);
		} else {
			List<SearchFlightModel> roundTrip = new ArrayList<>();
			searchFlightDetails.setReturnTrip(roundTrip);
		}

		return searchFlightDetails;
	}

	@Override
	public List<SearchFlightModel> getSearchFlightforRound(SearchFlightModel searchFlightModel) {
		// TODO Auto-generated method stub new ArrayList<FlightDetails>();
		List<FlightDetails> list = iflightDetailsRepostiory.findByStartPointAndEndPoint(searchFlightModel.getEndPoint(),
				searchFlightModel.getStartPoint());
		List<SearchFlightModel> searchmodel = new ArrayList<>();
		for (FlightDetails flightDetails : list) {
			if (flightDetails.isFlightActiveStatus()) {

				SearchFlightModel flightModel = new SearchFlightModel();
				boolean chkStatus = getSearchFlieghtStatus(flightDetails.getFlighttravelDays(),
						searchFlightModel.getReturnDate());

				if (chkStatus) {
					flightModel.setFlightId(flightDetails.getFlightId());
					flightModel.setAirlineName(flightDetails.getAirlineName());
					flightModel.setFlightName(flightDetails.getFlightName());
					flightModel.setStartTime(flightDetails.getFlightStartTime());
					flightModel.setEndTime(flightDetails.getFlightEndTime());
					flightModel.setStartPoint(flightDetails.getStartPoint());
					flightModel.setEndPoint(flightDetails.getEndPoint());
					flightModel.setAvalibleTicket(String.valueOf(flightDetails.getTotalNumberOfSeats()));
					flightModel.setTravelHours(flightDetails.getTravelHours());
					flightModel.setTicketFare(flightDetails.getPriceDetails());
					flightModel.setSearchDate(searchFlightModel.getReturnDate());
					flightModel.setFlightCode(flightDetails.getFlightCode());
					searchmodel.add(flightModel);
				}
			}
		}
		return searchmodel;
	}

	private boolean getSearchFlieghtStatus(String flighttravelDays, String searchDate) {
		String days = DateUtil.getDay(searchDate);
		boolean chkStatus = false;
		if (flighttravelDays.equalsIgnoreCase("AllDays")) {
			chkStatus = true;
		} else if (flighttravelDays.equals("WeekDays")) {
			List<String> weekDays = Stream.of("monday", "tuesday", "wednesday", "thersday", "friday")
					.collect(Collectors.toList());
			if (weekDays.contains(days.toLowerCase())) {
				chkStatus = true;
			}
		} else if (flighttravelDays.equals("WeekEnds")) {
			List<String> weekEnds = Stream.of("saturday", "sunday").collect(Collectors.toList());
			if (weekEnds.contains(days.toLowerCase())) {
				chkStatus = true;
			}
		}
		return chkStatus;
	}

	@Override
	public FlightDetails getFlightByFlightId(Long flightId) {
		return iflightDetailsRepostiory.findById(flightId).orElseThrow();
	}

}
