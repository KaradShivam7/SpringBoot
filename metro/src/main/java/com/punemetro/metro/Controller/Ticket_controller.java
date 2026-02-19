package com.punemetro.metro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.punemetro.metro.DTO.TicketRequestDTO;
import com.punemetro.metro.Entity.Ticket;
import com.punemetro.metro.Exception.invalidstationexception;
import com.punemetro.metro.Service.Ticket_service;

@RestController
public class Ticket_controller {
	
	@Autowired
	private Ticket_service service;
	
	@PostMapping("/book-ticket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody TicketRequestDTO request) throws invalidstationexception {
	    return ResponseEntity.ok(service.bookTicket(request));
	}


}
