package com.wf.training.employee.test.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.mockito.MockitoAnnotations;

import com.wf.training.employee.controller.EmployeeController;
import com.wf.training.employee.dao.EmployeeDao;

public class TestEmployeeController {

	private EmployeeController servlet;
	
	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpServletResponse response;
	
	@Mock
	private RequestDispatcher rd;
	
	private EmployeeDao employeeDao;
	
	@Before
	public void setUp() {
		// MockitoAnnotations.initMocks(this);
		this.servlet = new EmployeeController();
		this.employeeDao = new EmployeeDao("","","","");
		this.servlet.setEmployeeDao(employeeDao);
		request = mock(HttpServletRequest.class);
		response= mock(HttpServletResponse.class);
		rd = mock(RequestDispatcher.class);
	}
	
	@Test
	public void testEntryFormRequest() throws ServletException, IOException {
		// mock functionality
		when(request.getParameter("action")).thenReturn("entryform");
		when(request.getRequestDispatcher("newentry.jsp")).thenReturn(rd);
		
		// call the actual method
		this.servlet.doGet(request, response);
		// test the expection
		verify(rd).forward(request, response);
	}
	
	@Test
	public void testNewRecord() throws ServletException, IOException {
		// mock functionality
		when(request.getParameter("action")).thenReturn("save");
		when(request.getParameter("ename")).thenReturn("First");
		when(request.getParameter("email")).thenReturn("first@mail.com");
		when(request.getParameter("age")).thenReturn("30");
		when(request.getRequestDispatcher("employee?action=list")).thenReturn(rd);
		
		// call the actual method
		this.servlet.doGet(request, response);
		// test the expection
		verify(rd).forward(request, response);
	}
}















