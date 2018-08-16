package io.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import io.curso.model.Evento;
import io.curso.repository.EventoRepository;

@Controller
@RequestMapping("index")
public class IndexController {
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "view/Index";
	}
	
	
	@RequestMapping(value="/index",method=RequestMethod.POST)
	public String salva(Evento e) {
		er.save(e);
		return "redirect:/cadastro/evento";
	}
	
	@RequestMapping(value="/lista")
	public ModelAndView list() {
		Iterable<Evento> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("view/Lista");
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	

}
