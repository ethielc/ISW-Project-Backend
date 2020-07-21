package com.zac.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zac.backend.model.Pabellon;
import com.zac.backend.service.PabellonService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pabellones")
public class PabellonController {
	@Autowired
	PabellonService pabellonService;
	
	//Get Request
	@GetMapping("/todos")
	public List<Pabellon> getPabellones() {
		return pabellonService.listAll();
	}
	@GetMapping("/{id}")
	public Optional<Pabellon> getMedicoById(@PathVariable("id_pabellon") Long id_pabellon) {
		return pabellonService.listOne(id_pabellon);
	}
	@GetMapping("/filtro")
	public List<Pabellon> getPabellonesByDisponibilidad(@RequestParam(value = "disponibilidad") Boolean disponibilidad) {
		return pabellonService.findByDisponibilidad(disponibilidad);
	}
	
	//Post Request
	@PostMapping("")
	public ResponseEntity<Pabellon> addPabellon(@RequestBody Pabellon pabellon) {
		Pabellon pabe = pabellonService.saveOrUpdatePabellon(pabellon);
		return new ResponseEntity<Pabellon>(pabe, HttpStatus.CREATED);
	}
	
	//Put Request
	@PutMapping("/{id")
	public Optional<Object> updatePabellon(@PathVariable Long id_pabellon, @RequestBody Pabellon pabellon) {
		return pabellonService.listOne(id_pabellon).map(pabe -> {
			pabe.setSala(pabellon.getSala());
			pabe.setCant_camas(pabellon.getCant_camas());
			pabe.setDisponibilidad(pabellon.isDisponibilidad());
			pabe.setCamas(pabellon.getCamas());
			return pabellonService.saveOrUpdatePabellon(pabe);
		});
	}
	
	//Delete Request
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePabellon(@PathVariable Long id_pabellon) {
		try {
			pabellonService.deletePabellon(id_pabellon);
			return new ResponseEntity<>("Se borro con exito", HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<>("Ocurrio un error", HttpStatus.BAD_REQUEST);
		}
	}
}
