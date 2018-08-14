package com.api.validator.controller;

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

import com.api.validator.model.Usuario;
import com.api.validator.repository.UsuarioRepository;

@RestController
@RequestMapping("/evento")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository us;
	
	Map<String, String> erros;
	
	@GetMapping("/listaConvidados")
	public Iterable<Usuario> lista(){
		return us.findAll();
	}
	
	@GetMapping("/lista/{id}")
	public Optional<Usuario> listaId(@PathVariable("id") Long id){
		return us.findById(id);		
	}
	
	@PutMapping("/atualizar")
	public Usuario listaId(Usuario user){
		return us.save(user);		
	}
	
	@DeleteMapping("/delete")
	public boolean delete(@PathVariable("id") Long id) {
		us.deleteById(id);
		return true;
	}

	
	@PostMapping("/salvar")
	public ResponseEntity<Object> create(@RequestBody @Valid Usuario user, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			erros = new HashMap<>();
			for(FieldError e : bindingResult.getFieldErrors()) {
				erros.put(e.getField(), e.getDefaultMessage());
			}
			return new ResponseEntity<>(erros, HttpStatus.NOT_ACCEPTABLE);
		}
		
		Usuario usuario = us.findByEmail(user.getEmail());
		
		if(usuario != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(us.save(user), HttpStatus.OK);
	}

	
	
	
	
	
	

}
