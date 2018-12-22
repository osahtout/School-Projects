package com.HuffmanSplayTree;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;



public class Huffman extends BinaryTree{
	static BufferedReader scan = null;
	BinaryTree bt = new BinaryTree();
	
	static myQueue<BinaryTree.treeNode> queue = new myQueue<>(257);
	
	public static void main(String[] args)
	{
		String sourceFile = null;
		if(args[0]!=null)
		sourceFile = args[0];
		int[][] asc = new int[2][256];
		int[] asc1 = new int[256];
		
		int coun=0;
		for(int i =0;i<256;i++)
		{
			asc[0][i] = coun;
			coun++;
		}
		
		//System.out.println(queue.getSize());
		
		
		
		try
		{
			
			
			scan = new BufferedReader(new FileReader(sourceFile));
			asc1 = getFrequency();
			scan.close();
			
			
		}catch(FileNotFoundException e)
		{
			System.out.println("File does Not exist\nTerminating...");
			System.exit(0);
		}catch(IOException e)
		{
			System.out.println("File does Not exist\nTerminating...");
			System.exit(0);
		}
		
/*		
		for(int i =0;i<asc1.length;i++)
		{
			asc[1][i] = asc1[i]; 
		}
		
		for(int i =0;i<2;i++)
		{
			for(int j =0;j<=i;j++)
			{
				asc[1][i] = asc1[i]; 
			}
			
		}
		
		for (int i = 0; i < asc.length; i++) {
            for (int j = 0; j < asc[i].length; j++) {
                System.out.print(asc[i][j]+" ");  }
            System.out.println();		}
		
	*/	
		
		
		BinaryTree.treeNode root = huffmanTree(asc1);
		
		
		System.out.println(root.toString());
			
		

		
		
	}
	
	/**
	 * taken from assignment 1
	 * @param toSort
	 * @return
	 */
	public static int[][] insertionSort(int[][] toSort)
	{
		
		int[][] sorted = new int[2][256];
		for (int i = 1;i < 256; i++) // loop starting at the first element and not the 0th element because theres nothing to compare the zeroth element
		{
			sorted[i][i] = toSort[i][i];
		}
		
		
		
		for (int i = 1;i < 256; i++) // loop starting at the first element and not the 0th element because theres nothing to compare the zeroth element
		{
			
			int current = sorted[1][i]; //storing the current value to insert it later
			int k = i;
			
			
			while((k-1)>=0 && sorted[1][k-1]>current) //if the value we are looking is that the previous to keep loopin
			{		
				sorted[k][k] = sorted[k-1][k-1];  // if the value is larger, than the current it moves the value
					k--;
			}
			
			sorted[1][k] = current; //when the shifting is done, the current element is moved to the sorted place
		}	
		
		return sorted;	
	}
	
	
	public static BinaryTree.treeNode huffmanTree(int[] frequencyArray)
	{
		//
		PriorityQueue<treeNode> pq = new PriorityQueue<>(); // this didnt work either...
		for(char i = 0; i<256 ;i++)
		{
			
				
				if(frequencyArray[i] > 0)
				{
					
				queue.enqueue(new treeNode(frequencyArray[i], i, null, null));
				}
			}
			while(queue.getSizeOfLine() > 1)
			{
				
				treeNode parent = merge();
				queue.enqueue(parent);
				
			
				}
		return queue.deQueue();
	}
	
	
	//merges the 2 smallest nodes to make a parent node
	
	public static treeNode merge()
	{
		treeNode l = queue.deQueue();
		treeNode r = queue.deQueue();
		
		treeNode merged = new BinaryTree.treeNode(l.getValue()+r.getValue(), '\0', l, r);
		
		return merged;
		
	}
	
	public static int[] getFrequency() throws IOException
	{
		int[] frequencyArray = new int[256];
		
	
			int x;
			int c = 0;
			x = scan.read();
			while(x != -1) 
			{
				frequencyArray[x]++;
				//System.out.print((char)x);
				x = scan.read();		
			}
		
			scan.close();
			
			
	
		return frequencyArray;
		
	}

}
