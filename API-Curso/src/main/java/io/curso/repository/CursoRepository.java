package io.curso.repository;

import org.springframework.data.repository.CrudRepository;

import io.curso.model.Cursos;

public interface CursoRepository extends CrudRepository<Cursos, Long>{

	Cursos findByAlunos(Long id);

}
