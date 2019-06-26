package com.reavture.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtemail");
		String password = request.getParameter("txtpassword");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		// If the user detail is not filled by the users //
		if(!email.isEmpty()&& !password.isEmpty()) {
			
			out.print("User is Validated Successfully . ");//  Response will not been seen// 
			
			// Forward request and request to the Login servlet // 
			RequestDispatcher dispacture = request.getRequestDispatcher("login"); //Response from the login servlet will be seen//
			dispacture.forward(request, response);
			
		}else {
			
			out.print("User is Validated Failed !! Please re-Enter detail. ");
			
			RequestDispatcher dispacture = request.getRequestDispatcher("Index.html");
			dispacture.include(request, response);
			
		}
	}

}
