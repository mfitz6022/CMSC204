package com.example;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBManagerSTUDENT_Test {
	private CourseDBManager manager = new CourseDBManager();

	@Before
	public void setUp() throws Exception {
		manager = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		manager = null;
	}

	@Test
	public void testAddToDB() {
		try {
			manager.add("CMSC204",12345,4,"CS211","David K.");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	public void testShowAll() {
		manager.add("ARTT225",54321,3,"AR403","A. Miller");
		manager.add("MATH182",10293,4,"DL","Dr. Math");
		manager.add("CMSC206",98765,4,"SC123","Dr. Python");
		manager.add("CMSC253",11111,4,"DL","Dr. Linux");
		ArrayList<String> list = manager.showAll();
		
  		assertEquals(list.get(0),"\nCourse:ARTT225 CRN:54321 Credits:3 Instructor:A. Miller Room:AR403");
  		assertEquals(list.get(1),"\nCourse:MATH182 CRN:10293 Credits:4 Instructor:Dr. Math Room:DL");
		assertEquals(list.get(2),"\nCourse:CMSC206 CRN:98765 Credits:4 Instructor:Dr. Python Room:SC123");
		assertEquals(list.get(3),"\nCourse:CMSC253 CRN:11111 Credits:4 Instructor:Dr. Linux Room:DL");
	}

}
