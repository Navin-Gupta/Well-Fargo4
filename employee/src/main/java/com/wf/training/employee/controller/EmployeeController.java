package com.wf.training.employee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.training.employee.dao.EmployeeDao;
import com.wf.training.employee.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeDao employeeDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String jdbcDriver =  config.getServletContext().getInitParameter("jdbcDriver");
		String jdbcUrl =  config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername =  config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword =  config.getServletContext().getInitParameter("jdbcPassword");
		
		this.employeeDao = new EmployeeDao(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// receive the action parameter
		String action = request.getParameter("action");
		String viewName = "";
		
		try {
			switch(action) {
			case "list":
				viewName = showDashboard(request,response);	
				break;
			case "entryform":
				viewName = showEntryForm(request,response);	
				break;
			case "save":
				viewName = saveNewRecord(request,response);	
				break;
			case "editform":break;
			case "edit":break;
			case "delete":
				viewName = deleteRecord(request,response);	
				break;
			
			}
		}catch(Exception ex) {
			// centralized/common handling of exception
			throw new ServletException(ex.getMessage());
		}
		if(viewName==null || viewName.equals("")) {
			response.sendError(response.SC_NOT_FOUND);
		}else {
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
		}
	}

	
	private String deleteRecord(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		this.employeeDao.deleteEmployee(id);
		
		return "employee?action=list";
	}

	private String saveNewRecord(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String name = request.getParameter("ename");
		String email= request.getParameter("email");
		String age = request.getParameter("age");
		this.employeeDao.addNewEmployee(name, email, age);
		// check boolean value and return the entry page url
		
		return "employee?action=list";
	}

	private String showEntryForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		return "newentry.jsp";
	}

	private String showDashboard(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		// need to retrieve records from DB
		List<Employee> employees = this.employeeDao.getEmployeeRecords();
		// put data into request object (to share with view page)
		request.setAttribute("employees", employees);
		return "dashboard.jsp";
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
