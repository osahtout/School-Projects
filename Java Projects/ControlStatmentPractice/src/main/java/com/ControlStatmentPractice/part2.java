// Assignment (2)
// Written by: (Omar Sahtout 40018126)
// For COMP 248 Section (P PA?) – Fall 2017
// Use: determine the fine and demerit point depending on the speed of the driver
// --------------------------------------------------------
package com.ControlStatmentPractice;
import java.util.Scanner;

public class part2 {

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
			
			System.out.print("How fast was driver going?: ");
				int speed = in.nextInt();
				int adddem = 0;                //******this is for each case, it will assign the number of points that will be added******
				
					if (speed < 111)
							System.out.println("Driver driving too slow for a speeding ticket");
						else if (speed > 100 && speed < 111) {					
							System.out.println("The fine is 65$ but no demerit points.");}
						
						else if (speed > 110 && speed < 120) {
								adddem = 2;
							System.out.println("The fine is 120$ and the driver get 2 points.");}
						
						else if (speed > 119 && speed < 140) {
								adddem = 5;
							System.out.println("The fine is 240$ and the driver get 5 points.");}
						
						else if (speed > 139 && speed < 160) {
								adddem = 7;
							System.out.println("The fine is 360$ and the driver gets 7 points.");}
											
							else 
								System.out.println("The driver loses their license, their car and is fined 520$.");
					
					// ******each speed zone prints a fine and assigns the demerit points*******
					
		if (speed >100 && speed <160) {
			System.out.print("How How many demerit points did the driver have prior to being stopped?: ");
				int dem = in.nextInt();
					System.out.println("the driver now has " + (dem = dem + adddem) + ".");
				
					if (dem >= 12)
						System.out.println("The driver has over 12 and the license is revoked!");}
							
								     //*****asks for current demerit points and adds the assigned points depending on the speed*****
									// *****if more than 12 is accumulated then license is revoked*****
						
	System.out.println("Thank you for using this program.");
in.close();
	}

}
