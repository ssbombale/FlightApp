package com.user.ticket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ticket")
public class TicketCtrl {

	@GetMapping("/")
	public String test() {
		return "HelloWorld";
	}
	
	
	
}
