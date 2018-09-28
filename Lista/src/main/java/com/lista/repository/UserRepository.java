package com.lista.repository;


import org.springframework.data.repository.CrudRepository;

import com.lista.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByNome(String nome);

}
