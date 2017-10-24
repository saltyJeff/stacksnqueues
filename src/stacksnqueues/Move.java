package stacksnqueues;

public class Move {
	public String moveName;
	public double secs;
	public String toString() {
		return String.format("Doing %s for %.2f secs", moveName, secs);
	}
}
