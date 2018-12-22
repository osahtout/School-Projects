//________________________________________
//Assignement # 1
//Written by: Omar Sahtout ID: 40018126
//________________________________________



/**
 * A program that lets user store information for a user determined number of books
 * 
 * @author Omar Sahtout
 */

package com.BookShelf;
import java.util.Scanner;
public class BookStore {

	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		
		String password = "password",inputPass,author,title;
		int counter1=0, counter2=0,choice, changeChoice, maxBooks;
		long isbn;
		double price;
		boolean end=false;
		
		
		System.out.println("******************************************\nWelcome to the book tracking application\n******************************************\n");
			
			do {
			System.out.println("What is the maximum number of books will you keep track?");
				 maxBooks = key.nextInt();
			}while(maxBooks<=0);
			
			
				//empty array to be filled with book objects
				Book[] inventory = new Book[maxBooks];
			
					
/**
 * LOOPS UNTIL USER QUITS APPLICATION:
 * Keeps looping back to the main menu until boolean end is true			
 */
do {
				counter2=0;
				
	
				/**
				 * LOOPS UNTIL PASSWORD ENTERED CORRECTLY OR OPTION 2 OR 3 IS CHOSEN
				 */
		do {
					
					/**
					 * MAIN MENU
					 */
			System.out.println("\nWhat would you like to do: "
					+ "\n	1.	Enter new books (password required)"
					+ "\n	2.	Change information of a book (password required)"
					+ "\n	3.	Display all books by a specific author."
					+ "\n	4.	Display all books under a certain price."
					+ "\n	5.	Quit.");
			do {
			System.out.print("Please enter your choice> ");
					choice = key.nextInt();
			}while(choice>6 || choice<0);
			
			
				
			/**
			 * PASSWORD ALGORITHM START:
			 * if option 1 or 2 is chosen then it has to go through this algorithm before
			 * entering either option
			 */
				counter1=0;
				if (choice==1 || choice==2) {
					
					do {
					System.out.println("\nPlease enter the password");
							inputPass = key.next();
						
							if ((inputPass.equals(password))!=true) {
								counter1++;
									System.out.println("Incorrect password!");
							}
						}while((inputPass.equals(password))!=true && counter1<3);
					
				}
				
				/**
				 * This is where option 1 and option 2 differs in the password algorithm
				 * if option 1 is selected then after 3 attempts the counter starts
				 * after the second counter=4 then a 6th option in the switch statement is chosen and
				 * the application closes 
				 */
				
				if (choice==1)
					counter2++;
			}while(counter1>=3 && counter2<4);
				
				if (counter2>3)
					choice=10;
			/**
			 * PASSOWRD ALGORITHM ENDS
			 */
				
				
				
				switch (choice) {
				
				
				
				//START OF OPTION 111 FROM MAIM MENU
				
				case 1:
					
				/**
				 * creates and adds book object to the array
				 */
					//boolean empty=true;
					int booksLeft=maxBooks;
						int add;	
						
						/**
						 * this verifies that there is some elements left the array
						 * then display the amount of space left
						 */
							for (int j=0;j<inventory.length;j++) {
								if (inventory[j]!=null)
									booksLeft--;				}
								System.out.println("\nYou have "+booksLeft+" spot left.");
						
									/**
									 * asks the user how many new object they want to add to the array
									 * if there's not enough space, it notifies them and asks them again
									 */
							do {
								System.out.println("How many new books would you like to enter?");
									add=key.nextInt();
										if (add>booksLeft)
								System.out.println("not enough space");
										
								}while(add>booksLeft);
							
							
								/**
								 * a loop that starts from the first empty element in the array
								 * and until the number chosen by the user
								 * then it asks for constructor details to create the objects and add
								 * them to the array
								 * then displays the object
								 */
								for (int p=(maxBooks-booksLeft);p<=(maxBooks-booksLeft)+add-1;p++) {
									System.out.println(" ");
									String	ans=key.nextLine();
									
										System.out.println("Author for book "+(p+1));
											author=key.nextLine();
										System.out.println("title for book "+(p+1));
											title=key.nextLine();
										System.out.println("ISBN for book "+(p+1));
											isbn=key.nextLong();
										System.out.println("price for book "+(p+1));
											price=key.nextDouble();			
								
								inventory[p]= new Book(title, author, price, isbn);
								}
								break;
	
					
				case 2:
					
					boolean case2End=false;
					
					System.out.println("Which book would you like to change ("+1+" to "+(maxBooks)+")");
						int index=key.nextInt();
						
						//displays the book
					System.out.println("\nBook #"+(index)+"\n"+inventory[index-1]);
						if (inventory[index-1]==null) {
							System.out.println("Ooopps! Looks like there's no book on this shelve");
							break;
								}
							
					
					do {
					System.out.println("\nWhat information would you like to change?"
							+ "\n	1.	Author"
							+ "\n	2.	title"
							+ "\n	3.	ISBN"
							+ "\n	4.	Price"
							+ "\n	5.	Quit to main menu");
					do {
						System.out.println("Enter you choice>");
							changeChoice = key.nextInt();
					}while(changeChoice<0 || changeChoice>5);
					
					if (inventory[index-1]==null) {
						changeChoice=5;
							System.out.println("there's no books to change anything");
					}
					
								switch(changeChoice){
									
							/**
							 * CHANGING AUTHOR
							 */
									case 1:
								
											boolean good=true;
												do {
														System.out.println(" ");
															String	ans=key.nextLine();
											
											
														System.out.println("What is the new authors name?");
															String newAuthor=key.nextLine();
																inventory[index-1].setAuthor(newAuthor);
								
														System.out.println("\nNew author name has been set.\n"+inventory[index-1]);

														System.out.println("Was these changes correct? y/n");
															String yn=key.next();
																if (yn.equalsIgnoreCase("y")) 
																	good=true;
																else 
																	good=false;
												}while(good==false);
												break;
								
							/**
							 * CHANGING TITLE
							 */
									case 2:
											do {
													System.out.println(" ");
														String	ans=key.nextLine();
											
													System.out.println("What is the new Title of the book?");
														String newTitle=key.nextLine();
															inventory[index-1].setTitle(newTitle);
								
													System.out.println("\nNew Title has been set.\n"+inventory[index-1]);

													System.out.println("Was these changes correct? y/n");
														String yn=key.next();
															if (yn.equalsIgnoreCase("y")) 
																good=true;	
															else 
																good=false;
											}while(good==false);
											break;
											
								
							/**
							 * CHANGING ISBN
							 */
									case 3:								
											do {
													System.out.println(" ");
														String	ans=key.nextLine();
											
													System.out.println("What is the new ISBN of the book?");
														long newISBN=key.nextLong();
															inventory[index-1].setISBN(newISBN);
								
													System.out.println("\nNew ISBN has been set.\n"+inventory[index-1]);

													System.out.println("Was these changes correct? y/n");
														String yn=key.next();
															if (yn.equalsIgnoreCase("y")) 
																good=true;	
															else 
																good=false;
											}while(good==false);
											break;
								
											
									case 4:		//CHANGES PRICE					
											do {
													System.out.println(" ");
														String	ans=key.nextLine();
											
													System.out.println("What is the new price of the book?");
														double newPrice=key.nextDouble();
															inventory[index-1].setPrice(newPrice);
								
													System.out.println("\nNew price has been set.\n"+inventory[index-1]);

													System.out.println("Was these changes correct? y/n");
														String yn=key.next();
															if (yn.equalsIgnoreCase("y")) 
																good=true;	
															else 
																good=false;
												
											}while(good==false);
											break;
								
									
									
									case 5:
										case2End=true;
										break;
						
								
							}
					}while(case2End==false);
								break;			//END OF OPTION 2222222222222
					
					

					
				case 3:	//Displays all books with same author
					
						int counter=0;
						System.out.println(" ");
						String	ans=key.nextLine();
					
						System.out.println("Which Author would you like to dislpay their books?");
							String displayAuthor = key.nextLine();
						
								System.out.println("OK here are the books.....");
							
							for (int i=0;i<inventory.length;i++) {
								if (inventory[i]!=null) {
									if (findBooksBy(inventory, displayAuthor, i)==true)
										System.out.println(inventory[i].toString()+"\n*******");
										counter++;
								}
							}

							if (counter==0)
								System.out.println("\nOops! Sorry there are no books with that author in your inventory");
				break; //END of option 333 and return to the main menu
					
			
				//Displays all books under a certain price
				case 4: 
						System.out.println("Whats the highest price you want to see to see the books cheaper than that price?");
							double maxPrice = key.nextDouble();
						
							for (int i=0;i<inventory.length;i++) {
								if (inventory[i]!=null) {
									if (findCheaperThan(inventory, maxPrice,i)==true)
										System.out.println(inventory[i].toString());
								}
							}

				break;//END of option 4
					
				case 5:
					
					System.out.println("\n\n*************************************************\nThank you for using the book tracking application"
							+ "\n*************************************************");	
					end=true;
					break;
					
				case 10://Quits program
					System.out.println("Program detected suspicous activities and will terminate immediately!");
					end=true;
				break;				
				}
				
}while(end==false);
				

			key.close();
	}

	
	/**
	 * 
	 * static methods that takes 3 parameters to see if user input matches object attribute
	 * @param inventory the array filled with object
	 * @param displayAuthor the user input
	 * @param i from the main method loop to loop the array in static method
	 * @return boolean if the attribute matches user input
	 */
	public static boolean findBooksBy(Book[] inventory, String displayAuthor, int i) {
	
		return (inventory[i].getAuthor().equalsIgnoreCase(displayAuthor)) ;
		
		}
	
	
	/**
	 * method return boolean if the attribute price is lower than user input
	 * @param inventory the array with objects
	 * @param maxPrice price of the user 
	 * @param i number from a loop in the main method to loop the static method
	 * @return boolean if price is lower
	 */
	public static boolean findCheaperThan(Book[] inventory, double maxPrice, int i) {
		
			return (inventory[i].getPrice()<maxPrice);
			
	}
	
}
