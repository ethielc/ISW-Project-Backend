package com.zac.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CAMA")
public class Cama {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_cama;
	@Column(name = "ocupada")
	private boolean ocupada;
	@Column(name = "paciente")
	private String paciente;
	@ManyToOne
	@JoinColumn(name = "id_pabellon", nullable = false)
	private Pabellon pabellon;
	
	public Cama() {
		super();
	}

	public Cama(long id_cama, boolean ocupada, String paciente, Pabellon pabellon) {
		super();
		this.id_cama = id_cama;
		this.ocupada = ocupada;
		this.paciente = paciente;
		this.pabellon = pabellon;
	}

	public long getId_cama() {
		return id_cama;
	}

	public void setId_cama(long id_cama) {
		this.id_cama = id_cama;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public Pabellon getPabellon() {
		return pabellon;
	}

	public void setPabellon(Pabellon pabellon) {
		this.pabellon = pabellon;
	}
}
