package com.admin.Repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.admin.entity.AirLine;
import com.admin.entity.FlightDetails;
import com.admin.entity.OutputModel;
import com.admin.service.AdminService;
import com.admin.service.IAirLineRepostiory;
import com.admin.service.IFlightDetailsRepostiory;
import com.admin.service.IUseraccountRepostiory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdminCtrlTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private IUseraccountRepostiory useraccountRepostiory;

	@Autowired
	private IAirLineRepostiory airLineRepostiory;

	@Autowired
	private IFlightDetailsRepostiory iFlightDetailsRepostiory;

	@Autowired
	private AdminService adminService;

	@Test
	public void testJunt() {
		assertThat(
				this.restTemplate.getForObject("http://localhost:" + port + "//api/admin/adminCtrl/test", String.class))
						.contains("Hello World!!!!");
	}

	@Test
	public void allAirline() {

		ResponseEntity<AirLine[]> response = this.restTemplate
				.getForEntity("http://localhost:" + port + "//api/admin/adminCtrl/getAllAirLine", AirLine[].class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);

	}

	@Test
	public void allFlight() {

		ResponseEntity<FlightDetails[]> response = this.restTemplate.getForEntity(
				"http://localhost:" + port + "//api/admin/adminCtrl/fetchAllFlight", FlightDetails[].class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);

	}

	@Test
	public void createAirline() {
		AirLine airLine = new AirLine("TestAirline", "1234", true, "TA");
		ResponseEntity<OutputModel> response = this.restTemplate.postForEntity(
				"http://localhost:" + port + "//api/admin/adminCtrl/createAirLine", airLine, OutputModel.class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		OutputModel outputModel = response.getBody();
		assertEquals(outputModel.isStatus(), true);

	}

	@Test
	public void createFlightError() {
		FlightDetails details = new FlightDetails(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"JF", true, "CBE", "CHE", "", "12:00", "13:00", "1:00", "AllDays", "Indico");
		ResponseEntity<OutputModel> response = this.restTemplate.postForEntity(
				"http://localhost:" + port + "//api/admin/adminCtrl/createNewFlight", details, OutputModel.class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		OutputModel outputModel = response.getBody();
		assertEquals(outputModel.isStatus(), false);
	}

	@Test
	public void createAirlineError() {
		AirLine airLine = new AirLine(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"1234", true, "TA");
		ResponseEntity<OutputModel> response = this.restTemplate.postForEntity(
				"http://localhost:" + port + "//api/admin/adminCtrl/createAirLine", airLine, OutputModel.class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		OutputModel outputModel = response.getBody();

		assertEquals(outputModel.isStatus(), false);

	}

	@Test
	public void createFlight() {
		FlightDetails details = new FlightDetails("JunitFlight", "JF", true, "CBE", "CHE", "", "12:00", "13:00", "1:00",
				"AllDays", "Indico");
		ResponseEntity<OutputModel> response = this.restTemplate.postForEntity(
				"http://localhost:" + port + "//api/admin/adminCtrl/createNewFlight", details, OutputModel.class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		OutputModel outputModel = response.getBody();
		assertEquals(outputModel.isStatus(), true);
	}

	@Test
	public void getAirline() {
		AirLine airLine = new AirLine("TestAirline", "1234", true, "TA");

		ResponseEntity<AirLine[]> response = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/admin/adminCtrl/searchAirlineByName/" + airLine.getAirlineName(),
				AirLine[].class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		AirLine[] outputModel = response.getBody();
		for (AirLine air : outputModel) {
			System.out.println("-------->>>>>>" + air.getAirlineId());
			airLineRepostiory.deleteById(air.getAirlineId());
		}
	}

	@Test
	public void getFlight() {
		FlightDetails details = new FlightDetails("JunitFlight", "JF", true, "CBE", "CHE", "", "12:00", "13:00", "1:00",
				"AllDays", "Indico");
		ResponseEntity<FlightDetails[]> response = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/admin/adminCtrl/searchFlightByName/" + details.getFlightName(),
				FlightDetails[].class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		FlightDetails[] outputModel = response.getBody();
		for (FlightDetails air : outputModel) {
			System.out.println("-------->>>>>>" + air.getFlightId());
			iFlightDetailsRepostiory.deleteById(air.getFlightId());
		}
	}

	@Test
	public void getflightById() {
		Long flightId = 2l;
		ResponseEntity<FlightDetails> response = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/admin/adminCtrl/getFlightDetailById/" + flightId,
				FlightDetails.class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		FlightDetails details = response.getBody();
	}

	@Test
	public void getairlineById() {
		Long airlineId = 1l;
		ResponseEntity<AirLine> response = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/admin/adminCtrl/getAirLineId/" + airlineId, AirLine.class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);

	}

	@Test
	public void updateAirline() {

		AirLine airLine = adminService.geteAirlineByCode("code");

	}

	@Test
	public void activateAirline() {
		AirLine airLine = new AirLine("DemoAirline", "1234", true, "TAAA");
		ResponseEntity<OutputModel> response = this.restTemplate.postForEntity(
				"http://localhost:" + port + "//api/admin/adminCtrl/createAirLine", airLine, OutputModel.class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		OutputModel outputModel = response.getBody();
		assertEquals(outputModel.isStatus(), true);
		AirLine airLineNew = adminService.geteAirlineByCode(airLine.getAirlineCode());

		airLineNew.setAirlineActiveStatus(false);

		FlightDetails details = new FlightDetails("JunitFlight", "JF", true, "CBE", "CHE", "", "12:00", "13:00", "1:00",
				"AllDays", "DemoAirline");
		ResponseEntity<OutputModel> flifhtresponse = this.restTemplate.postForEntity(
				"http://localhost:" + port + "//api/admin/adminCtrl/createNewFlight", details, OutputModel.class);
		List<FlightDetails> list = adminService.getFlightByAirlineName(airLineNew.getAirlineName());

		for (FlightDetails flightDetails : list) {
			flightDetails.setFlightActiveStatus(true);
			adminService.saveFliehtDetails(flightDetails);
			
			
			
			ResponseEntity<FlightDetails> responseActive = this.restTemplate.getForEntity(
					"http://localhost:" + port + "/api/admin/adminCtrl/activateFlights/" + flightDetails.getFlightId(), FlightDetails.class);
			
			
			ResponseEntity<FlightDetails> responseDeactive = this.restTemplate.getForEntity(
					"http://localhost:" + port + "/api/admin/adminCtrl/cancelFlight/" + flightDetails.getFlightId(), FlightDetails.class);
			
			assertEquals(responseActive.getStatusCodeValue(), 200);
			

			assertEquals(responseDeactive.getStatusCodeValue(), 200);
			
		}

		ResponseEntity<OutputModel> upateResponce = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/admin/adminCtrl/activateAirline/" + airLineNew.getAirlineId(),
				OutputModel.class);

		assertEquals(upateResponce.getStatusCodeValue(), 200);
		OutputModel updateOutputModel = upateResponce.getBody();
		assertEquals(updateOutputModel.isStatus(), true);

		ResponseEntity<OutputModel> errorResponce = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/admin/adminCtrl/activateAirline/" + 0000, OutputModel.class);
		assertEquals(errorResponce.getStatusCodeValue(), 200);
		OutputModel errorOutputModel = upateResponce.getBody();
		assertEquals(errorOutputModel.isStatus(), true);

		System.out.println("----->>>" + flifhtresponse.getStatusCodeValue());
		assertEquals(flifhtresponse.getStatusCodeValue(), 200);

		airLineRepostiory.deleteById(airLineNew.getAirlineId());
		for (FlightDetails flightDetails : list) {
			iFlightDetailsRepostiory.deleteById(flightDetails.getFlightId());
		}
	}

	@Test
	public void deactivateAirline() {
		AirLine airLine = new AirLine("DemoAirline", "1234", false, "TAAA");
		ResponseEntity<OutputModel> response = this.restTemplate.postForEntity(
				"http://localhost:" + port + "//api/admin/adminCtrl/createAirLine", airLine, OutputModel.class);

		System.out.println("----->>>" + response.getStatusCodeValue());
		assertEquals(response.getStatusCodeValue(), 200);
		OutputModel outputModel = response.getBody();
		assertEquals(outputModel.isStatus(), true);
		AirLine airLineNew = adminService.geteAirlineByCode(airLine.getAirlineCode());

		airLineNew.setAirlineActiveStatus(true);

		FlightDetails details = new FlightDetails("JunitFlight", "JF", true, "CBE", "CHE", "", "12:00", "13:00", "1:00",
				"AllDays", "DemoAirline");
		ResponseEntity<OutputModel> flifhtresponse = this.restTemplate.postForEntity(
				"http://localhost:" + port + "//api/admin/adminCtrl/createNewFlight", details, OutputModel.class);
		List<FlightDetails> list = adminService.getFlightByAirlineName(airLineNew.getAirlineName());

		for (FlightDetails flightDetails : list) {
			flightDetails.setFlightActiveStatus(true);
			adminService.saveFliehtDetails(flightDetails);
		}

		ResponseEntity<OutputModel> upateResponce = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/admin/adminCtrl/deactivateAirline/" + airLineNew.getAirlineId(),
				OutputModel.class);

		assertEquals(upateResponce.getStatusCodeValue(), 200);
		OutputModel updateOutputModel = upateResponce.getBody();
		assertEquals(updateOutputModel.isStatus(), true);

		ResponseEntity<OutputModel> errorResponce = this.restTemplate.getForEntity(
				"http://localhost:" + port + "/api/admin/adminCtrl/deactivateAirline/" + 0000, OutputModel.class);
		assertEquals(errorResponce.getStatusCodeValue(), 200);
		OutputModel errorOutputModel = upateResponce.getBody();
		assertEquals(errorOutputModel.isStatus(), true);

		airLineRepostiory.deleteById(airLineNew.getAirlineId());
		for (FlightDetails flightDetails : list) {
			iFlightDetailsRepostiory.deleteById(flightDetails.getFlightId());
		}

	} 

	
	
	
	
//getAllAirLine
}
