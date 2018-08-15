package br.com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.security.model.Role;

public interface RolesRepository extends JpaRepository<Role, Long>{

}
