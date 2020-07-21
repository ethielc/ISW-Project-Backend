package com.zac.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zac.backend.model.Cama;
import com.zac.backend.repository.CamaRepository;

@Service("CamaService")
public class CamaService {
	@Autowired
	@Qualifier("CamaRepository")
	CamaRepository camaRepository;
	
	public boolean crear(Cama cama) {
		try {
			camaRepository.save(cama);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public boolean actualizar(Cama cama) {
		try {
			camaRepository.save(cama);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public boolean borrar(long id) {
		try {
			Cama cama = camaRepository.findById(id);
			camaRepository.delete(cama);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	public Cama obtenerPorId(long id) {
		return camaRepository.findById(id);
	}
	public List<Cama> obtenerPorOcupada(int ocupada) {
		return camaRepository.findByOcupada(ocupada);
	}
	public List<Cama> obtenerPorPabellon(long pabellon) {
		return camaRepository.findByPabellon(pabellon);
	}
}
