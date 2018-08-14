package com.api.validator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.validator.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario findByEmail(String email);

}
