package com.HeapSort;

public class HeapSort {
//	static int length;
	static int counter = 1;
	static int trace;
	
	public static void sort(int[] input)
	{
		
int		length = input.length-1;
		
		for(int i = length/2;i>=0;i--)
			heapify(input, i, length);
		
		for (int i = length; i>=0; i--)
		{
			
			
			int swap = input[0];
				input[0] = input[i];
					input[i] = swap;
			length = length-1;
			heapify(input, 0, length);
			
			
			
		}
		
	}

	public static void sort(int[] input, int traceStep)
	{
		trace = traceStep;
	int	length = input.length-1;
		
		for(int i = length/2;i>=0;i--)
			heapify(input, i, 0);
		
		for (int i = length; i>=0; i--)
		{
			
			int swap = input[0];
			input[0] = input[i];
			input[i] = swap;
			heapify(input, 0, length);
		
		}
	}

	
	public static void heapify(int[] input, int index, int length)
	{
		
		int parent = index;
		
		int rightChild = 2*index + 1;
		int leftChild = 2*index +2;
		
		int swap = 0;

	
		
		if (leftChild <= length && input[leftChild] > input[index]) {
			parent = leftChild;
			swap = input[index];
		}

		 if (rightChild <= length && (input[rightChild] > input[parent]))  {
			parent = rightChild;
			
		}
		 
	
		 //*******************************
		 if(counter == trace) {
			 System.out.print("\n\nTrace at step "+counter+": ");
			 for(int k = 0; k<input.length;k++)
			 {
				 System.out.print(input[k]+" ");
			 }
			 System.out.println();
			 counter++;
			 } 
		 
		// counter ++;

		if (parent != index)
		{
			 counter ++;
			swap = input[index];
			input[index] = input[parent];
			input[parent] = swap;
			
				heapify(input, parent, 0);
	}
	
	}
}
