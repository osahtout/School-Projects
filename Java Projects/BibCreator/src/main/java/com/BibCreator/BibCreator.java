// -----------------------------------------------------
// Assignment (3)
// Written by: (Omar Sahtout 40018126)
// 
// The purpose of this learn input output, create files, read line by line, or int by int, manipulate them and print them and if 
// a file is not what we wanted then to delete said file.
// -----------------------------------------------------
package com.BibCreator;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class BibCreator {
	static File[] bibFile = new File[10];
	static PrintWriter[] pIEEE = new PrintWriter[10];
	static PrintWriter[] pACM = new PrintWriter[10];
	static PrintWriter[] pNJ = new PrintWriter[10];
	static File[] toDelete = new File[30];
	static int start = 10;
	
	
	
	
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to my simple JavaScript Object Notation program");

		Scanner kb= new Scanner(System.in);
		
		
		/**
		 * this is to just to Warn the user of which file has missing content
		 */
		for (int i=0;i<bibFile.length;i++) {
			bibFile[i]=new File("Latex"+(i+1)+".bib");
		}
		
		
		Scanner[] s = new Scanner[10];
	
		

		/**
		 * looping through the printwriter to write to 3 different files, totaling 30 files if none are invalid
		 */
		
		
		System.out.println("\nOpening Files...");
			for (int i=0;i<s.length;i++)
			{
				
			try {	
				
				s[i] = new Scanner(new FileInputStream("Latex"+(i+1)+".bib"));
				pIEEE[i]= new PrintWriter(new FileOutputStream("IEEE"+(i+1)+".json"));
				pACM[i]= new PrintWriter(new FileOutputStream("ACM"+(i+1)+".json"));
				pNJ[i]= new PrintWriter(new FileOutputStream("NJ"+(i+1)+".json"));
		
			}
		catch (FileNotFoundException e) {
			System.out.println("\nCould not open file "+"Latex"+(i+1)+".bib");
			System.out.println("\nTerminating program immediaty");
			System.exit(0);
		
		}
			
			
			}
			
					System.out.println("Executing file copy");
					processForValidation(s);
					
					
					//closes the printWriter
					for (int i=0;i<s.length;i++)
					{
					pIEEE[i].close();
					pACM[i].close();
					pNJ[i].close();
					}
					
		
		
		
		
			/**
			 * deletion of invalid files
			 */
		for (int i=0;i<toDelete.length;i++) {
		if (toDelete[i]!=null) {
		if(toDelete[i].delete()) {
			System.out.println("\n*******************\nDeleting "+toDelete[i]+"\n*******************");
			
		}else
			System.out.println("File did not delete");
		}
		}
		
		
		
		
		System.out.println("\nOkay copying done...\n\n");
		

		String fileToSearch = null;
			System.out.println("Please enter the file you want to display (enter 'quit' to exit): ");

					fileToSearch = kb.nextLine();
				
				while(fileToSearch != "quit")
				{
					BufferedReader br=null;
					
					
					
					/**
					 * this is where the user can ask to see the content of a file
					 * asks for name of file, if valid, calls the method to display
					 * else, a try/catch block inside the main try/catch to give the user another try
					 * if fails, program terminates
					 * loops until the user enters "quits"
					 */
					try 
					{
			
						
						if (fileToSearch.equals("quit")) 
						{
							System.out.println("\n__________________________________________\nThank you for using my JSON program!\n__________________________________________");
							System.exit(0);
							}
						br=new BufferedReader(new FileReader(fileToSearch));
						fileToDisplay(br);
			
					}catch(FileNotFoundException a)
					{
						System.out.println("File Does Not Exist, You have one last attempt");
						try 
						{
						fileToSearch = kb.nextLine();
							br=new BufferedReader(new FileReader(fileToSearch));
								fileToDisplay(br);
						}catch(FileNotFoundException f)
						{
								System.out.println("You have exhausted your last attempt\nProgram will terminate immediatly!");
								System.exit(0);

						}
						catch(IOException g) 
						{
							System.out.println("IOEXception");
							System.exit(0);
						}
					}catch(IOException g) {
							System.out.println("IOEXception");
								System.exit(0);
					}			
		
						System.out.println("Would you like to display for another file? or enter quit to exit");
		
						fileToSearch = kb.nextLine();
				}	
		
		
		kb.close();
		
		
		
	}
		
		
	/**
	 * PrintWriters are static to make parameter passing shorter.
	 * This is the "big method" that reads line by line, tries to calls a method to manipulate the read line
	 * if successful, and all the info has been noted, it prints to all 3 different file.
	 * if an error has been caught, it warns the user, adds the created file to an array and deletes them later on
	 * @param inputFile, 
	 * 
	 */
	public static void processForValidation(Scanner[] inputFile)
	{
		String s = null, IEEE = null, newString = null, ACM=null, NJ=null;;
		String title=null, authorIEEE=null, authorACM=null, authorNJ=null, journal=null, volume=null, month=null, year=null,pages=null, doi=null, number=null;

		int counter = 0, numbering=0, invalidFile=0;
		
	

	for (int i=0;i<inputFile.length;i++) 
	{	
		try {
		while(inputFile[i].hasNextLine()) 
		{	
			s=inputFile[i].nextLine();
			
			
			
			/**
			 * this if/else block is to separate the information (i.e. month, author, year...) 
			 */
			if (s.toLowerCase().contains("author={")) {
				counter++;
				String ss =  getGoodString(s);
				String[] s2 = ss.split(" and");
						authorIEEE = s2[0]+",";
						authorNJ = s2[0]+" &";

				for (int k=1;k<s2.length-1;k++) 
				{
					if (s2[k]!=null) 
					{	
						authorIEEE += s2[k]+",";
						authorNJ += s2[k]+" &";
					}
				}
				authorIEEE += s2[s2.length-1]+". ";	
				//=newString;
				authorACM=s2[0]+" et al.";
				authorNJ += s2[s2.length-1]+". ";
	
			}	
				 if (s.toLowerCase().contains("title={")) {
					 counter++;
					newString =  getGoodString(s);
					title = newString;

				 }	
				else if (s.toLowerCase().contains("journal={")) {
					newString=  getGoodString(s);		
					journal = newString;
					counter++;
				}
				else if (s.toLowerCase().contains("volume={")) {
					newString=  getGoodString(s);			
						volume = newString;
						counter++;
				}
				else if (s.toLowerCase().contains("month={")) {
					newString=  getGoodString(s);				
					month = newString;
					counter++;
				}
				else if (s.toLowerCase().contains("year={")) {
					newString=  getGoodString(s);			
					year = newString;
					counter++;
				}
					
				else if (s.toLowerCase().contains("number={")) {
					newString=  getGoodString(s);			
					number = newString;
					counter++;
				}
				else if (s.toLowerCase().contains("pages={")) {
					newString =  getGoodString(s);
					pages = newString;
					counter++;
				}
					else if(s.toLowerCase().contains("doi={")) {
						newString = getGoodString(s);
						doi = newString;
						counter++;
					}
		
				
				 
				 
				 /**
				  * If the method has obtained all the needed information (counter == 9)
				  * it will make the proper string and print it to the 3 different files
				  */
				if (counter>8) {
					
			IEEE=authorIEEE+'"'+title+'"'+", "+journal+", vol. "+volume+", no. "+number+", p. "+pages+", "+month+" "+year+".\r\n";
					pIEEE[i].println(IEEE);			
					
					numbering++;	
			ACM ="["+numbering+"]	"+authorACM+" "+year+". "+title+". "+journal+". "+volume+", "+number+" ("+year+"), "+pages+". DOI:https://doi.org/"+doi+".\r\n";
					pACM[i].println(ACM);
							
			NJ=authorNJ+title+". "+journal+". "+volume+", "+pages+"("+year+")"+".\r\n";
					pNJ[i].println(NJ);
						counter = 0;
					
				}
				
			
				 
		}
		
			//for ACM [n]
			numbering = 0;
			
		/**
		 * when a field is empty, it warns the user and put the file in a static array
		 */
		}catch(FileInvalidException e) {
					 System.out.println("In the file "+bibFile[i].getName()+", '"+s.substring(0, s.indexOf('='))+"'"+" has no data, process has stop.\n");
					invalidFile++;
					
						toDelete[i] = new File("IEEE"+(i+1)+".json");
						toDelete[start+i]=new File("ACM"+(i+1)+".json");
						toDelete[2*start+i]= new File("NJ"+(i+1)+".json");

			
					
				 }
		
		inputFile[i].close();
	}
	
	System.out.println("You had "+invalidFile+" invalid files and "+(10-invalidFile)+" valid files that have been copies");

	}
	
	
	
		/**
		 * 
		 * @param s takes a string, then removes the unwanted parts
		 * @return	returns the manipulated string for file output later on
		 * @throws FileInvalidException if the part needed is missing
		 */
	public static String getGoodString(String s) throws FileInvalidException{
		String goodString;
		goodString = s.substring(s.indexOf('{')+1, s.indexOf('}'));
		if(goodString.length() == 0 || goodString.equals("") || goodString.equals(" ")) {
			throw new FileInvalidException("Error: no Data.");
		}
				
			return goodString;
	}
	

	
	/**
	 * This is to display to user the content of the created file
	 * @param br, a bufferedReader to read character by character
	 * @throws IOException if there is problem with reading the file, it throws an exception
	 */
	public static void fileToDisplay(BufferedReader br) throws IOException
	{
		

		int letter;
		
		letter = br.read();
		while(letter != -1) 
		{
			System.out.print((char)letter);		
			letter = br.read();		
		}
		
		br.close();
	}
	
}
	
	
