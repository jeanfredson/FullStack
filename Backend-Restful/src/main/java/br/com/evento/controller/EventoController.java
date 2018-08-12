package br.com.evento.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.evento.model.Evento;
import br.com.evento.repository.EventoRepository;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	
	public Map<String, String> erros;
	
	@Autowired
	private EventoRepository er;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Evento> listaAll() {
		return er.findAll();
	}
	@GetMapping("/lista/{id}")
	public Optional<Evento> listaId(@PathVariable("id") Long id){
		return er.findById(id);
	}
	
	
	@PostMapping("/salva")
	public ResponseEntity<Object> saveEvent(@RequestBody @Valid Evento evento, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()) {
			erros = new HashMap<>();
			for(FieldError e : bindingResult.getFieldErrors()) {
				erros.put(e.getField(), e.getDefaultMessage());
			}
			return new ResponseEntity<>(erros, HttpStatus.NOT_ACCEPTABLE);
		}
		
		Evento e = er.findByEmail(evento.getEmail());
		if(e != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}		
		return new ResponseEntity<>(er.save(evento), HttpStatus.OK);
	}
	
	
	@DeleteMapping("delete")
	public boolean deleteEvento(@RequestBody Long id) {
		if(id != null) {
			er.deleteById(id);
		}
		return true;
	}

}
