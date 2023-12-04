package com.example;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test {
	
	Graph townGraph;

	Town town1;
	Town town2;
	Town town3;
	Town town4;
	Town town5;
	
	@Before
	public void setUp() throws Exception {
		townGraph = new Graph();
		
		town1 = new Town("test1");
		town2 = new Town("test2");
		town3 = new Town("test3");
		town4 = new Town("test4");
		town5 = new Town("test5");
		
		townGraph.addVertex(town1);
		townGraph.addVertex(town2);
		townGraph.addVertex(town3);
		townGraph.addVertex(town4);
		townGraph.addVertex(town5);
		
		townGraph.addEdge(town1, town2, 1, "road1");
		townGraph.addEdge(town1, town3, 2, "road2");
		townGraph.addEdge(town2, town3, 3, "road3");
		townGraph.addEdge(town3, town4, 4, "road4");
		townGraph.addEdge(town4, town5, 5, "road5");

	}

	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = town4 = town5 = null;
		townGraph = null;
	}

	@Test
	public void testGetEdge() {
		assertTrue(townGraph.getEdge(town1, town2).getName().equals("road1"));
		assertTrue(townGraph.getEdge(town3, town4).getName().equals("road4"));
		assertTrue(townGraph.getEdge(town4, town5).getName().equals("road5"));
	}

	@Test
	public void testAddEdge() {
		townGraph.addEdge(town4, town1, 6, "road6");
		assertTrue(townGraph.getEdge(town4, town1).getName().equals("road6"));
		
		townGraph.addEdge(town1, town5, 7, "road7");
		assertTrue(townGraph.getEdge(town1, town5).getName().equals("road7"));
		
		townGraph.addEdge(town2, town4, 8, "road8");
		assertTrue(townGraph.getEdge(town2, town4).getName().equals("road8"));
		
		townGraph.addEdge(town4, town3, 9, "road9");
		assertFalse(townGraph.getEdge(town4, town3).getName().equals("road9"));
		
	}

	@Test
	public void testAddVertex() {
		Town town6 = new Town("town6");
		Town town7 = new Town("town7");
		
		townGraph.addVertex(town6);
		assertTrue(townGraph.containsVertex(town6));
		
		assertFalse(townGraph.containsVertex(town7));
		
		townGraph.addVertex(town7);
		assertTrue(townGraph.containsVertex(town7));
	}

	@Test
	public void testContainsEdge() {
		assertTrue(townGraph.containsEdge(town1, town2));
		assertTrue(townGraph.containsEdge(town1, town3));
		assertFalse(townGraph.containsEdge(town4, town1));
	}

	@Test
	public void testContainsVertex() {
		assertTrue(townGraph.containsVertex(town1));
		assertTrue(townGraph.containsVertex(town4));
		assertTrue(townGraph.containsVertex(town3));
		
		Town town1 = new Town("town1");
		
		assertFalse(townGraph.containsVertex(town1));
	}

	@Test
	public void testRemoveVertex() {
		townGraph.removeVertex(town1);
		assertFalse(townGraph.containsVertex(town1));
		assertFalse(townGraph.containsEdge(town1, town2));
	}

	@Test
	public void testVertexSet() {
		Set<Town> townSet = townGraph.vertexSet();
		
		assertTrue(townSet.contains(town1));
		assertTrue(townSet.contains(town2));
		assertTrue(townSet.contains(town3));
		assertTrue(townSet.contains(town4));
		assertTrue(townSet.contains(town5));
	}

}
