package threads;

// Import (aka include) some stuff.
import threads.common.*;
import threads.exceptions.*;

/**
 * Class BlockManager
 * Implements character block "manager" and does twists with threads.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca;
 * Inspired by previous code by Prof. D. Probst
 *
 * $Revision: 1.5 $
 * $Last Revision Date: 2019/02/02 $

 */
public class BlockManager
{
	/**
	 * The stack itself
	 */
	private static BlockStack soStack = new BlockStack();

	/**
	 * Number of threads dumping stack
	 */
	private static final int NUM_PROBERS = 4;

	/**
	 * Number of steps they take
	 */
	private static int siThreadSteps = 5;

	/**
	 * For atomicity
	 */
	private static Semaphore mutex = new Semaphore(1);

	/*
	 * For synchronization
	 */

	/**
	 * phase1 is to make sure phase I for all is done before any phase II begins
	 */
	private static Semaphore phase1 = new Semaphore(-9);

	/**
	 * I choose a negative value because we need all the phase1 from all objects to be
	 * completed before phase2 starts. after each phase1 completion, the semaphore will
	 * increment until it goes above 0 (or 1) which all the phase1 has finished. When phase1
	 * are being executed, phase2 is waiting for the lock to be unlocked and when the lock is
	 * available, each phase2 will execute independently.
	 */

	/**
	 * phase2 is for use in conjunction with Thread.turnTestAndSet() for phase II proceed
	 * in the thread creation order
	 */
	private static Semaphore phase2 = new Semaphore(NUM_PROBERS);


	// The main()
	public static void main(String[] argv)
	{
		try
		{
			// Some initial stats...
			System.out.println("Main thread starts executing.");
			System.out.println("Initial value of top = " + soStack.getITop() + ".");
			System.out.println("Initial value of stack top = " + soStack.pick() + ".");
			System.out.println("Main thread will now fork several threads.");

			/*
			 * The birth of threads
			 */
			AcquireBlock consumer1 = new AcquireBlock();
			AcquireBlock consumer2 = new AcquireBlock();
			AcquireBlock consumer3 = new AcquireBlock();

			System.out.println("main(): Three AcquireBlock threads have been created.");

			ReleaseBlock producer1 = new ReleaseBlock();
			ReleaseBlock producer2 = new ReleaseBlock();
			ReleaseBlock producer3 = new ReleaseBlock();

			System.out.println("main(): Three ReleaseBlock threads have been created.");

			// Create an array object first
			CharStackProber	aStackProbers[] = new CharStackProber[NUM_PROBERS];

			// Then the CharStackProber objects
			for(int i = 0; i < NUM_PROBERS; i++)
				aStackProbers[i] = new CharStackProber();

			System.out.println("main(): CharStackProber threads have been created: " + NUM_PROBERS);

			/*
			 * Twist 'em all
			 */

			consumer1.start();
			aStackProbers[0].start();
			producer1.start();

			aStackProbers[1].start();

			consumer2.start();
			aStackProbers[2].start();
			producer2.start();

			consumer3.start();
			aStackProbers[3].start();
			producer3.start();

			System.out.println("main(): All the threads are ready.");

			System.out.println("value of sephamore = " + phase1.getiValue());

			/*
			 * Wait by here for all forked threads to die
			 */
			consumer1.join();
			consumer2.join();
			consumer3.join();

			producer1.join();
			producer2.join();
			producer3.join();

			aStackProbers[0].join();
			aStackProbers[1].join();
			aStackProbers[2].join();
			aStackProbers[3].join();

			for(int i = 0; i < NUM_PROBERS; i++)
				aStackProbers[i].join();

			// Some final stats after all the child threads terminated...
			System.out.println("System terminates normally.");
			System.out.println("Final value of top = " + soStack.getITop() + ".");
			System.out.println("Final value of stack top = " + soStack.pick() + ".");
			System.out.println("Final value of stack top-1 = " + soStack.getAt(soStack.getITop() - 1) + ".");
			System.out.println("Stack access count = " + soStack.getAccessCounter());

			System.exit(0);
		}
		catch(InterruptedException e)
		{
			System.err.println("Caught InterruptedException (internal error): " + e.getMessage());
			e.printStackTrace(System.err);
		}
		catch(Exception e)
		{
			reportException(e);
		}
		finally
		{
			System.exit(1);
		}
	} // main()


