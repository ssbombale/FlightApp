package com.admin.Repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.admin.entity.AirLine;
import com.admin.entity.FlightDetails;
import com.admin.entity.Useraccount;
import com.admin.service.AdminService;
import com.admin.service.IAirLineRepostiory;
import com.admin.service.IFlightDetailsRepostiory;
import com.admin.service.IUseraccountRepostiory;

@SpringBootTest
public class AdminTestCheck {

	@Autowired
	private IUseraccountRepostiory useraccountRepostiory;

	@Autowired
	private IAirLineRepostiory airLineRepostiory; 

	@Autowired
	private IFlightDetailsRepostiory iFlightDetailsRepostiory;

	@Autowired
	private AdminService adminService;



	
	
	@Test
	void loadUserPresent() {

		String name = "krishna@test.com";
		Useraccount useraccount = useraccountRepostiory.findByUserName(name);
		System.out.println(useraccount.getUserName());
		assertEquals(name, useraccount.getUserName());
		assertNotEquals("sdvsv", useraccount.getUserName());
	}

	@Test
	void airlineSavecheck() {
		AirLine airLine = new AirLine("TestAirline", "1234", true, "TA");
		AirLine falseAirline = new AirLine("TestAirlinecv", "1234", true, "TA");
		AirLine resuAirLine = airLineRepostiory.save(airLine);
		assertTrue(airLine.equals(resuAirLine));
		assertFalse(falseAirline.equals(resuAirLine));
		airLineRepostiory.deleteById(airLine.getAirlineId());
	}

	@Test
	void saveFlightcheck() {

		FlightDetails details = new FlightDetails("JunitFlight", "JF", true, "CBE", "CHE", "", "12:00", "13:00", "1:00",
				"AllDays", "Indico");

		FlightDetails junit = new FlightDetails("JunitFlightV1", "JF123", true, "CBE", "CHE", "", "12:00", "13:00",
				"1:00", "AllDays", "IndicoF1");

		FlightDetails resuAirLine = iFlightDetailsRepostiory.save(details);
		assertTrue(details.equals(resuAirLine));
		assertFalse(junit.equals(resuAirLine));
		assertEquals(details.getAirlineName(), resuAirLine.getAirlineName());
		assertEquals(resuAirLine.getFlightName(), details.getFlightName());

		assertNotEquals(junit.getAirlineName(), resuAirLine.getAirlineName());
		assertNotEquals(resuAirLine.getFlightName(), junit.getFlightName());

		iFlightDetailsRepostiory.deleteById(resuAirLine.getFlightId());

	}

	@Test
	void updateFlightcheck() {
		FlightDetails details = new FlightDetails("JunitFlight", "JF", true, "CBE", "CHE", "", "12:00", "13:00", "1:00",
				"AllDays", "Indico");

		FlightDetails junit = new FlightDetails("JunitFlightV1", "JF123", true, "CBE", "CHE", "", "12:00", "13:00",
				"1:00", "AllDays", "IndicoF1");
		FlightDetails resuAirLine = iFlightDetailsRepostiory.save(details);
		resuAirLine.setFlightName("TestFlightTFE");
		resuAirLine.setFlightCode("TTF");
		resuAirLine.setFlighttravelDays("WeekEnds");
		FlightDetails updateFlight = iFlightDetailsRepostiory.save(resuAirLine);

		assertEquals(updateFlight.getFlightCode(), "TTF");
		assertEquals(updateFlight.getFlightName(), "TestFlightTFE");
		assertEquals(updateFlight.getFlighttravelDays(), "WeekEnds");

		assertNotEquals(junit.getAirlineName(), resuAirLine.getAirlineName());
		assertNotEquals(resuAirLine.getFlightName(), junit.getFlightName());

		iFlightDetailsRepostiory.deleteById(resuAirLine.getFlightId());

	}

	@Test
	void updateairlinecheck() {
		AirLine airLine = new AirLine("TestAirline", "1234", true, "TA");
		AirLine resuAirLine = airLineRepostiory.save(airLine);

		resuAirLine.setAirlineName("TestAirlineUpdate");
		resuAirLine.setAirlineActiveStatus(false);
		AirLine falseAirline = airLineRepostiory.save(resuAirLine);

		assertEquals(falseAirline.getAirlineName(), "TestAirlineUpdate");
		assertEquals(falseAirline.isAirlineActiveStatus(), false);
		airLineRepostiory.deleteById(falseAirline.getAirlineId());
	}

