package com.revature;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AnnotationTest {

	
	@Before
	public void runBefore() {
		System.out.println("called runBefore method");
	}
	
	@After
	public void runAfter() {
		System.out.println("called runAfter method");
	}
	
	@Test 
	public void testOne() {
		System.out.println("Called test one");
		assertEquals(5,5);
	}
	
	
	@Test 
	public void testTwo() {
		System.out.println("Called test two");
		assertArrayEquals(new int[] {5,3,1}, new int[] {5,3,1});
	}
	
	@Test 
	@Ignore
	public void testThree() {
		System.out.println("Called test two");
		fail("test three failed");
	}
}
