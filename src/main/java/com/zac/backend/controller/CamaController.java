package com.zac.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zac.backend.model.Cama;
import com.zac.backend.service.CamaService;
import com.zac.backend.service.PabellonService;

@RestController
@RequestMapping("/api/pabellones")
public class CamaController {
	@Autowired
    CamaService camaService;
	@Autowired
	PabellonService pabellonService;
	
	//Get Request
	@GetMapping("/{id_pabellon}/camas")
	public List<Cama> getCamasByPabellonId(@PathVariable Long id_pabellon) {
		return camaService.findByPabellonId(id_pabellon);
	}
	
	//Post Request
	@PostMapping("/{id_pabellon}/camas")
	public Optional<Object> addCama(@PathVariable Long id_pabellon, @RequestBody Cama camaRequest) {
		return pabellonService.listOne(id_pabellon).map(pabe -> {
			camaRequest.setPabellon(pabe);
			return camaService.saveOrUpdateCama(camaRequest);
		});
	}
	
	//Put Request
	@PutMapping("/{id_pabellon}/camas/{id_cama}")
	public Optional<Object> updateCama(@PathVariable Long id_pabellon, @PathVariable Long id_cama, @RequestBody Cama camaRequest) {
		return camaService.listOne(id_cama).map(cama -> {
			cama.setOcupada(camaRequest.getOcupada());
			cama.setPaciente(camaRequest.getPaciente());
			cama.setPabellon(camaRequest.getPabellon());
			return camaService.saveOrUpdateCama(cama);
		});
	}
	
	//Delete Request
	@DeleteMapping("/{id_pabellon}/camas/{id_cama}")
	public ResponseEntity<String> deleteCama(@PathVariable Long id_pabellon, @PathVariable Long id_cama) {
		try {
			camaService.deleteCama(id_cama);
			return new ResponseEntity<>("Se borró con extito", HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<>("Ocurrio un error", HttpStatus.BAD_REQUEST);
		}
	}
}
