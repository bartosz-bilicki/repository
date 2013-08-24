package pl.bb.fight.statistics;

public class Vitality implements Statistic {
	public int value;

	public Vitality(int defaultValue) {
		this.value = defaultValue;
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
