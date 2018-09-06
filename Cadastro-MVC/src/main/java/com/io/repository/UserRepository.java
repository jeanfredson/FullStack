package com.io.repository;


import org.springframework.data.repository.CrudRepository;

import com.io.modal.User;

public interface UserRepository extends CrudRepository<User, String>{

	User findById(Long id);


}
