package com.CourseSequence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.CourseSequence.CourseList.CourseNode;

import java.util.NoSuchElementException;
//import java.util.StringTokenizer;



public class EnrolmentResults 
{
	static Scanner sc = null;

	public static void main(String[] args) 
	{
			
		System.out.println("Welcome to the enrollment program\n");
		
			CourseList list2 = new CourseList();
		
			
			
			/*
			CourseList list1 = new CourseList();

			
					Course a = new Course();
					a.setCourseID("aaaaaaaaa");
					Course b = new Course("wotwotid", "java",3.0, "before java", "none");
					Course c = new Course("@@@@@@@@@@@@@@@@@", "java",3.0, "before java", "none");
					Course d = new Course("4444444id", "java",3.0, "before java", "none");
					Course e = new Course("88888833id", "java",3.0, "before java", "none");
					Course f = new Course("lksjhalksdjfhlaid", "java",3.0, "before java", "none");
				
					
					list1.addToEnd(c);
					list1.addToStart(b);
					list1.addToStart(a);
					
					
					list1.addToEnd(e);
					list1.addToEnd(f);
					list1.addToEnd(d);
				
					
						CourseList l2 = null;
						
							//copy constructor
										try {
											l2 =	list1.clone();
										} catch (CloneNotSupportedException e1) {
											System.out.println("Something went wrong with cloning");

										}
										
										System.out.println("-----------------------------\nCOpy constructor list");
									l2.ShowList();
						
						
									System.out.println("----------------------------------------\nThe find and contain method and private leak");
										System.out.println(l2.contains("wotwotid"));
										CourseNode t = list1.find("wotwotid");
										
										t.getCourseObject().setCourseID("0000000000000000000000000000000000");
						
										System.out.println(t.getCourseObject().getCourseID());
										
						
									
					
					
				
										System.out.println("The Size of The List1 is "+list1.countSize()+" and l2 "+l2.getSize()+"\n");
			System.out.println("--------------------\nadding at index method");
					try {
					list1.addAtIndex(c, 5);
					}catch(NoSuchElementException e1) {
						System.out.println("Something went wrong adding at infex\nTerminaing immediatly");
						System.exit(0);
					}
					
					
					
					list1.ShowList();
				
				
				System.out.println("--------------------\ndeleting from start method");
				
					list1.deleteFromStart();
					
					list1.ShowList();
					
				System.out.println("--------------------\ndeleting from index method");
					list1.deleteAtIndex(4);
					
					
					list1.ShowList();
				//	System.out.println("\nThe Size of The List is "+list1.countSize()+" and new "+list1.getSize());
					
					System.out.println("--------------------\replace  from start method");
					list1.replaceAtIndex(a, 4);
//						list1.ShowList();
					
				
			*/
	
				try
				{
					/**attempt to open the syllabus 
					 * if not successful, terminates
					 */
					sc = new Scanner(new FileInputStream("Syllabus.txt"));	
				
				}
				catch (FileNotFoundException mesage) 
				{
					System.out.println("\nCould not open file");
					System.out.println("\nTerminating program immediaty");
					System.exit(0);
				}	
				
				
				/**
				 * After string method that returns the an array of courses from the syllabus
				 * 
				 */
				Course[] Carray = addCourse();
					sc.close();
				
				
				
				//	System.out.println(list2.countSize());
					
					
					
					/**
					 * adds all the courses from the array a link list
					 * I added an extra step to make sure if i need to verify everything
					 */
				
				for (int i = 0;i<Carray.length;i++) {
					//System.out.println(Carray[i]+"\n**********\n");
					list2.addToEnd(Carray[i]);
					
				}
				
				
				System.out.println(list2.getSize());
				list2.ShowList();

				//deletes the duplicates
				list2 = deleteDuplicates(list2);
				
				
				
				System.out.println(list2.getSize());
				
				//prints the linked list
				list2.ShowList();
				
				Scanner key = new Scanner(System.in);
				String req = null; 
				
				
				System.out.println("Do you have a request? (Request1, Request2, Request3 or Request4 (ENTER 'Stop' TO EXIT)");
				
					
				
				
				req = key.next();
					
//				System.out.println(" ");
//				String	ans=key.nextLine();
					
				/**
				 * changes the string so the user won't have to type the file capitalized and won't need the extension
				 */
					String request = req.substring(0, 1).toUpperCase() + req.substring(1);
					
					if(!request.endsWith(".txt"))
						request = request+".txt";
					
					
					
					try {
						sc = new Scanner(new FileInputStream(request));
					}catch (FileNotFoundException mesage) {
						System.out.println("\nCould not open file");
						System.out.println("\nTerminating program immediaty");
						System.exit(0);
					
					}	
					
					
					
					ArrayList<String> infoRequest = requestFile();
					
						sc.close();
					
				
						canOrCannot(infoRequest, list2);
					
				
			
						key.close();
	
	System.out.println("\n***********************************\nThank you for using my enrollement program!");
	
	
	}
	
	
	/**
	 * Takes an arraylist of all the requested and completed class
	 * then verifies that the preReq have been met or is taking the class concurrently with the coReq
	 * Notifies the user what they can or cannot enroll
	 * @param wot
	 * @param list
	 */
	public static void canOrCannot(ArrayList<String> wot, CourseList list) 
	{
		int size = wot.size();
		int stop = wot.indexOf("Requested");
		ArrayList<String> requ = new ArrayList<String>();
		ArrayList<String> fini = new ArrayList<String>();

		ArrayList<String> can = new ArrayList<String>();
		ArrayList<String> not = new ArrayList<String>();
		


		
			if ((size-1) == (stop))
				System.out.println("\nNo Enrollment courses requested");
			
			else 
			{
				
					for (int i = stop+1;i < wot.size();i++) 
					{
						requ.add(wot.get(i));	
					}
				
				
					for (int i = 1;i < stop;i++) 
					{
				//	if (list.contains(wot.get(i)))
						fini.add(wot.get(i));
					}
				
				
					for (int i = 0;i < requ.size();i++) 
					{
						for (int j = 0;j < fini.size();j++) 
						{
							if ((list.find(requ.get(i)).getCourseObject().getPreReqID()).equalsIgnoreCase(fini.get(j)))
							{
								System.out.println("You CAN enroll for "+requ.get(i)+" because you completed "+list.find(requ.get(i)).getCourseObject().getPreReqID());
									can.add(requ.get(i));
							}
						
							
							
						for (int k = 0;k < requ.size();k++) 
						{	
							if((list.find(requ.get(i)).getCourseObject().getCoReqID()).equalsIgnoreCase(requ.get(k)))
							{
								if(!can.contains(requ.get(i))) 
								{
									System.out.println("You CAN enroll for "+requ.get(i)+" because you are taking "+requ.get(k));
										can.add(requ.get(i));
								}
							}
						 
						} 
						}
					
					
					
					}
				
				for (int i = 0;i < requ.size();i++) 
				{
					if	(!can.contains(requ.get(i)))
						not.add(requ.get(i));
				}

				
					if (!not.isEmpty()) 
					{
							for (int i = 0;i<not.size();i++)
							{
									System.out.println("You CANNOT enroll in " + not.get(i)+ " becasue you have not completed "+list.find(not.get(i)).getCourseObject().getPreReqID());
							}
					}
			}
		
		}

			
			
	
	
