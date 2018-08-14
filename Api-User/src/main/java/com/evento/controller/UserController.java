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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.evento.model.User;
import com.evento.repository.UserRepository;

@RestController
@RequestMapping("/use")
public class UserController {

	
	@Autowired
	private UserRepository ur;
	
	private Map<String, String> erros;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<User> lista(){
		return ur.findAll();
	}
	
	@GetMapping("/{id}")
	public @ResponseBody Optional<User> listId(@PathVariable(value="id") Long id){
		return ur.findById(id);
	}
	
	@PutMapping("/update")
	public User update(User u){
		return ur.save(u);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(Long id) {
		if(id == null ) {
			return false;
		}
		ur.deleteById(id);
		return true;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Object> salva(@Valid @RequestBody User user, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			erros = new HashMap<>();
			for(FieldError erro : bindingResult.getFieldErrors()) {
				erros.put(erro.getCode(), erro.getDefaultMessage());
			}
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		User u = ur.findByNome(user.getNome());
		if(u != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(ur.save(user), HttpStatus.OK);
	}
	



	
}
