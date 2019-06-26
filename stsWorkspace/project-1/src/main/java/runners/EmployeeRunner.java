package runners;
import java.io.IOException;
import java.io.PrintWriter;

//imports
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdo.util.Input;

import ERS_Actors.Employee;
import JBDC_DAO.Employee_DAO;
import JBDC_DAO.Employee_DAO_Implementation;

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
		ObjectMapper om = new ObjectMapper();
		
			Employee e = om.readValue(request.getReader(), Employee.class);
			
			if(emp_DAO.updateEmpl(e) > 0) { //user has been updated
				response.setStatus(201);
			} else { //user doesn't exist in the db
				response.sendError(404, "Employee doesn't exist.");
			}
	}
	
	/**
	 * Descripion - Grabs the information pertaining to the requested Employee and returns it as a JSON string.
	 * @param request - request received from webapp
	 * @param response - response received from webapp
	 * @throws IOException - if an input or output exception occurred
	 */
	public void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
		if(Input.isInputInt(request.getParameter("emp_id"))) {
			Employee emp = emp_DAO.getEmployee(Integer.parseInt(request.getParameter("emp_id")));
			pw.write(om.writeValueAsString(emp));
		} else {
			response.sendError(404, "Employee doesn't exist."); //employee doesn't exist
		}
	}
	
}
