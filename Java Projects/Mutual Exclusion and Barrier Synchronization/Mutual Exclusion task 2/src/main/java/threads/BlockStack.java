package threads;
import threads.exceptions.*;
/**
 * Class BlockStack
 * Implements character block stack and operations upon it.
 *
 * $Revision: 1.4 $
 * $Last Revision Date: 2019/02/02 $
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by an earlier code by Prof. D. Probst

 */
class BlockStack
{

	private static int stackAccessCounter = 0;

	public static final int MAX_SIZE = 28; /** # of letters in the English alphabet + 2 */

	private static final int DEFAULT_SIZE = 6; /** Default stack size*/

	private int sizeOfStack = DEFAULT_SIZE; /** Current size of the stack */

	private int topOfStack = 3; /** Current top of the stack */

	private char[] charStack = new char[] {'a', 'b', 'c', 'd', '*', '*'}; /** stack[0:5] with four defined values */




	public int getISize()
	{
		return sizeOfStack;
	}

	public int getITop()
	{
		return topOfStack;
	}

	public int getAccessCounter() { return stackAccessCounter; }


	public boolean isEmpty()
	{
		return this.topOfStack == '*';
	} //TODO


	/**
	 * Default constructor
	 */
	public BlockStack()
	{
	}

	/**
	 * Supplied size
	 */
	public BlockStack(final int piSize)
	{


                if(piSize != DEFAULT_SIZE)
		{
			this.charStack = new char[piSize];

			// Fill in with letters of the alphabet and keep
			// 2 free blocks
			for(int i = 0; i < piSize - 2; i++)
				this.charStack[i] = (char)('a' + i);

			this.charStack[piSize - 2] = this.charStack[piSize - 1] = '*';

			this.topOfStack = piSize - 3;
                        this.sizeOfStack = piSize;
		}
	}

	/**
	 * Picks a value from the top without modifying the stack
	 * @return top element of the stack, char
	 */
	public char pick() throws emptyStackException
	{
		if(this.charStack[0] == '*')
			throw new emptyStackException("stack is EMPTY");

		stackAccessCounter++;
		return this.charStack[this.topOfStack];
	}

	/**
	 * Returns arbitrary value from the stack array
	 * @return the element, char
	 */
	public char getAt(final int piPosition)
	{
		stackAccessCounter++;
		return this.charStack[piPosition];
	}

	/**
	 * Standard push operation
	 */
	public void push(final char pcBlock) throws emptyStackException, fullStackException
	{
		stackAccessCounter++;

			if (this.charStack[0] == '*') {
				this.charStack[0] = 'a';
				throw new emptyStackException("Stack is EMPTY");
			}

			else if(this.charStack[charStack.length-1] != '*')
				throw new fullStackException("Stack is FULL");
			else {
				this.charStack[++this.topOfStack] = pcBlock;
				System.out.println(pcBlock + " has been successfully added to the stack");
			}
	}

	/**
	 * Standard pop operation
	 * @return ex-top element of the stack, char
	 */
	public char pop()
	{
		stackAccessCounter++;

		try {
			if(this.charStack[0] == '*')
				throw new emptyStackException("stack is EMPTY");

			char cBlock = this.charStack[this.topOfStack];
			this.charStack[this.topOfStack--] = '*'; // Leave prev. value undefined

			return cBlock;

		}
		catch (emptyStackException e)
		{
			System.out.println("Stack is empty, will return a *");
			return '*';
		}
	}
}

// EOF
