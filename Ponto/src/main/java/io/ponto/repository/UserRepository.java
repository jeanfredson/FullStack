package io.ponto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.ponto.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
