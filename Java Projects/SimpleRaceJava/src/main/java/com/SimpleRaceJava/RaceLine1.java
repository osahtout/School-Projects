/**********************************************************************
Name: Omar Sahtout
ID:   40018126
Purpose: Try racing object cars

************************************************************************/
package com.SimpleRaceJava;
import java.util.Scanner;
public class RaceLine1 {


	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		String newName1;
		String name;
		int newmaxSpeed1,newmaxSpeed2;
		int initialLocation1,initialLocation2;

		
		
		System.out.println("Enter the model of the first car: ");
			newName1=in.nextLine();
		System.out.println("Enter the top speed of the first car: ");
			newmaxSpeed1=in.nextInt();	
		System.out.println("Enter the initial location of the first car: ");
			initialLocation1=in.nextInt();
	Car car1 = new Car(newName1, newmaxSpeed1, initialLocation1);	
			
		System.out.println("");
		in.nextLine();
		
		System.out.println("Enter the model of the second car: ");
			name=in.nextLine();
		System.out.println("Enter the top speed of the second car: ");
			newmaxSpeed2=in.nextInt();
		System.out.println("Enter the initial location of the second car: ");
			initialLocation2=in.nextInt();    
		
			Car car2 = new Car(name, newmaxSpeed2, initialLocation2);

		System.out.println(car1.toString()+"\n"+car2.toString()+"\n");
		
		if (car1.getLocation()>car2.getLocation()) {
			car1.turnAround();
		}else
			car2.turnAround();
		
		System.out.println(car1.toString()+"\n"+car2.toString()+"\n");
		
		
		car1.go(newmaxSpeed1);
		car2.go(newmaxSpeed2);
		
		
		//********crash********
		if (initialLocation1<initialLocation2) {
			while (car1.getLocation()!=car2.getLocation()&&car2.getLocation()>car1.getLocation()) {
					car1.move();
					car2.move();
					System.out.println(car1.toString()+"\n"+car2.toString()+"\n");			
																									}
						System.out.println("boom!");
												}
		else if (initialLocation2<initialLocation1) {
			while (car1.getLocation()!=car2.getLocation()&&car1.getLocation()>car2.getLocation()) {
					car1.move();
					car2.move();
					System.out.println(car1.toString()+"\n"+car2.toString()+"\n");			
																									}
						System.out.println("boom!");
												}
		//*********end Crash************
		
		
		
			
			
			
		
		in.close();
	}

}
