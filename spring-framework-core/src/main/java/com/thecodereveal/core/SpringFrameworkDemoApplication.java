package com.thecodereveal.core;

import java.awt.DisplayMode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thecodereveal.core.annotation.ConfigContainer;
import com.thecodereveal.core.annotation.MoviesLister;
import com.thecodereveal.core.autowiring.EmployeeService;
import com.thecodereveal.core.di.AccountService;
import com.thecodereveal.core.di.CurrentAccount;
import com.thecodereveal.core.di.MyBankAccount;
import com.thecodereveal.core.di.SavingAccount;
import com.thecodereveal.core.models.Person;

//@SpringBootApplication
public class SpringFrameworkDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringFrameworkDemoApplication.class, args);
		
		//Init
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("app.xml");
		
		//Bean
		Person person=applicationContext.getBean(Person.class);
		
		Person person1=applicationContext.getBean("person", Person.class);
		
		person.setFirstName("Pardeep");
		
		System.out.println("First Name "+person.getFirstName());
		
		
		MyBankAccount myBankAccount=applicationContext.getBean(MyBankAccount.class);
		
		myBankAccount.createAccount();
		
		/*
		 * EmployeeService
		 * employeeService=applicationContext.getBean(EmployeeService.class);
		 * employeeService.getEmployeeDetails();
		 * System.out.println(employeeService.hashCode());
		 * 
		 * EmployeeService
		 * employeeService1=applicationContext.getBean(EmployeeService.class);
		 * employeeService1.getEmployeeDetails();
		 * System.out.println(employeeService1.hashCode());
		 */
		
	    ApplicationContext applicationContext2=new AnnotationConfigApplicationContext(ConfigContainer.class);
		
		MoviesLister moviesLister=applicationContext2.getBean(MoviesLister.class);
		moviesLister.getMovieList();
		
		
	}

}
