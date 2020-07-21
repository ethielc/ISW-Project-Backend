package com.zac.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zac.backend.model.Cama;

@Repository("CamaRepository")
public interface CamaRepository extends JpaRepository<Cama, Long>{
	public List<Cama> findByOcupada(Boolean ocupada);
	public List<Cama> findByPabellon(Long id_pabellon);
}
