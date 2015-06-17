package edu.fiu.cis.acrl.tools.timeperiod;

import edu.fiu.cis.acrl.tools.timeperiod.TimePeriod;

public class TimePeriodWithCounter extends TimePeriod {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int counter=0;

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}
	
	public int incCounter() {
		counter++;
		return counter;
	}
	
	public int decCounter() {
		counter--;
		return counter;
	}
}
