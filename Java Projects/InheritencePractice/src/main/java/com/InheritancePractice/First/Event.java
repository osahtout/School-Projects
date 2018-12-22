package com.InheritancePractice.First;

public class Event {
	private int year;
	private int month;
	private int numberOfCities;
	
		public Event() {
			System.out.println("Creating a default Event...");
			year=2018;
			month=01;
			numberOfCities=0;
		}
		public Event(int year, int month, int numberOfCities) {
			System.out.println("Creating a paramatized Event...");
			this.year=year;
			this.month=month;
			this.numberOfCities=numberOfCities;
		}
		public Event(Event e) {
			System.out.println("Creating a copy Event...");
			this.year=e.year;
			this.month=e.month;
			this.numberOfCities=e.numberOfCities;
		}
		
		
			public int getYear() {
				return this.year;
			}
			public int getMonth() {
				return this.month;
			}
			public int getNumberOfCities() {
				return this.numberOfCities;
			}
			
				
				public void setYear(int y) {
					this.year=y;
				}
				public void setMonth(int m) {
					System.out.println("Setting the month...\n");
						if (m>12 || m<=0) {
							System.out.println(m+" is not a number associated with a month");
							System.out.println("Resetting the month to the original...\n");
						}else
					this.month=m;
				}
				public void setNumberOfCities(int n) {
					this.numberOfCities=n;
				}
				
				
			
			
			public boolean equals(Object x) {

				if (x.getClass()!=this.getClass())
					return false;
				
				Event y=(Event) x;
					if (year==y.year && month==y.month && numberOfCities==y.numberOfCities)
						return true;
					else return false;
				}
			
			
			public String toString() {
				return "Year: "+this.year+"\nMonth: "+this.month+"\nNumber of Cities: "+this.numberOfCities+"\n";
			}	
		
}
