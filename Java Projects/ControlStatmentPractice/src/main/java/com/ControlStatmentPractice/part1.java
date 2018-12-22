// -------------------------------------------------------
// Assignment (2)
// Written by: (Omar Sahtout 40018126)
// For COMP 248 Section (P PA?) – Fall 2017
// Use: to display the day depending on the number using switch statement
// --------------------------------------------------------

package com.ControlStatmentPractice;
import java.util.Scanner;

public class part1 {

public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			System.out.print("Please enter the day of the week (1-7): ");
			 int day = sc.nextInt();
			 
/* ***user inputs a number and depending on the case using the switch statement prints 
			 the day of the week*** */
			 
			switch (day) {
				case 1: System.out.println("It's Monday, a weekday :(");
					break;
				case 2: System.out.println("It's Tuesday, a weekday :(");
					break;
				case 3: System.out.println("It's Wednesday, a weekdy :(");
					break;
				case 4: System.out.println("It's Thursday, a weekday :(");
					break;
				case 5: System.out.println("It's Friday \nFinally the weekend!");
					break;
				case 6: System.out.println("It's Saturday \nThe weekend yaay");
					break;
				case 7: System.out.println("It's Sunday \nstill the weekend");
					break;
		
				 default: System.out.println("That's not a day of the week!"); 		}
			
sc.close();
			 }

}


