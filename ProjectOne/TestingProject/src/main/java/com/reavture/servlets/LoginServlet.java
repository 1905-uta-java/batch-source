package com.reavture.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDaoImpl empDao = new EmployeeDaoImpl();
	Employee eRef = new Employee();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String email = request.getParameter("txtemail");
		String password= request.getParameter("txtpassword");
		

		
		boolean Auth = empDao.AuthenticatedUser(email, password);
		boolean Auth_pos=empDao.AuthenticatedPosition("Manager", email);
		System.out.println(Auth);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body><center>");
		if(Auth) {
			HttpSession session = request.getSession();
			session.setAttribute("KeyEmail", email);
		if(Auth && Auth_pos) {
			out.print("Welcome I am manager");
			response.sendRedirect("manager.html");
		}else{
			out.print("I am employee");
			response.sendRedirect("UpdateEmp.html");
			
		}
		}else {
			
		}
		out.print("</center></body></html>");
		
		
	}

}
