/**
 * Name: Omar Sahtout
 * ID:   40018126
 * Assignment 1: insertion sort and more
 */

package com.ISort;

import java.util.*;

public class ISort {

	public static void main(String[] args) {

//		int[] toSort;
//		int[] done = null;
//		long start = 0, end = 0;
//		int temp;
//		long l = 21;
//		int n = 0, r, sum = 0;
//		for (long i = 20; i<= 9999999999L; i++)
//		{
//			if(i%2 == 0 && i%3 == 0 && i%4 == 0 && i%5 == 0 && i%6 == 0 && i%7 == 0 && i%8 == 0 && i%9 == 0 && i%10 == 0 && i%11 == 0 && i%12 == 0 && i%13 == 0&& i%14== 0 && i%15 == 0 && i%16 == 0 && i%17 == 0 && i%18 == 0 && i%19 == 0 && i%20 == 0)
//			{
//				System.out.println(i);
//				if(l>i)
//					l=i;
//			}
//		}



	/**
	 * this is only to test complexity and time in ns
	 */
	if(args.length == 0)
	{

		ArrayList<Integer> wot = new ArrayList<Integer>();
        for (int i=0; i<500; i++)
        {
            wot.add(i);
        }
        Collections.shuffle(wot);
        /**
         * I wanted a way to generate a random number between 1 and 1000
         * then randomize that array(list) without having to manually do it
         * so i read online about collections and found shuffle
         *
         */

        int[] tho = new int[wot.size()];
        int[] done1 = new int[tho.length];


        for (int i=0; i<tho.length; i++)
        {
            tho[i] = wot.get(i);
        }

        //prints the length since its random (just for the complexity question)
        System.out.println("length of array: "+tho.length);

        //prints the sorted array but only the first, middle and last since the array may contain 100s of elements
        System.out.println("\nunsorted list: "+tho[0]+"..."+tho[tho.length/2]+"..."+tho[tho.length-1]);

        long start = System.nanoTime();		//stores right before the algorithm starts
		 done1 = insertionSort(tho);
		 long end = System.nanoTime();		//stores right after the algorithm ends

		System.out.println("sorted array: "+done1[0]+"..."+done1[done1.length/2]+"..."+done1[done1.length-1]);
		System.out.println("\nstart time: "+(start)+"\nend time "+ end);
		System.out.println("\nTotal time: "+(end-start)+" nanosec");

	}


		if(args.length>0) {
			System.out.print("Your unsorted list: ");
			for (int i = 0;i<args.length;i++)
			{
				System.out.print(args[i]+" ");
			}
			System.out.println("");
try {


		/**
		 * using debug as the first argument
		 */

		if (args[0].toLowerCase().equals("debug"))
		{

			System.out.println("Running debug");

			/**
			 * converting the Strin[] to an array of ints ingnoring debug
			 */
			int []toSort = new int[args.length-1];
			int[] done = new int[args.length-1];

			for(int i = 0;i<toSort.length;i++)
			{
				toSort[i] = Integer.parseInt(args[i+1]);
			}



			long start = System.nanoTime();		//stores the start of time right before
			done = ISortDebug(toSort);
			 long end = System.nanoTime();		//stores in the end of time for the algorithm


			 //prints the sorted array
			 System.out.print("Your sorted list: ");
			 for(int i = 0;i<done.length;i++)
				{
			 System.out.print(done[i]+" ");
				}


			 //prints the time
			 System.out.println("\nTotal time: "+(end-start)+" nanosec");

		}


		/**
		 * just integers
		 */

		else
		{


			//converts the args[] to an array of ints
			int[] toSort = new int[args.length];
			int[] done = new int[args.length];

			for(int i = 0;i<args.length;i++)
			{
				toSort[i] = Integer.parseInt(args[i]);
			}


			//stores time right before and right after the algorithm
			long start = System.nanoTime();
			done = insertionSort(toSort);
			 long end = System.nanoTime();

			 //displays the sorted array
			 System.out.print("Your sorted list: ");
			 for(int i = 0;i<done.length;i++)
				{
			 System.out.print(done[i]+" ");
				}


			 //displays the time
			 System.out.println("\nTotal time: "+(end-start)+" nanosec");


		}




		//so it wouldnt crash everythime
}catch(ArrayIndexOutOfBoundsException e)
{
	System.out.println("Missing arguments in args\n(debug has to be the and the rest has to be integers or all are integers\nTerminating program");
	System.exit(0);
}

		}









	}
	/**
	 * insertion algorithm without the debug version
	 * starts the 1st element (not the zeroth) because there's nothing to compare the zeroth element
	 *
	 * @param toSort
	 * @return
	 */
	public static int[] insertionSort(int[] toSort)
	{

		for (int i = 1;i < toSort.length; i++) // loop starting at the first element and not the 0th element because theres nothing to compare the zeroth element
		{

			int current = toSort[i]; //storing the current value to insert it later
			int k = i;


			while((k-1)>=0 && toSort[k-1]>current) //if the value we are looking is that the previous to keep loopin
			{
				toSort[k] = toSort[k-1];  // if the value is larger, than the current it moves the value
					k--;
			}

			toSort[k] = current; //when the shifting is done, the current element is moved to the sorted place
		}

		return toSort;
	}






	public static int[] ISortDebug(int[] toSort)
	{

		for (int i = 0;i < toSort.length; i++)
		{

			int current = toSort[i];
			int k = i;

		//	if(toSort[k] < current)
		//	System.out.print("i"+toSort[k]+"i");

		 while((k)>0 && toSort[k-1] > current)
		 {


			 for(int q=0;q<(k-1);q++)
			 {
				 System.out.print(toSort[q]+" ");
			 }


			 System.out.print("i"+toSort[k-1]+"i ");




			 for(int q=(k);q<(i);q++)
			 {
				 System.out.print(toSort[q]+" ");
			 }


			 System.out.print("|"+current+"| ");


			 for(int q=(i);q<(toSort.length);q++)
			 {
				 System.out.print(toSort[q]+" ");
			 }

		//	 System.out.println("*"+toSort[k-1]+"*");
		//	 System.out.print("****current: "+current+"*******k-1: "+toSort[k-1]);
			 if(current > toSort[k-1])
			 {
				 System.out.print(">");
			 }
			 else if(current < (toSort[k-1]))
			 {
				 System.out.print("<");
			 }
			 else
				 System.out.print("|");

			 System.out.print("\n");


				toSort[k] = toSort[k-1];
				k--;

//				if ((k-1 ==0) && toSort[k-1] > current)
//					System.out.println("i"+toSort[k-1]+"i");
//				for (int q=(k-1);q<(toSort[k]);q++)
//					System.out.print(toSort[q]+"");
//				System.out.print("|"+current+"|");

			}
		 if (k-1 == 0 && toSort[k-1] < current) {
		 System.out.print("i"+toSort[0]+"i ");
		 for (int q = 1; q<i;q ++)
		 	System.out.print(toSort[q]+" ");

		 System.out.print("|"+current+"| ");

		 for (int q = i; q<toSort.length;q ++)
		 System.out.print(toSort[q]+" ");

		 System.out.print(">");

		 System.out.println(" ");
		 }
			toSort[k] = current;

			for (int q = 0; q<toSort.length; q++)
				System.out.print(toSort[q]+" ");
			System.out.print("|");

			System.out.print("\n");

		}

		return toSort;
	}

}

