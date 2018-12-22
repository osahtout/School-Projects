package com.InheritancePractice.second;

public class Culturalfiesta extends Festival{
		private int maxNumberOfLanguages;
		
		//defualt constructor
		public Culturalfiesta() {
			System.out.println("Creating a default Culturalfiesta...");
			this.maxNumberOfLanguages=1;
		}
		//param. constructor
		public Culturalfiesta(int year, int month, int cities, String name, double ticketPrice, int duration, int languages) {
			super(year, month, cities, name, ticketPrice, duration);
			System.out.println("Creating a paramatized Cutlturalfiesta...");
			this.maxNumberOfLanguages=languages;
		}
		
		//copy constuctor
		public Culturalfiesta(Culturalfiesta cf) {
			super(cf.getYear(), cf.getMonth(), cf.getNumberOfCities(), cf.name, cf.ticketPrice, cf.duration);
			
		/*	setYear(cf.getYear());
			setMonth(cf.getMonth());
			setNumberOfCities(cf.getNumberOfCities());
			setTicketPrice(cf.getDuration());
			setDuration(cf.getDuration());*/
			
			System.out.println("Creating a copy Culturalfestival...");
			this.maxNumberOfLanguages=cf.maxNumberOfLanguages;
			
		}
	
		
		public int getMaxNumberOfLanguages() {
			return maxNumberOfLanguages;
		}
		public void setMaxNumberOfLanguages(int m) {
			System.out.println("Changing the number of languages...");
				this.maxNumberOfLanguages=m;
		}
		
		
		
		public boolean equals(Object x) {
		
			if (x.getClass()!=this.getClass())
				return false;
			
			Culturalfiesta y=(Culturalfiesta) x;
		//		if (year==y.year && month==y.month && numberOfCities==y.numberOfCities&& getName().equals(y.getName()) && getTicketPrice()==y.getTicketPrice() && getDuration()==y.getDuration()&& maxNumberOfLanguages==y.maxNumberOfLanguages);
					if(getYear()==y.getYear())
						if(getMonth()==y.getMonth())
							if(getNumberOfCities()==y.getNumberOfCities())
								if(name.equals(y.name))
									if(ticketPrice==y.ticketPrice)
										if(duration==y.duration)
											if(maxNumberOfLanguages==y.maxNumberOfLanguages)
												return true;
			

											else return false;
					return false;
			
				
		}
		
		public String toString() {
			return "Year: "+super.getYear()+"\nMonth: "+super.getMonth()+"\nNumber of Cities: "+super.getNumberOfCities()+
					"\nName: "+super.name+"\nTicket Price: "+super.ticketPrice+"\nDuration: "+super.duration+" day\nNumber of Languages: "+maxNumberOfLanguages;
		}
		
		
}
