// -------------------------------------------------------
// Assignment (2)
// Written by: (Omar Sahtout 40018126)
// For COMP 248 Section (P PA?) � Fall 2017
// Purpose is to display the day depending on the number using if/else
// --------------------------------------------------------
package com.ControlStatmentPractice;
import java.util.Scanner;

public class part1ifelse {

public static void main(String[] args) {	
	Scanner in = new Scanner(System.in);
			
		System.out.print("Enter a number for the day of the week: ");
				int day = in.nextInt();
			
			if (day == 1) 
					System.out.print("Monday, a weekday :(");
				else if(day == 2)
					System.out.println("Tuesday, a weekday :(");
				else if(day == 3)
					System.out.println("Wednesday, a weekday :(");
				else if(day == 4)
					System.out.println("Thursday, a weekday :(");
				else if(day == 5)
					System.out.println("It's Friday \nFinally the weekend!");
				else if(day == 6)
					System.out.println("It's Saturday \nThe weekend yaay");
				else if(day == 7)
					System.out.println("It's Sunday \ntill the weekend");
			else 
				System.out.println("That's not a day of the week!");
						
						// ***displays the days depending on the user input
						//   if input is 1 then display Monday or it displays the day it the number is assigned
						//   if it's not between 1-7 input then displays error***
			
			
in.close();
	} 
 
}
