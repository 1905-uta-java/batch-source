package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Before;
import org.junit.Test;

import com.revature.frontend.FrontEnd;

public class UnitTests {

	private static final FrontEnd fe = new FrontEnd();
	
	
	@Test
	public void testNoSuchUser() {
		assertEquals(0, fe.login("tinytina", "password"));
		/* Console will say
		 * Username and password not found
		 * and the return to the 'main' screen.
		 * Type 'exit' to move to next test.
		 */
	}
	@Test
	public void testExistingUser() {
		assertTrue(fe.login("Pepsi Cola", "reallyn0tcol@") > 0);
		/*Consoe should say
		 * Success!
		 * and give a list of commands to use
		 * Type 'exit' to move to the next test.
		 */
	}
	@Test
	public void testNewUserExists() {
		try {
			fe.newUser("Pepsi Cola", "funkynewpassword");
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		/* Console should say:
		 * User already exists
		 * Type 'exit' to move to the next test.
		 */
	}
	
	@Test
	public void testTooShortPassword() {
		try {	fe.newUser("TinyTina", "pass");
		} catch (SQLIntegrityConstraintViolationException e) {
			assertTrue(true);
		}
	} 
	
	@Test
	public void testInvalidWithdraw() {
		fe.login("tinytina", "missesroland");
		/* Once logged in type
		 * 'deposit' and then '999'
		 * The console should give an insufficient funds message.
		 */
	}
	@Test
	public void testInvalidInputOnDeposit() {
		fe.login("tinytina", "missesroland");
		/*Once logged in type
		 * 'deposit' and then 'asdf'
		 * The console should say Invalid Input and prompt to enter a whole number
		 * Inside the login method there is an internal try-catch for numberformat exceptions
		 */
	}
	@Test
	public void testInvalidInputOnWithdraw() {
		fe.login("tinytina",  "missesroland");
		/*Once logged in type
		 * 'withdraw' and then 'asdf'
		 * The console should say Invalid Input and prompt to enter a whole number
		 * Inside the login method there is an internal try-catch for numberformat exceptions
		 */
	}
}
