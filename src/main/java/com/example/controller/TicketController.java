package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Event;
import com.example.model.Ticket;
import com.example.repository.TicketRepository;
import com.example.service.TicketService;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private TicketService ticketService;

	@GetMapping("/tickets")
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable(value = "id") long ticketId)
			throws ResourceNotFoundException {
		Ticket ticket = ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + ticketId));
		return ResponseEntity.ok().body(ticket);
	}

//	@PostMapping("/users")
//	public User createUser(@Valid @RequestBody User user) {
//		user.setid(userService.generateSequence(User.SEQUENCE_NAME));
//		return userRepository.save(user);
//	}

	@PutMapping("/update")
	public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "id") Long ticketId,
			@Validated @RequestBody Ticket ticketDetails) throws ResourceNotFoundException {
		Ticket ticket = ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + ticketId));

         
		 
		Ticket updatedTicket = ticketRepository.save(ticket);
		return ResponseEntity.ok(updatedTicket);
	}

	@DeleteMapping("//{id}")
	public Map<String, Boolean> deleteTicket(@PathVariable(value = "id") Long ticketId)
			throws ResourceNotFoundException {
		Ticket ticket = ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + ticketId));

		ticketRepository.delete(ticket);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

