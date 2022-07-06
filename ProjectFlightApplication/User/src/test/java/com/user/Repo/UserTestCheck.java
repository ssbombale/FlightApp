package com.user.Repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.user.entity.AirLine;
import com.user.entity.FlightDetails;
import com.user.service.IAirLineRepostiory;
import com.user.service.IFlightDetailsRepostiory;
import com.user.service.UserService;

@SpringBootTest
public class UserTestCheck {

	

	@Autowired
	private IAirLineRepostiory airLineRepostiory;

	@Autowired
	private IFlightDetailsRepostiory iFlightDetailsRepostiory;

	@Autowired
	private UserService adminService;

	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
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
