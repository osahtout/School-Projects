package com.CarDemo;

public class Car {
	private int Age;
	private String Type;
	private double Cost;
	
	
	//Constructors
	public Car(){
		Type = "sedan";
		Age = 0;		
		Cost = 32000;
	}
	public Car(double fistCost) {
		Cost = fistCost;
		Age = 0;
		Type = "sedan";
	}
	public Car(int firstAge,double fistCost) {
		Age = firstAge;
		Cost = fistCost;
		Type = "sedan";
	}
	public Car(int firstAge,double fistCost, String firstType) {
		Age = firstAge;
		Cost = fistCost;
		Type = firstType;
	}

	
	//Accessor
	public int getAge() {
		return Age;   //this??
	}
	public String getType() {
		return Type;  
	}
	public double getCost() {
		return Cost;
	}
	
	//mutators
	public void setAge(int newAge) {
		this.Age = newAge;
	}
	public void setType(String newType) {
		this.Type = newType;
	}
	public void setCost(double newCost) {
		this.Cost = newCost;
	}
	public void setnewCar3(int newAge, String newType, double newCost) {
		this.Age = newAge;
		this.Type = newType;
		this.Cost = newCost;
	}
	public void setnewCar2(int newAge, double newCost){
		this.Age = newAge;
		this.Cost = newCost;
	}

	//Estimating price base on the type and age of the car
	public String estimatePrice() {
			if (Type.equalsIgnoreCase("sedan")) {
				if (Age <=5) {
					Cost = Cost - Cost*0.1*Age;}
				else {
					Cost = Cost - Cost*0.1*5 - (Cost*0.1*5)*0.05*(Age-5);}
				}
			else if (Type.equalsIgnoreCase("SUV")){
				if (Age <=5) {
					Cost = Cost - Cost*0.08*Age;
				}else {
					Cost = Cost - Cost*0.08*5 - (Cost*0.04*(Age-5));}
			}return "Estimated price of the car is: "+Cost;
				
			
			
			//A sedan costs $32000, depreciates 10% every year in first five years and 5% every year afterwards. 
			//An SUV costs $45000, depreciates 8% every year in the first five years and 4% every year afterwards.
		}
		
	public String toString() {
		return "This car is type " +Type+". Its age is "+Age+" and it cost "+Cost;
	}

	public boolean equals(Car car2) {
		return (this.Age == car2.Age && this.Type.toString() == car2.Type.toString());
			
	}
	public boolean isGreater(Car anotherCar) {
		return (Cost>anotherCar.getCost());
		
	}
	public boolean isLess(Car anotherCar) {
		return (Cost<anotherCar.getCost());
	}
}
