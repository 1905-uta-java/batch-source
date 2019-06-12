package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.model.Account;
import com.revature.model.Customer;

public class Project0Test {
	
	private static final Driver driver = new Driver();
	private static final AccountDao ad = new AccountDaoImpl();
	private static final CustomerDao cd = new CustomerDaoImpl();

	
	@Test
	public void testGetAccountBalanceInAccount() {
		Account a1 = new Account(6, 3, "Checking", 550);
		assertTrue(a1.getAccountBalance() == 550);
	}

	
	@Test 
	public void testCreateCustomerInCustomer() {
		List<Customer> customers = new ArrayList<>();
		Customer c = new Customer(1, "B", "S", "lsk@sldfj", "12-MAR-28", "N4829", "Chsid","Rio","WI",52930,123456789);
		customers.add(c);
		assertTrue(customers.size() > 0);
	}
	
	@Test 
	public void testCheckForLettersOnly() {
		assertEquals(0,driver.CheckStringForLettersOnly("Hi"));
	}
	
	@Test
	public void testCheckForLettersOnlyFalse() {
		assertEquals(1,driver.CheckStringForLettersOnly("234"));
	}
	
	@Test 
	public void testCheckForBirthFormatTrue() {
		assertEquals(0, driver.CheckForBirthFormat("12-JAN-88"));
	}
	
	@Test 
	public void testCheckForBirthFormatFalse() {
		assertEquals(1, driver.CheckForBirthFormat("12-1-88"));
	}
	
	@Test 
	public void testCheckForZipFormatTrue() {
		assertEquals(0, driver.CheckForZipFormat("45632"));
	}
	
	@Test 
	public void testCheckForZipFormatFalse() {
		assertEquals(1, driver.CheckForZipFormat("45635252"));
	}
	
	@Test 
	public void testCheckForSSFormatTrue() {
		assertEquals(0, driver.CheckForSSFormat("874569215"));
	}
	
	@Test 
	public void testCheckForSSFormatFalse1() {
		assertEquals(1, driver.CheckForSSFormat("8745692532153"));
	}
	
	@Test 
	public void testCheckForSSFormatFalse2() {
		assertEquals(1, driver.CheckForSSFormat("874-56-92153"));
	}
	
	@Test
	public void testCheckForStateFormatTrue() {
		assertEquals(0, driver.CheckForStateFormat("WI"));
	}
	
	@Test
	public void testCheckForStateFormatFalse() {
		assertEquals(1, driver.CheckForStateFormat("Wisconsin"));
	}
	
	@Test
	public void testCheckForValidEmailTrue() {
		assertEquals(0, driver.CheckForValidEmail("email@gmail.com"));
	}
	
	@Test
	public void testCheckForValidEmailFalse() {
		assertEquals(1, driver.CheckForValidEmail("email.gmail.com"));
	}
	
	
}

