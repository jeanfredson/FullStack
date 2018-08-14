package com.evento.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.evento.model.Validator;
import com.evento.repository.ValidatorRepository;

@RestController
public class ValidatorController {
	
	
	@Autowired
	private ValidatorRepository vr;
	
	private Map<String, String> erros;
	
	
	@PostMapping("/create")
	public ResponseEntity<Object> salvaUser(@RequestBody @Valid Validator valid, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			erros = new HashMap<>();
			for(FieldError erro : bindingResult.getFieldErrors()) {
				erros.put(erro.getField(), erro.getDefaultMessage());
			}
			return new ResponseEntity<>(erros, HttpStatus.NOT_ACCEPTABLE);
		}
		
		Validator val = vr.findByEmail(valid.getEmail());
		if(val != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(vr.save(valid), HttpStatus.OK);
	}
	
	@GetMapping()
	public @ResponseBody Iterable<Validator> lista(){
		return vr.findAll();
	}
	@GetMapping("/{codigo}")
	public @ResponseBody Optional<Validator> listaId(@PathVariable(value="codigo") Long id){
		if(id == null) {
			return null;
		}
		return vr.findById(id);
	}
	
	@DeleteMapping("/delete")
	public boolean deletaUser(@PathVariable(value="id") Long id) {
		if(id == null) {
			return false;
		}
		vr.deleteById(id);
		return true;
	}

}
