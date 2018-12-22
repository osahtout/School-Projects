package com.InheritancePractice.second;

import com.InheritancePractice.First.Event;

public class Festival extends Event{
	protected String name;
	protected double ticketPrice;
	protected int duration;
	
	/**********************************
	 * Switching from protected to private
	 * only restrict access from the children
	 * of this class.
	 * So in order to access these atribute, 
	 * would be allowed through the accessors
	 * and mutators. Adding an extra step
	 ***********************************/
	
	
		public Festival() {
			System.out.println("Creating a default Festival...");
			this.name="generic festival";
			this.ticketPrice=10.00;
			this.duration=1;
		}
		
		public Festival(int year, int month, int numberOfCities, String name,double ticketPrice, int duration) {
			super(year, month, numberOfCities);
			System.out.println("Creating a paramitized Festival...");
			this.name=name;
			this.ticketPrice=ticketPrice;
			this.duration=duration;
		}
		
		//copy constructor
		public Festival(Festival f){
			super(f.getYear(), f.getMonth(), f.getNumberOfCities());
			System.out.println("Creating a copy Festival...\n");
			this.name=f.name;
			this.ticketPrice=f.ticketPrice;
			this.duration=f.duration;
		}
		
		//setters for this class
		public void setName(String name) {
			System.out.println("Changing name...\n");
				this.name=name;
		}
		public void setTicketPrice(double price) {
			System.out.println("Changing price...");
				this.ticketPrice=price;
		}
		public void setDuration(int duration) {
			System.out.println("Changing duration...");
				this.duration=duration;
		}
		

		public String getName() {
			return this.name;
		}
		public double getTicketPrice() {
			return this.ticketPrice;
		}
		public int getDuration() {
			return this.duration;
		}
		
		
		public boolean equals(Object x) {
		//	boolean b = false;
			if (x.getClass()!=this.getClass())
				return false;
			
			Festival y=(Festival) x;
			//	if (year==y.getYear() && month==y.getMonth() && numberOfCities==y.getNumberOfCities()&& name==y.name 
			//			&&ticketPrice==y.ticketPrice && duration==y.duration);
			if(getYear()==y.getYear())
				if(getMonth()==y.getMonth())
					if(getNumberOfCities()==y.getNumberOfCities())
						if(name.equals(y.name))
							if(ticketPrice==y.ticketPrice)
								if(duration==y.duration)
										return true;
						else return false;
			return false;
	
			
				
		}
		
		public String toString() {
			return "Year: "+super.getYear()+"\nMonth: "+super.getMonth()+"\nNumber of Cities: "+super.getNumberOfCities()+
					"\nName: "+this.name+"\nTicket Price: "+this.ticketPrice+"$\nDuration: "+this.duration+"\n";
		}  

}
