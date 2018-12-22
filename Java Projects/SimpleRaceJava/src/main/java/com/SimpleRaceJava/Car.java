/**********************************************************************
Name: Omar Sahtout
ID:   40018126
Purpose: Try racing object cars

************************************************************************/
package com.SimpleRaceJava;
public class Car {

	private String Model;
	private int Location, currentSpeed, maxSpeed;
	private boolean movingForward;
	private boolean crashed, podium;
	private boolean[] special = new boolean[52];
	
	public Car() {
		Model = "Ford Model A";
		Location = 0;
		currentSpeed = 0;
		maxSpeed = 0;
		movingForward = true;
		crashed = false;
		podium=false;
	}
	public Car(String newModel, int newmaxSpeed, int initialLocation) {
		Model = newModel;
		if (newmaxSpeed <0 || initialLocation <0) {
			System.out.println("Please enter a value ovwer 0");
			System.exit(0);
		}
		else {
		maxSpeed = newmaxSpeed;
		Location = initialLocation;
		}
		movingForward = true;
		currentSpeed =0;	
		crashed = false;
		podium=false;}
	//Part 2
	public Car(String newModel, int newMaxSpeed) {
		this.Model=newModel;
		maxSpeed=newMaxSpeed;
		Location=0;
		movingForward=true;
		currentSpeed=0;
		crashed = false;
		podium=false;
	}
	
	public Car (Car c) {
		new Car(c.getModel(), c.getSpeed(),c.getLocation());
		
	}
	public void setModel(String newModel) {
		this.Model=newModel;
	}
	public void setCurrentSpeed(int newSpeed) {
		this.currentSpeed=newSpeed;
	}
	public void setCrashed(boolean b) {
		this.crashed=true;
	}
	public void setPodium(boolean b) {
		this.podium=b;
	}
	
	
	
	public String getModel() {
		return Model;
	}
	public boolean getDirection() {
		return movingForward;
	}
	public int getLocation() {
		return Location;
	}
	public int getSpeed() {
		return currentSpeed;
	}
	public boolean getCrashed() {
		return crashed;
	}
	public boolean getPodium() {
		return podium;
	}
	public int go(int maxSpeed) {
		currentSpeed = maxSpeed;
		return currentSpeed;
	}
	public int stop() {
		return currentSpeed=0;
	}
	public boolean turnAround() {
		{
		if (movingForward==true) {
			movingForward=false; }
		else if(movingForward==false) {
			movingForward=true;	}}
		return movingForward;
	}
	public int move() {
		if (movingForward==true) {
			Location = Location+currentSpeed;
		}
		else if (movingForward==false) {
			Location=Location-currentSpeed;
		}return Location;
	}
	public int getTopSpeed() {
		return maxSpeed;
	}
	//Part 2
	public int accelerate() {
		if (currentSpeed<maxSpeed)
			currentSpeed += 1;
		return currentSpeed;
	}
	public int brake() {
		if (currentSpeed>=0)
			currentSpeed-=1;
		return currentSpeed;
	}
	

	
	public String toString() 
	{		
		return "The "+Model+" has a Top Speed of "+maxSpeed+", Located at "+Location+" and is facing "
		+(getDirection()? (String) "forward":(String) "backwards")+(getSpeed()>0? (" with a speed of "+currentSpeed):(String)" Not Moving");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}