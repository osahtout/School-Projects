/**
 * the (not that) flexible tree structure
 * @author osaht
 * @param <T>
 *
 */


package com.HuffmanSplayTree;
	
	
public class BinaryTree extends myQueue implements Comparable<Object>{

	
	public static class treeNode
	{
		
		int index;
		int value;
		char letter;
		
		
		treeNode rightChild;
		treeNode leftChild;
		
		
		public treeNode()
		{
			value = 0;
			letter = ' ';
			index = 0;
			
			rightChild = null;
			leftChild = null;			
		}
		
		public treeNode(int value) 
		{
			this.value = value;
		}
		public treeNode(int value, treeNode leftChild, treeNode rightChild)
		{
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		
		public treeNode(int value, char c, treeNode leftChild, treeNode rightChild)
		{
			this.value = value;
			this.letter = c;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		
		
		public treeNode(char l)
		{
			this.letter = l;
		}
		
		public treeNode(char value, treeNode leftChild, treeNode rightChild)
		{
			this.letter = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		
		
		public void setChar(char c)
		{
			this.letter = c;
		}
		public char getChar()
		{
			return this.letter;
		}
		
		public void setValue(int value)
		{
			this.value = value;	
		}
		public void setLeftChild(treeNode l)
		{
			this.leftChild = l;
		}
		public void setrightChild(treeNode r)
		{
			this.rightChild = r;
		}
		
		public int getValue()
		{
			return this.value;
		}
		public treeNode getLeftChild()
		{
			return this.leftChild;
		}
		public treeNode getRightChild()
		{
			return this.rightChild;
		}
		
		
		
		public String toString() {
			return "\n*Value: "+this.value+" && Char: "+letter+"\nrightChild: "+rightChild+"\n"+"leftChild: "+leftChild+"*\n";
		}
		



		
		
		public int compareTo(treeNode o) {
		
			
			int freqCompare = 0;
			int lc = 0;
			
			if(this.letter < o.letter)
				lc = -1;
			else if(this.letter > o.letter)
				lc = 1;
			
			if(this.value < o.value)
				freqCompare = -1;
			else if(this.value > o.value)
				freqCompare = 1;
			
			if(freqCompare != 0)
				return freqCompare;
			return lc;
			
			
			
		}

		
}
	
	
	
	treeNode root;
	static int size = 0;
	//treeNode travers = root;
	
	public  BinaryTree()
	{
		root = null;
	}

	public boolean add(int value)
	{
        if (root == null) {

            root = new treeNode(value);

        } else {

            treeNode t = root;
            treeNode parentNode;
            
            
            while (true)
            {
                parentNode = t;
                
                //adds to the left is less than value
                if (value < t.value) 
                {
                    t = t.leftChild;
                
                    if (t == null)
                    {        
                        parentNode.leftChild = new treeNode(value, null, null);
                        size++;
                        return true;
                    }
                } 
                //or adds to the right if its not less
                else
                { 

                   t = t.rightChild;
                   
                    if (t == null) 
                    {
                        parentNode.rightChild = new treeNode(value, null, null);
                        size++;
                        return true;
                    }
                }
            }
        }
		return false;
    }
	
	
	public treeNode getParentNode(int value)
	{
		treeNode t = root;
		
		 while (true)
            {
               // treeNode parentNode = t;
                
                //adds to the left is less than value
                if (value < t.value) 
                {
                   if(t.leftChild.value != value)
                	t = t.leftChild;
                
                    return t;
                } 
                //or adds to the right if its not less
                else
                { 
                
                if(t.rightChild.value != value)
                   t = t.rightChild;
                return t;
                }
                   
            }        
	}

	public boolean delete(int value)
	{
		
			
		
		return false;
	}
	
	
	public boolean checkBST()
	{
		
		//TODO
		return false;
	}
	
	public boolean isLeaf(treeNode t)
	{
		
		if(t.leftChild == null && t.rightChild == null)
			return true;
		
			return false;
	}
	
	
	
	public void traverse(String s, treeNode t)
	{
		
		if(s.equalsIgnoreCase("inOrder"))
		{
			if(t != null)
			{
				traverse("inOrder", t.leftChild);
				System.out.print(t.value+" ");
				traverse("inOrder",t.rightChild);
			}
		}
		else if(s.equalsIgnoreCase("preorder"))
		{

			if(t != null)
			{
				System.out.println(t.value+" ");
				traverse("preorder", t.leftChild);
				traverse("preorder", t.rightChild);
				
			}
		}
		else
		{
			//TODO postorder
		}
		
		
	}
	
	

	public void inOrder(treeNode t)
	{
		

		if(t != null)
		{
			inOrder(t.leftChild);
			System.out.print(t.value+" ");
			inOrder(t.rightChild);
		}
	}
	
	
	public  treeNode findByValue(int v)
	{
		treeNode t = root;
		
		while(t!=null)
		{
			if(v < t.value)
				t = t.leftChild;
			else if(v > t.value)
				t = t.rightChild;
			else if(t.value == v)
				return t;
			else 
			{
				System.out.println("No Node found with such value");
				return null;
			}
		}
		
		return t;
	}
	
	
	


	@Override
	public int compareTo(Object o) {
		
		return 0;
	}

	
	
	
	
	
	
	
	
}
