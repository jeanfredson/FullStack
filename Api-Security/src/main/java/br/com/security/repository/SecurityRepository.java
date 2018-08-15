package br.com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.security.model.Security;

public interface SecurityRepository extends JpaRepository<Security, Long>{

	Security findOne(String email);

}
