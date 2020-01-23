package com.br.qualiti.espacoodonto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.qualiti.espacoodonto.exception.ResourceNotFoundException;
import com.br.qualiti.espacoodonto.model.Appointment;
import com.br.qualiti.espacoodonto.repository.AppointmentRepository;

@Service
public class AppointmentService {
	private AppointmentRepository appointmentRepository;

	AppointmentService(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	public Appointment create(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	public List findAll() {
		return appointmentRepository.findAll();
	}

	public Optional<Appointment> findById(long id) {
		return appointmentRepository.findById(id);
	}

	public Appointment update(long id, Appointment appointment) {
		Optional<Appointment> currentAppointment = appointmentRepository.findById(id);
		if (currentAppointment.isPresent()) {
			currentAppointment.get().setPacientId(appointment.getPacientId());
			currentAppointment.get().setTime(appointment.getTime());
			currentAppointment.get().setValue(appointment.getValue());
			return appointmentRepository.save(currentAppointment.get());
		} else {
			throw new ResourceNotFoundException("Appointment", "Client",
					"A consulta com id: " + id + "não foi encontrada");
		}
	}

	public void delete(long id) {
		try {
			appointmentRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {

		}
	}
}
