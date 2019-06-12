package com.revature.satoshiBank;

import com.revature.model.User;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;


public class EvaluationServiceTest {
		UserDao userDao = new UserDaoImpl();
		/*******************************************************************
		 * Test 1 New user balance is 0
		 * @throws SQLException 
		 *******************************************************************/
		@Test
		public void newUserBalanceShouldBeZero() {
			User u = new User("z@g.com","password",(double)0);
//			userDao.createBankUser();
			assertTrue((double) 0 == u.balance);
		}
	

		/*******************************************************************
		 * Test 2 Test if withdraw limit cannot exceed existing balance
		 ******************************************************************/
		//public String testAnUnacceptableWithdraw()throws SQLException {
		//	Connection myConn= ConnectionUtil.getHardCodedConnection();
		//	CallableStatement myCallable = null;
		//	String userEmail = "a@g.com";
		//	String password = "password";
		//		Double withdrawAmount = (double) 999;    
		//
		//	// prepare the stored procedure call
		//	String sql = "{call withdraw(?, ?)}";
		//	myCallable = myConn.prepareCall(sql);
		//	// set the parameters
		//	myCallable.setString(1, userEmail);
		//	myCallable.setDouble(2, withdrawAmount);
		//	// call the stored procedure
		//	myCallable.execute();
		//	
		//
		//}
		//
		//public void withdraw_should_throw_SQL_Exception() {
		//    assertEquals(testAnUnacceptableWithdraw(), null);
		//}
		
		/*******************************************************************
		 * Test 3 Test if deposit works
		 ******************************************************************/
		
		
		/*******************************************************************
		 * Test 4 Test login
		 ******************************************************************/
		
		
		/*******************************************************************
		 * Test 5 Test logout
		 ******************************************************************/
	
}
