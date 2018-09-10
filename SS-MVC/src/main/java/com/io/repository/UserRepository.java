package com.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.model.User;

public interface UserRepository  extends JpaRepository<User, String>{

}
