package com.form.validator.controller;

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

import com.form.validator.modal.User;
import com.form.validator.repository.UserRepository;

@RestController
@RequestMapping("/form")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	Map<String, String> erros;

	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody @Valid User user, BindingResult result){
				
		if(result.hasErrors()) {
			erros = new HashMap<>();			
			for(FieldError erro : result.getFieldErrors()) {
				erros.put(erro.getField(), erro.getDefaultMessage());
			}
			return new ResponseEntity<>(erros, HttpStatus.NOT_ACCEPTABLE);
		}
		
		User u = userRepository.findByEmail(user.getEmail());
		
		if(u != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}		
		return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
	}
	
	@GetMapping("/lista")
	public Iterable<User> lista(){
		return userRepository.findAll();
	}
	
	@GetMapping("/lista/{id}")
	public Optional<User> listaId(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
		return true; 
	}
	@PutMapping("/update")
	public User update(User user) {
		return userRepository.save(user);
	}
	
	
	
	
}
