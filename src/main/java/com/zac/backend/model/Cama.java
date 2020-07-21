package com.zac.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CAMA")
public class Cama {
	@Id
	@GenericGenerator(name="incrementcama", strategy="increment")
    @GeneratedValue(generator="incrementcama")
	@Column(name="id_cama")
	private long id;
	
	@Column(name="id_pabellon")
    private long pabellon;
	
	@Column(name = "ocupada")
	private int ocupada;
	@Column(name = "paciente")
	private String paciente;
	
	public Cama() {
		super();
	}

	public Cama(long id_cama, int ocupada, String paciente, long pabellon) {
		super();
		this.id = id_cama;
		this.ocupada = ocupada;
		this.paciente = paciente;
		this.pabellon = pabellon;
	}

	public long getId_cama() {
		return id;
	}

	public void setId_cama(long id_cama) {
		this.id = id_cama;
	}

	public int getOcupada() {
		return ocupada;
	}

	public void setOcupada(int ocupada) {
		this.ocupada = ocupada;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public long getPabellon() {
		return pabellon;
	}

	public void setPabellon(long pabellon) {
		this.pabellon = pabellon;
	}
}
