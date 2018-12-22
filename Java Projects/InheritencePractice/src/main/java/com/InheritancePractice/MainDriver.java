//import java.awt.print.Book;

import First.Event;
import last.fair;
import last.fair.Type;
import second.Culturalfiesta;
import second.Festival;
import second.Musicfiesta;
import third.SportCompetition;
import third.SportCompetition.Season;

public class MainDriver {

	public static void main(String[] args) {
		//creating the events
		Festival f1=new Festival(2019,1,10,"first", 20, 8);
			System.out.println("\n");
		
		Festival f2=new Festival(2020, 2, 11, "second", 77, 3);
			System.out.println("\n");
			
		Festival f3= new Festival();
		System.out.println("\n");
		
		System.out.println();
		
		
		Culturalfiesta c1=new Culturalfiesta(2021, 3,12, "third", 13, 10, 5);
			System.out.println("\n");
		
			
		Culturalfiesta c2=new Culturalfiesta(2022, 4, 13, "fourth", 13, 10, 5);
			System.out.println("\n");
			
		
			
		Musicfiesta m1=new Musicfiesta(2023,5,14,"fifth",7,3,2,1);
		System.out.println("\n");
		
		Musicfiesta m2=new Musicfiesta();
		System.out.println("\n");
		
		SportCompetition sp1=new SportCompetition();
		System.out.println("\n");
		
		
		fair fair1=new fair(2019, 01, 1, 3, Type.career);
		System.out.println("\n");
		
		
		//array of events
		Event[] inventory=new Event[10];
		
			//changing year for the static method
			f1.setYear(2018);
			c2.setYear(2018);
			sp1.setYear(2018);
			
			//copy constructor
			Culturalfiesta cc=new Culturalfiesta(c2);
			System.out.println("\n");
			
			
			//Assigning the events to an element of the array 
				inventory[0]=m2;
				inventory[1]=f1;
				inventory[2]=cc;
				inventory[3]=f2;
				inventory[4]=c1;
				inventory[5]=c2;
				inventory[6]=m1;
				inventory[7]=sp1;
				inventory[8]=fair1;
				inventory[9]=f3;
				
				
				//displaying the array
			for (int i=0;i<inventory.length;i++)
				System.out.println(inventory[i]+"\n");
			
						
			//the equals methods					
			System.out.println(f2.equals(c2));
			System.out.println("\n");

			System.out.println(cc.equals(c2));
			System.out.println("\n");
			
			cc.setDuration(0);
			
			System.out.println(cc.equals(c2));
			System.out.println("\n");
			
			
			
			
			
			//see which events are at a certain year
			for (int i=0;i<inventory.length;i++)
			System.out.println(sameYear(inventory, 2018, i));
			
			//see which events have the least cities and the most cities
			leastOrMostCities(inventory);
			
			
			
			System.out.println("_______________PART 2___________________");
			
			
			Event[] anArray= new Event[12];
			
			SportCompetition sp2=new SportCompetition(2019, 9, 10, 15, Season.summer);
			System.out.println("\n");
			fair fair2=new fair(2029, 07, 1, 7, Type.science);
			System.out.println("\n");
			
			
			anArray[0]=m2;
			anArray[1]=f1;
			anArray[2]=cc;
			anArray[3]=f2;
			anArray[4]=c1;
			anArray[5]=c2;
			anArray[6]=m1;
			anArray[7]=sp1;
			anArray[8]=fair1;
			anArray[9]=f3;
			anArray[10]=sp2;
			anArray[11]=fair2;
			
			
			
			
			
			
			
			
			
			
					copyFestival(anArray);

			
		
	}
	
public static String sameYear(Event[] inventory, int y, int i){
	String s="";
	if (inventory[i].getYear()==y)
		s= "At index "+i+"\n"+inventory[i]+"\n";
	
	return s;

									}

public static void leastOrMostCities(Event[] inventory) {
			int least=inventory[0].getNumberOfCities();
			int most=inventory[0].getNumberOfCities();
			int index1 = 0;
			int index2=0;
			Event[] leastOrMost=new Event[2];
	
	for (int i=0;i<inventory.length;i++) {
		if (inventory[i].getNumberOfCities()>most) {
			most=inventory[i].getNumberOfCities();
			leastOrMost[0]=inventory[i];
			index1=i;
		}
		if (inventory[i].getNumberOfCities()<least)
			{least=inventory[i].getNumberOfCities();
		leastOrMost[1]=inventory[i];
		index2=i;}
	}
				
	

	System.out.println("The most cities is at index "+index1+"\n"+inventory[index1]+"\n");
	System.out.println("The Least cities is at "+index2+"\n"+inventory[index2]+"\n");
		}




/**
 * This will not work properly with polymorphism 
 * because the copy constructors don't have the same name
 * for polymorphism to choose the right method
 * it will only choose the copy Constructor in the Event class.
 * 
 * For it to work properly, we need to make a new method called clone 
 * in each class that calls the copy constructor of each class.
 * now we have a method that class the Copy Constructor depending on the class
 * which allows polymorphism to work.
 * 
 * example:
 * public Festical clone()
 * 		{
 * 		return new Festival(this)
 * 		}
 * 
 * adding the clone method will trigger polymorphism
 * 
 * 
 * @param inventory
 * @return
 */
public static Event[] copyFestival(Event[] inventory) {
	Event[] copyInventory = new Event[inventory.length];
	
		for (int i=0;i<copyInventory.length;i++) {
			Event e =new Event(inventory[i]);
			copyInventory[i]=e;
			System.out.println(copyInventory[i]+"\n");
		}
	return copyInventory;
}






}
