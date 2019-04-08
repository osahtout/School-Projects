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
	int peppers = 2;

	/**
	 * Constructor
	 * sets the number of philosophers
	 * set the number of chopsticks as the number of philosopher (if more than there wouldn't be any sychro problem)
	 * sets every philosopher state to thinking
	 */
	public Monitor(int piNumberOfPhilosophers)
	{

		// TODO: set appropriate number of chopsticks based on the # of philosophers
		this.piNumberOfPhilosophers = piNumberOfPhilosophers;
		this.numberOfSticks = piNumberOfPhilosophers;
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
	 * This will allow the philosopher of the one of the other philosophers
	 * on either of sides are eating,
	 * if on is then he is hungry and has to wait for them to finish
	 * @param philoInArray
	 * @throws InterruptedException
	 */
	private void test(int philoInArray) throws InterruptedException {
		philosopherIsHungry(philoInArray);
		while(someoneIsEating(philoInArray))
		{
			wait();
		}
	}

	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID) throws InterruptedException {

		test(piTID-1);

		philosopherIsEating(piTID-1);
	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
		philosopherIsThinking(piTID-1);
		notifyAll();
	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk(final int piTID)throws InterruptedException
	{
			if(cannotTalk())
				wait();
			else {
				youCanTalk(piTID);
			}
	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk(final int piTID)
	{
		someoneNeedsToTalk--;
		currentlyTalking = -1;				//sets the currently talking back to no one
		philosopherIsThinking(piTID-1);	// sets the philosopher to thinking
		notifyAll(); 						//signals everyone that he finished talking
	}

	/**
	 * checks if someone is talking or someone is about to talk sleeps if false
	 * or it waits until all has finished talking
	 * gives priority to those who talk
	 * @param piTID
	 * @throws InterruptedException
	 */
	public synchronized void requestSleep(final int piTID) throws InterruptedException {
		while (someIsTalking() || someoneNeedsToTalk > 0) {
			wait();
		}
		someoneNeedsToSleep++;
		philosopherIsSleep(piTID-1);
	}

	/**
	 * sets the philosopher state to thinking and notifies everyone who wants to talk
	 * @param piTID
	 */
	public synchronized void endSleep(final int piTID) {
		someoneNeedsToSleep--;
		philosopherIsThinking(piTID-1);
		notifyAll();
	}

	/**
	 * can only request pepper while eating and there is one available
	 * decrement the number available by one
	 * @param piTID
	 * @throws InterruptedException
	 */
	public synchronized void requestPepper(final int piTID) throws InterruptedException {
		while(bothPeppersAreNotAvailable(state[piTID - 1]))
			wait();
		peppers--;
	}

	/**
	 * increment the number available and notifies everyone that one is available
	 * @param piTID
	 */
	public synchronized void endPeppers(final int piTID) {
		peppers++;
		notifyAll();
	}


	/**
	 * lets him talk and allows me to know who is talking
	 * @param piTID
	 */
	private void youCanTalk(int piTID) {
		someoneNeedsToTalk++;
		currentlyTalking = piTID;
		philosopherIsTalking(piTID-1);
	}


	private void philosopherIsTalking(int i) {
		state[i] = State.talking;
	}

	/**
	 * @return true if someone is talking
	 */
	private boolean cannotTalk() {
		return currentlyTalking != -1 || someoneNeedsToSleep > 0;
	}

	/**
	 * checks if his state is not eating and if peppers are available
	 * @param state
	 * @return
	 */
	private boolean bothPeppersAreNotAvailable(State state) {
		return state != State.eating && peppers < 1;
	}


	/**
	 * checks on the philosopher's left and right to see if they are eating
	 * also checks if he is hungry
	 * @param philoInArray
	 * @return
	 */
	private boolean someoneIsEating(int philoInArray) {
		return state[ (Math.abs((philoInArray-1))%piNumberOfPhilosophers) ] == State.eating ||
				state[ (Math.abs((philoInArray+1))%piNumberOfPhilosophers) ] == State.eating;
	}

	private void philosopherIsSleep(int i) {
		state[i] = State.sleeping;
	}

	private void philosopherIsEating(int i) {
		state[i] = State.eating;
	}
	private void philosopherIsHungry(int i) {
		state[i] = State.hungry;
	}

	private void philosopherIsThinking(int i) {
		state[i] = State.thinking; //it just set the philosopher to thinking and signals everyone that he is done eating
	}

	private boolean someIsTalking() {
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

	/**
	 * The implementation of adding and removing is a little ambiguous.
	 * Do I add at either end or in the middle
	 * Do I remove either end or in the middle
	 * If I add at the ends, I need to check if the first or last is eating or is hungry
	 * And if there is a small number of philosophers, it will cause deadlock (one process is waiting to eat while the other
	 * is waiting to think)
	 * That also means that the array has to be cloned the size incremented by one which is not ideal to do unless I use List or arraylist
	 * If one is added in the middle, it would cause the same problems with one more being where it should be added in the array
	 * I don't know where the addition and removal of the philosophers will take place, in the beginning, at the end, in the middle of
	 * eating or talking, during runtime, injecting the function while it's running?
	 *
	 * the language is very vague and the response I got when asking was to clarify what I did.
	 * It's the same with the priority, who defines the priority. Who and how is the priority set?
	 * Do I assume that the piTID is the priority number?
	 *
	 *
	 * @param placeOnTable
	 * @throws InterruptedException
	 */
	public synchronized void addPhilosopherAt(int placeOnTable) throws InterruptedException {
		State[] newState;

		while (heIsEating(placeOnTable-1)|| heIsHungry(placeOnTable-1 ) ||
				someoneIsEating(placeOnTable-1) || someoneIsHungry(placeOnTable-1)) {
			wait();
		}
		/**
		 * make a new state array with size state.length+1
		 *
		 */
		newState = java.util.Arrays.copyOf(state, state.length+1);

		/*
		copies the end half of the array
		 */
		for(int i = newState.length-1; i>placeOnTable-1;i--) {
			newState[i] = state[i-1];
		}

		/**
		 * copies the first half
		 */
		for (int i = 0; i < placeOnTable - 1; i++) {
			newState[i] = state[i];
		}

		state[placeOnTable - 1] = State.thinking;

			for (int i = placeOnTable; i < newState.length; i++) {
				newState[i] = state[i - 1];
			}

			for (int i = 0; i < newState.length; i++) {

				System.out.println(newState[i]);
			}


	}

	private boolean heIsHungry(int i) {
		return state[ (Math.abs((i-1))%piNumberOfPhilosophers) ] == State.hungry;
	}

	private boolean heIsEating(int i) {
		return state[ (Math.abs((i-1))%piNumberOfPhilosophers) ] == State.eating;
	}

	private boolean someoneIsHungry(int philoInArray) {
		return state[ (Math.abs((philoInArray-1))%piNumberOfPhilosophers) ] == State.hungry ||
				state[ (Math.abs((philoInArray+1))%piNumberOfPhilosophers) ] == State.hungry;
	}
}


//[  (Math.abs((philoInArray-1)) % piNumberOfPhilosophers)  ]

// EOF
