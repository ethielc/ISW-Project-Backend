package com.zac.backend.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zac.backend.model.Pabellon;

@Repository("PabellonRepository")
public interface PabellonRepository extends JpaRepository<Pabellon, Serializable>{
	public Pabellon findById(long id);
	public List<Pabellon> findByDisponibilidad(int disponibilidad);
}
