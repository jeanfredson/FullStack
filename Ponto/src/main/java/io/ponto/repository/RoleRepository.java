package io.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ponto.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{

}
