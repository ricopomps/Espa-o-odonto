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
import com.br.qualiti.espacoodonto.model.Pacient;
import com.br.qualiti.espacoodonto.service.PacientService;

@RestController()
@RequestMapping("/api/v1/pacient")
public class PacientController {
	private PacientService pacientService;

	PacientController(PacientService pacientService) {
		this.pacientService = pacientService;
	}

	@PostMapping
	public Pacient create(@RequestBody Pacient pacient) {
		return pacientService.create(pacient);
	}

	@GetMapping
	public List findAll() {
		return pacientService.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable long id) {
		Optional<Pacient> pacient = pacientService.findById(id);
		if (pacient.isPresent()) {
			return ResponseEntity.ok().body(pacient);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody Pacient pacient) {
		try {
			Pacient updatedPacient = pacientService.update(id, pacient);
			return ResponseEntity.ok().body(updatedPacient);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity delete(@PathVariable long id) {
		pacientService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
