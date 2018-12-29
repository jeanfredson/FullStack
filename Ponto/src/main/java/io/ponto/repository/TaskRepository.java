package io.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ponto.model.Task;

public interface TaskRepository extends JpaRepository<Task, String>{

}
