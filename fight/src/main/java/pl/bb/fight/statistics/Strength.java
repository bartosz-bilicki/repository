package pl.bb.fight.statistics;

public class Strength implements Statistic {
	public int value;

	public Strength(int value) {
		this.value = value;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void levelUp() {
		value += getLevelUpIncrement();
	}

	private int getLevelUpIncrement() {
		return 2;
	}
}
