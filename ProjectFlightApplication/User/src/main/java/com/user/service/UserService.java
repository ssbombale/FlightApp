package com.user.service;

import java.util.List;

import com.user.entity.FlightDetails;
import com.user.entity.SearchFlightDetails;
import com.user.entity.SearchFlightModel;
import com.user.entity.User;

public interface UserService {
	
	public User saveUser(User user);

	public SearchFlightDetails getSearchFlightList(SearchFlightModel searchFlightModel);

	List<SearchFlightModel> getSearchFlightforRound(SearchFlightModel searchFlightModel);

	public FlightDetails getFlightByFlightId(Long flightId);

}
