/**
 * A data-structure to keep (state,fValue) pairs. This class will helpful to add
 * states to priority queues. You can add a state with the f() value to a queue
 * by adding (state,f() value) pair to the priority queue.
 * 
 */
public class StateFValuePair implements Comparable<StateFValuePair> {
	private State state;
	private double fValue;

	public StateFValuePair(State state, double fValue) {
		this.state = state;
		this.fValue = fValue;
	}

	public State getState() {
		return state;
	}

	public double getFValue() {
		return fValue;
	}
	
	

	@Override
	public int compareTo(StateFValuePair o) {
		if (this.fValue > o.fValue)
			return 1;
		else if (this.fValue < o.fValue)
			return -1;

		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		StateFValuePair ob = (StateFValuePair)obj;
		return ob.getState().equals(this.state) && ob.fValue == this.fValue;
	}
}
