package com.HeapSort;

import java.util.Random;

public class RandomGen
{
	
	int[] rand;
	 int size;
	
	 Random r = new Random();
	 
	 
	 public RandomGen() {
		 size = 10;
		 rand = new int[size];
		 
		 rand = randomize(rand, size);
		
	 }
	 
	 public RandomGen(int size)
	 {
		 this.size = size;
		 rand = new int[size];
	 }
	 
	 
	 public int[] randomize(int[] array, int size)
	 {
		 
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(size*10);
		}
		 
		 return array;
	 }
	 
	 public int[] getArray()
	 {
		 return rand;
	 }
	
}
