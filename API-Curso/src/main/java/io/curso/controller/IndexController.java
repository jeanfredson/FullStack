package io.curso.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.curso.model.Aluno;
import io.curso.model.Cursos;
import io.curso.repository.AlunoRepository;
import io.curso.repository.CursoRepository;

@RestController
@RequestMapping("/io")
public class IndexController {

	@Autowired
	private CursoRepository cr;
	
	@Autowired
	private AlunoRepository ar;
	
	private Map<String, String> erros;
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@Valid @RequestBody Cursos c, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			erros = new HashMap<>();
			for(FieldError e : bindingResult.getFieldErrors()) {
				erros.put(e.getField(), e.getDefaultMessage());
			}
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(cr.save(c), HttpStatus.OK);
	}
	
	
	
	@PostMapping("/{id}")
	public ResponseEntity<Object> create(@PathVariable("id") Long id, Aluno a){
		Cursos curso = cr.findByAlunos(id);
		a.setCurso(curso);
		if(a == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(ar.save(a), HttpStatus.OK);
	}
}
