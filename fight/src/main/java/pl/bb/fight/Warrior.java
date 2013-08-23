package pl.bb.fight;

import pl.bb.fight.damage.Damage;
import pl.bb.fight.weapon.WarriorFist;
import pl.bb.fight.weapon.Weapon;

public class Warrior {

	private final int maximumLife;
	private int currentLife;
	private Weapon weapon;

	public Warrior(int maximumLife) {
		this.maximumLife = maximumLife;
		this.currentLife = maximumLife;
		weapon = new WarriorFist();
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

	public void takeDamage(Damage damage) {
		int amount = damage.getAmount();
		if (amount >= currentLife) {
			currentLife = 0;
		} else {
			currentLife -= amount;
		}
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public Damage getWeaponDamage() {
		return weapon.getDamage();
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Damage dealDamage() {
		return weapon.getDamage();
	}

}
