package com.zac.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zac.backend.model.Pabellon;
import com.zac.backend.repository.PabellonRepository;

@Service("PabellonService")
public class PabellonService {
	@Autowired
	private PabellonRepository pabellonRepository;
	
	//Request
	public List<Pabellon> listAll() {
		return pabellonRepository.findAll();
	}
	public Optional<Pabellon> listOne(Long id) {
        return pabellonRepository.findById(id);
    }
	public List<Pabellon> findByDisponibilidad(Boolean disponibilidad) {
		return pabellonRepository.findByDisponibilidad(disponibilidad);
	}
	
	//Create & Update
	public Pabellon saveOrUpdatePabellon(Pabellon pabellon) {
		return pabellonRepository.save(pabellon);
	}
	
	//Delete
	@Transactional
	public void deletePabellon(Long id) {
		pabellonRepository.deleteById(id);
	}
}
