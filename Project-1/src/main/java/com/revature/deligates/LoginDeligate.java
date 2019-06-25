package com.revature.deligates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;
import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImp;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.util.ValidationUtil;

public class LoginDeligate {
	ValidationUtil valid = new ValidationUtil();
	EmployeeDao eDao = new EmployeeDaoImp();
	ManagerDao mDao = new ManagerDaoImp();
	
	public void returnLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean validInfo = true;
		String uName = request.getParameter("userName");
		String pWord = request.getParameter("passWord");
		System.out.println(uName);
		if(!valid.validateUname(uName) || !valid.validatePword(pWord)) {
			validInfo = false;
		}
		
		if(validInfo) {
			Employee e = eDao.getEmployeeByLogin(uName, pWord);
			Manager m = mDao.getManagerByLogin(uName, pWord);
			String s = "";
			
			if(e != null) {
				System.out.println("reached emp");
				s = new ObjectMapper().writeValueAsString(e.getId());
				response.setHeader("Authentic", s);
			} else if(m != null) {
				System.out.println("reached man");
				s = new ObjectMapper().writeValueAsString(m.getId());
				response.setHeader("Authentic", s);
			} else {
				System.out.println("reached bad");
				response.sendError(405, "Login Information Incorrect");
			}
		} else {
			response.sendError(405, "Invalid Login Information");
		}
	}
	
	public void returnCreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean validInfo = true;
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String uName = request.getParameter("userName");
		String pWord = request.getParameter("passWord");
		String eMail = request.getParameter("email");
		int manId = valid.validateInt(request.getParameter("managerId"));
		
		if(!valid.validateName(fName) && !valid.validateName(lName)) {
			validInfo = false;
		} if(valid.validateUname(uName)) {
			validInfo = false;
		} if(!valid.validatePword(pWord)) {
			validInfo = false;
		} if(!valid.validateEmail(eMail)) {
			validInfo = false;
		} if(!valid.validateManId(manId)) {
			validInfo = false;
		}
		
		if(!(manId >= 20000)) {
			int num = mDao.getManagers().size() - 1;
			int id = mDao.getManagers().get(num).getId() + 1;
			
			Manager m = new Manager(id, fName, lName, uName, pWord, eMail);
			mDao.createManager(m);
			String s = new ObjectMapper().writeValueAsString(m.getId());
			response.setHeader("Authentic", s);
		} else {
			int num = eDao.getEmployees().size() - 1;
			int id = eDao.getEmployees().get(num).getId() + 1;
			int mId = valid.validateInt(request.getParameter("managerId"));
			if(valid.validateManId(mId)) {
				// Use the information to create an Employee and send it to the EmployeeService
				Employee e = new Employee(id, fName, lName, uName, pWord, eMail, mId);
				eDao.createEmployee(e);
				String s = new ObjectMapper().writeValueAsString(e.getId());
				response.setHeader("Authentic", s);
			} else {
				validInfo = false;
			}
			
		}
		
		if(!validInfo) {
			System.out.println("Reached the wrong thing");
			response.sendError(405, "Cannot create user: Input is Invalid");
		}
	}
}
