package com.thecodereveal.core.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigContainer {

	@Bean
	public MoviesFinder moviesFinder() {
		return new MoviesFinder();
	}
	
	@Bean MoviesLister moviesLister() {
		return new MoviesLister();
	}
}
