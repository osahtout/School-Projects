package com.CourseSequence;

import java.util.Scanner;

public class Course implements Cloneable, DirectlyRelatable{

	private String courseID, courseName, preReqID, coReqID;
	private double credit;
	Scanner key = new Scanner (System.in);

	
		public Course() {
		//	System.out.println("Creating a Course using the DEFAULT construtor...");
			courseID = "N/A";
			courseName = "N/A";
			preReqID = "NONE";
			coReqID = "NONE";
			credit = 0;
		}
		
		public Course(String courseID, String courseName,double credit, String preReqID, String coReqID) {
		//	System.out.println("Creating a Course using the 5 paramteized construtor...");
			
			this.courseID = courseID;
			this.courseName = courseName;
			this.credit = credit;
			this.preReqID = preReqID;
			this.coReqID = coReqID;
		}
		
		public Course(Course c, String courseIDs) {
		//	System.out.println("Calling the COPY constructor");
			courseID = courseIDs;
			courseName = c.courseName;
			preReqID = c.preReqID;
			coReqID = c.coReqID;
			credit = c.credit;
		}
		
		public Course clone() throws CloneNotSupportedException { //DO THIS 
			System.out.println("Creating a copy using the CLONE method");
			
			System.out.println("Please enter the new Course ID:");
			String anotherCourseID = key.nextLine();
			//super.clone();
			//Course c = new Course(this, anotherCourseID);
			return new Course(this, anotherCourseID);
			
		}
	
	
		public String getCourseID() {
			return courseID;
		}
		public String getCourseName() {
			return courseName;
		}
		public String getPreReqID() {
			return preReqID;
		}
		public String getCoReqID() {
			return coReqID;
		}
		public double getCredit() {
			return credit;
		}
		
		
		
		public void setCourseID(String c) {
			courseID = c;
		}
		public void setCourseName(String c) {
			courseName = c;
		}
		public void setPreReqID(String c) {
			preReqID = c;
		}
		public void setCoReqID(String c) {
			coReqID = c;
		}
		public void setCredit(double c) {
			credit = c;
		}
		
		
		
	/*	public String toString() {
			return "Name of the course: "+courseName+"\n"
					+"Prerequisite: "+ preReqID+"\n"
					+"coReqID: "+coReqID+"\n"
					+"credt: "+credit+"\n"
					+"Course ID: "+courseID;
		}	*/
		
		public String toString() {
			return "Course ID: "+courseID+"\n"
					+"Name of the course: "+courseName+"\n"
					+"Prerequisite: "+ preReqID+"\n"
					+"coReqID: "+coReqID+"\n"
					+"credt: "+credit;
					
		}
		
		public boolean equals(Object x) {
			if (x==null || x.getClass() != this.getClass() || this == null) {
				return false;
			}
			else {
				Course c = (Course) x;
				return (this.courseName == c.courseName && this.preReqID == c.coReqID
						&& this.coReqID == c.coReqID && this.credit == c.credit);
			}
		
		}

		
		public boolean isDirectlyRelatable(Course c) {
			
			return (c.courseName.equals(this.preReqID) || c.courseName.equals(this.coReqID));
		
		}
		
		
		
		
		
		
		
		
		
		
}
