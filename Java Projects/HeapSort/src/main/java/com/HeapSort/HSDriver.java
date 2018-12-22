package com.HeapSort;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
public class HSDriver {

	static Scanner wot;
	
	
	
	public static void main(String[] args) 
	{
		
		
		System.out.println('\''+1);
		for(int i = 0;i<24;i++)
		{
		System.out.println((133+323*i)%12);
		
		}
		long s2 = System.nanoTime();
		int sum = 0;
		for(int i = 3;i<2000000;i++)
		{
			
			if (isPrime(i))
			{
				//System.out.println(i+" time: "+System.currentTimeMillis());
				sum += i;
			}
				
		}
		long e2 = System.nanoTime();
		System.out.println("sum is: "+sum+" time: "+(e2-s2));
//		
//		for (long c = 0; c< 99999999999999L; c++)
//		{
//			for (long b = 0;b<=c ; b++)
//			{
//				for (long a = 0;a<=b; a++)
//				{
//					System.out.println(a+" + "+b+" + "+c+" = "+(a+b+c));
//					if((a*a)+(b*b)==(c*c) && a+b+c== 1000) 
//					{
//						System.out.println("found it");
//						System.out.println("*******************");
//						System.out.println("*******************");
//						System.out.println("*******************");
//						System.out.println("*******************");
//						System.out.println("a: "+a);
//						System.out.println("b: "+b);
//						System.out.println("c: "+c);
//						System.out.println("abc: "+a*b*c);
//						System.exit(0);
//					
//					}
//				}
//			}
//		}
		
		
//		int prime = 0;
//		
//		
//		
//		try {
//			wot = new Scanner(new FileInputStream("primes-to-200k.txt"));
//			prime = Integer.parseInt(prime());
//			
//		} catch (FileNotFoundException e1) {
//			System.out.println("WOT UR U DOIN");
//			
//			
//		}
//		System.out.println(isPrime(prime));
//		
//		wot.close();
//		
		
		
		
		
		
		
		
		
		
		System.out.println("--------------------------------");
		
		int input[] = null;
		int input2[] = null;
		if(args[0].equalsIgnoreCase("randomgen")) 
		{
			System.out.println("Random Gen selected.");
			
			int size = Integer.parseInt(args[1]);
			RandomGen r = new RandomGen(size);
			 input = new int[size];
			
			 
			//adds numbers and randomizes the array from RandomGen class 
			r.randomize(input, size);
			
			
			//seed arguments
			if (args.length>3)
			{
				 input2 = input;
				 
			}
			
			
			
				System.out.print("\nHere is your unsorted Random array: ");
				for(int i = 0; i< size;i++)
				{
				System.out.print(input[i]+" ");
				}
			
		  }
		
		
		
		else if(args[0].equalsIgnoreCase("fixedgen"))
		{
			
			System.out.println("Fixed Gen selected.");
			
			int size = Integer.parseInt(args[1]);
			FixedGen r = new FixedGen(size);
			 input = new int[size];
			
			 
			//adds numbers and randomizes the array from RandomGen class 
			r.fix(input, size);
			
			System.out.print("\nHere is your unsorted Fixed array: ");
			for(int i = 0; i< size;i++)
			{
			System.out.print(input[i]+" ");
			}
			
			
		}
		else {
			System.out.println("Something went wrong, terminating immediatly.");
			System.exit(0);
		}
		
		
		
		
		
		
		
		
		if(args[2].equalsIgnoreCase("-1") || args[2].equalsIgnoreCase("0"))
		{
			
			
			
		
			long s = System.nanoTime();
			HeapSort.sort(input);
			long e = System.nanoTime();
			
			System.out.print("\nHere is your heapified array: ");
			for(int i = 0; i<input.length;i++)
			{
				System.out.print(input[i]+" ");
			}
			System.out.println("\nTime elapsed: "+(e-s)+"ns.");
			
			
			if(args.length>3 && args[3].equalsIgnoreCase("seed"))
			{
				long s1 = System.nanoTime();
				HeapSort.sort(input2);
				long e1 = System.nanoTime();
				
				System.out.print("\nHere is your heapified array: ");
				for(int i = 0; i<input.length;i++)
				{
					System.out.print(input[i]+" ");
				}
				System.out.println("\nTime elapsed: "+(e1-s1)+"ns.");
			}
			
			
		}
		else 
		{
			int traceStep = Integer.parseInt(args[2]);
			
			
			
			long s = System.nanoTime();
			HeapSort.sort(input, traceStep);
			long e = System.nanoTime();
			
			System.out.print("\nHere is your heapified array: ");
			for(int i = 0; i<input.length;i++)
			{
				System.out.print(input[i]+" ");
			}
			
			
			System.out.println("\nTime elapsed: "+(e-s)+"ns.");
			
			
			
			if(args.length>3 && args[3].equalsIgnoreCase("seed"))
			{
				long s1 = System.nanoTime();
				HeapSort.sort(input2, traceStep);
				long e1 = System.nanoTime();
				
				System.out.print("\nHere is your heapified array: ");
				for(int i = 0; i<input.length;i++)
				{
					System.out.print(input[i]+" ");
				}
				System.out.println("\nTime elapsed: "+(e1-s1)+"ns.");
			}
		}
		
		
		
		
		

	}
	
	
	public static String prime()
	{

		String prime = null;
		int c = 0;
		while(wot.hasNext())
		{
			prime = wot.next();
			c++;
			System.out.println(c+" "+prime);
			if (c == 10001)
			return prime;
			
		}
		return prime;
	}
	
	static boolean isPrime(int n) {
	    
	    if (n%2==0) return false;
	  
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	
	public static int sum1(int n)
	{
		if(n <= 1)
			return n;
		
		else
			return n*n+(sum1(n-1));
		
	}
	
	public static int sum2(int n)
	{
		if (n<=1)
			return n;
		else 
			return (n+sum2(n-1));
	}

}
