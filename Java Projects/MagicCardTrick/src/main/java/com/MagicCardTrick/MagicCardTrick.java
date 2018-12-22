package com.MagicCardTrick;
//import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MagicCardTrick {

	public static void main(String[] args) {
		
		System.out.println("WELCOME TO THE JAVA MAGIC CARD TRICK\n");
		
		Scanner in = new Scanner(System.in);
		String[] Suits = {"Heart", "Diamonds", "Spade", "Clubs"};
		String[] Rank = {"Ace", "Two", "Three", "Tour", "Five", "Six", "Seven", "Eight","Nine","Ten", "Jack", "Queen", "king"};
		int cards = Suits.length*Rank.length;
		String[] Deck = new String[cards];
		int index;
		String temp;
		String answer;
		String[][] Hand = new String[4][4];
		
		
		//***********Makes a standard Deck**************
		for (int i=0;i<Rank.length;i++) {
			for (int j=0;j<Suits.length;j++) {
				Deck[i*Suits.length+j] = Rank[i]+" of "+Suits[j];				
			}}	
	do{	
	//*********Randomize Deck***********
		Random shuffle = new Random();
		for (int i=0; i<cards;i++) {
			index=shuffle.nextInt(cards-i);		
			temp=Deck[index];
			Deck[index]=Deck[i];
			Deck[i]=temp;		}
		
		//""""""test deck output"""""""
//			for (int i=0;i<cards;i++)
	//			System.out.println(Deck[i]);
			
		// pick 16 cards from deck
		String[] firstHand = new String[15];
			for (int i=0;i<firstHand.length;i++) {
				firstHand[i]=Deck[i];}
	
/*				//"""""Prints the hand of 16 cards in a column""""""""		
			for (int i=0;i<firstHand.length;i++) {
				System.out.println(firstHand[i]);}
						System.out.print("\n");      */
			
			//*********adds the 16 card hand to a 2D 4x4 array************
			for(int i=0; i<4;i++) {
				   for(int j=0;j<4;j++)
				       Hand[i][j] = firstHand[(j*3) + i];
								}
			
			//*******prints out the hand in a 4x4 table************
			for (int i = 0; i < Hand.length; i++) {
	            for (int j = 0; j < Hand[i].length; j++) {
	                System.out.print(Hand[i][j] + "       ");  }
	            System.out.println();		}
			
		int row,col;
			//	do {	
		
		System.out.print("\nFrom the hand above pick a card and remember it well.\n");
					do {
						System.out.println("\nWhich column is your card in (numbers between 1 and 4)?");
						row = in.nextInt();
					}while(row<1||row>4);
					
					
		//+++++++++++++++++++++TRANSPOSE++++++++++++++++++
					for (int i = 0; i < Hand.length; i++) {
			            for (int j = 0; j < Hand[i].length; j++) {
			                System.out.print(Hand[j][i] + "       ");  }
			            System.out.println();		}
		
					do {
						System.out.println("\nNow which column is your card in (numbers between 1 and 4)?");
						col=in.nextInt();
					}while(col<1||col>4);
					
					System.out.println("your card is ***"+Hand[col-1][row-1]+"***");
			
			
				System.out.println("\nWould you like to try again? y/n");
			answer = in.next();	
	}while ((answer.toUpperCase()).compareTo("Y") == 0);
			
			System.out.println("Thank you for using Java Magic!");
			in.close();
	}

}