	@Test
	void deactivateAirline() {
		AirLine airLine = new AirLine("TestAirline", "1234", true, "TA");
		AirLine resuAirLine = airLineRepostiory.save(airLine);
		assertEquals(resuAirLine.isAirlineActiveStatus(), true);
		resuAirLine.setAirlineActiveStatus(false);
		AirLine falseAirline = airLineRepostiory.save(resuAirLine);

		assertEquals(falseAirline.isAirlineActiveStatus(), false);
		airLineRepostiory.deleteById(falseAirline.getAirlineId());

	}

	@Test
	void activateAirline() {
		AirLine airLine = new AirLine("TestAirline", "1234", false, "TA");
		AirLine resuAirLine = airLineRepostiory.save(airLine);
		assertEquals(resuAirLine.isAirlineActiveStatus(), false);
		resuAirLine.setAirlineActiveStatus(true);
		AirLine falseAirline = airLineRepostiory.save(resuAirLine);
		assertEquals(falseAirline.isAirlineActiveStatus(), true);
		airLineRepostiory.deleteById(falseAirline.getAirlineId());
	}

	@Test
	void flightList() {
		List<FlightDetails> flight = adminService.getAllflightDetails();
		System.out.println(flight);
		assertThat(flight).size().isGreaterThan(0);

	}

	@Test
	void airlineList() {
		List<AirLine> flight = adminService.getAllAirLine();
		assertThat(flight).size().isGreaterThan(0);
	}

	@Test
	void deleteFlightcheck() {

		FlightDetails details = new FlightDetails("JunitFlight", "JF", true, "CBE", "CHE", "", "12:00", "13:00", "1:00",
				"AllDays", "Indico");

		FlightDetails resuAirLine = iFlightDetailsRepostiory.save(details);
		assertTrue(details.equals(resuAirLine));
		assertEquals(details.getAirlineName(), resuAirLine.getAirlineName());
		assertEquals(resuAirLine.getFlightName(), details.getFlightName());
		assertThat(iFlightDetailsRepostiory.existsById(resuAirLine.getFlightId())).isTrue();
		iFlightDetailsRepostiory.deleteById(resuAirLine.getFlightId());
		assertThat(iFlightDetailsRepostiory.existsById(resuAirLine.getFlightId())).isFalse();

	}

	@Test
	void deleteairlinecheck() {
		AirLine airLine = new AirLine("TestAirline", "1234", true, "TA");
		AirLine falseAirline = new AirLine("TestAirlinecv", "1234", true, "TA");
		AirLine resuAirLine = airLineRepostiory.save(airLine);
		assertTrue(airLine.equals(resuAirLine));
		assertFalse(falseAirline.equals(resuAirLine));
		assertThat(airLineRepostiory.existsById(resuAirLine.getAirlineId())).isTrue();
		airLineRepostiory.deleteById(resuAirLine.getAirlineId());
		assertThat(airLineRepostiory.existsById(resuAirLine.getAirlineId())).isFalse();

	}

	@Test
	void loadfirstNamePresent() {

		String name = "krishna@test.com";
		String fistName = "Krishna";
		Useraccount useraccount = useraccountRepostiory.findByUserName(name);
		System.out.println(useraccount.getUserName());
		assertEquals(name, useraccount.getUserName());
		assertNotEquals("sdvsv", useraccount.getUserName());

		assertEquals(fistName, useraccount.getFirstName());
		assertNotEquals(name, useraccount.getFirstName());
	}

	@Test
	void flightListByFightName() {
		FlightDetails details = new FlightDetails("JunitFlight", "JF", true, "CBE", "CHE", "", "12:00", "13:00", "1:00",
				"AllDays", "Indico");
		FlightDetails resuAirLine = iFlightDetailsRepostiory.save(details);

		List<FlightDetails> flight = adminService.getSearchByFlightName(resuAirLine.getFlightName());
		assertThat(flight).size().isGreaterThan(0);
		iFlightDetailsRepostiory.deleteById(resuAirLine.getFlightId());
		assertThat(iFlightDetailsRepostiory.existsById(resuAirLine.getFlightId())).isFalse();
	}

	@Test
	void airlineListByAirlineName() {
		AirLine airLine = new AirLine("TestAirline", "1234", true, "TA");
		AirLine falseAirline = new AirLine("TestAirlinecv", "1234", true, "TA");
		AirLine resuAirLine = airLineRepostiory.save(airLine);
		assertTrue(airLine.equals(resuAirLine));
		assertFalse(falseAirline.equals(resuAirLine));
		List<AirLine> testAirLines = airLineRepostiory.findByAirlineName("TestAirline");
		assertThat(testAirLines).size().isGreaterThan(0);
		airLineRepostiory.deleteById(airLine.getAirlineId());
		assertThat(airLineRepostiory.existsById(airLine.getAirlineId())).isFalse();

	}
}
