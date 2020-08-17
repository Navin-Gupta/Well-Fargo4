package com.wf.training.employee.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wf.training.employee.testres.Sample;

public class TestSample {
	
	private Sample sample;
	
	@BeforeClass
	public void baseSetUp() {
		// executes once before test cases run
	}
	
	@Before
	public void setUp() {
		// going to execute before each test case
		sample = new Sample();
	}
	
	// each test case would be written as a java method
	// Method needs to be registered as test case
	@Test
	public void testAdd() {
		sample = new Sample();
		int actualValue = sample.add(20, 30);
		// test now
		assertEquals(50, actualValue);
	}
	@Test
	public void testSubtract() {
		sample = new Sample();
		int actualValue = sample.subtract(30, 20);
		// test now
		assertEquals(10, actualValue);
	}
	@Test
	public void testMultiply() {
		sample = new Sample();
		int actualValue = sample.multiply(2, 3);
		// test now
		assertEquals(6, actualValue);
	}
	
	@After
	public void clean() {
		// called after each test case
	}

	@AfterClass
	public void baseClean() {
		// executes once after all test has executed
	}
	
}
