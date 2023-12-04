package com.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {

	Town town1;
	Town town2;
	Town town3;
	Town town4;
	Town town5;
	
	Road road1;
	Road road2;
	Road road3;
	Road road4;
	Road road5;
	
	@Before
	public void setUp() throws Exception {
		town1 = new Town("road1");
		town2 = new Town("road2");
		town3 = new Town("road3");
		town4 = new Town("road4");
		town5 = new Town("road5");
		
		road1 = new Road(town1, town2, 1, "road1");
		road2 = new Road(town1, town3, 2, "road2");
		road3 = new Road(town2, town3, 3, "road3");
		road4 = new Road(town3, town4, 4, "road4");
		road5 = new Road(town4, town5, 5, "road5");
	}

	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = town4 = town5 = null;
		road1 = road2 = road3 = road4 = road5 = null;
	}

	@Test
	public void containsTest() {
		assertTrue(road1.contains(town1));
		assertTrue(road1.contains(town2));
		assertFalse(road5.contains(town3));
		
		assertTrue(road3.contains(town2));
		assertFalse(road3.contains(town5));
	}
	
	@Test
	public void equalsTest() {
		Road road6 = new Road(town1,town2, 1, "road1");
		assertTrue(road1.equals(road6));
		assertFalse(road3.equals(road1));
		assertFalse(road4.equals(road5));
		assertFalse(road6.equals(road4));
	}
	
	@Test
	public void getNameTest() {
		assertTrue(road1.getName().equals("road1"));
		assertTrue(road2.getName().equals("road2"));
		assertFalse(road3.getName().equals("road3"));
	}
	
	@Test
	public void getDistanceTest() {
		assertEquals(road1.getDistance(), 1);
		assertEquals(road2.getDistance(), 2);
		assertEquals(road3.getDistance(), 3);
		assertEquals(road4.getDistance(), 4);
	}
	
	@Test
	public void compareToTest() {
		assertTrue(road1.compareTo(road2) < 0);
		assertTrue(road4.compareTo(road2) > 0);
		assertFalse(road4.compareTo(road1) < 0);
	}

}
