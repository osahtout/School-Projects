package com.InheritancePractice.third;

import com.InheritancePractice.First.Event;

public class SportCompetition extends Event{
	
	private int numberOfActivities;
	public enum Season{summer, fall, winter, spring};
	private Season season;
	
	public SportCompetition() {
		System.out.println("Creating a default Sport Competition");
		numberOfActivities=1;
		season=Season.summer;
	}
	
	public SportCompetition(int year, int month, int numberOfCities, int numberOfActivities, Season season) {
		super(year, month, numberOfCities);
		System.out.println("Creating a parametized Sport Competition...");
		this.numberOfActivities=numberOfActivities;
		this.season=season;
	}
	
	public SportCompetition(SportCompetition sc) {
		super(sc.getYear(), sc.getMonth(),sc.getNumberOfCities());
		numberOfActivities=sc.numberOfActivities;
		season=sc.season;
		
	}
	
	
	
	
	
	
	public void setNumberOfActivities(int n) {
		this.numberOfActivities=n;
	}
	
	public void setSeason(Season s) {
		System.out.println("Changing the season...");
		if (s==Season.summer||s==Season.winter||s==Season.fall||s==Season.spring)
				this.season=s;
		else
			System.out.println("That is not a season\nReverting back the changes...");
	}
	
	
	
	
	
	
	
	
	public int getNumberOfActivities() {
		return numberOfActivities;
	}
	
	public Season getSeason() {
		return season;
	}
	
	
	
	
	
	
	
	
	public boolean equals(Object x) {
		if (x.getClass()!=this.getClass())
			return false;
		
		SportCompetition y=(SportCompetition) x;
			if (getYear()==y.getYear()&&getMonth()==y.getMonth()&& getNumberOfCities()==y.getNumberOfCities()&& season==y.season && numberOfActivities==y.numberOfActivities)
				return true;
			else return false;
	}
	
	
	
	public String toString() {
		return "Year: "+this.getYear()+"\nMonth: "+this.getMonth()+"\nNumber of Cities: "+this.getNumberOfCities()+"\nseason: "+season+"\n Number of Activities: "+numberOfActivities;
	}	

}
