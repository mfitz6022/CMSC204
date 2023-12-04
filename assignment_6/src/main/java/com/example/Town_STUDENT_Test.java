package com.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {

	Town town1;
	Town town2;
	Town town3;
	Town town4;
	
	@Before
	public void setUp() throws Exception {
		town1 = new Town("town1");
		town2 = new Town("town2");
		town3 = new Town("town3");
		town3 = new Town("town4");
	}

	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = town4 = null;
	}

	@Test
	public void getNameTest() {
		assertTrue(town1.getName().equals("town1"));
		assertTrue(town2.getName().equals("town2"));
		assertTrue(town3.getName().equals("town3"));
		assertTrue(town3.getName().equals("town4"));
	}

	@Test
	public void createCopyTest() {
		Town town5 = new Town(town1);
		assertTrue(town1.equals(town5));
		
		Town town6 = new Town(town3);
		assertTrue(town3.equals(town6));
	}
	
	@Test
	public void equalsTest() {
		Town town5 = new Town("town1");
		assertFalse(town2.equals(town5));
		
		assertTrue(town3.equals(town3));
		
		Town town6 = new Town("town2");
		assertTrue(town2.equals(town6));
	}
	
	@Test
	public void compareToTest() {
		assertTrue(town1.compareTo(town2) <= 0);
		assertTrue(town3.compareTo(town4) == 0);
		assertTrue(town2.compareTo(town3) <= 0);
	}
}
