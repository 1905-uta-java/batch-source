package com.company.services;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.company.dao.ReimbursementDao;
import com.company.dao.ReimbursementDaoImpl;
import com.company.model.Reimbursement;

public class ReimbursementService {
	ReimbursementDao rd = new ReimbursementDaoImpl();
	
	//Get all reimbursements
	public List<Reimbursement> getAll(){
		return rd.getReimbursements();
	}
	
	//Get reimbursement by id
	public Reimbursement getById(int id) {
		return rd.getReimbursementById(id);
	}
	
	//Get all reimbursements by employee id
	public List<Reimbursement> getAllByEmpId(int empId){
		return rd.getAllReimbursementsByEmployee(empId);
	}
	
	//Get all reimbursements by Manager id
	public List<Reimbursement> getAllByManagerId(int mangId){
		return rd.getAllReimbursementsByManager(mangId);
	}
	
	//Create reimbursement
	public int create(Reimbursement r) {
		return rd.createReimbursement(r);
	}
	
	//Update reimbursement
	public int update(Reimbursement r) {
		return rd.updateReimbursement(r);
	}
	
	//Delete reimbursement
	public int delete(int id) {
		return rd.deleteReimbursement(id);
	}
	
	//Get next reimbursement Id
	public int getNextRequestId() {
		return rd.getNextReimbursementID() + 1;
	}
	
	//Convert a string into an int, if cant be done return null;
	public int convertStringToInt(String num) {
		if(num == null || num.equals("")) {
			return 0;
		}
		
		//Remove everything but numbers from string
		String numbers = num.replaceAll("[^0-9]","");
		
		if(numbers.equals("")) {
			return 0;
		}
		
		try {
			int number = Integer.parseInt(numbers);
			return number;
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//Convert a string date and time into a Date
	public Date convertDateTimeString(String dateTime) {
		SimpleDateFormat format = new SimpleDateFormat("MMddyy");
        java.util.Date parsed;
		try {
			parsed = format.parse(dateTime);
			return new Date(parsed.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Convert a string into a double, if cant be done return 0;
	public double convertStringToDouble(String num) {
		if(num == null || num =="") {
			return 0;
		}
		try {
			double number = Double.parseDouble(num);
			return number;
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

}
