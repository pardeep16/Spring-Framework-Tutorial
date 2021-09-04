package com.thecodereveal.app.services;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.thecodereveal.app.entities.TaskDetails;
import com.thecodereveal.app.handler.TaskException;
import com.thecodereveal.app.mapper.TaskMapper;
import com.thecodereveal.app.repository.TaskRepository;
import com.thecodereveal.model.Task;
import com.thecodereveal.model.TaskStatus;

import javassist.NotFoundException;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskMapper taskMapper;
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	@Transactional
	public Task createTask(Task task) {
		
		TaskDetails taskDetails = taskMapper.convertToTaskDetails(task);
		
		return taskMapper.convertToTaskDto(taskRepository.save(taskDetails));
		
	}

	@Override
	@Transactional
	public void deleteTask(Long id){
		Optional<TaskDetails> taskDetails=taskRepository.findById(id);
		
		if(!taskDetails.isPresent()) {
			throw new TaskException(HttpStatus.NOT_FOUND,"Task Not Found!");
		}
		
		TaskDetails task=taskDetails.get();
		//task.setTaskStatus(TaskStatus.DELETED);
		taskRepository.delete(task);
		
		
	}

	@Override
	public Task getTasks(Long id) {
		Optional<TaskDetails> taskDetails=taskRepository.findById(id);
		
		if(taskDetails.isPresent()) {
			return taskMapper.convertToTaskDto(taskDetails.get());
		}
		return null;
	}

	@Override
	@Transactional
	public Task updateTask(Long id, Task task){
		Optional<TaskDetails> taskDetails=taskRepository.findById(id);
		
		if(taskDetails.isPresent()) {
			TaskDetails taskDetailsUpdate=taskMapper.convertToTaskDetails(task);
			taskDetailsUpdate.setId(id);
			return taskMapper.convertToTaskDto(taskRepository.save(taskDetailsUpdate));
		}
		
		throw new TaskException(HttpStatus.NOT_FOUND, "No Task Found with Id "+id);
	}

	@Override
	public List<Task> getAllTasks() {
		
		return taskMapper.convertToTaskList(taskRepository.findAll());
	}

}
