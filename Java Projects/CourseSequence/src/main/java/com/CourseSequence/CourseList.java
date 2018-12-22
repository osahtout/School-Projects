package com.CourseSequence;

import java.util.NoSuchElementException;

public class CourseList implements Cloneable
{
	public class CourseNode
	{
		 private Course c;
		 private CourseNode next;
			
		 public CourseNode() 
		 {
			 c = null;
			 next = null;	
		 }
		 
		 public CourseNode(Course c, CourseNode next) {
			 this.c = c;
			 this.next = next;
		 }
		 
		 
		 public CourseNode(CourseNode cn) throws CloneNotSupportedException {
			c = cn.c.clone();
			next = cn.next;
		 }
		 
		 
		 public CourseNode clone() throws CloneNotSupportedException {
			 //CourseNode cn = (CourseNode) super.clone();
			 //return cn;
			 	return new CourseNode(this);
		 }
		 
		 
		public void setCourseObject(Course c)
		{
			this.c = c;
		}
		public void setCourseNode(CourseNode next) 
		{
			this.next = next;
		}
		
		public Course getCourseObject() {
			return c;
		}
		public CourseNode getCourseNode() {
			return next;
		}

		
		 
	}
	
	private CourseNode head; //SHOULD POINT TO THE FIRST NODE
	private int size = 0;
	
		
		public CourseList() {
			head = null;
		}
		
		/**
		 * Deep copies (hopefully) courseList
		 * @param lst
		 * @throws CloneNotSupportedException
		 */
		public CourseList(CourseList cl) throws CloneNotSupportedException 
		{
		
			if(cl.head == null)
				head = null;
			else
			{
				head = null;	
				CourseNode a, b, c;
				
				a = cl.head;
				b = c = null;
				
					while(a != null)				
					{
						if (head == null)
						{
							
							b = new CourseNode(a); 
								head = b;
						}
						else 
						{
							c = new CourseNode(a);				
								b.next = c;					
									b = c;												}
										a = a.next;
						}
				
				b = c = null; 
						
			}
		}

		//clone method
		public CourseList clone() throws CloneNotSupportedException {
			return new CourseList(this);
		}
		
		
		/**
		 * adds a node at the beginning of the Linked List
		 * @param toAdd
		 */
		public void addToStart(Course toAdd)
		{
			head = new CourseNode(toAdd, head);
			size++;
		}
		
		/**
		 * returns true if there's a node in a list and has been deleted
		 * if the list is empty, it returns false
		 * @return
		 */
		public boolean deleteFromStart() 
		{
			if (head != null) 
			{
				head = head.next;
				size--;
				return true;
			}
				else 
				{
					return false;
				}
		}
		
		/**
		 * Adds a node to the end of the list 
		 * @param toAdd
		 */
		public void addToEnd(Course toAdd) 
		{
			if(head == null) {
				addToStart(toAdd);
			return;
			}
			
			CourseNode aPointer = head;

				while (aPointer.next!=null) 
				{
					aPointer = aPointer.next;
				}
				
				aPointer.next = new CourseNode(toAdd, null);
				
				aPointer = null;
				size++;
		}//TO FINISH
	
		/**
		 * This counts the number of nodes in the list if its called
		 * 
		 * @return
		 */
		public int countSize() 
		{
			int sizes = 0;
			CourseNode aPointer;
				aPointer = head;
				
				while(aPointer!=null) { //NEXTNEXTNEXTNEXTNEXNTEXTNEXT
					sizes++;
					aPointer = aPointer.next;
				}
			return  sizes;
		}
		
		/**
		 * This uses the private attribute that adds or subtract depending if a node is added or deleted
		 * like a static attribute but it belongs to the object(list) instead of the class
		 * @return
		 */
		public int getSize() {
			return size;
		}
		
