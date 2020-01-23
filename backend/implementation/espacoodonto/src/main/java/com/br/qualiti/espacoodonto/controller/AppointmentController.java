package com.br.qualiti.espacoodonto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.qualiti.espacoodonto.exception.ResourceNotFoundException;
import com.br.qualiti.espacoodonto.model.Appointment;
import com.br.qualiti.espacoodonto.service.AppointmentService;

@RestController()
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
	private AppointmentService appointmentService;

	AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@PostMapping
	public Appointment create(@RequestBody Appointment appointment) {
		return appointmentService.create(appointment);
	}

	@GetMapping
	public List findAll() {
		return appointmentService.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable long id) {
		Optional<Appointment> appointment = appointmentService.findById(id);
		if (appointment.isPresent()) {
			return ResponseEntity.ok().body(appointment);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Appointment appointment) {
		try {
			Appointment updatedappointment = appointmentService.update(id, appointment);
			return ResponseEntity.ok().body(updatedappointment);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity delete(@PathVariable long id) {
		appointmentService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
