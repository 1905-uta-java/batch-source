package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomers();
	public Customer getCustomerById(int id);
	public int insertCustomer(Customer c);
	public int updateCustomer(Customer c);
	public int deleteCustomer(int id);
	public int addAccount(int accountNum, String accountType);


}