			/**
			 * this is adds the requested and completed to an array
			 * @return
			 */
			public static ArrayList<String> requestFile()
			{
				ArrayList<String> request = new ArrayList<String>();
				String s;
				while(sc.hasNextLine()) 
				{
					s = sc.nextLine();
					request.add(s);
				}

				return request;
			}
	
			

	
			/**
			 * Opens the syllabus and splits all the information to the necessary parameters for the courses and adds them to and array
			 * @return
			 */
		public static Course[] addCourse()
		{
			
			String s = null, id = null, name = null, pre = null, co = null, num = null, comp = "COMP";
			double d = 0;
			Course[] coursArray	 = new Course[10];
			int i = 0;
	
				while(sc.hasNextLine())
				{
		
					while(i<coursArray.length) 
					{
		
						s = sc.nextLine();
	
							if (s.startsWith(comp))
							{	
								id = s.substring(0, 7);
								name = s.substring(8, s.length()-2);
									if (i==4 || i==6) 
									{
											name = s.substring(8, s.length()-3);
									}
									name = name.replace('_', ' ');
									num = s.substring(s.length()-2);
	//	System.out.println(num);	
						//			double dnum = 0;
						//			if (sc.hasNextDouble())
						//			dnum = sc.nextDouble();
									
						//			System.out.println(dnum);
									d = Double.parseDouble(num);
		

	//	System.out.println("\n------------------------\n"+id+"\n"+name+"\n"+d+"\n-------------------------\n");
								if (sc.hasNextLine()) 
								{
									s = sc.nextLine();
		
										if (s.length()>1)
										{
											pre = s.substring(1);
											pre = pre.substring(1);
										}
										else 
											pre ="none";
	//			System.out.println("\n------------------------\n"+pre+"\n-------------------------\n")
								}
		
										if (sc.hasNextLine()) 
										{
											s = sc.nextLine();
		
												if (s.length()>2) 
												{
													co = s.substring(2);			
												}
												else 
													if(s.length() <= 2)
														co ="none";
		//		System.out.println("\n-----------------------\n"+co+"\n-------------------------\n");

										}
										
										coursArray[i] = new Course(id, name, d, pre, co);
											i++;
							}

					}
	
	
				}
		
		
					return coursArray;
		}
		
		
		
