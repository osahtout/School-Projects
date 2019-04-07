package com.dinningPhilo;

import sun.misc.Signal;

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

	private void test(int piTID)
	{
		if((state[Math.abs(piTID-1)%piNumberOfPhilosophers]) != State.eating && (state[Math.abs(piTID+1)%piNumberOfPhilosophers]) != State.eating && state[piTID] == State.hungry)
		{
			state[piTID] = State.eating;
			notifyAll();
		}
	}

	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 */
	public synchronized void pickUp(final int piTID) throws InterruptedException {
		// ...
		state[piTID] = State.hungry;
		test(piTID);
		if(state[piTID] != State.eating)
			wait();

	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 */
	public synchronized void putDown(final int piTID)
	{
		// ...
		state[piTID] = State.thinking;
		test(piTID - 1);
		test(piTID + 1);

	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 */
	public synchronized void requestTalk()
	{
		// ...
	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk()
	{
		// ...
	}
}

// EOF
