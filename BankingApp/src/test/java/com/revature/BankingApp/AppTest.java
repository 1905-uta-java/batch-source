package com.revature.BankingApp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;


public class AppTest {
    
    @Test
    public void testIsDoubleTrue() {
    	assertEquals(BankDriver.isDouble("100.0"), true);
    }
    
    @Test
    public void testisDoubleFalse() {
    	assertEquals(BankDriver.isDouble("Not Double"), false);
    }
    
    @Test
    public void testIsAUser() {
    	Customer c = new Customer();
    	assertEquals(BankDriver.User("ccoggin0", "Q5urr5cNds").getClass(), c.getClass());
    }
    
    @Test
    public void testNotAUser() {
    	assertEquals(BankDriver.User(" ", " "), null);
    }
    
    @Test
    public void testEmailExists() {
    	assertEquals(BankDriver.emailExist("tony1latorre@hotmail.com"), true);
    }
    
    @Test
    public void testEmailDoesNotExist() {
    	assertEquals(BankDriver.emailExist(" "), false);
    }
    @Test
    public void testIsAccountTypeTrue() {
    	assertEquals(BankDriver.isAccountType("Checking"), true);
    }
    @Test
    public void testIsAccountTypeTrueSavings(){
    	assertEquals(BankDriver.isAccountType("Saving"), true);
    	
    }
    @Test
    public void testIsAccountTypeFalse() {
    	assertEquals(BankDriver.isAccountType("Not Account"), false);
    }
    @Test
    public void testIsSSNTrue() {
    	assertEquals(BankDriver.isSSN("982769887"), true);
    }
    @Test
    public void testIsSSNFalse() {
    	assertEquals(BankDriver.isSSN("9867"), false);
    }
    
}
