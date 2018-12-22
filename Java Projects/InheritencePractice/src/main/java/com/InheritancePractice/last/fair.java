package com.InheritancePractice.last;

import com.InheritancePractice.First.Event;
public class fair extends Event{
	
	private int exibitor;
	public enum Type {career, science, trade, travel};
	private Type type;
	
	public fair() {
		exibitor=1;
		type=Type.career;
	}
	
	public fair(int year, int month, int numberOfCities, int exibitor, Type type) {
		super(year, month, numberOfCities);
		System.out.println("Creating a parametized fair...");
		this.exibitor=exibitor;
		this.type=type;
	}
	
	public fair(fair f) {
		super(f.getYear(), f.getMonth(), f.getNumberOfCities());
		exibitor=f.exibitor;
		type=f.type;
	}
	
	
	
	public void setExibitor(int e) {
		this.exibitor=e;
	}
	
	
	public void setType(Type type) {
		System.out.println("Changing the Type...");
			if (type==Type.career||type==Type.science||type==Type.trade||type==Type.travel)
					this.type=type;
			else
				System.out.println("That is not a season\nReverting back the changes...");
	}
	

	
	
	
	public int getExibitor() {
		return exibitor;
	}

	public Type getType() {
		return type;
	}
	
	
	public boolean equals(Object x) {
		if (x.getClass()!=this.getClass())
			return false;
		
		fair y=(fair) x;
		if(getYear()==y.getYear())
			if(getMonth()==y.getMonth())
				if(getNumberOfCities()==y.getNumberOfCities())
					if (exibitor==y.exibitor)
						if (type==y.type)
							return true;
						else return false;
		return false;
	}
	
	
	public String toString() {
	 return "Year: "+super.getYear()+"\nMonth: "+super.getMonth()+"\nNumber of Cities: "+super.getNumberOfCities()+"\nExibitors: "+exibitor+"\nType: "+type;
	}
	
}
