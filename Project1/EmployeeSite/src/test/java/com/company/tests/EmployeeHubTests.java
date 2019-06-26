package com.company.tests;


import static org.junit.Assert.*;
import org.junit.Test;

import com.company.services.EmployeeService;
import com.company.services.ReimbursementService;


public class EmployeeHubTests {
	private EmployeeService es = new EmployeeService();
	private ReimbursementService rs = new ReimbursementService();
	
	
	/*
	 * EMPLOYEE SERVICE TESTS
	 */
	@Test
	public void testEmpSerConvertPhoneCorrect() {
		assertEquals(17158911069L,es.convertPhoneString("1-715-891-1069"));
	}
	
	
	@Test
	public void testEmpSerConvertPhoneTooLong() {
		assertEquals(0,es.convertPhoneString("1239239234898923489284003"));
	}
	
	@Test
	public void testEmpSerConvertPhoneNull() {
		assertEquals(0, es.convertPhoneString(null));
	}
	
	@Test
	public void testEmpSerConvertPhoneEmpty() {
		assertEquals(0,es.convertPhoneString(""));
	}
	
	@Test
	public void testEmpSerConvertIdCorrect() {
		assertEquals(100001,es.convertIdString("100001"));
	}
	
	@Test
	public void testEmpSerConvertIdNotNumber() {
		assertEquals(0,es.convertIdString("asdfadf"));
	}
	
	@Test
	public void testEmpSerConvertIdNull() {
		assertEquals(0,es.convertIdString(null));

	}
	
	@Test
	public void testEmpSerConvertIdEmpty() {
		assertEquals(0,es.convertIdString(""));
	}
	
	@Test
	public void testEmpSerGenPasswordCorrect() {
		assertEquals("DustinMartin2",es.generatePassword("Dustin", "Martin", 100002));
	}
	
	@Test
	public void testEmpSerGenPasswordNull() {
		assertEquals(null,es.generatePassword(null, "Martin", 100002));
		assertEquals(null,es.generatePassword("Dustin", null, 100002));
	}
	
	@Test
	public void testEmpSerGenPasswordEmpty() {
		assertEquals(null,es.generatePassword("", "Martin", 100002));
		assertEquals(null,es.generatePassword("Dustin", "", 100002));
	}
	
	@Test
	public void testEmpSerGenPassword0Id() {
		assertEquals(null, es.generatePassword("Dustin", "Martin", 0));	
	}
	
	@Test
	public void testEmpSerGenEmailCorrect() {
		assertEquals("DustinMartin2@company.com",es.generateEmail("Dustin", "Martin", 100002));
	}
	
	@Test
	public void testEmpSerGenEmailNull() {
		assertEquals(null,es.generateEmail(null, "Martin", 100002));
		assertEquals(null,es.generateEmail("Dustin", null, 100002));
	}
	
	@Test
	public void testEmpSerGenEmailEmpty() {
		assertEquals(null,es.generateEmail("", "Martin", 100002));
		assertEquals(null,es.generateEmail("Dustin", "", 100002));
	}
	
	@Test
	public void testEmpSerGenEmail0Id() {
		assertEquals(null, es.generateEmail("Dustin", "Martin", 0));	
	}
	
	
	/*
	 * REIMBURSEMENT SERVICE TESTS
	 */
	@Test
	public void testReiSerConvertStrToIntCorrect() {
		assertEquals(100001,rs.convertStringToInt("100001"));
	}
	
	@Test
	public void testReiSerConvertStrToIntIncorrect() {
		assertEquals(0,rs.convertStringToInt("sajkdfjasldk"));
	}
	
	@Test
	public void testReiSerConvertStrToIntNull() {
		assertEquals(0,rs.convertStringToInt(null));
	}
	
	@Test
	public void testReiSerConvertStrToIntEmpty() {
		assertEquals(0,rs.convertStringToInt(""));
	}
	
	
}
