package com.revature.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    RequestHelper helper = new RequestHelper();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("You've reached the front controller GET METHOD!");
		// create request helper to help with non static requests
		
		
		// get a URL for our static resources
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("Your path is: " + path);
		String completeURI = request.getRequestURI();
		System.out.println("Complete path is: " + completeURI);
		
		// if path is static, direct request to static resource
		if (path.startsWith("/static/"))
		{
			System.out.println(path + " starts with static!");
			super.doGet(request, response);
		}
		else
		{
			// HAVE THE REQUEST HELPER HANDLE THE METHODS
			helper.processGet(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("You've reached the front controller POST METHOD!");
		// create request helper to help with non static requests
		
		
		// get a URL for our static resources
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("Your path is: " + path);
		String completeURI = request.getRequestURI();
		System.out.println("Complete path is: " + completeURI);
		
		// if path is static, direct request to static resource
		if (path.startsWith("/static/"))
		{
			System.out.println(path + " starts with static!");
			super.doPost(request, response);
		}
		else
		{
			// HAVE THE REQUEST HELPER HANDLE THE METHODS
			helper.processPost(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("You've reached the front controller PUT METHOD!");
		// create request helper to help with non static requests
		
		
		// get a URL for our static resources
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("Your path is: " + path);
		String completeURI = request.getRequestURI();
		System.out.println("Complete path is: " + completeURI);
		
		// if path is static, direct request to static resource
		if (path.startsWith("/static/"))
		{
			System.out.println(path + " starts with static!");
			super.doPut(request, response);
		}
		else
		{
			// HAVE THE REQUEST HELPER HANDLE THE METHODS
			helper.processPut(request, response);
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
