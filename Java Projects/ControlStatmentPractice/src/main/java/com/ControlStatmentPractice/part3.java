// Assignment (2)
// Written by: (Omar Sahtout 40018126)
// For COMP 248 Section (P PA?) � Fall 2017
// Use: determining the best subscription for a food delivery service
// --------------------------------------------------------
package com.ControlStatmentPractice;
import java.util.Scanner;
    
public class part3 {

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
			
		System.out.println("Welcome to the Food delivery subscription analysis!");
		System.out.print("\nhow many times do you eat?: ");
			String thx = "\nThank you for using this software, enjoy your meal!";
				double eat = in.nextDouble();   				
				double sav1 = 0.00;									//***declare variables with double for decimals***
				double sav2 = 0.00;
				double ppf = eat * 3.00;							//***equations to determine the cost per month of each subscription***
				double occf = (Math.max(0, (eat-6)*2.00)+15.00);	//***Math.max is used because # of deliveries can't be below zero***
				double mtl = Math.max(0, (eat-12)*1.50 + 30.00);
				
			if (ppf < occf) { 
						System.out.printf("***we recommend the payperfood*** "
								+ "\nThe cost per month would be $%.2f, less than the monthly Subscriptions! %n%s", ppf, thx);}
				
			else if (ppf >= occf && occf < mtl) {
																	//***if else if statements to determine the cheapest subscription***
					sav1 = (double) ppf - occf;						//***saving equation to prove it's the best option***
					sav2 = (double) 30 - occf;
					
						System.out.printf("We reccomend using Ocassioanlfoods, the total cost would be $%.2f per month"
						+ "\nyou would save $%.2f from paypermeal and $%.2f from montrealfoods \n%s" , occf, sav1, sav2, thx);}
		
			else  {
					sav1 = (double) ppf - mtl;
					sav2 = (double)	occf - mtl;
						System.out.printf("We reccomend using Montreal, the total cost would be $%.2f per month" + 
						"\nyou would save $%.2f from paypermeal and $%.2f from OccasionalFoodies \n%s" , mtl, sav1, sav2, thx);}

in.close();
	}

}	