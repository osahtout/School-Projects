package com.HeapSort;

import java.util.Random;

public class FixedGen {
	
	
	int[] rand;
	 int size;
	
	 Random r = new Random();
	 
	 
	 public FixedGen() {
		 size = 10;
		 rand = new int[size];
		 
		 rand = fix(rand, size);
		
	 }
	 
	 public FixedGen(int size)
	 {
		 this.size = size;
		 rand = new int[size];
	 }
	 
	 
	 public int[] fix(int[] array, int size)
	 {
		 array[0] = r.nextInt(size*5);
		 
		 int toAdd =0;
		
		 
		for (int i = 1; i < array.length; i++) {
			
				
				 toAdd = r.nextInt(size*array[i-1]);
				
				
		
			array[i] = toAdd;
		}
		
		for(int i = 0; i < array.length / 2; i++)
		{
			
			//reverse order for decreasing 
		    int temp = array[i];
		    array[i] = array[array.length - i - 1];
		    array[array.length - i - 1] = temp;
		}
		 
		 return array;
	 }
	 
	 public int[] getArray()
	 {
		 return rand;
	 }
	
	

}
