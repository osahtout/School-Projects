package com.CarDemo;

public class CarDemo {

	public static void main(String[] args) {
		Car honda = new Car(3,25000);
		Car toyota = new Car(3, 32000, "sedan");
		Car RangeRover = new Car(7,45000, "SUV");
		

			System.out.println("for the Honda :"+honda+"\n"+toyota+"\n"+RangeRover);
			System.out.println(honda.estimatePrice());
			System.out.println(RangeRover.estimatePrice());
			System.out.println("the equlity of these cars is "+honda.equals(RangeRover));
			System.out.println("the equality of  cars ithe honda and the toyota is "+honda.equals(toyota));
System.out.print("\n");
			System.out.println("the car type for RangeRover is "+RangeRover.getType()+" its age is "+RangeRover.getAge()+" and it cost "+RangeRover.getCost());
System.out.print("\n");			
			
			honda.setAge(7);
			System.out.print("the new age for honda is: "+honda.getAge()+" and the new "+honda.estimatePrice());
			
	
	
	
	}
}
