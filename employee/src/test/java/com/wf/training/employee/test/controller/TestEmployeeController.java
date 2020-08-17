package com.wf.training.employee.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.MockitoAnnotations;

public class TestEmployeeController {

	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpServletResponse response;
	
	@Before
	public void setUp() {
		// MockitoAnnotations.initMocks(this);
		request = mock(HttpServletRequest.class);
		response= mock(HttpServletResponse.class);
	}
}
