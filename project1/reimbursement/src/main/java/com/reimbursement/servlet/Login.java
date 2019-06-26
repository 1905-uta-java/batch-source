package com.reimbursement.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.reimbursement.dao.EmployeeDao;
import com.reimbursement.dao.EmployeeDaoImpl;
import com.reimbursement.model.Employee;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Login() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String path = "";
		
		System.out.println("username is " + username);
		System.out.println("password is " + password);
		
		EmployeeDao em = new EmployeeDaoImpl();
		Employee employee = new Employee();
		employee = em.getEmployeeByUsername("mantu");
		System.out.println("Employee is " + employee);
		
		
		if(employee.getId() > 0 && employee.getPassword().equals(password)) {
			System.out.println("id is " + employee.getId() + " password: " + employee.getPassword() + " username: " + username);
			if(employee.getSupervisor() == 1) { //is Supervisor
				path = "shome";
			} else
				path = "ehome";
		} else
			path = "index";
		request.getSession().setAttribute("username", username);
		response.sendRedirect(path);
	}	
}