package com.admin.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.entity.AirLine;
import com.admin.entity.AuthResponse;
import com.admin.entity.FlightDetails;
import com.admin.entity.Login;
import com.admin.entity.OutputModel;
import com.admin.entity.Useraccount;
import com.admin.security.jwt.JwtUtils;
import com.admin.service.AdminService;
import com.admin.service.UseraccountServiceImpl;

@RestController
@RequestMapping(value = "/api/admin/adminCtrl")
@CrossOrigin(origins = "*")
public class AdminCtrl {
 
	@Autowired
	private AdminService adminService;

	@GetMapping(value = "/test")
	public String test() {
		return "Hello World!!!!";
	} 

	@PostMapping(value = "/createAirLine")
	public OutputModel createAirLine(@RequestBody AirLine airLine) {

		OutputModel model = new OutputModel();
		try {
			airLine.setAirlineActiveStatus(true);
			AirLine savedAirLine = adminService.saveAirLine(airLine);
			model = new OutputModel(true, savedAirLine.getAirlineName() + " has been saved");
		} catch (Exception e) {
			System.err.println(e);
			model = new OutputModel(false, "Something Went to Wrong!!!");
		}
		return model;
	}

	@GetMapping(value = "/getAllAirLine")
	public List<AirLine> getAllAirLine() {
		return adminService.getAllAirLine();
	}

	@PostMapping(value = "/createNewFlight")
	public OutputModel createNewFlight(@RequestBody FlightDetails flightDetails) {
		OutputModel model = new OutputModel();
		try {

			FlightDetails saveFlightDetails = adminService.saveFliehtDetails(flightDetails);
			model = new OutputModel(true, saveFlightDetails.getFlightName() + " has been Saved");
		} catch (Exception e) {
			System.err.println(e);
			model = new OutputModel(false, "Something Went to Wrong!!!");
		}
		return model;
	}

	@GetMapping(value = "/fetchAllFlight")
	public List<FlightDetails> getAllFlightList() {
		return adminService.getAllflightDetails();
	}

	@GetMapping(value = "/searchAirlineByName/{airLineName}")
	public List<AirLine> searchAirLineByName(@PathVariable String airLineName) {
		System.out.println(airLineName);
		return adminService.getSearchByAirLineName(airLineName);
	}

	@GetMapping(value = "/searchFlightByName/{flightName}")
	public List<FlightDetails> searchFlightByName(@PathVariable String flightName) {
		return adminService.getSearchByFlightName(flightName);
	}

	@GetMapping(value = "/getAirLineId/{airlineId}")
	public AirLine getAirLineId(@PathVariable Long airlineId) {
		return adminService.getAirLineByAirLineId(airlineId);
	}

	@GetMapping(value = "/getFlightDetailById/{flightId}")
	public FlightDetails getFlightDetailById(@PathVariable Long flightId) {
		return adminService.getFlightDetailsBuFlightId(flightId);
	}

	@GetMapping(value = "/activateAirline/{airlineId}") 
	public OutputModel activateAirline(@PathVariable Long airlineId) {
		OutputModel outputModel = new OutputModel();
		try {
			AirLine airline = adminService.getAirLineByAirLineId(airlineId);
			airline.setAirlineActiveStatus(true);
			airline = adminService.saveAirLine(airline);
			List<FlightDetails> list = adminService.getFlightByAirlineName(airline.getAirlineName());
			for (FlightDetails flightDetails : list) {
				flightDetails.setFlightActiveStatus(true);
				adminService.saveFliehtDetails(flightDetails);
			}
			outputModel = new OutputModel(true, "Activated SuccessFully");
		} catch (Exception e) {
			System.err.println(e);
			outputModel = new OutputModel(false, "Somthing went to wrong");

		}
		return outputModel;
	}

