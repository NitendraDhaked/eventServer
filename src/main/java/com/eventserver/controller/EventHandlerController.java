package com.eventserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventserver.constants.AppConstants;
import com.eventserver.response.EventServerResponse;
import com.eventserver.service.EventService;

@RestController
@RequestMapping(AppConstants.EVENT_API_PATH)
@CrossOrigin(origins = "http://localhost:4200")
public class EventHandlerController {
	
	@Autowired
	EventService eventService;
	
	@GetMapping("/event/{eventId}")
	public EventServerResponse calculate(@PathVariable(value = "eventId") Integer eventId) {
		
		return eventService.calculate(eventId);
	}
}
