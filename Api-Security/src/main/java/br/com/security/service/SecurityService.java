package br.com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.security.model.Role;
import br.com.security.model.Security;
import br.com.security.repository.SecurityRepository;

@Service
public class SecurityService {

	@Autowired
	private SecurityRepository sr;
	
	public void createSecurity(Security sec) {
		sec.setPassword("rafael");
		Role role = new Role("SECURITY");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		sec.setRoles(roles);
		sr.save(sec);
	}
	
	public void createAdmin(Security sec) {
		sec.setPassword("rafael");
		Role role = new Role("SECURITY");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		sec.setRoles(roles);
		sr.save(sec);
	}
	
	public Security findOne(String email) {
		return sr.findOne(email);
	}
}
