package com.thecodereveal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thecodereveal.app.entities.TaskDetails;

@Repository
public interface TaskRepository extends JpaRepository<TaskDetails, Long> {

}
