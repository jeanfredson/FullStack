package io.curso.repository;

import org.springframework.data.repository.CrudRepository;

import io.curso.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