	/**
	 * Inner AcquireBlock thread class. CONSUMER
	 */
	static class AcquireBlock extends BaseThread
	{

		/**
		 * A copy of a block returned by pop().  @see BlocStack#pop()
		 */
		private char cCopy;

		public void run()
		{




			System.out.println("AcquireBlock thread [TID=" + this.iTID + "] starts executing.");


			phase1();
			phase1.Signal();

			try
			{
				mutex.Wait();


				System.out.println("AcquireBlock thread [TID=" + this.iTID + "] requests Ms block.");

				this.cCopy = soStack.pop();

				System.out.println
				(
					"AcquireBlock thread [TID=" + this.iTID + "] has obtained Ms block " + this.cCopy +
					" from position " + (soStack.getITop() + 1) + "."
				);


				System.out.println
				(
					"Acq[TID=" + this.iTID + "]: Current value of top = " +
					soStack.getITop() + "."
				);

				System.out.println
				(
					"Acq[TID=" + this.iTID + "]: Current value of stack top = " +
					soStack.pick() + "."
				);
			}
			catch(Exception e)
			{
				reportException(e);
				System.exit(1);
			}
			mutex.Signal();




			phase1.Wait();
			phase2();
			phase1.Signal();

			System.out.println("AcquireBlock thread [TID=" + this.iTID + "] terminates.");


		}
	} // class AcquireBlock


	/**
	 * Inner class ReleaseBlock. PRODUCER
	 */
	static class ReleaseBlock extends BaseThread
	{
		/**
		 * Block to be returned. Default is 'a' if the stack is empty.
		 */
		private char cBlock = 'a';

		public void run()
		{



			System.out.println("ReleaseBlock thread [TID=" + this.iTID + "] starts executing.");


			phase1();
			phase1.Signal();

			try
			{
				mutex.Wait();

				if(!soStack.isEmpty())
					this.cBlock = (char)(soStack.pick() + 1);


				System.out.println
				(
					"ReleaseBlock thread [TID=" + this.iTID + "] returns Ms block " + this.cBlock +
					" to position " + (soStack.getITop() + 1) + "."
				);
				try {
					soStack.push(this.cBlock);
				}
				catch(emptyStackException e)
				{
					System.out.println("Stack is EMPTY replacing top with 'a'");
				}catch(fullStackException e)
				{
					System.out.println("stack is FULL, abandoning task");
				}
				System.out.println
				(
					"Rel[TID=" + this.iTID + "]: Current value of top = " +
					soStack.getITop() + "."
				);

				System.out.println
				(
					"Rel[TID=" + this.iTID + "]: Current value of stack top = " +
					soStack.pick() + "."
				);
			}
			catch(Exception e)
			{
				reportException(e);
				System.exit(1);
			}
			mutex.Signal();




			phase1.Wait();
			phase2();
			phase1.Signal();

			System.out.println("ReleaseBlock thread [TID=" + this.iTID + "] terminates.");



		}



	} // class ReleaseBlock


	/**
	 * Inner class CharStackProber to dump stack contents.
	 */
	static class CharStackProber extends BaseThread
	{
		public void run()
		{



			phase1();
			phase1.Signal();


			try
			{
				mutex.Wait();

				for(int i = 0; i < siThreadSteps; i++)
				{
					System.out.print("Stack Prober [TID=" + this.iTID + "]: Stack state: ");

					// [s] - means ordinary slot of a stack
					// (s) - current top of the stack
					for(int s = 0; s < soStack.getISize(); s++)
						System.out.print
						(
							(s == BlockManager.soStack.getITop() ? "(" : "[") +
							BlockManager.soStack.getAt(s) +
							(s == BlockManager.soStack.getITop() ? ")" : "]")
						);

					System.out.println(".");

				}
			}
			catch(Exception e)
			{
				reportException(e);
				System.exit(1);
			}
			mutex.Signal();




			phase1.Wait();
			phase2();
			phase1.Signal();


		}
	} // class CharStackProber


	/**
	 * Outputs exception information to STDERR
	 * @param poException Exception object to dump to STDERR
	 */
	private static void reportException(Exception poException)
	{
		System.err.println("Caught exception : " + poException.getClass().getName());
		System.err.println("Message          : " + poException.getMessage());
		System.err.println("Stack Trace      : ");
		poException.printStackTrace(System.err);
	}
} // class BlockManager

// EOF
