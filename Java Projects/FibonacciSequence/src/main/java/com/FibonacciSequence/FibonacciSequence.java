// Written by: Omar Sahtout
// For COMP 248 Section (P Pa) � Fall 2017
// This program prints the fibonnaci sequence up to the users want.
// --------------------------------------------------------
package com.FibonacciSequence;
import java.util.Scanner;
public class FibonacciSequence{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n, i=1, j=1, k=1, output=0;
		String answer;


		do {
			System.out.print("Enter the number of sequences: ");
			n= in.nextInt();
				
				System.out.print("Result is: ");
				for(;i<=n;i++) {
				
					if (i==1)	
					System.out.print(j);
						
					else if (i==2)	
					System.out.print(", " + k);
					else {
										
					output = j + k ;
					System.out.print(", " +output);

					j=k;
					k=output;
					
					}
				}
					System.out.println(" \nWould you like to continue? (y/n)");
					 answer = in.next();
		}while ((answer.toUpperCase()).compareTo("Y") == 0);
			System.out.println("thank you using this Fibonacci output.");
	
		in.close();
	}}

 
// 	do {System.out.println("result is: " + j);
//} while (i==1);