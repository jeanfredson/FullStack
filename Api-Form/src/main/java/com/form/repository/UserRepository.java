package com.form.repository;

import org.springframework.data.repository.CrudRepository;

import com.form.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
