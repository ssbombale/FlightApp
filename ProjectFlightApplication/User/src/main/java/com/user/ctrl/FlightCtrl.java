package com.user.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.user.entity.FlightDetails;
import com.user.entity.OutputModel;
import com.user.entity.SearchFlightDetails;
import com.user.entity.SearchFlightModel;
import com.user.service.UserService;
import com.user.ticket.entity.PassangerDetails;
import com.user.ticket.entity.ShowticketDetails;
import com.user.ticket.entity.TicketBooking;
import com.user.ticket.entity.TicketBookingModel;
import com.user.ticket.service.TicketBookingService;

@RestController
@RequestMapping(value = "/api/user/flightctrl")
@CrossOrigin(origins = "*")
public class FlightCtrl {

	@Autowired
	private UserService userService;

	@Autowired
	private TicketBookingService ticketBookingService;

	@PostMapping(value = "/searchFlight")
	public SearchFlightDetails searchFlight(@RequestBody SearchFlightModel searchFlightModel) {
		SearchFlightDetails searchFlightDetails = new SearchFlightDetails();
		try {
			searchFlightDetails = userService.getSearchFlightList(searchFlightModel);
			searchFlightDetails.setTripType(searchFlightModel.getSearchType());
		} catch (Exception e) {
			System.err.println(e);
		}
		return searchFlightDetails;
	}

	@PostMapping(value = "/ticketBook")
	public ShowticketDetails ticketBook(@RequestBody TicketBookingModel ticketBookingModel) {
		ShowticketDetails showticketDetails = new ShowticketDetails();

		TicketBooking ticketBooking = new TicketBooking();
		ticketBooking = ticketBookingService.ticketBookSave(ticketBookingModel);
		ticketBookingModel.setPnrNumber(ticketBooking.getPnrNumber());

		List<PassangerDetails> details = ticketBookingService.savePassangerDetails(ticketBookingModel);
		showticketDetails = new ShowticketDetails(ticketBooking, details, true);

		return showticketDetails;
	}

	@GetMapping(value = "/searchTicket/{pnrNumber}/{searchMode}")
	public ResponseEntity<?> searchTicket(@PathVariable String pnrNumber, @PathVariable String searchMode) {
		ShowticketDetails showticketDetails = new ShowticketDetails();
		OutputModel outputModel = new OutputModel();
		try {
			TicketBooking ticketBooking = new TicketBooking();
			List<TicketBooking> ticketList = new ArrayList<>();

			if (searchMode.equalsIgnoreCase("ByEmail")) {
				ticketList = ticketBookingService.getTicketDetailsByUserName(pnrNumber);
			} else if (searchMode.equalsIgnoreCase("ByPnrNumber")) {
				ticketBooking = ticketBookingService.getTicketDetailsByPnr(pnrNumber);
			}
			if (ticketBooking != null) {
				List<PassangerDetails> details = ticketBookingService
						.getPassangersDetails(ticketBooking.getPnrNumber());
				showticketDetails = new ShowticketDetails(ticketBooking, details, true);
				return ResponseEntity.ok(showticketDetails);

			} else {
				outputModel = new OutputModel(false, "not Found");
				return ResponseEntity.ok(outputModel);

			}
		} catch (Exception e) {
			System.err.println(e);
			outputModel = new OutputModel(false, "Ticket Not Found!!!!!");
			return ResponseEntity.ok(outputModel);
		}

	}

	@GetMapping(value = "/searchByUserName/{userName}")
	public List<TicketBooking> searchByUserName(@PathVariable String userName) {
		List<TicketBooking> ticketList = new ArrayList<>();

		ticketList = ticketBookingService.getTicketDetailsByUserName(userName);

		return ticketList;
	}

	@GetMapping(value = "/cancelTicket/{pnrNumber}/{searchMode}")
	public ResponseEntity<?> cancelTicket(@PathVariable String pnrNumber, @PathVariable String searchMode) {
		ShowticketDetails cancelTicket = new ShowticketDetails();
		OutputModel outputModel = new OutputModel();
		try {
			TicketBooking ticketBooking = new TicketBooking();
			List<TicketBooking> ticketList = new ArrayList<>();
			if (searchMode.equalsIgnoreCase("ByEmail")) {
				ticketList = ticketBookingService.getTicketDetailsByUserName(pnrNumber);
			} else if (searchMode.equalsIgnoreCase("ByPnrNumber")) {
				ticketBooking = ticketBookingService.getTicketDetailsByPnr(pnrNumber);

			}
			if (ticketBooking != null) {
				List<PassangerDetails> details = ticketBookingService
						.getPassangersDetails(ticketBooking.getPnrNumber());
				ticketBookingService.deleteTicketDetailsById(ticketBooking.getTicketBookingId());
				ticketBookingService.deletePassangerById(details);
				outputModel = new OutputModel(true, "Ticket Has Been Canceled");
				return ResponseEntity.ok(outputModel);

			} else if (!ticketList.isEmpty()) {
				return ResponseEntity.ok(ticketList);
			} else {

				outputModel = new OutputModel(false, "Ticket Not Found!!!!!");
				return ResponseEntity.ok(outputModel);
			}
		} catch (

		Exception e) {
			System.err.println(e);
			outputModel = new OutputModel(false, "Ticket Not Found!!!!!");
			return ResponseEntity.ok(outputModel);
		}

	}

	@GetMapping(value = "/getMealType/{flightId}")
	public String getMealType(@PathVariable Long flightId) {

		JsonArray js = new JsonArray();

		FlightDetails details = userService.getFlightByFlightId(flightId);
		if (details.getMealType().equalsIgnoreCase("Both")) {
			JsonObject veg = new JsonObject();
			veg.addProperty("mealtype", "Veg");
			js.add(veg); 
			JsonObject nveg = new JsonObject();
			nveg.addProperty("mealtype", "Non-Veg");
			js.add(nveg);
		} else if (details.getMealType().equalsIgnoreCase("veg")) {
			JsonObject veg = new JsonObject();
			veg.addProperty("mealtype", "Veg");
			js.add(veg);

		} else if (details.getMealType().equalsIgnoreCase("Non-Veg")) {
			JsonObject nveg = new JsonObject();
			nveg.addProperty("mealtype", "Non-Veg");
			js.add(nveg);
		}

		return js.toString();

	}

	@PutMapping(value = "/getTicketFare/{ticketType}/{flightId}")
	public String getTicketFare(@PathVariable String ticketType, @PathVariable Long flightId,
			@RequestBody List<PassangerDetails> passangerListSize) {

		JsonObject jsonObject = new JsonObject();
		try {
			System.out.println(passangerListSize.size());
			FlightDetails details = userService.getFlightByFlightId(flightId);
			if (ticketType.equalsIgnoreCase("Economy")) {
				jsonObject.addProperty("ticketFare", details.getPriceEconamySeats() * passangerListSize.size());
			} else if (ticketType.equalsIgnoreCase("Business")) {
				jsonObject.addProperty("ticketFare", details.getPriceDetails() * passangerListSize.size());
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		return jsonObject.toString();
	}

}
