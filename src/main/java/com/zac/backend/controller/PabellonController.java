package com.zac.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zac.backend.model.Pabellon;
import com.zac.backend.service.PabellonService;

@RestController
@RequestMapping("/api/pabellones")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PabellonController {
	@Autowired
	PabellonService pabellonService;
	
	//Get Request
	@GetMapping("/pabellones")
	public List<Pabellon> getPabellones() {
		return pabellonService.obtenerAll();
	}
	@GetMapping("/")
	public Pabellon getPabellonById(@RequestParam(name = "id_pabellon", required = true) long id_pabellon) {
		return pabellonService.obtenerPorId(id_pabellon);
	}
	@GetMapping("/pabellones/filtroPabellones")
	public List<Pabellon> getPabellonesByDisponibilidad(@RequestParam(value = "disponibilidad") int disponibilidad) {
		return pabellonService.obtenerPorDisponibilidad(disponibilidad);
	}
	
	//Post Request
	@PostMapping("/")
	public boolean addPabellon(@RequestBody Pabellon pabellon) {
		return pabellonService.crear(pabellon);
	}
	
	//Put Request
	@PutMapping("/")
	public boolean updatePabellon(@RequestBody Pabellon pabellon) {
		return pabellonService.actualizar(pabellon);
		/*
		try {
			Pabellon pabe = pabellonService.obtenerPorId(id_pabellon);
			pabe.setSala(pabellon.getSala());
			pabe.setCant_camas(pabellon.getCant_camas());
			pabe.setDisponibilidad(pabellon.getDisponibilidad());
			pabe.setCamas(pabellon.getCamas());
			return pabellonService.saveOrUpdatePabellon(pabe);
		} catch(Exception e) {
			return null;
		}
		
		return pabellonService.listOne(id_pabellon).map(pabe -> {
			pabe.setSala(pabellon.getSala());
			pabe.setCant_camas(pabellon.getCant_camas());
			pabe.setDisponibilidad(pabellon.getDisponibilidad());
			pabe.setCamas(pabellon.getCamas());
			return pabellonService.saveOrUpdatePabellon(pabe);
		});
		*/
		
	}
	
	//Delete Request
	@DeleteMapping("/{id}")
	public boolean deletePabellon(@PathVariable("id") long id) {
		return pabellonService.borrar(id);
		/*
		try {
			pabellonService.deletePabellon(id_pabellon);
			return new ResponseEntity<>("Se borro con exito", HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<>("Ha ocurrido un error al tratar de borrar un pabellon", HttpStatus.BAD_REQUEST);
		}
		*/
	}
}