	@GetMapping(value = "/deactivateAirline/{airlineId}")
	public OutputModel deactivateAirline(@PathVariable Long airlineId) {
		OutputModel outputModel = new OutputModel();
		try {
			AirLine airline = adminService.getAirLineByAirLineId(airlineId);

			airline.setAirlineActiveStatus(false);
			airline = adminService.saveAirLine(airline);
			List<FlightDetails> list = adminService.getFlightByAirlineName(airline.getAirlineName());
			for (FlightDetails flightDetails : list) {
				flightDetails.setFlightActiveStatus(false);
				adminService.saveFliehtDetails(flightDetails);
			}
			System.out.println(list);

			outputModel = new OutputModel(true, "De - Activated SuccessFully");
		} catch (Exception e) {
			System.err.println(e);
			outputModel = new OutputModel(false, "Somthing went to wrong");

		}
		return outputModel;
	}

	@PutMapping(value = "/updateAirLine/{airlineId}")
	public ResponseEntity<?> updateAirline(@PathVariable Long airlineId, @RequestBody AirLine airLine) {
		OutputModel model = new OutputModel();
		try {
			AirLine line = adminService.getAirLineByAirLineId(airlineId);
			if (line != null) {
				line.setAirlineName(airLine.getAirlineName());
				line.setAirlineCode(airLine.getAirlineCode());
				line.setAirlineContactNumber(airLine.getAirlineContactNumber());
				adminService.saveAirLine(line);
				model = new OutputModel(true, "UpdatesuccessFully");
			}
		} catch (Exception e) {
			System.err.println(e);
			model = new OutputModel(false, "Somthing Went to wrong");
		}
		return ResponseEntity.ok(model);
	}

	@PutMapping(value = "/updateFlight/{flightId}")
	public ResponseEntity<?> updateFlight(@PathVariable Long flightId, @RequestBody FlightDetails flightDetails) {
		OutputModel model = new OutputModel();
		try {
			FlightDetails details = adminService.getFlightDetailsBuFlightId(flightId);
			if (details != null) {
				details.setAirlineName(flightDetails.getAirlineName());
				details.setFlightName(flightDetails.getFlightName());
				details.setFlightCode(flightDetails.getFlightCode());
				details.setStartPoint(flightDetails.getStartPoint());
				details.setEndPoint(flightDetails.getEndPoint());
				details.setAvalibleSeats(flightDetails.getAvalibleSeats());
				details.setFlightStartTime(flightDetails.getFlightStartTime());
				details.setFlightEndTime(flightDetails.getFlightEndTime());
				details.setTotalNumberOfSeats(flightDetails.getTotalNumberOfSeats());
				details.setPriceDetails(flightDetails.getPriceDetails());
				details.setTravelHours(flightDetails.getTravelHours());
				details.setTotalNumberOfEconamySeats(flightDetails.getTotalNumberOfEconamySeats());
				details.setPriceEconamySeats(flightDetails.getPriceEconamySeats());
				details.setMealType(flightDetails.getMealType());
				adminService.saveFliehtDetails(details);
				model = new OutputModel(true, "UpdatesuccessFully");
			} 
		} catch (Exception e) {
			System.err.println(e);
			model = new OutputModel(false, "Somthing Went to wrong");
		}
		return ResponseEntity.ok(model);
	}
	
	
	
	@GetMapping(value = "cancelFlight/{flightId}")
	public OutputModel cancelFlights(@PathVariable Long flightId) {
		OutputModel model = new OutputModel();
		try {
			FlightDetails details = adminService.getFlightDetailsBuFlightId(flightId);
			details.setFlightActiveStatus(false);
			adminService.saveFliehtDetails(details);
			model = new OutputModel(true, "Updated");
		}catch(Exception e)
		{
			System.err.println(e);
			model = new OutputModel(false, "not Update");
		}
		
		return model;
	}
	

	@GetMapping(value = "activateFlights/{flightId}")
	public OutputModel activateFlights(@PathVariable Long flightId) {
		OutputModel model = new OutputModel();
		try {
			FlightDetails details = adminService.getFlightDetailsBuFlightId(flightId);
			details.setFlightActiveStatus(true);
			adminService.saveFliehtDetails(details);
			model = new OutputModel(true, "Updated");
		}catch(Exception e)
		{
			System.err.println(e);
			model = new OutputModel(false, "not Update");
		}
		
		return model;
	}
	

	
	
	
}
