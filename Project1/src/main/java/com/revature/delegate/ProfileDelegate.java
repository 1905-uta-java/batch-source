package com.revature.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Employee;
import com.revature.model.Profile;
import com.revature.service.EmployeeService;
import com.revature.service.ProfileService;

public class ProfileDelegate {
	
	ProfileService profService = new ProfileService();
	EmployeeService eServe = new EmployeeService();
	
	public void getProfileInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String token = request.getHeader("Authorization");
		Profile currentProfile = profService.getUserById(Integer.parseInt(token.split(":")[0]));
		Employee emp = eServe.getById(currentProfile.getEmpId());
		currentProfile.setEmp(emp);
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(currentProfile));
		//pw.write(new ObjectMapper().writeValueAsString(emp));
		pw.close();
	}
	
	public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//grab employee id from Authorization header
		String token = request.getHeader("Authorization");
		Profile currentProfile = profService.getUserById(Integer.parseInt(token.split(":")[0]));
		Employee currentEmployee = eServe.getById(currentProfile.getEmpId());
		currentProfile.setEmp(currentEmployee);
		int empId = currentProfile.getEmpId();
		
		//grab information from request body
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String data = br.readLine();
		String[] dataArr = data.split("&");
		
		PrintWriter pw = response.getWriter();
		for(String s : dataArr) {
			String spl = s.split("=")[0];
			switch(spl) {
//			case "username":
//				if(s.split("=").length > 1) {
//					profService.setUsername(s.split("=")[1], empId);
//					response.setHeader("Authorization", token.split(":")[0]+s.split("=")[1]);
//					pw.write("username="+s.split("=")[0]);
//				}
//				break;
			case "fullname":
				if(s.split("=").length > 1) {
					eServe.setEmployeeName(s.split("=")[1], empId);
					pw.write("fullname="+s.split("=")[0]);
				}
				break;
			case "email":
				if(s.split("=").length > 1) {
					eServe.setEmployeeEmail(s.split("=")[1], empId);					
					pw.write("email="+s.split("=")[0]);

				}
				break;
			case "password":
				if(s.split("=").length > 1) {
					profService.setPassword(s.split("=")[1], empId);
				}
				break;
			}
		}
		//call upon eServe to update employee information or profService for username/password changes
//		response.setStatus(200);
		request.getRequestDispatcher("/static/views/Profile.html").forward(request, response);
		
	}

}
