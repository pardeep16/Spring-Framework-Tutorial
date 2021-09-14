package com.thecodereveal.core.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.thecodereveal.core.test.SpringUnitTest;

public class CalculationServiceTest extends SpringUnitTest {

	@Autowired
	CalculationService calculationService;
	
	@Test
	public void testAddNumbers() {
		assertEquals(4, calculationService.addNumbers(2, 2));
	}
	
	@Test
	public void testAddNumbers2() {
		assertNotEquals(10, calculationService.addNumbers(2, 2));
	}
	
	@Test
	public void testMax() {
		assertEquals(5, calculationService.findMax(5, 4));
	}
}
