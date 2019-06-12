package com.revature.BankingApp.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.revature.BankingApp.model.Customer;
import com.revature.BankingApp.util.ConnectionUtil;

public class CustomerDoaImpl implements CustomerDoa {

	@Override
	public List<Customer> getCustomer() {
		List<Customer> customers = new ArrayList();
		
		String sql = "SELECT * FROM CUSTOMER";
		
		try(Connection c = ConnectionUtil.getHardCodedConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql);
				){
			while(rs.next()) {
				int custId = 	rs.getInt("CUSTOMER_ID");
				String fn = 	rs.getString("FIRSTNAME");
				String ln = 	rs.getString("LASTNAME");
				String ssn = 	rs.getString("SSN");
				String email = 	rs.getString("EMAIL");
				String un = 	rs.getString("USERNAME");
				String pass = 	rs.getString("CUSTOMER_PASSWORD");
				String pho = 	rs.getString("PHONE");
				String addr = 	rs.getString("ADDRESS");
				String city = 	rs.getString("CITY");
				String cou = 	rs.getString("COUNTRY");
				String dAdded = rs.getString("DATE_ADDED");
				String dRemov = rs.getString("DATE_REMOVED");
				Customer temp = new Customer(custId, fn, ln, ssn, email, un, pass,
						pho, addr, city, cou, dAdded, dRemov);
				customers.add(temp);
						
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		List<Customer> temp = getCustomer();
		return temp.get(id);
	}

	@Override
	public void addCustomer(Customer c) {
		//cid, fn, ln, ssn, em, us, pas, ph, add, ci, cou, date
		String sql = "INSERT INTO CUSTOMER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NULL)";
		int i = 0;
		int custId = 0;
		List<Customer>customers = getCustomer();
		for(Customer cu : customers) {
			int temp = cu.getCustomerId();
			if(temp >= custId) {
				custId = temp;
			}
		}
		custId += 1;
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String dateOpen = dateFormat.format(date);
		
		try(Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(++i, custId);
			ps.setString(++i, c.getFirstName());
			ps.setString(++i, c.getLastName());
			ps.setString(++i, c.getSSN());
			ps.setString(++i, c.getEmail());
			ps.setString(++i, c.getUsername());
			ps.setString(++i, c.getPassword());
			ps.setString(++i, c.getPhone());
			ps.setString(++i, c.getAddress());
			ps.setString(++i, c.getCity());
			ps.setString(++i, c.getCountry());
			ps.setString(++i, dateOpen);
			ps.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
	}
	

}
