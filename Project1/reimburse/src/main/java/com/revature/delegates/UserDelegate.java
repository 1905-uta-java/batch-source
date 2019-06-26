package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImpl;
import com.revature.models.User;

public class UserDelegate {
	
	private UserDao ud = new UserDaoImpl();
	
	
	public void getUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// get idStr from parameters
		String idStr = request.getParameter("id");
		
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		
		if(idStr == null) {
			// get users from UserDao, convert to JSON, write to response body
			List<User> users = ud.getAll();
			pw.write(om.writeValueAsString(users));
			pw.close();
		} else if(idStr.matches("^\\d+$")) {
			// get one user and return it in the response body
			User u = ud.getById(Integer.parseInt(idStr));
			if(u == null) {
				response.sendError(404, "No user with given ID");
			} else {
				pw.write(om.writeValueAsString(u));
				pw.close();
			}
		} else {
			response.sendError(400, "Invalid ID param");
		}
	}

}
