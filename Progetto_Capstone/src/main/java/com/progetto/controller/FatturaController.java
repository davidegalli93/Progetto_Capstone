package com.progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progetto.model.Fattura;
import com.progetto.payload.FatturaDTO;
import com.progetto.service.FatturaService;

@RestController
@RequestMapping("/fattura")
public class FatturaController {

	@Autowired private FatturaService service;

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody FatturaDTO a) {
		return ResponseEntity.ok(service.create(a));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Fattura a) {
		return ResponseEntity.ok(service.update(id, a));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeById(@PathVariable Long id) {
		return ResponseEntity.ok(service.delete(id));
	}
}
	