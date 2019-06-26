package com.reavture.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.model.Employee;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDaoImpl empDao = new EmployeeDaoImpl();

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("txtname");
		String email = request.getParameter("txtemail");
		String password= request.getParameter("txtpassword");
		
		Employee eRef = new Employee(0,email,password,"Employee",0,"Pending");
		
		int i=empDao.CreateEmployee(eRef);
		System.out.println(name+" - "+email+" - "+password);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body><center>");
		if(i>0) {
			out.print(" Successfully register.");
		}else {
			out.print("Registration Failed !!!.");
		}
		out.print("</center></body></html>");
		
	}

}
