package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.CalculatorService;

public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CalculatorService cs = new CalculatorService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("doGet handler method invoked in calculator servlet");
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter pw = response.getWriter();
//		pw.write("<p><h2>My Calculator Page</h2></p>");
//		pw.close();
		RequestDispatcher rd = request.getRequestDispatcher("Calculator.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// get operation -> get "operation" parameter from request object
		String operation = request.getParameter("operation");
		
		// get numbers -> get "n1" and "n2" parameters from request object
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		
		PrintWriter pw = response.getWriter();
		
		try {
			int num1 = Integer.parseInt(n1);
			int num2 = Integer.parseInt(n2);
			
			System.out.println(operation+" on "+ n1 + " and "+ n2);
			
			//perform operation
			int result = cs.calculate(num1, num2, operation);
//			pw.write("<p> The answer is: "+result+ " </p>");
			
			request.setAttribute("result", new Integer(result));
			response.setContentType("text/html");
			
			pw.print("before requestdispatcher");
			RequestDispatcher rd = request.getRequestDispatcher("answer");
			rd.forward(request, response);
			pw.print("after requestdispatcher");
			
		} catch (NumberFormatException e) {
			pw.write("<p> Invalid input </p>");
			e.printStackTrace();
		} finally {
			pw.close();
		}
		
	}
	
	
	
}
