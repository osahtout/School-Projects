package com.HuffmanSplayTree;
public class priorityQueue<T> extends BinaryTree{
	
	
	T[] aQueue;
	int size, front, end, sizeOfLine;
	
	
	@SuppressWarnings("unchecked")
	public priorityQueue()
	{
		//System.out.println("Creating a default Queue size of 10");
		size = 11;
		aQueue = (T[]) new Object[size];
		
		
		
		front = 0;
		end = 0;
		sizeOfLine = 0;
	}
	
	@SuppressWarnings("unchecked")
	public priorityQueue(int size)
	{
		this.size = size;
		aQueue =(T[]) new Object[size];
		

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
	
	public treeNode[] getQueue()
	{
		return (treeNode[]) aQueue;
	}
	
	public treeNode getSpecificQueue(int i)
	{
		return (treeNode) aQueue[i];
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
	
	
	public boolean enqueue2(T a)
	{
		int q = (int) a;
		if(isFull())
		{
			System.out.println("QUEUE IS FULL");
			return false;
		}
		else
		{
			
			aQueue[end] = a;
			
//			if(end+1 == size)
//				end =0;
//			else
				end++;
			
			
			sizeOfLine++;
				return true;
		}
			
	
		
	}

	
	
	
	
	
	public treeNode deQueue()
	{
		
		if(isEmpty())
		{
			
			System.out.println("QUEUE IS EMPTY");
				return null;
		}
		
		else
		{
			T t = aQueue[front];
			aQueue[front] = null;
			
			if(front+1 == size)
				front = 0;
			else
			front++;
			
			sizeOfLine--;
			return (treeNode) t;
		}
	}
	
	
	
	public treeNode peek()
	{
		return (treeNode) aQueue[front];
	}
	
	
	public void toDisplay()
	{
		for (int i = 0;i<aQueue.length;i++)
		{

			System.out.println("|"+i+": "+aQueue[i]+" ");
			
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

//	public int compareTo(BinaryTree o) {
//		
//		
//		int freqCompare = 0;
//		int lc = 0;
//		
//		if(this.getChar() < o.getChar())
//			lc = -1;
//		else if(this.getChar() > o.getChar())
//			lc = 1;
//		
//		if(this.getValue() < o.getValue())
//			freqCompare = -1;
//		else if(this.getValue() > o.getValue())
//			freqCompare = 1;
//		
//		if(freqCompare != 0)
//			return freqCompare;
//		return lc;                }
	
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
