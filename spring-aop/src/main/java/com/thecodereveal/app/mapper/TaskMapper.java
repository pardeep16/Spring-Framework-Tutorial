package com.thecodereveal.app.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.thecodereveal.app.entities.TaskDetails;
import com.thecodereveal.model.Task;
import com.thecodereveal.model.TaskStatus;

@Component
public class TaskMapper {

	
	public TaskDetails convertToTaskDetails(Task task){
		
		TaskDetails taskDetails=new TaskDetails();
		taskDetails.setTitle(task.getTitle());
		taskDetails.setDescription(task.getDescription());
		taskDetails.setStartDate(getDate(task.getStartDate()));
		taskDetails.setEndDate(getDate(task.getEndDate()));
		taskDetails.setTaskStatus(TaskStatus.fromValue(task.getStatus().getValue()));
		return taskDetails;
		
	}

	public Task convertToTaskDto(TaskDetails taskDetials) {
		Task task=new Task();
		task.setId(taskDetials.getId());
		task.setTitle(taskDetials.getTitle());
		task.setDescription(taskDetials.getDescription());
		task.setStartDate(null!=taskDetials.getStartDate()?dateFormat(taskDetials.getStartDate()):"");
		task.setEndDate(null!=taskDetials.getEndDate()?dateFormat(taskDetials.getEndDate()):"");
		task.setStatus(taskDetials.getTaskStatus());
		return task;
	}
	
	private Date getDate(String date){
		try {
		if(StringUtils.isEmpty(date)) {
			return null;
		}
			
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.parse(date);
		}
		catch(ParseException e) {
			//e.printStackTrace();
			return null;
		}
		
	}
	
	private String dateFormat(Date date) {
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
			
		
	}

	public List<Task> convertToTaskList(List<TaskDetails> taskList) {
		return taskList.stream().map(task->convertToTaskDto(task)).collect(Collectors.toList());
	}
}
