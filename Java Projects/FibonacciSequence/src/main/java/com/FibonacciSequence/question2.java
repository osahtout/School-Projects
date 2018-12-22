// Written by: (Omar Sahtout)
// For COMP 248 Section (your section) � Fall 2017
// This program prints the fibonnaci sequence up to the users want.
// --------------------------------------------------------

//import java.util.Arrays;
package com.FibonacciSequence;
import java.util.Scanner;

public class question2 {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
			int length;
			double tax1, tax2, subtotal = 0, invalid = 0; // decleration of variables
			
		do {
		System.out.print("enter number of items boutgh [0...10]:");  
			length = in.nextInt();						
		invalid += 1;											//sets the number of elements in the array
		}while (length<0 | length >10);									//loops and adds 1 to invalid if over 100 or below 0
			double[] items = new double[length];
			
				
				for (int counter=0; counter<length; counter++)     { 			// counter for each element in array
		do {
			System.out.print("price of item "+(counter+1)+"[0...1000]: ");		
				items[counter] = in.nextDouble();								//user input for every element (counter+1) for items[0] displayed as item 1
				invalid += 1;
			}while (items[counter]<0 | items[counter]>1000);					//loops and adds 1 to invalid until user inputs proper amount
																	}
				
				do {
				System.out.print("enter the first tax rate [0...100]: ");		
					tax1 = in.nextDouble();
				invalid += 1;
				}while(tax1<0 | tax1>100);					
					tax1= tax1/100;
				do {																// for each tax, loops and add 1 to invalid until user input the right amount
					System.out.print("enter the rate of tax 2 [0...100]: ");		// then sets them below 1
					tax2 = in.nextDouble();
					invalid += 1;
				}while (tax2<0 | tax2>100);
					tax2 = tax2/100;
							
									for (double i : items) {					// sums all the elements in the array
										subtotal +=i;
												}
			
				double totaltax1 = subtotal*tax1;
				double totaltax2 = subtotal*tax2;							//calculates the total, the first and second tax
				double total = subtotal + totaltax1+totaltax2;
				
			System.out.printf("\nHere are your results:"
						+ "\n --------------- \n"
						+ "You have %.0f invalids entry\n"
						+ "subtotal: %.2f$ \n"
						+ "Tax 1: %.2f$ \n"
						+ "Tax 2: %.2f$ \n"
						+ "Total: %.2f$ \n", invalid, subtotal, totaltax1, totaltax2, total);   
				System.out.println("Thank you, come again!");
in.close();
	}

}
