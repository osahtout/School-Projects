package com.InheritancePractice.second;

public class Musicfiesta extends Festival{
	private int numberOfBands;
	
		public Musicfiesta() {
			System.out.println("Creating a default Musicfiesta...");
				numberOfBands=1;
		}
		
		public Musicfiesta(int numberOfBands) {
			System.out.println("Creating a Musicfiesta with 1 parameter...");
			this.numberOfBands=numberOfBands;
		}
		
		public Musicfiesta(int year, int month, int cities, String name, double ticketPrice, int duration, int languages, int numberOfBands) {
			super(year, month, cities, name, ticketPrice, duration);
				System.out.println("Creating a parametized constructor...");
				this.numberOfBands=numberOfBands;
		}
		
		public Musicfiesta(Musicfiesta m) {
			super(m.getYear(), m.getMonth(),m.getNumberOfCities(), m.name, m.ticketPrice, m.duration);
			System.out.println("Creating a copy Musicfiesta...");
			numberOfBands=m.numberOfBands;
		}
		
		public void setNumberOfBands(int n) {
			this.numberOfBands=n;
		}
		public int getNumberOfBands() {
			return this.numberOfBands;
		}
		
		public boolean equals(Object x) {
			
			if (x.getClass()!=this.getClass())
				return false;
			
	Musicfiesta y=(Musicfiesta) x;
	if(getYear()==y.getYear())
		if(getMonth()==y.getMonth())
			if(getNumberOfCities()==y.getNumberOfCities())
				if(name.equals(y.name))
					if(ticketPrice==y.ticketPrice)
						if(duration==y.duration)
							if(numberOfBands==y.numberOfBands)
									return true;


								else return false;
		return false;
		}
		
		public String toString() {
			return "Year: "+super.getYear()+"\nMonth: "+super.getMonth()+"\nNumber of Cities: "+super.getNumberOfCities()+
					"\nName: "+super.name+"\nTicket Price: "+super.ticketPrice+"\nDuration: "+super.duration+"\nNumber of Bands: "+numberOfBands;
		}
		
		
		
		
		
}
