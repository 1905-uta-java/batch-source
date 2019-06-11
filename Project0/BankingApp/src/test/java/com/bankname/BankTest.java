package com.bankname;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bankname.util.PasswordEncryptionUtil;
import com.bankname.util.ValidationUtil;

public class BankTest {
	
	
	/*************************
	 * Testing ValidationUtil.java
	 *************************/
		//Testing validEmail()
			@Test
			public void nullValidEmail() {
				assertEquals(false, ValidationUtil.validEmail(null));
			}
			
			@Test
			public void correctValidEmail() {
				assertEquals(true, ValidationUtil.validEmail("dcm9595@gmail.com"));
			}
			
			@Test
			public void incorrectValidEmail() {
				assertEquals(false, ValidationUtil.validEmail("asdasdfasd"));
			}
			
			@Test
			public void emptyValidEmail() {
				assertEquals(false, ValidationUtil.validEmail(""));
			}
			
			
		//Testing validPassword()
			@Test
			public void nullValidPassword() {
				assertEquals(false, ValidationUtil.validPassword(null));
			}
			
			@Test
			public void correctValidPassword() {
				assertEquals(true, ValidationUtil.validPassword("Password123"));
			}
			
			@Test
			public void emptyValidPassword() {
				assertEquals(false, ValidationUtil.validEmail(""));
			}
			
						
		//Testing validDepositAmount()
			@Test
			public void nullValidDepositAmount() {
				assertEquals(false, ValidationUtil.validDepositAmount(null));
			}
			
			@Test
			public void correctValidDepositAmount() {
				assertEquals(true, ValidationUtil.validDepositAmount("159.23"));
			}
			
			@Test
			public void incorrectValidDepositAmount() {
				assertEquals(false, ValidationUtil.validDepositAmount("asdjekn"));
			}
			
			@Test
			public void emptyValidDepositAmount() {
				assertEquals(false, ValidationUtil.validDepositAmount(""));
			}
			
			
		//Testing validWithdrawAmount()
			@Test
			public void nullValidWithdrawAmount() {
				assertEquals(false, ValidationUtil.validWithdrawAmount(null, 0.0));
			}
			
			@Test
			public void correctValidWithdrawAmount() {
				assertEquals(true, ValidationUtil.validWithdrawAmount("230.09",500.93));
			}
			
			@Test
			public void incorrectValidWithdrawAmount() {
				assertEquals(false, ValidationUtil.validWithdrawAmount("asdrsd",500.95));
			}
			
			@Test
			public void toLargeAmountValidWithdrawAmount() {
				assertEquals(false, ValidationUtil.validWithdrawAmount("700.34",500.95));
			}
			
			@Test
			public void emptyValidWithdrawAmount() {
				assertEquals(false, ValidationUtil.validWithdrawAmount("", 0));
			}
			
		//Testing verifyEmail()
			@Test
			public void nullVerifyEmail() {
				assertEquals(false, ValidationUtil.verifyEmail(null));
			}
			
			@Test
			public void correctVerifyEmail() {
				assertEquals(true, ValidationUtil.verifyEmail("johnsmith@gmail.com"));
			}
			
			@Test
			public void incorrectVerifyEmail() {
				assertEquals(false, ValidationUtil.verifyEmail("randomstranger@gmail.com"));
			}
			
			@Test
			public void emptyVerifyEmail() {
				assertEquals(false, ValidationUtil.verifyEmail(""));
			}
			
		//Testing verifyPassword()
			@Test
			public void nullVerifyPassword() {
				assertEquals(false, ValidationUtil.verifyPassword(null,null));
			}
			
			@Test
			public void correctVerifyPassword() {
				assertEquals(true, ValidationUtil.verifyPassword("johnsmith@gmail.com","Passw0rd"));
			}
			
			@Test
			public void incorrectVerifyPassword() {
				assertEquals(false, ValidationUtil.verifyPassword("johnsmith@gmail.com","password"));
			}
			
			@Test
			public void emptyVerifyPassword() {
				assertEquals(false, ValidationUtil.verifyPassword("johnsmith@gmail.com",""));
			}
			
			
			
	/*************************
	 * Testing PasswordEncryptionUtil.java
	*************************/	
		//Testing encryptPassword()
			@Test
			public void nullEncryptPassword() {
				assertEquals("",PasswordEncryptionUtil.encryptPassword(null));
			}
			
			@Test
			public void correctEncryptPassword() {
				assertEquals("d41e98d1eafa6d6011d3a70f1a5b92f0",PasswordEncryptionUtil.encryptPassword("Passw0rd"));
			}
			
			

}

