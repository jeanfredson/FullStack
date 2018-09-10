package com.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.model.Task;

public interface TaskRepository  extends JpaRepository<Task, String>{

}
