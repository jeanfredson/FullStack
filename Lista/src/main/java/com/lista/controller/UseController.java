package com.lista.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.lista.model.User;
import com.lista.repository.UserRepository;

@RestController
@RequestMapping(path="/lista")
public class UseController {
	
	@Autowired
	private UserRepository userReptor;
	
	private Map<String, String> erros;
	
	@PostMapping()
	public ResponseEntity<Object> create (@RequestBody @Valid User u, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			erros = new HashMap<>();
			for(FieldError e : bindingResult.getFieldErrors()) {
				erros.put(e.getCode(), e.getDefaultMessage());	
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		User user = userReptor.findByNome(u.getNome());
		if(user != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(userReptor.save(u), HttpStatus.OK);
	}
	
	@GetMapping()
	public Iterable<User> listaAll(){
		return userReptor.findAll();
	}
	
	@GetMapping("/id")
	public Optional<User> listId(@PathVariable("id") Long id){
		return userReptor.findById(id);		
	}
	
	@DeleteMapping("/id")
	public boolean delete (@PathVariable("id") Long id) {
		userReptor.deleteById(id);
		return true;
	}
	
	@PutMapping()
	public User update(User u) {
		return userReptor.save(u);
	}
	
	

}
