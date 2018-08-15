package br.com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.security.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