		/**
		 * if there's two courses with the same courseID, it deletes the last one
		 * @param cl
		 * @return
		 */
		public static CourseList deleteDuplicates(CourseList cl) {
			
			
			for (int i = 0;i<cl.getSize();i++) {
				for (int j = i+1;j<cl.getSize();j++) {
					if (cl.getNodeAtIndex(i).getCourseObject().getCourseID().equals(cl.getNodeAtIndex(j).getCourseObject().getCourseID())) {
					//	System.out.println(cl.getNodeAtIndex(j).getCourseObject().getCourseID());
						System.out.println("There seems to be duplicates. Deleteing duplicates...");
						
						cl.deleteAtIndex(j);
					}
				}
			}
			return cl;
		}
		
		
		
		
		
		
		
		
		
		
		
		
}




//this is testing the CourseList and CourseNode


/*	CourseList list1 = new CourseList();

System.out.println(list1.countSize());
		Course a = new Course();
		a.setCourseID("aaaaaaaaa");
		Course b = new Course("wotwotid", "java",3.0, "before java", "none");
		Course c = new Course("@@@@@@@@@@@@@@@@@", "java",3.0, "before java", "none");
		Course d = new Course("4444444id", "java",3.0, "before java", "none");
		Course e = new Course("88888833id", "java",3.0, "before java", "none");
		Course f = new Course("lksjhalksdjfhlaid", "java",3.0, "before java", "none");
	
		
		list1.addToEnd(c);
		list1.addToStart(b);
		list1.addToStart(a);
		
		
		list1.addToEnd(e);
		list1.addToEnd(f);
		list1.addToEnd(d);
	
		
			CourseList l2 = null;
							try {
								l2 =	list1.clone();
							} catch (CloneNotSupportedException e1) {
								System.out.println("Something went wrong with cloning");

							}
						l2.ShowList();
			
						
							System.out.println(l2.contains("wotwotid"));
							CourseNode t = list1.find("wotwotid");
							
							t.getCourseObject().setCourseID("0000000000000000000000000000000000");
			
							System.out.println(t.getCourseObject().getCourseID());
							list1.ShowList();
			
							l2.ShowList();
		
		
	//	list1.ShowList();
		
//		System.out.println("The Size of The List is "+list1.countSize()+" and new "+list1.getSize()+"\n");
	//		list1.ShowList();
		try {
		list1.addAtIndex(c, 3);
		}catch(NoSuchElementException e1) {
			System.out.println("Something went wrong adding at infex\nTerminaing immediatly");
			System.exit(0);
		}
		
		
		
		list1.ShowList();
	//	System.out.println("\nThe Size of The List is "+list1.countSize()+" and new "+list1.getSize());
		
	//	CourseNode t = list1.find("wotwotid");
		
		list1.deleteFromStart();
		
//			list1.ShowList();
		
	
		list1.deleteAtIndex(4);
		
		
		list1.ShowList();
	//	System.out.println("\nThe Size of The List is "+list1.countSize()+" and new "+list1.getSize());
		
		
		list1.replaceAtIndex(a, 4);
//			list1.ShowList();
		
		
//		System.out.println("\nThe Size of The List is "+list1.countSize()+" and new "+list1.getSize());
		
		
		*/