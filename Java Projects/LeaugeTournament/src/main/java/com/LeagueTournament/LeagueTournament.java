package com.LeagueTournament;
import java.util.Random;
import java.util.Scanner;
public class LeagueTournament {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String answer;
		String temp;
		int index;
		
		System.out.println("Welcome, may the odds be ever in your favor");
	System.out.println("What would the name of the team be?");
		String teamName=in.nextLine();
		
		String[] teamArray = new String[8];
				System.out.println("enter the name of each of 8 teams");
					for (int i=0;i<8;i++)
						teamArray[i]=in.nextLine();
// ________________________________________________________________________________
					do {
						System.out.println("\n**** Welcome to the "+teamName+" league****\n");	
					
						// shuffles the team
						Random shuffle = new Random();
							for (int i=7; i>0;i--) {
								index=shuffle.nextInt(i+1);			
								temp=teamArray[index];
								teamArray[index]=teamArray[i];
								teamArray[i]=temp;				}
							
							//prints the first 2 team, puts them in an another array and randomly picks a winner
				System.out.println("Quater Final 1:" +teamArray[0]+" Vs "+teamArray[1] );				
							String[] Qfinals1 = {teamArray[0], teamArray[1]};						//prints the the first 2 t
							int rnd1 = new Random().nextInt(2);//generates a random number less than 2
						     System.out.println(Qfinals1[rnd1]+" wins!\n"); //puts that number in the new array to select a winner
						     
							// does the above 4x for the quarter finals the 2 times for the semifinals and 1 for the final
				   System.out.println("Quater Final 2:" +teamArray[2]+" Vs "+teamArray[3] );				
						String[] Qfinals2 = {teamArray[2], teamArray[3]};
						int rnd2 = new Random().nextInt(2);
							System.out.println(Qfinals2[rnd2]+" wins!\n");									
							
					System.out.println("Quater Final 3:" +teamArray[4]+" Vs "+teamArray[5] );				
						String[] Qfinals3 = {teamArray[4], teamArray[5]};
								int rnd3 = new Random().nextInt(2);
									System.out.println(Qfinals3[rnd3]+" wins!\n");	     
						     
				     System.out.println("Quater Final 4:" +teamArray[6]+" Vs "+teamArray[7] );				
							String[] Qfinals4 = {teamArray[6], teamArray[7]};
								int rnd4 = new Random().nextInt(2);
									System.out.println(Qfinals4[rnd4]+" wins!\n");
						     	
									System.out.println("\n**SEMI FINALS**\n");
									//SEMI FINALS
									//prints the the first two winner
					System.out.println("Semi Final 1: "+Qfinals1[rnd1]+" vs "+Qfinals2[rnd2]);
					   		String[] semiFinals1 = {Qfinals1[rnd1], Qfinals2[rnd2]};
					   			int rnd5 = new Random().nextInt(2);
					   				System.out.println(semiFinals1[rnd5]+" WINS!!\n");
					   		
				  System.out.println("Semi Final 2: "+Qfinals3[rnd3]+" vs "+Qfinals4[rnd4]);
				  			String[] semiFinals2 = {Qfinals3[rnd3], Qfinals3[rnd4]};
				  				int rnd6 = new Random().nextInt(2);
				  				System.out.println(semiFinals2[rnd6]+" WINS!!\n");
				  				
				  				System.out.println("\n***FINALS***\n");
				  				//FINAL ROUND
				  System.out.println("Finals: "+semiFinals1[rnd5]+" vs "+semiFinals2[rnd6]);
					   		String[] Finals = {semiFinals1[rnd5], semiFinals2[rnd6]};
					   			int rnd7 = new Random().nextInt(2);
					   				System.out.println(Finals[rnd7]+" WINS THE LEAGUE!!!");
					   		
						     
						
						System.out.println("\nWould you like a different outcome? y/n");
							answer = in.next();	
					}while ((answer.toUpperCase()).compareTo("Y") == 0);
					
				System.out.println("Thank you for using this tornament generator");

in.close();
}}
