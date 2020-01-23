package com.br.qualiti.espacoodonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.qualiti.espacoodonto.exception.ResourceNotFoundException;
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

	public List findAll() {
		return pacientRepository.findAll();
	}

	public Optional<Pacient> findById(long id) {
		return pacientRepository.findById(id);
	}

	public Pacient update(long id, Pacient pacient) {
		Optional<Pacient> currentPacient = pacientRepository.findById(id);
		if (currentPacient.isPresent()) {
			currentPacient.get().setName(pacient.getName());
			currentPacient.get().setCell(pacient.getCell());
			currentPacient.get().setGender(pacient.getGender());
			currentPacient.get().setDateOfBirth(pacient.getDateOfBirth());
			return pacientRepository.save(currentPacient.get());
		} else {
			throw new ResourceNotFoundException("Pacient", "Client",
					"O paciente com id: " + id + " não foi encontrado");
		}
	}
	public void delete(long id) {
		try {
			pacientRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			
		}
	}
}
