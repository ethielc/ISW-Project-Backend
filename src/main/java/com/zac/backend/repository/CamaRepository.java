package com.zac.backend.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zac.backend.model.Cama;

@Repository("CamaRepository")
public interface CamaRepository extends JpaRepository<Cama, Serializable>{
	public List<Cama> findByOcupada(int ocupada);
	public List<Cama> findByPabellon(long pabellon);
	public Cama findById(long id);
}
