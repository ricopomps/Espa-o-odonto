package com.br.qualiti.espacoodonto.service;

import org.springframework.stereotype.Service;

import com.br.qualiti.espacoodonto.model.Pacient;
import com.br.qualiti.espacoodonto.repository.PacientRepository;

@Service
public class PacientService {
	private PacientRepository pacientRepository;

	PacientService(PacientRepository pacientRepository) {
		this.pacientRepository = pacientRepository;
	}

	public Pacient create(Pacient pacient) {
		return pacientRepository.save(pacient);
	}
}
