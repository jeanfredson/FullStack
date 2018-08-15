package br.com.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.evento.model.Convidado;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {

}
