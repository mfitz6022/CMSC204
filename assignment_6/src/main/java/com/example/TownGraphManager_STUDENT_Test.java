package com.example;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test {
	
	TownGraphManager TGM;

	String town1;
	String town2;
	String town3;
	
	@Before
	public void setUp() throws Exception {
		TGM = new TownGraphManager();
		
		town1 = "town1";
		town2 = "town2";
		town3 = "town3";
		
		TGM.addTown(town1);
		TGM.addTown(town2);
		TGM.addTown(town3);
		
		TGM.addRoad(town1, town2, 1, "road1");
		TGM.addRoad(town1, town3, 2, "road2");
		TGM.addRoad(town2, town3, 3, "road3");
		
	}

	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = null;
		TGM = null;
	}

	@Test
	public void testAddRoad() {
		TGM.addRoad(town3, town1, 4, "road4");
		assertTrue(TGM.getRoad(town3, town1).equals("road4"));
	}

	@Test
	public void testGetRoad() {
		assertTrue(TGM.getRoad(town1, town2).equals("road1"));
		assertTrue(TGM.getRoad(town1, town3).equals("road2"));
		assertTrue(TGM.getRoad(town2, town3).equals("road3"));
	}

	@Test
	public void testAddTown() {
		String town4 = "town4";
		String town5 = "town5";
		
		TGM.addTown(town1);

		assertTrue(TGM.containsTown(town1));
		
		assertFalse(TGM.containsTown(town5));
	}

	@Test
	public void testGetTown() {
		assertNotNull(TGM.getTown("town1"));
		assertNotNull(TGM.getTown("town2"));
		assertNotNull(TGM.getTown("town3"));
		assertNull(TGM.getTown("town4"));
	}

	@Test
	public void testContainsTown() {
		assertTrue(TGM.containsTown(town1));
		assertFalse(TGM.containsTown("town4"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertTrue(TGM.containsRoadConnection(town1, town2));
		assertTrue(TGM.containsRoadConnection(town1, town3));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> allRoads = TGM.allRoads();
		assertTrue(allRoads.contains("road1"));
		assertTrue(allRoads.contains("road2"));
		assertTrue(allRoads.contains("road3"));
	}

	@Test
	public void testDeleteRoadConnection() {
		TGM.deleteRoadConnection(town1, town2, "road1");
		assertFalse(TGM.containsRoadConnection(town1, town2));
	}

	@Test
	public void testDeleteTown() {
		TGM.deleteTown(town1);
		assertFalse(TGM.containsTown(town1));
	}

	@Test
	public void testAllTowns() {
		ArrayList<String> townList = TGM.allTowns();
		assertTrue(townList.contains("town1"));
		assertTrue(townList.contains("town2"));
		assertTrue(townList.contains("town3"));
	}

}
