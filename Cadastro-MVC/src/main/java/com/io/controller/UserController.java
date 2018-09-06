package com.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.io.modal.User;
import com.io.repository.UserRepository;

@Controller
@RequestMapping(path="/user")
public class UserController {
	
	
	@Autowired
	private UserRepository us;
	
	@RequestMapping()
	public String user() {
		return "Index";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		Iterable<User> lista = us.findAll();
		ModelAndView mv = new ModelAndView("Index");
		mv.addObject("users", lista);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salva(User u) {
		us.save(u);
		return "redirect:/user";
	}
	
	@RequestMapping(value = "/deletar")
	public String deletaUsuario(Long id) {
		
		User u = us.findById(id);
		us.delete(u);
		return "redirect:/user";
	}
		

}
