package com.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evento.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByNome(String nome);


}
