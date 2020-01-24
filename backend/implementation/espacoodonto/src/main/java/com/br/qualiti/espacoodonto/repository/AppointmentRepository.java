package com.br.qualiti.espacoodonto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.qualiti.espacoodonto.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
List<Appointment> findByTimeContaining(Date date);
}
