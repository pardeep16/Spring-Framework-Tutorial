package com.thecodereveal.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

import com.thecodereveal.app.handler.TaskException;

@Aspect
@Configuration
public class AspectConfig {
	
	/*
	 * Logging
	 * Exception Handling
	 * TimeTaken
	 */
	private Logger log=LoggerFactory.getLogger(AspectConfig.class);
	
	@Before(value = "execution(* com.thecodereveal.app.api.*.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Executing {}",joinPoint);
	}
	
	@After(value = "execution(* com.thecodereveal.app.api.*.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("Complete exceution of {}",joinPoint);
	}
	
	@Around(value = "execution(* com.thecodereveal.app.services.*.*(..))")
	public Object taskHandler(ProceedingJoinPoint joinPoint) throws Throwable {
		
		try {
			Object obj=joinPoint.proceed();
			return obj;
		}
		catch(TaskException e) {
			log.info(" TaskException StatusCode {}",e.getHttpStatus().value());
			log.info("TaskException Message {}",e.getMessage());
			throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
		}
	}
	
	@Around(value = "execution(* com.thecodereveal.app.api.*.*(..))")
	public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long stratTime=System.currentTimeMillis();
		
		try {
			Object obj=joinPoint.proceed();
			long timeTaken=System.currentTimeMillis()-stratTime;
			log.info("Time taken by {} is {}",joinPoint,timeTaken);
			return obj;
		}
		catch(TaskException e) {
			log.info(" TaskException StatusCode {}",e.getHttpStatus().value());
			log.info("TaskException Message {}",e.getMessage());
			throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
		}
	}
	
	
}
