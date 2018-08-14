package com.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evento.model.Validator;

public interface ValidatorRepository extends JpaRepository<Validator, Long>{

	Validator findByEmail(String email);

}
