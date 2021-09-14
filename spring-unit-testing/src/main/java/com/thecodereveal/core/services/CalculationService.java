package com.thecodereveal.core.services;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {
	
	public int addNumbers(int a,int b) {
		return a+b;
	}
	
	public int findMax(int a,int b) {
		return Math.max(a, b);
	}

}
