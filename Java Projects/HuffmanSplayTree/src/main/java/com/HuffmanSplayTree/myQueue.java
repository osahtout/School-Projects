package com.HuffmanSplayTree;

public class myQueue<T>{
	
	T[] theQueue;
	int size, front, end, sizeOfLine;
	
	
	@SuppressWarnings("unchecked")
	public myQueue()
	{
		//System.out.println("Creating a default Queue size of 10");
		size = 11;
		theQueue = (T[]) new Object[size];
		
		
		
		front = 0;
		end = 0;
		sizeOfLine = 0;
	}
	
	@SuppressWarnings("unchecked")
	public myQueue(int size)
	{
		this.size = size;
		theQueue =(T[]) new Object[size];
		

		front = 0;
		end = 0;
		sizeOfLine = 0;
		
	}
	
	public boolean priority(int value)
	{
//		int i;
//		
//		if(sizeOfLine == 0)
//			enqueue(value);
//		
//		for (i = sizeOfLine-1 ; i>-1; i--)
//		{
//			if(theQueue[i] < value))
//				theQueue[i+1] = theQueue[i];
//			else 
//				break;
//			
//			theQueue[i] = value;
//			end++;
//			sizeOfLine++;
//		}
		
		return false;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public T[] getQueue()
	{
		return theQueue;
	}
	
	public T getSpecificQueue(int i)
	{
		return theQueue[i];
	}
	
	public int getFront() {
		return front;
	}

	public int getEnd() {
		return end;
	}

	public int getSizeOfLine() {
		return sizeOfLine;
	}
	
	
	
	public Object[] copyQueue(myQueue q)
	{
		//TODO
		return q.getQueue();
	}
	

	public void setSize(int newSize)
	{
		
		if(newSize < this.size)
			System.out.println("Making Queue smaller size is illogical");
		else 
		{
			this.size = newSize;
			//TODO copy constructor
			
		}
		
	}

	
	
	
	public boolean isFull()
	{
		if(sizeOfLine+1 == size)
				return true;
			else
				return false;	
	}
	
	public boolean isEmpty()
	{
		if(sizeOfLine == 0 || end == 0)
			return true;
		
		return false;
	}
	
	
	public boolean enqueue(T e)
	{
		if(isFull())
		{
			System.out.println("QUEUE IS FULL");
			return false;
		}
		else
		{
			
			theQueue[end] = e;
			
//			if(end+1 == size)
//				end =0;
//			else
				end++;
			
			
			sizeOfLine++;
				return true;
		}
			
	
		
	}

	
	
	
	
	
	public T deQueue()
	{
		
		if(isEmpty())
		{
			
			System.out.println("QUEUE IS EMPTY");
				return null;
		}
		
		else
		{
			T t = theQueue[front];
			theQueue[front] = null;
			
			if(front+1 == size)
				front = 0;
			else
			front++;
			
			sizeOfLine--;
			return t;
		}
	}
	
	
	
	public T peek()
	{
		return theQueue[front];
	}
	
	
	public void toDisplay()
	{
		for (int i = 0;i<theQueue.length;i++)
		{

			System.out.println("|"+i+": "+theQueue[i]+" ");
			
		}
		System.out.println();
//		for (int i = 0;i<theQueue.length;i++)
//		{
//			System.out.print("|   "+i+"   ");
//		
//		}
	
		
		System.out.println(front);
		System.out.println(end);
		
	}

//	public int compareTo(BinaryTree.treeNode o) {
//		
//		
//		int freqCompare = 0;
//		int lc = 0;
//		
//		if(this.getChar() < o.getChar())
//			lc = -1;
//		else if(this.letter > o.letter)
//			lc = 1;
//		
//		if(this.value < o.value)
//			freqCompare = -1;
//		else if(this.value > o.value)
//			freqCompare = 1;
//		
//		if(freqCompare != 0)
//			return freqCompare;
//		return lc;                }
//
//	public char getChar() {
//		
//		return super.letter;
//	}
	
//public static void main(String[] args)
//{
//	myQueue<treeNode> queue = new myQueue<>(257);
//	queue.enqueue(new treeNode());
//	
//	for(char i = 0; i<256 ;i++)
//	{
//		
//			
//		//	queue.enqueue(new treeNode((int) i, i, null, null));
//			
//	}
//	
//	
//	
//}
}
