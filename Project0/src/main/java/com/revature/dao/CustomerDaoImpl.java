package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Customer;
import com.revature.model.Account;
import com.revature.util.ConnectionUtil;

public class CustomerDaoImpl implements CustomerDao {
	
	AccountDao ad = new AccountDaoImpl();

	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		
		String sql = "SELECT * FROM CUSTOMER";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);) {
			
			while(rs.next()) {
				Customer c = new Customer();
				int custId = rs.getInt("CUSTOMERID");
				c.setId(custId);
				String firstName = rs.getString("FIRSTNAME");
				c.setFirstName(firstName);
				String lastName = rs.getString("LASTNAME");
				c.setLastName(lastName);
				String email = rs.getString("EMAIL");
				c.setEmail(email);
				String birthdate = rs.getString("BIRTHDATE");
				c.setBirthdate(birthdate);
				String address = rs.getString("ADDRESS");
				c.setAddress(address);
				String street = rs.getString("STREET");
				c.setStreet(street);
				String city = rs.getString("CITY");
				c.setCity(city);
				String state = rs.getString("ASTATE");
				c.setState(state);
				int zip = rs.getInt("ZIP");
				c.setZip(zip);
				int ss = rs.getInt("SS");
				c.setSs(ss);

				
				customers.add(c);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customers;
	}

	public Customer getCustomerById(int id) {
		
		String sql = ("SELECT * FROM CUSTOMER WHERE CUSTOMERID = ?");
		Customer c = new Customer();
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int custId = rs.getInt("CUSTOMERID");
				c.setId(custId);
				String firstName = rs.getString("FIRSTNAME");
				c.setFirstName(firstName);
				String lastName = rs.getString("LASTNAME");
				c.setLastName(lastName);
				String email = rs.getString("EMAIL");
				c.setEmail(email);
				String birthdate = rs.getString("BIRTHDATE");
				c.setBirthdate(birthdate);
				String address = rs.getString("ADDRESS");
				c.setAddress(address);
				String street = rs.getString("STREET");
				c.setStreet(street);
				String city = rs.getString("CITY");
				c.setCity(city);
				String state = rs.getString("ASTATE");
				c.setState(state);
				int zip = rs.getInt("ZIP");
				c.setZip(zip);
				int ss = rs.getInt("SS");
				c.setSs(ss);

				c = new Customer(custId, firstName, lastName, email, birthdate,
						address, street, city, state, zip, ss);
				
			}
			rs.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public int insertCustomer(Customer c) {
		
		int customersCreated = 0;
		
		String sql = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try (Connection con = ConnectionUtil.getHardCodedConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, c.getId());
			ps.setString(2, c.getFirstName());
			ps.setString(3, c.getLastName());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getBirthdate());
			ps.setString(6, c.getAddress());
			ps.setString(7, c.getStreet());
			ps.setString(8, c.getCity());
			ps.setString(9, c.getState());
			ps.setInt(10, c.getZip());
			ps.setInt(11, c.getSs());
			
			customersCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customersCreated;
	}

	public int updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addAccount(int accountNum, String accountType) {
		// TODO Auto-generated method stub
		return 0;
	}

}
