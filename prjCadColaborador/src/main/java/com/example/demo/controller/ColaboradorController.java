package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Colaborador;
import com.example.demo.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

	private final ColaboradorService colaboradorService;
	
	@Autowired
	public ColaboradorController(ColaboradorService colaboradorService) {
		this.colaboradorService = colaboradorService;
	}
	@PostMapping 
	public Colaborador createColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorService.saveColaborador(colaborador);
	}
	@GetMapping("/{id}")
	public Colaborador getColaborador(@PathVariable Long id) {
		return colaboradorService.getColaboradorById(id);
	}
	@GetMapping
	public List<Colaborador> getAllColaborador(){
		return colaboradorService.getAllColaborador();
	}
	@DeleteMapping("/{id}")
	public void deleteColaborador(@PathVariable Long id) {
		colaboradorService.deleteColaborador(id);
	}
}
