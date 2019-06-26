package com.company.delegates;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.Employee;
import com.company.services.EmployeeService;
import com.company.util.PasswordEncryptionUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDelegate {
	private EmployeeService es = new EmployeeService();
	
	//Get relevant employee's dependent on user.
	public List<Employee> getRelevantEmployees(HttpServletRequest request,HttpServletResponse response){
		String strId = request.getParameter("emp_id");
		int empId = es.convertIdString(strId);
		List<Employee> relEmps;
		//Check if id converted correctly
		if(empId == 0) {
			return null;
		}
		
		//If they have the owners id 100001 then get all employees
		if(empId == 100001) {
			relEmps = es.getAll();
		}else {
			//Get all employees that have this id as their manager id and also employee with that id
			relEmps = es.getByManagerId(empId);
			Employee current = es.getById(empId);
			//Add the employee with the id to the list of employees with id as manager
			relEmps.add(current);
		}
		return relEmps;
	}
	
	//Get only the employee's information
	public Employee getEmployeeInfo(HttpServletRequest request,HttpServletResponse response) {
		String strId = request.getParameter("emp_id");
		Employee emp;
		//IF strId is null, then try email
		if(strId == null) {
			String email = request.getParameter("email");
			emp = es.getByEmail(email);
		}else {
			int empId = es.convertIdString(strId);
			
			//Check if id converted correctly
			if(empId == 0) {
				return null;
			}
			
			
			emp = es.getById(empId);
		}
		
		return emp;
	}
	
	//Create new Employee for database
	public int createEmployee(HttpServletRequest request,HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Employee newEmp = mapper.readValue(request.getInputStream(),Employee.class);
		
		//Get all information and convert information as needed
		int empId = es.generateEmployeeId();
		String email = es.generateEmail(newEmp.getFirstName(), newEmp.getLastName(), empId);
		String defaultPassword = es.generatePassword(newEmp.getFirstName(), newEmp.getLastName(), empId);
		
		//Verify nothing is null or 0
		if(email == null || empId == 0 || defaultPassword == null) {
			return 0;
		}
		
		//Hash the password
		String hashPassword = PasswordEncryptionUtil.encryptPassword(defaultPassword);
		newEmp.setEmpId(empId);
		newEmp.setEmail(email);
		newEmp.setPassword(hashPassword);
		
		//Create new employee
		
		return es.create(newEmp);
	}
	
	//Update a current Employee 
	public int updateEmployee(HttpServletRequest request,HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Employee newEmp = mapper.readValue(request.getInputStream(),Employee.class);
		
		//Get the rest of the employees information that can't be changed
		Employee oldInfo = es.getById(newEmp.getEmpId());
		
		//New information
		newEmp.setEmail(oldInfo.getEmail());
		newEmp.setPassword(oldInfo.getPassword());
		
		return es.update(newEmp);
	}
	
	//Delete an employee
	public int deleteEmployee(HttpServletRequest request,HttpServletResponse response){
		String strId = request.getParameter("emp_id");
		int empId = es.convertIdString(strId);
		
		//Check if empId is 0
		if(empId == 0) {
			return 0;
		}
		
		return es.delete(empId);
	}
	
	//Change employee password
	public int changePassword(HttpServletRequest request,HttpServletResponse response) {
		String strId = request.getParameter("emp_id");
		int empId = es.convertIdString(strId);
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newpass");
		
		//Check if any are null/0
		if(empId == 0 || password == null || newPassword == null) {
			return 0;
		}
		
		String hashPassword = PasswordEncryptionUtil.encryptPassword(password);
		
		Employee emp = es.getById(empId);
		if(!emp.getPassword().trim().equals(hashPassword))
		{
			return 0;
		}
		
		String hashNewPassword = PasswordEncryptionUtil.encryptPassword(newPassword);
		
		return es.changePassword(empId, hashNewPassword);
	}
	
	//Promote an employee
	public int promoteEmployee(HttpServletRequest request,HttpServletResponse response) {
		String strId = request.getParameter("emp_id");
		int empId = es.convertIdString(strId);
		
		//Check if any 0
		if(empId == 0) {
			return 0;
		}
		
		return es.promoteEmployee(empId);
	}
}
