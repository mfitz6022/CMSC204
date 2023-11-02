package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface 
{
	LinkedList<CourseDBElement>[] hashTable;
	private int tableSize;
	private final int DEFAULT_TABLE_SIZE = 10;
	
	public CourseDBStructure()
	{
		hashTable = new LinkedList[DEFAULT_TABLE_SIZE];
		this.tableSize = DEFAULT_TABLE_SIZE;
	}
	
	public CourseDBStructure(int tableSize)
	{
		hashTable = new LinkedList[tableSize];
		this.tableSize = tableSize;
	}
	
	public CourseDBStructure(String test, int tableSize)
	{
		hashTable = new LinkedList[tableSize];
		this.tableSize = tableSize;
	}

	@Override
	public void add(CourseDBElement element) 
	{
		int hash = element.hashCode();
		int hashIndex = hash % tableSize;

		if (hashTable[hashIndex] == null) {
			hashTable[hashIndex] = new LinkedList<CourseDBElement>();
			hashTable[hashIndex].add(element);
		}
		else if (hashTable[hashIndex].contains(element))
			return;
		else
			hashTable[hashIndex].add(element);

	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		String temp = "" + crn;
		int hash = temp.hashCode();
		int hashIndex = hash % tableSize;

		try {

			if(hashTable[hashIndex] != null) {

				for(int i = 0; i < hashTable[hashIndex].size(); i++) {
					CourseDBElement tempElement = hashTable[hashIndex].get(i);

					if(tempElement.getCRN() == crn)
						return tempElement;
				}

			}

			throw new IOException();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		
	}

	@Override
	public int getTableSize() {
		return tableSize;
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> classes = new ArrayList<String>();
		String tempString;
		CourseDBElement tempDBE;

		for(int i = 0; i < hashTable.length; i++) {

			if(hashTable[i] != null) {

				for(int j = 0; j < hashTable[i].size(); j++) {
					tempDBE = hashTable[i].get(j);

					tempString = "\nCourse:" + tempDBE.getID() + " CRN:" +
							tempDBE.getCRN() + " Credits:" +
							tempDBE.getCredits() + " Instructor:" +
							tempDBE.getInstructorName() + " Room:" +
							tempDBE.getRoomNum();
					
					classes.add(tempString);
				}
			}

		}

		return classes;
	}

}
