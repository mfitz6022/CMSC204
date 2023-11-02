package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface 
{
	private CourseDBStructure database;
	
	public CourseDBManager() {
		database = new CourseDBStructure();
	}
	
	public CourseDBManager(int tableSize) {
		database = new CourseDBStructure(tableSize);
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement newCourse = new CourseDBElement(id, crn, credits, roomNum, instructor);
		database.add(newCourse);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return database.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner file = new Scanner(input);
		String line, id, roomNum, instructor;
		int crn, credits;
		CourseDBElement tempDBE;

		while(file.hasNext()) {
			line = file.nextLine();
			String[] array = line.split(" ");
			id = array[0];
			crn = Integer.parseInt(array[1]);
			credits = Integer.parseInt(array[2]);

			if (!array[3].equals("Distance")) {
				roomNum = array[3];
				instructor = "";

				for (int i = 4; i < array.length; i++) {
					instructor += array[i] + " ";
				}

			} else {
				roomNum = array[3] + " " + array[4];
				instructor = "";

				for(int i = 5; i < array.length; i++) {
					instructor += array[i] + " ";
				}
			}

			tempDBE = new CourseDBElement(id, crn, credits, roomNum, instructor);
			database.add(tempDBE);
		}

		file.close();
	}

	@Override
	public ArrayList<String> showAll() {
		return database.showAll();
	}
	
}
