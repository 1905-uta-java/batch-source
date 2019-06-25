package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.businesslogic.CreateEmployeeService;
import com.revature.businesslogic.SelectEmployeeService;
import com.revature.businesslogic.UpdateEmployeeService;
import com.revature.models.Employee;

public class EmployeeDelegate
{
	SelectEmployeeService selectEmpService = new SelectEmployeeService();
	UpdateEmployeeService updateEmpService = new UpdateEmployeeService();
	
	public EmployeeDelegate()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void toViewOwnInformation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		// send to getEmpInfo service
		System.out.println("LEAVING EMPLOYEE DELEGATE! GOING TO EMPLOYEE SERVICE!");
		selectEmpService.getEmployeeInfo(request, response);
	}
	
	public void toUpdateOwnInformation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("LEAVING EMPLOYEE DELEGATE! GOING TO UPDATE EMPLOYEE SERVICE!");
		updateEmpService.updateEmployeeInfo(request, response);
	}
	
	public void toViewAllEmps(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("LEAVING EMP DELEGATE! GOING TO EMP SERVICE");
		selectEmpService.getAllEmps(request, response);
	}
	
}
