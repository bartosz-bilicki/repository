package pl.bb.bowlingKata;

public class Frame {
	private boolean isAfterRollOne = false;
	private boolean isAfterRollTwo = false;
	private int rollOne;
	private int rollTwo;

	public void rollOne(int roll) {
		this.rollOne = roll;
		isAfterRollOne = true;
	}

	public void rollTwo(int roll) {
		this.rollTwo = roll;
		isAfterRollTwo = true;
	}

	public int score() {
		return rollOne + rollTwo;
	}

	public boolean isSpare() {
		return ((rollOne + rollTwo) == 10);
	}

	public boolean isStrike() {
		return (rollOne == 10);
	}

	public boolean isAfterRollOne() {
		return isAfterRollOne;
	}

	public boolean isAfterRollTwo() {
		return isAfterRollTwo;
	}

}
