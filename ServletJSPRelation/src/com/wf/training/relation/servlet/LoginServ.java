package com.wf.training.relation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/login")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// some business logic here
		// response.sendRedirect("login.jsp");
		
		// putting data in request object
		request.setAttribute("key", "");// any object
		// receiving data 
		Object object = request.getAttribute("key");
		
		// putting data in session object
		// need to retrieve in servlet
		// JSP : already exposed with name 'session'
		HttpSession session = request.getSession();
		session.setAttribute("key", ""); //object
		// receiving data
		Object object1 = session.getAttribute("key");
		
		// putting data in application object
		ServletContext context = this.getServletContext();
		context.setAttribute("key", ""); //object
		// receiving data
		Object object2 = context.getAttribute("key");
		
		
		
		
		RequestDispatcher dispatch =  request.getRequestDispatcher("login.jsp");
		dispatch.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
