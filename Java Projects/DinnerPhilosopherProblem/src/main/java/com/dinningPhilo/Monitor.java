package com.dinningPhilo;


/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */
	private enum State {thinking, talking, hungry, eating, sleeping}
	int numberOfSticks;
	int piNumberOfPhilosophers;
	private State[] state;
	int currentlyTalking = -1; //-1 means no one is talking
	static int someoneNeedsToTalk = 0;
	static int someoneNeedsToSleep = 0;

	/**
	 * Constructor
	 */
	public Monitor(int piNumberOfPhilosophers)
	{

		// TODO: set appropriate number of chopsticks based on the # of philosophers
		this.piNumberOfPhilosophers = piNumberOfPhilosophers;
		this.numberOfSticks = piNumberOfPhilosophers % 2 == 0? piNumberOfPhilosophers: piNumberOfPhilosophers - 1;
		state = new State[piNumberOfPhilosophers];
				for (int i = 0; i < state.length; i++) {
					state[i] = State.thinking;
				}
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */

	/**
	 * failed attempt at test
	 */
//	private void test(int piTID)
//	{
//
//
//			int index = piTID-1;
//			int before = (index-1) % piNumberOfPhilosophers;
//			if(before < 0)
//				before=piNumberOfPhilosophers-1;
//			int after = (index+1) % piNumberOfPhilosophers;
//
////			System.out.println("Philosopher "+piTID+" is checking for philosopher "+(piTID-1)+ " % "+ piNumberOfPhilosophers+ " = "+ before);
////			System.out.println("Philosopher "+piTID+" is checking for philosopher "+(piTID+1)+ " % "+ piNumberOfPhilosophers+ " = "+ after);
////			System.out.println("Philosopher "+piTID+" is checking for philosopher "+ (before+ 1));
////			System.out.println("Philosopher "+piTID+" is checking for philosopher "+ (after+1));
////			System.out.println(piTID+" which is "+index+" is doing "+ (index-1) +" % "+ piNumberOfPhilosophers +" = "+before);
////			System.out.println(piTID+" which is "+index+" is doing "+ (index+1) +" % "+ piNumberOfPhilosophers +" = "+after);
//
//			if(	(state[before] != State.eating) &&
//				(state[ after ] != State.eating) &&
//					state[index] == State.hungry)
//		{
//			state[index] = State.eating;
//			notify();
//		}}






	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID) throws InterruptedException {

		int philoInArray = piTID-1;

		test(philoInArray);

		state[philoInArray] = State.eating;


	}

	/**
	 * This will allow the philosopher of the one of the other philosophers
	 * on either of sides are eating,
	 * if on is then he is hungry and has to wait for them to finish
	 * @param philoInArray
	 * @throws InterruptedException
	 */
	private void test(int philoInArray) throws InterruptedException {
		while(someoneIsEating(philoInArray))
		{
			state[philoInArray] = State.hungry;
			wait();
		}
	}

	private boolean someoneIsEating(int philoInArray) {
		return state[ (Math.abs((philoInArray-1))%piNumberOfPhilosophers) ] == State.eating ||
				state[ (Math.abs((philoInArray+1))%piNumberOfPhilosophers) ] == State.eating;
	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
		// ...
			state[piTID-1] = State.thinking; //it just set the philosopher to thinking and signals everyone that he is done eating
			notifyAll();





	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk(final int piTID)throws InterruptedException
	{
		// ...


			if(currentlyTalking != -1 || someoneNeedsToSleep > 0)  //if someone is talking  he waits
				wait();
			else						//lets him talk and allows me to know who is talking
			{
				someoneNeedsToTalk++;
				currentlyTalking = piTID;
				state[piTID-1] = State.talking;
			}

	}



	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk(final int piTID)
	{
		// ...
		someoneNeedsToTalk--;

		currentlyTalking = -1; 				//sets the currently talking back to no one
		state[piTID-1] = State.thinking; 	// sets the philosopher to thinking
		notifyAll(); 						//signals everyone that he finished talking
	}

	private boolean someIsTalking()
	{
		for (int i = 0; i < state.length; i++) {
			if(state[i] == State.talking)
				return true;
		}
		return false;
	}

	private boolean someIsSleeping()
	{
		for (int i = 0; i < state.length; i++) {
			if(state[i] == State.sleeping)
				return true;
		}
		return false;
	}


	public synchronized void requestSleep(final int piTID) throws InterruptedException
	{
		while (someIsTalking() || someoneNeedsToTalk > 0)
		{
			wait();
		}
		someoneNeedsToSleep++;
		state[piTID-1] = State.sleeping;
	}

	public synchronized void endSleep(final int piTID)
	{
		someoneNeedsToSleep--;
		state[piTID-1] = State.thinking;
		notifyAll();
	}


	private synchronized void insertPhilosopher(int index) throws InterruptedException
	{
		while(state[index]!=State.eating || state[index]!=State.hungry ||
				state[index-1]!=State.eating || state[index-1]!=State.hungry ||
					state[index-2]!=State.eating || state[index-2]!=State.hungry)
			wait();

		for (int i = 0; i < index; i++) {
			/**
			 * make a new state array with size state.length+1
			 *
			 */



		}
	}

}

// EOF
