package com.revature.dao;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.model.Bank;

public class BankDaoTest {
	
	@Test
	public void viewBalanceOfChecking() {
		Bank b = new Bank();
		BankDao bd = new BankDaoImpl();
		b.setUsername("Frag");
		b.setPassword("lit");
		b.setAccountType("checking");
		assertEquals(0,bd.viewBalance(b),.01);
	}
	
	@Test
	public void viewBalanceOfSavings() {
		Bank b = new Bank();
		BankDao bd = new BankDaoImpl();
		b.setUsername("Frag");
		b.setPassword("lit");
		b.setAccountType("savings");
		assertEquals(6371.95,bd.viewBalance(b),.01);
	}
	
}
