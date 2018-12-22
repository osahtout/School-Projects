/**********************************************************************
Name: Omar Sahtout
ID:   40018126
Purpose: Try racing object cars
|||||||||||||||I did not get to complete the program, bug fixes and finishing touches||||||||||||||
************************************************************************/
package com.SimpleRaceJava;
import java.util.Scanner;
public class RaceLine2 {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
			int crash=0;
			int nbWinners =0;
			
			
			String[][] myPhone2D = new String[5][10];
			
				for (int i=0;i<myPhone2D.length;i++) {
					for (int j=0;j<myPhone2D[i].length;j++) {
						myPhone2D[i][j]="8482424";
						}
				}
				for (int i=0;i<myPhone2D.length;i++) {
					for (int j=0;j<myPhone2D[i].length;j++) {
						System.out.print(myPhone2D[i][j]+"  ");
						}
					System.out.println();
				}
				System.out.println("\n");
				
				for (int i=0;i<myPhone2D.length;i++) {
					for (int j=0;j<myPhone2D[i].length;j++) {
						myPhone2D[0][j]="1";
						}
				}
			
			
				for (int i=0;i<myPhone2D.length;i++) {
					for (int j=0;j<myPhone2D[i].length;j++) {
						System.out.print(myPhone2D[i][j]+"  ");
						}
					System.out.println();
				}
			
		
		  
			//user inputs size of array and laps
			System.out.println("how many race cars? ");
				int	nbCars = in.nextInt();
				
			System.out.println("How many laps?");
				int lap =in.nextInt();
			int	raceLength=lap*100;
					
			//array of objects
			Car[] arrayOfCars = new Car[nbCars];
			
			//user inputs for constructor
				for (int i=0; i<nbCars;i++) {				
					System.out.println(" ");
					String	ans=in.nextLine();	// garbage input for nextLine
					
					//inputs the model and top speed into the array
					System.out.println("enter the name for car "+ (i+1));  
					String	aModel=in.nextLine();
				int topSpeed;
				do {			
					System.out.println("enter the speed of car "+(i+1)+" (2-7)"); //input max speed
					topSpeed=in.nextInt();
				}while(topSpeed<2||topSpeed>7);  
				
					//new array filled with objects
					arrayOfCars[i]= new Car(aModel, topSpeed);	
					
				}
				//array to be filled with winners
				int[] winners = new int[nbCars+1];
						int carsLeft = nbCars;  
				
			  
			  for (int z=0;z<nbCars;z++) {			
	do {			
			  	
		for (int j=0;j<nbCars;j++) {				
			
			
			//accelerate if race is not finished or not crashed
			if(arrayOfCars[j].getLocation()<raceLength & arrayOfCars[j].getCrashed()==false)
					arrayOfCars[j].accelerate();
						
				//moves regardless (if crashed, speed should be 0)
					arrayOfCars[j].move();
					
			//stops if finished race
			//should add if .getCrashed==true but it creates an infinite loop
			if (arrayOfCars[j].getLocation()>raceLength) {
				arrayOfCars[j].setCurrentSpeed(0);
				arrayOfCars[j].setPodium(true);
			}
			
			//incorporates the crash algorithm method
			//
		else	if (arrayOfCars[j].getLocation()>100) {
					if (crashForI(arrayOfCars, j)==true) {
						carsLeft-=1;
						crash +=1;
						
						arrayOfCars[j].setCrashed(true);

				}
			}			
			
			for(int i=0;i<nbCars;i++) {
				if (arrayOfCars[i].getCrashed()==true)
					arrayOfCars[i].setCurrentSpeed(0);
			}
			
				
					System.out.println(arrayOfCars[j].toString());
			
	//**********		
/*		if (race[j].getLocation()>raceLength) {
					race[j].stop();

			}
			else
				race[j].accelerate();
								
					race[j].move();
					
								
				System.out.println(race[j].toString());
					
				
				if (race[j].getLocation()>100) {
					if (crashForI(race, j)) {
						crash +=1;
						race[j].stop();
					}
				}			*/
					
				
					
				//	adding winners to new array 
				// should take the whats left of the cars and add them to anew array
		for(int i=0;i<3;i++){
			if((arrayOfCars[i].getLocation()>raceLength)&(arrayOfCars[i].getPodium()==true)){
				winners[nbWinners] = i;
				carsLeft--;
				nbWinners++;
						}}
				//outputing winners, should t
		if((nbWinners<=3)){
			System.out.println("Winners are: ");
				for(int k=0;k<nbWinners;k++){
			System.out.println(arrayOfCars[winners[k]].toString());
				}}
						
							
							}
		System.out.println("there is "+crash+" crashes");
	}while(arrayOfCars[z].getLocation()<raceLength || nbWinners==3 || crash==3);
	}  
		  

		in.close();
		
	
	
	
}
		//crash algorithm
	//Iterates though the array and check if 2 has the same location, if they do it checks
	//if a third has the same location
	public static boolean crashForI(Car[] race, int carI){

		int carInPotentialCrash = 0;

		for (int i = 0; i < race.length; i++){

				if (race[i].getLocation() == race[carI].getLocation()){
					carInPotentialCrash++;
					
				}	
		}

		if (carInPotentialCrash >= 3)
			return true;
		else
			return false;
		}
	
	
	
	
	public static void resetCrash(Car[] race, int CarI) {
		int potentialCrash = 0;
		for (int i=0;i<race.length;i++) {
			if (race[i].getLocation()==race[CarI].getLocation()) {
				potentialCrash++;
				if (potentialCrash >= 3)
					race[i].stop();
					race[CarI].stop();
			}
		}
	}
		
	
	
	
		
	}

