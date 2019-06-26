package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimburse;
import com.revature.service.ReimburseService;

public class ReimburseDelegate {
	ReimburseService rService = new ReimburseService();

	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<Reimburse> r = new ArrayList<>();
		Object[] rArr = null;
		
		r = rService.getAll();
		rArr = r.toArray();
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(rArr));
		pw.close();
		
	}

	public void returnRemInfo(HttpServletRequest request, HttpServletResponse response, String strId) throws IOException, ServletException {
		ArrayList<Reimburse> r = new ArrayList<>();
		Object[] rArr = null;

		System.out.println("GETTING REQS FROM ID " + strId);
		try {
			int id = Integer.parseInt(strId);
			r = rService.getRemsFromId(id);
			rArr = r.toArray();
		} catch (NumberFormatException e) {
			System.out.println("Can't convert " + strId + " into an id");
		}
		
		
		System.out.println("PRINTING REIMBURSE ARRAY");
		for(int i = 0; i < rArr.length; i++) {
			System.out.println(rArr[i]);
		}
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(rArr));
		pw.close();
	}
	
	
	public void newReimburse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-YYYY");
		int newRemId = rService.getNewRemNum();
		Date date = new Date();
		Reimburse r = new Reimburse(newRemId, request.getParameter("desc"), Double.parseDouble(request.getParameter("amount")),
				simpleFormat.format(date), null, "Pending", Integer.parseInt(request.getParameter("manId")),
				Integer.parseInt(request.getParameter("empId")));
		System.out.println("HERE WE GO, NEW REIMBURSEMENT: " +  r);
		rService.addReimbursement(r);
	}
	

	public void updReimburse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter pw = response.getWriter();
		
		ArrayList<Reimburse> r = new ArrayList<>();
		Object[] rArr = null;

		System.out.println("GETTING REQS FROM Logged in user " );
		r = rService.upd();
		rArr = r.toArray();
		
		for(int i = 0; i < rArr.length; i++) {
			System.out.println(rArr[i]);
		}
		
		pw.write(new ObjectMapper().writeValueAsString(rArr));
		pw.close();
	
	}
	
	public void pushToDb() {
		rService.forceDB();
	}


	public void logout() {
		rService.logout();
	}


	public void approve(int id) {
		rService.approve(id);
		
	}


	public void deny(int id) {
		rService.deny(id);
	}


	public void adminRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ArrayList<Reimburse> r = new ArrayList<>();
		Object[] rArr = null;

		String strId = request.getParameter("manId");
		
		System.out.println("GETTING REQS FROM ID " + strId);
		try {
			int id = Integer.parseInt(strId);
			r = rService.getRemsForAdmin(id);
			rArr = r.toArray();
		} catch (NumberFormatException e) {
			System.out.println("Can't convert " + strId + " into an id");
		}
		
		
		System.out.println("PRINTING REIMBURSE ARRAY");
		for(int i = 0; i < rArr.length; i++) {
			System.out.println(rArr[i]);
		}
		
		PrintWriter pw = response.getWriter();
		pw.write(new ObjectMapper().writeValueAsString(rArr));
		pw.close();
	}
}
