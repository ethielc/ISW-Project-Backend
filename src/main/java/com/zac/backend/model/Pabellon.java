package com.zac.backend.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PABELLON")
public class Pabellon {
	@Id
    @GenericGenerator(name="incrementpabellon", strategy="increment")
    @GeneratedValue(generator="incrementpabellon")
	@Column(name="id_pabellon")
	private long id;
	@Column(name = "sala")
	private String sala;
	@Column(name = "cant_camas")
	private int cant_camas;
	@Column(name = "disponibilidad")
	private int disponibilidad;
	@OneToMany(mappedBy = "pabellon")
	private Set<Cama> camas;
	
	public Pabellon() {
		super();
	}

	public Pabellon(long id_pabellon, String sala, int cant_camas, int disponibilidad, Set<Cama> camas) {
		super();
		this.id = id_pabellon;
		this.sala = sala;
		this.cant_camas = cant_camas;
		this.disponibilidad = disponibilidad;
		this.camas = camas;
	}

	public long getId_pabellon() {
		return id;
	}

	public void setId_pabellon(long id_pabellon) {
		this.id = id_pabellon;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public int getCant_camas() {
		return cant_camas;
	}

	public void setCant_camas(int cant_camas) {
		this.cant_camas = cant_camas;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Set<Cama> getCamas() {
		return camas;
	}

	public void setCamas(Set<Cama> camas) {
		this.camas = camas;
	}
}
