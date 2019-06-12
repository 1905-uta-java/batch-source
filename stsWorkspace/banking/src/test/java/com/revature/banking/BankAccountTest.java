package com.revature.banking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mdo.util.Input;
import com.revature.pZero.model.BankAccount;

public class BankAccountTest {
	
	private static final BankAccount bankAccount = new BankAccount();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	
	/**
	 * Test deposit()
	 */
	@Test
	public void testExpectedInput() {
		assertTrue(bankAccount.deposit(200.00));
	}
	
	@Test
	public void testNegativeInput() {
		assertFalse(bankAccount.deposit(-200.00));
	}
	
	
	/**
	 * Test withdraw()
	 */
	@Test
	public void testExpectedWithdraw() {
		BankAccount temp = new BankAccount();
		temp.setAmount(400);
		assertTrue(temp.withdraw(300));
	}
	
	@Test
	public void testUnexpectedWithdraw() {
		BankAccount temp = new BankAccount();
		temp.setAmount(200);
		assertFalse(temp.withdraw(300));
	}
	
	@Test
	public void testWithdrawNegative() {
		assertFalse(bankAccount.withdraw(-500));
	}
	
	
	
	/**
	 * Test Input verifying methods
	 * Doubles
	 */
	@Test
	public void testInputDoubleExpected() {
		assertTrue(Input.isInputDouble("52.00"));
	}
	
	@Test
	public void testInputNegativeDoubleExpected() {
		assertTrue(Input.isInputDouble("-52.00"));
	}
	
	@Test
	public void testInputDoubleUnexpected() {
		assertFalse(Input.isInputDouble("Hello World"));
	}
	
	@Test
	public void testInputDoubleUnexpectedSpace() {
		assertFalse(Input.isInputDouble(" "));
	}
	
	@Test
	public void testInputDoubleUnexpectedManySpace() {
		assertFalse(Input.isInputDouble("           "));
	}
	
	/**
	 * Test Input verifying methods
	 * Int
	 */
	@Test
	public void testInputIntExpected() {
		assertTrue(Input.isInputInt("52"));
	}
	
	@Test
	public void testNegativeInputIntExpected() {
		assertTrue(Input.isInputInt("-52"));
	}
	
	@Test
	public void testInputIntUnexpected() {
		assertFalse(Input.isInputInt("Hello World"));
	}
	
	@Test
	public void testInputIntUnexpectedSpace() {
		assertFalse(Input.isInputInt(" "));
	}
	
	@Test
	public void testInputIntUnexpectedManySpace() {
		assertFalse(Input.isInputInt("           "));
	}

	

}
