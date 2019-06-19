package com.revature.servlets.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeService empService = new EmployeeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		
		if(idStr == null) {
			// make a call to a service method which gets all of our employees
			List<Employee> employees = empService.getAll();
			
			// convert employees to JSON using Jackson databind's ObjectMapper
			ObjectMapper om = new ObjectMapper();
			String employeesJSON = om.writeValueAsString(employees);
			
			// write JSON to response body using response's PrintWriter
			PrintWriter pw = response.getWriter();
			pw.write(employeesJSON);
			pw.close();
		} else if (idStr.matches("^\\d+$")) {
			Employee e = empService.getById(Integer.parseInt(idStr));
			if(e == null) {
				response.setStatus(404);
			}
			
			ObjectMapper om = new ObjectMapper();
			String employeeJSON = om.writeValueAsString(e);
			
			PrintWriter pw = response.getWriter();
			pw.write(employeeJSON);
			pw.close();
			
		} else {
			response.setStatus(400);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get new employee information from request, pass it to service method
		String newName = request.getParameter("name");
		String newDptIdStr = request.getParameter("department");
		System.out.println("input "+newName+" with a dept id of "+newDptIdStr);
		if(newDptIdStr != null && newDptIdStr.matches("^\\d+$")) {
			Employee e = new Employee();
			e.setName(newName);
			e.getDepartment().setId(Integer.parseInt(newDptIdStr));
			empService.create(e);
//			response.setStatus(201);
			response.sendRedirect("directory");
		}
		
	}

}
