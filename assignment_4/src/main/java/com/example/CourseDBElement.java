package com.example;

public class CourseDBElement implements Comparable<CourseDBElement> {
	private String courseID;
	private int crn;
	private int credits;
	private String roomNumber;
	private String instructorName;
	
	public CourseDBElement() {
		courseID = "";
		crn = 0;
		credits = 0;
		roomNumber = "";
		instructorName = "";
	}
	
	public CourseDBElement(String courseID, int crn, int credits, String roomNumber, String instructorName) {
		this.courseID = courseID;
		this.crn = crn;
		this.credits = credits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}

	@Override
	public int hashCode() {
		String temp = "" + crn;
		return temp.hashCode();
	}

	@Override
	public int compareTo(CourseDBElement db) {
		if (crn > db.crn)
			return 1;
		else if (crn < db.crn)
			return -1;
		else
			return 0;
	}
	
	public String getID() {
		return courseID;
	}


	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}


	public int getCRN() {
		return crn;
	}


	public void setCRN(int crn) {
		this.crn = crn;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getRoomNum() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

}
