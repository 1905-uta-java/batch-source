package com.revature.satoshiBank;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.UserDaoImpl;
import com.revature.util.ConnectionUtil;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

	/*******************************************************************
	 * Question 1 Test if withdraw limit cannot exceed existing balance
	 ******************************************************************/
	public void testAnUnacceptableWithdraw() throws SQLException {
		Connection myConn= ConnectionUtil.getHardCodedConnection();
		CallableStatement myCallable = null;
		String userEmail = "a@g.com";
    	String password = "password";
 		Double withdrawAmount = (double) 999;    

		// prepare the stored procedure call
		String sql = "{call withdraw(?, ?)}";
		myCallable = myConn.prepareCall(sql);
		// set the parameters
		myCallable.setString(1, userEmail);
		myCallable.setDouble(2, withdrawAmount);
		// call the stored procedure
		myCallable.execute();
	}
	void assertEquals(SQLException, testAnUnacceptableDeposit());

	/*******************************************************************
	 * Question 2 Test if deposit works
	 ******************************************************************/
	
	
    /*******************************************************************
	 * Question 3 Test login
	 ******************************************************************/
    
    
    /*******************************************************************
	 * Question 4 Test logout
	 ******************************************************************/
	
	
	
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
