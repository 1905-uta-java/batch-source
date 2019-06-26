package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.doa.EmployeeDoa;
import com.revature.doa.ManagerDoa;
import com.revature.doa.TransactionDoa;
import com.revature.model.Employee;
import com.revature.model.FullTransaction;
import com.revature.model.Transaction;
import com.revature.util.EmployeeAuthentication;
import com.revature.util.ManagerAuthentication;

public class TransactoinDisplay {
	
	TransactionDoa td = new TransactionDoa();
	ManagerDoa md = new ManagerDoa();
	EmployeeDoa ed = new EmployeeDoa();
	
	
	public void displayTransaction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String empId  = request.getParameter("empId");
		System.out.println(empId);
		
		if(EmployeeAuthentication.isEmployeeId(empId)) {
			response.setHeader("employee", ed.getEmployeeById(Integer.parseInt(empId)).getFirstName() + " " + ed.getEmployeeById(Integer.parseInt(empId)).getLastName());

			PrintWriter pw = response.getWriter();
			List<Transaction> trans = td.getTransactionByEmployeeId(empId);
			if(trans.size() > 0) {
				List<FullTransaction> ftList = new ArrayList();
				writeEmployee(empId, ftList);
				pw.write(new ObjectMapper().writeValueAsString(ftList));
				pw.close();
			}
		}
		else if(ManagerAuthentication.isManagerId(empId)) {
			response.setHeader("manager", md.getManagerById(Integer.parseInt(empId)).getFirstName() + " " + md.getManagerById(Integer.parseInt(empId)).getLastName());
			PrintWriter pw = response.getWriter();
			System.out.println("TranactoinDisplay: " + td.getTransactionsByManagerId(empId));
			List<Transaction> trans = td.getTransactionsByManagerId(empId);
			if(trans.size() > 0) {
				List<FullTransaction> ftList = new ArrayList();
				for(Employee e : md.employeesUnderManager(Integer.parseInt(empId))) {
					writeEmployee(String.valueOf(e.getId()), ftList);
					
				}
				pw.write(new ObjectMapper().writeValueAsString(ftList));
				pw.close();

		}
	}
}
	
	public void writeEmployee(String empId, List<FullTransaction>ftList) throws JsonProcessingException{
		
		FullTransaction temp = new FullTransaction();
		FullTransaction ft = temp.setFullTransactionFromEmployee(empId);
		ftList.add(ft);
		

	}
	
}
