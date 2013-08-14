package pl.bb.fight;

public class Warrior {

	private final int maximumLife;
	private int currentLife;

	public Warrior(int maximumLife) {
		this.maximumLife = maximumLife;
		this.currentLife = maximumLife;
	}

	public int getMaximumLife() {
		return maximumLife;
	}

	public int getCurrentLife() {
		return currentLife;
	}

	public boolean isAlive() {
		return getCurrentLife() > 0;
	}

	public int dealDamage() {
		return 1;
	}

	public void takeDamage(int damage) {
		if (damage >= currentLife) {
			currentLife = 0;
		} else {
			currentLife -= damage;
		}
	}
}
