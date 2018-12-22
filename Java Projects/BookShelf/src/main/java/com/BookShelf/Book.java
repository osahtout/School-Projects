package com.BookShelf;
public class Book {

		//attributes with 1 static variable
		private String title;
		private String author;
		private double price;
		private long ISBN;
		private static int nbBooks=0;
		
		//default constructor
		public Book() {
			title="TBA";
			author="Unknown Author";
			price=0.00;
			ISBN=00000000;
			nbBooks++;
			
		}
		//constructor
		public Book(String title, String author, double price, long ISBN) {
			this.title=title;
			this.author=author;
			this.price=price;
			this.ISBN=ISBN;
			nbBooks++;
		}
		
		//Accessors
		public String getTitle() {
			return this.title;
		}
		public String getAuthor() {
			return this.author;
		}
		public double getPrice() {
			return this.price;
		}
		public long getISBN() {
			return this.ISBN;
		}
		
		//mutators
		public void setTitle(String title) {
			this.title=title;
		}
		public void setAuthor(String author) {
			this.author=author;
		}
		public void setPrice(double price) {
			this.price=price;
		}
		public void setISBN(long ISBN) {
			this.ISBN=ISBN;
		}
		
			//prints the details of the object
			public String toString() {
				return "\nTitle "+ title+"\nAuthor: "+author+"\nPrice: "+price+"\nISBN: "+ISBN+"\n";
			}
		
				//verifies if 2 obj has the same price and ISBN
			public boolean equals(Book book2) {
				return (price==book2.getPrice() && ISBN==book2.getISBN());
			}
			
				//accessor for the static variable
			public String findNumberNumberOfCreatedBooks() {
				return nbBooks+" have been created.\n";
		}
		
			
}
