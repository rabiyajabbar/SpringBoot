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
import com.example.repository.EventRepository;
import com.example.service.EventService;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/events")
public class EventController {
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventService eventService;

	@GetMapping("/events")
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable(value = "id") long eventId)
			throws ResourceNotFoundException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + eventId));
		return ResponseEntity.ok().body(event);
	}

//	@PostMapping("/users")
//	public User createUser(@Valid @RequestBody User user) {
//		user.setid(userService.generateSequence(User.SEQUENCE_NAME));
//		return userRepository.save(user);
//	}

	@PutMapping("/update")
	public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long eventId,
			@Validated @RequestBody Event eventDetails) throws ResourceNotFoundException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));

		event.setEventNAme(eventDetails.getEventNAme());
        event.setImgUrl(eventDetails.getImgUrl());
        
		Event updatedEvent = eventRepository.save(event);
		return ResponseEntity.ok(updatedEvent);
	}

	@DeleteMapping("//{id}")
	public Map<String, Boolean> deleteEvent(@PathVariable(value = "id") Long eventId)
			throws ResourceNotFoundException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));

		eventRepository.delete(event);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

