package com.company.services;

import java.util.List;

import com.company.dao.EmployeeDao;
import com.company.dao.EmployeeDaoImpl;
import com.company.model.Employee;
import com.company.model.Reimbursement;

public class EmployeeService {
	
	private EmployeeDao ed = new EmployeeDaoImpl();
	private ReimbursementService rs = new ReimbursementService();
	
	//Get all from database
	public List<Employee> getAll(){
		return ed.getEmployees();
	}
	
	//Get by employee Id
	public Employee getById(int empId){
		return ed.getEmployeeByEmpId(empId);
	}
	
	//Get by email
	public Employee getByEmail(String email) {
		return ed.getEmployeeByEmail(email);
	}
	
	//Get by manager id
	public List<Employee> getByManagerId(int mangId){
		return ed.getEmployeesByManager(mangId);
	}
	
	//Create employee
	public int create(Employee e) {
		return ed.createEmployee(e);
	}
	
	//Update employee
	public int update(Employee e) {
		return ed.updateEmployee(e);
	}
	
	//delete employee
	public int delete(int empId) {
		
		//Get the employee
		Employee deletingEmp = ed.getEmployeeByEmpId(empId);
		
		//Get all the employees that have this person as a manager
		List<Employee> underEmployees = ed.getEmployeesByManager(empId);
		
		//Get all of this persons reimbursements
		List<Reimbursement> employeeReims = rs.getAllByEmpId(empId);
		
		//Get all of the reimbursements that this person is manager for
		List<Reimbursement> managerOfReims = rs.getAllByManagerId(empId);
		
		//Loop through and update all ids then update database
		for(Employee e : underEmployees) {
			e.setManagerId(deletingEmp.getManagerId());
			ed.updateEmployee(e);
		}
		
		//Loop through empReims and update id
		for(Reimbursement r : employeeReims) {
			r.setEmpId(0);
			r.setManagerNotes("Old Reimbursements for employee:" + empId + " "+deletingEmp.getFirstName()+" "+deletingEmp.getLastName());
			rs.update(r);
		}
		
		//Loop through managerofReims and update id
		for(Reimbursement r : managerOfReims) {
			r.setManagerId(100001);
			r.setManagerNotes("Old Manager: "+empId);
			rs.update(r);
		}
		
		return ed.deleteEmployee(empId);
	}
	
	//Next ID
	public int getNextId() {
		return ed.getNextEmployeeID();
	}
	
	//Generate Email based on First Name, Last Name and Unique Portion of ID
	public String generateEmail(String first, String last, int id) {
		if(first == null || first.equals("") || last == null || last.equals("") || id == 0) {
			return null;
		}
		
		String email;
		if(id>=100000) {
			email = first+ last + Integer.toString(id-100000)+"@company.com";
		}else {
			email = first + last + Integer.toString(id)+"@company.com";
		}
		
		return email;
	}
	
	//Generate Employee Id
	public int generateEmployeeId() {
		int next = getNextId() + 100000;
		return next+1;
	}
	
	//Generate the default password
	public String generatePassword(String first,String last, int id) {
		
		if(first == null || first.equals("") || last == null || last.equals("") || id == 0) {
			return null;
		}
		
		String password;
		if(id>=100000) {
			password = first+ last + Integer.toString(id-100000);
		}else {
			password = first + last + Integer.toString(id);
		}
		
		return password;
	}
	
	//Convert an id from string into an int, if cant be done return null;
	public int convertIdString(String strId) {
		
		if(strId == null || strId.equals("")) {
			return 0;
		}
		
		//Remove everything but numbers from string
		String numbers = strId.replaceAll("[^0-9]","");
		
		if(numbers.equals("")) {
			return 0;
		}
		
		try {
			int id = Integer.parseInt(numbers);
			return id;
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//Convert a phone number in string format to integer
	public long convertPhoneString(String strPhone) {
		if(strPhone == null) {
			return 0;
		}
		
		//Remove everything but numbers from string
		String numStrPhone = strPhone.replaceAll("[^0-9]","");
		
		if(numStrPhone.equals("")) {
			return 0;
		}
		
		//return 0 if length isn't 11
		if(numStrPhone.length() != 11) {
			return 0;
		}
		
		try {
			long phone = Long.parseLong(numStrPhone);
			return phone;
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//Change password of an employee
	public int changePassword(int id, String password) {
		return ed.changePassword(id, password);
	}
	
	//Promote Employee
	public int promoteEmployee(int id) {
		Employee oldE = ed.getEmployeeByEmpId(id);
		int newid = id+100000;
		oldE.setEmpId(newid);
		
		//Get all the employees that have this person as a manager
		List<Employee> underEmployees = ed.getEmployeesByManager(id);
		
		//Get all of this persons reimbursements
		List<Reimbursement> employeeReims = rs.getAllByEmpId(id);
		
		//Get all of the reimbursements that this person is manager for
		List<Reimbursement> managerOfReims = rs.getAllByManagerId(id);
		
		//Loop through and update all ids then update database
		for(Employee e : underEmployees) {
			e.setManagerId(newid);
			ed.updateEmployee(e);
		}
		
		//Loop through empReims and update id
		for(Reimbursement r : employeeReims) {
			r.setEmpId(newid);
			rs.update(r);
		}
		
		//Loop through empReims and update id
		for(Reimbursement r : managerOfReims) {
			r.setManagerId(newid);
			rs.update(r);
		}

		return ed.updateEmployee(oldE);
	}
	
	
	
	
	
	
	
	
	
	
}
