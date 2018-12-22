package com.HuffmanSplayTree;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SplayTree extends BinaryTree
{
	
	
	
	static treeNode root;
	
	
	public SplayTree(int data)
	{
		root=new treeNode(data);
	}
	
	
	public SplayTree() {
		root = null;
	}


	public boolean add(int data)
	{

        if (root == null) {

            root = new treeNode(data);

        } else {

            treeNode t = root;
            treeNode parentNode;
            
            
            while (true)
            {
                parentNode = t;
                
                //adds to the left is less than value
                if (data < t.value) 
                {
                    t = t.leftChild;
                
                    if (t == null)
                    {        
                        parentNode.leftChild = new treeNode(data, null, null);
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
                        parentNode.rightChild = new treeNode(data, null, null);
                        size++;
                        return true;
                    }
                }
            }
        }
		return false;
	}

	
	public  treeNode find(int v )
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
		splay();
		return t;
	}
	
	public int contains(int data, treeNode n) {
		treeNode t = find(data);
		if(t!=null)
			return 1;
		return -1;
	}
	
	
	public boolean delete(int data )
	{
		//root= delete(data);
		return true;
	}
	
	public treeNode delete(int data, treeNode n) {
		// TODO Auto-generated method stub
		return null;
	}
	 
	
	public treeNode findMinvalueNode(treeNode n) {
		// TODO Auto-generated method stub
		return null;
	}

	public void preOrder()
	{
		System.out.println("Pre-order traversal");
	}
	
	
	
	public static void splay()
	{
		//if this
		zigzig();
		//else
		zigzag();
	}
	
	public static void zigzig()
	{
		
	}
	public static void zigzag()
	{
		
	}
	
	
	static Scanner scan;
	
	public static void main(String[] args)
	{
		
			String sourceFile = args[0];
			SplayTree sp= new SplayTree();
			
			try {
				
				scan = new Scanner(new FileInputStream(sourceFile));
				
				String s = null;
				
				while(scan.hasNextLine())
				{
					s = scan.nextLine();
					if(s.charAt(0)=='f')
						sp.find(Integer.parseInt(s.substring(1, s.length()-1)));
					else if(s.charAt(0)=='a')
						sp.add(Integer.parseInt(s.substring(1, s.length()-1)));
					else if(s.charAt(0)=='r')
						sp.delete(Integer.parseInt(s.substring(1, s.length()-1)));
					else
						System.out.println("oops something went wrong");
					
				}
				
				scan.close();
				
			}catch(FileNotFoundException e)
			{
				System.out.println("File not found\nterminating");
				System.exit(0);
			}
			
			
		
		
	}
	


}
