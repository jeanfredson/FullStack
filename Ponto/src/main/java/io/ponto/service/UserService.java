package io.ponto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ponto.model.Role;
import io.ponto.model.User;
import io.ponto.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;
	
	
	public void CreateUser(User user) {
		BCryptPasswordEncode encoder = new BCryptPasswordEncoder();
		
		user.setPassword(encoder.encode(user.getPassword()));
		// instancia a classe Role
		Role userRole = new Role("USER");
		// realiza uma lista da class
		List<Role> roles = new ArrayList<>();
		// adiciona a instancia da classe dentro do array
		roles.add(userRole);
		// passa para parametro do método de User setando dentro de Roles o array
		user.setRoles(roles);
		// salva o user 
		ur.save(user);	
		
	}
	
	

}
