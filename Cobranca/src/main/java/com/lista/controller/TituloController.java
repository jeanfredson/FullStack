package com.lista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lista.model.Titulo;
import com.lista.repository.TituloRepository;



@Controller
@RequestMapping(path="/titulos")
public class TituloController {
	

	@Autowired
	private TituloRepository tr;
	
	@RequestMapping(value="/novo", method=RequestMethod.GET)
	public String index() {
		return "view/Index";
	}
	
	@RequestMapping(value="/novo",method=RequestMethod.POST)
	public ModelAndView salvar(Titulo t) {
		ModelAndView mvc = new ModelAndView("view/Index");
		System.out.println("O valor é " + t.getStatus());
		return mvc;
	}

	
	
}
