package com.zac.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zac.backend.model.Pabellon;
import com.zac.backend.repository.PabellonRepository;

@Service("PabellonService")
public class PabellonService {
	@Autowired
	@Qualifier("PabellonRepository")
	private PabellonRepository pabellonRepository;
	
	public boolean crear(Pabellon pabellon) {
		try {
			pabellonRepository.save(pabellon);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public boolean actualizar(Pabellon pabellon) {
		try {
			pabellonRepository.save(pabellon);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public boolean borrar(long id) {
		try {
			Pabellon pabellon = pabellonRepository.findById(id);
			pabellonRepository.delete(pabellon);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public Pabellon obtenerPorId(long id) {
		return pabellonRepository.findById(id);
	}
	public List<Pabellon> obtenerAll() {
		return pabellonRepository.findAll();
	}
	public List<Pabellon> obtenerPorDisponibilidad(int disponibilidad) {
		return pabellonRepository.findByDisponibilidad(disponibilidad);
	}
	public boolean existe(long id) {
		return pabellonRepository.existsById(id);
	}
}
