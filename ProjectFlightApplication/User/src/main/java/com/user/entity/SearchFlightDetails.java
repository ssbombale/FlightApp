package com.user.entity;

import java.util.List;

public class SearchFlightDetails {

	private List<SearchFlightModel> oneWayTrip;
	private List<SearchFlightModel> returnTrip;
	private String tripType;

	public List<SearchFlightModel> getOneWayTrip() {
		return oneWayTrip;
	}

	public void setOneWayTrip(List<SearchFlightModel> oneWayTrip) {
		this.oneWayTrip = oneWayTrip;
	}

	public List<SearchFlightModel> getReturnTrip() {
		return returnTrip;
	}

	public void setReturnTrip(List<SearchFlightModel> returnTrip) {
		this.returnTrip = returnTrip;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

}
