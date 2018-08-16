package io.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.curso.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
