package com.zac.backend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zac.backend.model.Cama;
import com.zac.backend.repository.CamaRepository;

@Service("CamaService")
public class CamaService {
	@Autowired
	CamaRepository camaRepository;
	
	//Request
	public List<Cama> listAll() {
        return camaRepository.findAll();
    }
	public Optional<Cama> listOne(Long id) {
        return camaRepository.findById(id);
    }
	public List<Cama> listByDisponibilidad(int disponibilidad) {
        return camaRepository.findByOcupada(disponibilidad);
    }
	public List<Cama> findByPabellonId(Long id_pabellon) {
		return camaRepository.findByPabellon(id_pabellon);
	}
	
	//Create & Update
	public Cama saveOrUpdateCama(Cama cama) {
        return camaRepository.save(cama);
    }
	
	//Delete
	@Transactional
	public void deleteCama(Long id) {
        camaRepository.deleteById(id);
    }
}
