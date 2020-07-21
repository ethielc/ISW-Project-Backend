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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zac.backend.model.Cama;
import com.zac.backend.service.CamaService;

@RestController
@RequestMapping("/api/camas")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CamaController {
	@Autowired
    CamaService camaService;
	
	//Get Request
	@GetMapping("/")
	public Cama getCamasByPabellonId(@RequestParam(name="id", required=true) long id) {
		return camaService.obtenerPorId(id);
	}
	@GetMapping("/pabellon")
	public List<Cama> obtenerPorPabellon(@RequestParam(name="pabellon", required = true) long pabellon) {
		return camaService.obtenerPorPabellon(pabellon);
	}
	
	//Post Request
	@PostMapping("/")
	public boolean addCama(@RequestBody Cama camaRequest) {
		return camaService.crear(camaRequest);
	}
	
	//Put Request
	@PutMapping("/")
	public boolean updateCama(@RequestBody Cama camaRequest) {
		return camaService.actualizar(camaRequest);
	}
	
	//Delete Request
	@DeleteMapping("/{id}")
	public boolean deleteCama(@PathVariable("id") long id) {
		return camaService.borrar(id);
	}
}
