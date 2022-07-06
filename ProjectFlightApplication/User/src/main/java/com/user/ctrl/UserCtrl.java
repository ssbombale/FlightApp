package com.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.FlightDetails;
import com.user.entity.OutputModel;
import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping(value="/api/user/userctrl")
public class UserCtrl {
	
	@Autowired
	private UserService userService;
	
/**	@PostMapping(value = "/saveUser")
	public OutputModel saveUser(@RequestBody User user) {
		OutputModel model = new OutputModel();
		try {
			User saveUsers = userService.saveUser(user);
			model = new OutputModel(true, saveUsers.getUserEmail() + " User Created!!!!");
		}catch(Exception e) {
			System.err.println("Error "+ e);
			model = new OutputModel(false, "Somtheing Went to Wrong!!!!");
		}
		return model;
	}**/
	
}
