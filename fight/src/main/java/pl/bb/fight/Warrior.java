package pl.bb.fight;

import pl.bb.fight.damage.Damage;
import pl.bb.fight.damage.PhisicalDamage;

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

	public Damage dealDamage() {
		return new PhisicalDamage(1);
	}

	public void takeDamage(Damage damage) {
		int amount = damage.getAmount();
		if (amount >= currentLife) {
			currentLife = 0;
		} else {
			currentLife -= amount;
		}
	}
}
