package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{ 
		int result = (int) request.getAttribute("result");
		
		PrintWriter pw = response.getWriter();
		pw.write("<p> Your result is: "+ result+"</p>");
		pw.write("<p> <a href=\"Calculator.html\"> Calculate Again! </a></p>");
//		pw.close();
	}

}
