package com.br.qualiti.espacoodonto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
