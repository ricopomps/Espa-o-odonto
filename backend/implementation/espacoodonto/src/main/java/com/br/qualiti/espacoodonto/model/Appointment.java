package com.br.qualiti.espacoodonto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Date time;

	private double value;

	@JsonBackReference
	//@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pacient_id", nullable = false)
	private long pacientId;

	public Appointment() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public long getPacientId() {
		return pacientId;
	}

	public void setPacientId(long pacientId) {
		this.pacientId = pacientId;
	}

}
