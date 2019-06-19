package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Department;
import com.revature.services.DepartmentService;

public class DepartmentDelegate {
	
	private DepartmentService dService = new DepartmentService();
	
	public void getDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Department> departments = dService.getAll();
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(departments));
		pw.close();
	}

}
