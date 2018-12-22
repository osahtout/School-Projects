package com.ISort;

public class ISort2 {

	public static void main(String[] args) {
		
		int[] toSort;
		int[] done;
		
		if (args[0].toLowerCase().equals("debug"))
		{
			
			System.out.println("Running debug");
			
			
			toSort = new int[args.length-1];
			done = new int[args.length-1];
			
			for(int i = 1;i<args.length;i++)
			{
				toSort[i] = Integer.parseInt(args[i]); 
			}
			
			done = insertionSort(toSort);
		}
		else
		{
			toSort = new int[args.length];
			done = new int[args.length];
			
			for(int i = 0;i<args.length;i++)
			{
				toSort[i] = Integer.parseInt(args[i]); 
			}
			
			done = insertionSort(toSort);	
		}
		
		
		for (int i = 0;i<done.length;i++)
		{
			System.out.print(done[i]+" ");
		}
		
/*		
		
		int[] some = {6,3,9,1,22,14,8};
		int[] som1 = new int[some.length];
		
		for (int i = 0;i < som1.length; i++)
		{
			System.out.print(some[i]+" ");
			
		}
		System.out.println("\n---------------");
		
		som1 = insertionSort(some);
		
		
		
		for (int i = 0;i < som1.length; i++)
		{
		//	System.out.print(som1[i]+" ");
			
		}
*/
		System.out.println(System.currentTimeMillis());
		
	}
	
	public static int[] insertionSort(int[] toSort)
	{
		
		for (int i = 1;i < toSort.length; i++)
		{
			
			int index = toSort[i];
			int k = i;
			
			
		 while((k-1)>=0 && toSort[k-1]>index)
		 {
			 for (int j = 0;j < toSort.length; j++)
				{
					System.out.print(toSort[j]+" ");
				}
				System.out.println("");
				toSort[k] = toSort[k-1];
				k--;
				
			}
			
			toSort[k] = index;
		}
		
		
		
		return toSort;
		
		
	
	}

}



