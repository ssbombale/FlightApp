package com.user.Repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.user.ctrl.FlightCtrl;
import com.user.entity.OutputModel;
import com.user.entity.SearchFlightDetails;
import com.user.entity.SearchFlightModel;
import com.user.ticket.entity.PassangerDetails;
import com.user.ticket.entity.ShowticketDetails;
import com.user.ticket.entity.TicketBookingModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserCtrlTest {

	@Autowired
	private FlightCtrl ctrl;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@LocalServerPort
	private int port;

	@Test
	public void ticketbook() {

		PassangerDetails details = new PassangerDetails("Test", "", "male", 20, "veg");
		List<PassangerDetails> pass = new ArrayList<PassangerDetails>();
		pass.add(details);
		TicketBookingModel ticketBookModel = new TicketBookingModel("CHE", "CBE", "ABC", "ABC", "2022-06-01", "11:00",
				"12:00", "", "12000", "ABC", "Test@junit.com", pass);

		ResponseEntity<ShowticketDetails> response = this.restTemplate.postForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/ticketBook", ticketBookModel,
				ShowticketDetails.class);

		assertEquals(response.getStatusCodeValue(), 200);
		ShowticketDetails showticketDetails = response.getBody();
		assertEquals(showticketDetails.isStatus(), true);

		/** View Ticket By Pnr ***/
		String pnr = showticketDetails.getTicketBooking().getPnrNumber();
		String mode = "ByPnrNumber";
		ResponseEntity<ShowticketDetails> response2 = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/searchTicket/" + pnr + "/" + mode,
				ShowticketDetails.class);

		System.out.println("----->>>" + response2.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		ShowticketDetails details2 = response.getBody();

		assertEquals(details2.isStatus(), true);

		/** Email ***/
		String userEmail = showticketDetails.getTicketBooking().getUserName();
		mode = "ByEmail";
		ResponseEntity<ShowticketDetails[]> emailresponse = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/searchByUserName/" + userEmail ,
				ShowticketDetails[].class);

		System.out.println("----->>>" + emailresponse.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		ShowticketDetails ticketDetails = response.getBody();

		assertEquals(ticketDetails.isStatus(), true);

		userEmail = showticketDetails.getTicketBooking().getEndCity();
		mode = "ByEmail";
		ResponseEntity<ShowticketDetails[]> errorresponse = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/searchByUserName/" + userEmail ,
				ShowticketDetails[].class);


		assertEquals(errorresponse.getStatusCodeValue(), 200);

		/*** Error ***/
		userEmail = null;
		mode = null;
		ResponseEntity<ShowticketDetails> catchResponse = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/searchTicket/" + userEmail + "/" + mode,
				ShowticketDetails.class);

		assertEquals(catchResponse.getStatusCodeValue(), 200);
		ShowticketDetails catchDetails = catchResponse.getBody();

		assertEquals(catchDetails.isStatus(), true);

		

		/**** Cancel ****/
		PassangerDetails cancelPassangers = new PassangerDetails("Test", "", "male", 20, "veg");
		List<PassangerDetails> canpass = new ArrayList<PassangerDetails>();
		canpass.add(cancelPassangers);
		TicketBookingModel ticketBookModelCancel = new TicketBookingModel("CHE", "CBE", "ABC", "ABC", "2022-06-01",
				"11:00", "12:00", "", "12000", "ABC", "Test@juniit.com", pass);

		ResponseEntity<ShowticketDetails> cancelByPnr = this.restTemplate.postForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/ticketBook", ticketBookModelCancel,
				ShowticketDetails.class);

		assertEquals(cancelByPnr.getStatusCodeValue(), 200);
		ShowticketDetails showticketDetailspnr = cancelByPnr.getBody();
		assertEquals(showticketDetailspnr.isStatus(), true);

		userEmail = showticketDetailspnr.getTicketBooking().getPnrNumber();
		mode = "ByPnrNumber";
		ResponseEntity<OutputModel> cancelTicketByPnr = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/cancelTicket/" + userEmail + "/" + mode,
				OutputModel.class);

		assertEquals(cancelTicketByPnr.getStatusCodeValue(), 200);
		OutputModel outByPnr = cancelTicketByPnr.getBody();

		assertEquals(outByPnr.isStatus(), true);

		userEmail = showticketDetails.getTicketBooking().getAirlineName();
		mode = "ByPnrNumber";
		ResponseEntity<OutputModel> cancelTicketError = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/cancelTicket/" + userEmail + "/" + mode,
				OutputModel.class);

		assertEquals(cancelTicketError.getStatusCodeValue(), 200);
		OutputModel outByPnrErr = cancelTicketError.getBody();

		assertEquals(outByPnrErr.isStatus(), false);

	}

	@Test
	public void mealType() {
		Long flightId = 2l;

		ResponseEntity<String> response = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/getMealType/" + flightId, String.class);
		assertEquals(response.getStatusCodeValue(), 200);
	}

	@Test
	public void searchTicket() {

		SearchFlightModel flightModel = new SearchFlightModel("", "", "Chennai", "Mumbai", "", "", "2022-06-29",
				"oneway", "");
		
		ResponseEntity<SearchFlightDetails> response = this.restTemplate.postForEntity(
				"http://localhost:" + port + "/api/user/flightctrl/searchFlight", flightModel,
				SearchFlightDetails.class);
		
		assertEquals(response.getStatusCodeValue(), 200);
		SearchFlightDetails res = response.getBody();
		assertEquals(res.getTripType(), "oneway");

		

	}

}