		/**
		 * Adds a node to the specific index (from 0 to size, like an a array)
		 * @param toAdd
		 * @param index
		 * @throws NoSuchElementException
		 */
		public void addAtIndex(Course toAdd, int index)throws NoSuchElementException//TEST TJIS
		{
			if (index < 0 || index > size) //can add after the last index
				throw new NoSuchElementException();
			
			
			CourseNode aPointer = head;
			
			
			
			if (index == 0) 
			{
				addToStart(toAdd);
			}
			
				else if (index == size)
				{
					addToEnd(toAdd);
				}
			
					else
					{
						int ctr = 0;
						while(ctr < index-1) 
						{
							aPointer = aPointer.next;
							ctr++;
						}
						
						aPointer.next = new CourseNode(toAdd, aPointer.next);
						aPointer = null;
						size++;
					}
			
			
		}
		
		/**
		 * points the node before the index to the node after the index, so the the node at index becomes garbage
		 * should throw an exception if the index is larger than the list
		 * @param index
		 * @return
		 * @throws NoSuchElementException
		 */
		public boolean deleteAtIndex(int index) throws NoSuchElementException{
		
			if (index < 0 || index >= size)
				throw new NoSuchElementException();
			
			CourseNode p = head;
			
			if(index == 0) {
				deleteFromStart();
				return true;
				
			}
			
			else
			{
				int counter = 0;
				while(counter != index-1)
				{
					p = p.next;
					counter++;
				}
				if (p.next.next == null) {
					p.next = null;
					size--;
					p=null;
					return true;
				}
				else
				{
					p.next = p.next.next;
					size--;
					p=null;
					return true;
				}
					
			}

		}
		
		/**
		 * Takes a courseID as a parameter and searches through the list to find a match and returns the location
		 * Creates a PRIVACY LEAK, because the its return the location of the node. The user might delete or alter it and
		 * all the nodes that comes after.
		 * Making class CourseNode private might solve the issue
		 * @param cr
		 * @return
		 */
		public CourseNode find(String wot) {
			CourseNode n = head;
			int counter = 0;
			
			while(n!=null) {
				if(n.c.getCourseID().equals(wot)) {
				//	System.out.println("It took "+counter+" iteration to find the node"+ n.c.getCourseID());
					return n;
				}
					
				n=n.next;
				counter++;
				if(counter == 0)
				{
					System.out.println("Could not find the node "+n.c.getCourseID());
				}
			}
			
			
			return null;
		}
		
		/**
		 * uses the "find" method defined before to search for the course id and returns true or false
		 * @param id
		 * @return
		 */
		public boolean contains(String id)
		{
			CourseNode t = find(id);
				
				if (t != null)
					return true;
				else 
					return false;
		}
		
		/**
		 * deletes the node at the index and add the requested node to that index
		 * @param toAdd
		 * @param index
		 * @throws NoSuchElementException
		 */
		public void replaceAtIndex(Course toAdd, int index)throws NoSuchElementException 
		{
			if (index < 0 || index >= size) 
			{
				System.out.println(index+" is not an index in the list, the list goes from 0 to "+(size-1));
				return;
			}
			
			
			if(index == 0) 
			{
				head = new CourseNode(toAdd, head.next);
			}
				else
				{
					CourseNode p = head;
					int counter = 0;
						while(counter < index-1)
						{
							p = p.next;
							counter++;
						}
					p.next = new CourseNode(toAdd, p.next.next);
						p=null;
				}
		}
		
		/**
		 * iterate through the list and outputs the courseID
		 */
		public void ShowList() 
		{
			CourseNode p = head;
			if (p==null)
				System.out.println("The List is empty!");
			
			else 
			{
				System.out.println("\nShowing List with courseIDs");
				
				while(p!=null) 
				{
					System.out.print(p.c.getCourseID() + " => ");
					p=p.next;
				}
				System.out.println("\n*************");
			}
			
			
		}
		

		public CourseNode getNodeAtIndex(int i) {
			if (head == null) {
				return null;
			}
			int counter =0;
			CourseNode t = head;
			
			while(t.next != null && counter != i) {
				t = t.next;
				counter++;
			}
			return t;
			
		}
		
	
		
		public boolean delete(String toDel) {
			
			if (head == null) {
				return false;
			}
			
			if (head.getCourseObject().getCourseID().equals(toDel)) {
				head = head.next;
				return true;
			}
			
			CourseNode t = head;
			
			while(t.next != null || t.next.getCourseObject().getCourseID().equals(toDel)) {
				t=t.next;
				return true;
				
			}
			return false;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
