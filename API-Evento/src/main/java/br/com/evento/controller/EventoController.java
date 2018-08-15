package br.com.evento.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evento.model.Convidado;
import br.com.evento.model.Evento;
import br.com.evento.repository.ConvidadoRepository;
import br.com.evento.repository.EventoRepository;

@RestController
@RequestMapping("/io")
public class EventoController {
	
	@Autowired
	private EventoRepository ec;
	
	@Autowired
	private ConvidadoRepository cr;
	
	@PostMapping("/{id}")
	public Convidado salvando(@PathVariable("id") Long id, Convidado convidado ) {
		Evento evento = ec.findById(id);
		convidado.setEvento(evento);	
		return cr.save(convidado);
	}
	
	

}
