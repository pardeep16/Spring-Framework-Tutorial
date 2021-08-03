package com.thecodereveal.core.autowiring;

public class EmployeeService {
	
	private String employeeName;
	
	private Project projectService;
	
	public EmployeeService(Project project,String employeeName) {
		this.projectService=project;
		this.employeeName=employeeName;
	}
	
	public void getEmployeeDetails() {
		System.out.println("Emploee Name"+this.employeeName);
		System.out.println("Project Id"+projectService.getProjectId());
		System.out.println("Project Id"+projectService.getProjectName());
	}

	
}
