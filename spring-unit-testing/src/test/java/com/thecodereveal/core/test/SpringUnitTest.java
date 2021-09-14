package com.thecodereveal.core.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.thecodereveal.core.SpringUnitTestingApplication;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = {SpringUnitTestingApplication.class})
public class SpringUnitTest {

}