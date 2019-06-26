package ERS_Runners;
//imports
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdo.util.Input;

import ERS_Actors.Employee;
import JDBC_ERS_DAO.Employee_DAO;
import JDBC_ERS_DAO.Employee_DAO_Implementation;


/**
 * Description - This class acts as a runner for Employees. It performs functions that a Employee on the ERS website would be able perform
 * @author mattd
 * @version 1.0.0
 */
public class EmployeeRunner {
	//class attributes
	Employee_DAO emp_DAO = new Employee_DAO_Implementation();
	
	/**
	 * Description - Receives information from ERS webapp as a string, then searches through the employee list and updates the provided employee with new information.
	 * @param request - request from ERS webapp that contains the new employee information
	 * @param response - response for the ERS webapp, returns a status of 404 if user doesn't exist
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {//update user information		
		Employee e = null;
		
		try {
				e = new Employee(
					Integer.parseInt(request.getParameter("emp_id")),
					request.getParameter("lastname"),
					request.getParameter("firstname"),
					Integer.parseInt(request.getParameter("emp_pos")),
					request.getParameter("username"),
					request.getParameter("password"),
					request.getParameter("email")
					);
				
				if(emp_DAO.updateEmpl(e) > 0) { //user has been updated
					response.setStatus(200);
				} else { //user doesn't exist in the db
					response.sendError(404, "Employee doesn't exist.");
				}
				
		} catch (NumberFormatException nfe) {
			response.setStatus(400);
		}
		
	}
	
	/**
	 * Description - Grabs the information pertaining to the requested Employee and returns it as a JSON string.
	 * @param request - request received from webapp
	 * @param response - response received from webapp
	 * @throws IOException - if an input or output exception occurred
	 */
	public void getUserInfoById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
		System.out.println("printing: the emp_id" + request.getParameter("emp_id"));
		
		if(Input.isInputInt(request.getParameter("emp_id"))) {
			Employee emp = emp_DAO.getEmployee(Integer.parseInt(request.getParameter("emp_id")));
			pw.write(om.writeValueAsString(emp));
		} else {
			response.sendError(404, "Employee doesn't exist."); //employee doesn't exist
		}
		pw.close();
	}
	
	/**
	 * Description - Grabs the information pertaining to the requested Employee and returns it as a JSON string.
	 * @param request - request received from webapp
	 * @param response - response received from webapp
	 * @throws IOException - if an input or output exception occurred
	 */
	public void getUserInfoByLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
			Employee emp = emp_DAO.empLogin(request.getParameter("username"), request.getParameter("password"));
			
			if(emp == null)
				response.sendError(404, "Employee doesn't exist."); //employee doesn't exist
			else
				pw.write(om.writeValueAsString(emp));
			pw.close();
	}
	
	public void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
		List<Employee> temp = emp_DAO.getAllEmployees();
		
		pw.write(om.writeValueAsString(temp));
		pw.close();
		
	}
	
}
