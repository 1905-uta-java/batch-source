package com.revature.BankingApp.doa;

import java.util.List;

import com.revature.BankingApp.model.Customer;

public interface CustomerDoa {
	public List<Customer> getCustomer();
	public Customer getCustomerById(int id);
	public void addCustomer(Customer c);
	public void updateCustomer(Customer c);
	public void deleteCustomer(Customer c);
	
}
