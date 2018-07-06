package com.form.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.form.model.User;
import com.form.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {

	
	@Autowired
	private UserRepository repository;

	private Map<String, String> erros;

	@PostMapping("/create")
	public ResponseEntity<Object> createUsers(@RequestBody @Valid User u, BindingResult result) {

		if (result.hasErrors()) {
			erros = new HashMap<>();

			for (FieldError e : result.getFieldErrors()) {
				erros.put(e.getField(), e.getDefaultMessage());
			}
			return new ResponseEntity<>(erros, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(repository.save(u), HttpStatus.OK);
	}
	
	
	@GetMapping("/list")
	public Iterable<User> users(){
		return repository.findAll();
	}
	
	
	@GetMapping("/list/{id}")
	public Optional<User> users(@PathVariable("id") Long id){
		return repository.findById(id);
	}
	
	@PutMapping("/list/{id}")
	public Optional<User> update(@PathVariable("id") Long id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteUser(@PathVariable Long id){
		repository.deleteById(id);
		return true;
	}
	
	

}
