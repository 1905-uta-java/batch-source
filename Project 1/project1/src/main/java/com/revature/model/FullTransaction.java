package com.revature.model;

import java.util.List;

import com.revature.doa.EmployeeDoa;
import com.revature.doa.ManagerDoa;
import com.revature.doa.TransactionDoa;

public class FullTransaction {

	String empName;
	String manName;
	List<Transaction> transactions;
	public FullTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FullTransaction(String empName, String manName, List<Transaction>transactions) {
		super();
		this.empName = empName;
		this.manName = manName;
		this.transactions = transactions;
	
	}
	public FullTransaction(List<Employee> e, String firstName, List<Transaction> trans) {
		// TODO Auto-generated constructor stub
	}
	public String getEmpName() {
		return empName;
	}
	public String getManName() {
		return manName;
	}
	public List<Transaction> getTransactions(){
		return transactions;
	}
	
	public Transaction setTransactionFromEmployee(int empid, double d, String log) {
		ManagerDoa md = new ManagerDoa();
		EmployeeDoa ed = new EmployeeDoa();
		TransactionDoa t = new TransactionDoa();
		int index = t.nextId();
		Employee e = ed.getEmployeeById(empid);
		Manager m = md.getManagerById(e.getManagerId());
		Transaction trans = new Transaction(index, d, empid, m.getId(), log);
		return trans;
		
		
	}
	
	public FullTransaction setFullTransactionFromEmployee(int empid) {
		ManagerDoa md = new ManagerDoa();
		EmployeeDoa ed = new EmployeeDoa();
		TransactionDoa td = new TransactionDoa();
		Employee e = ed.getEmployeeById(empid);
		Manager m = md.getManagerById(e.getManagerId());
		List<Transaction> trans = td.getTransactionByEmployeeId(empid);
		
		return new FullTransaction(e.getFirstName(), m.getFirstName() , trans);
				
				
	}
	
	public FullTransaction setFullTransactionFromEmployee(String empid) {
		if(Integer.parseInt(empid) > 10000) {
			return setFullTransactionFromEmployee(Integer.parseInt(empid));
		}
		return null;
	}
	
	public FullTransaction setFullTransactionFromManager(int manId) {
		ManagerDoa md = new ManagerDoa();
		EmployeeDoa ed = new EmployeeDoa();
		TransactionDoa td = new TransactionDoa();
		List<Employee> e = ed.getEmployeesByManagerId(manId);
		Manager m = md.getManagerById(manId);
		List<Transaction> trans = td.getTransactionByEmployeeId(manId);
		
		return new FullTransaction(e, m.getFirstName() , trans);
		
	}
	
	public FullTransaction setFullTransactionFromManager(String manId) {
		if(Integer.parseInt(manId) > 20000) {
			return setFullTransactionFromManager(Integer.parseInt(manId));
		}
		return null;
	}
	@Override
	public String toString() {
		return "FullTransaction [empName=" + empName + ", manName=" + manName + ", transactions=" + transactions + "]";
	}
	
	
	

	
	
}
