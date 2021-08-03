package com.thecodereveal.core.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class MoviesLister {
	
	@Autowired
	private MoviesFinder moviesFinder;
	
	@Value("latest")
	private String parameter;

	public void getMovieList() {
		moviesFinder.getMovies();
		System.out.println("Parameter "+parameter);
	}

}
