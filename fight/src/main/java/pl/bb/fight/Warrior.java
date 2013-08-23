package pl.bb.fight;

import pl.bb.fight.armor.Armor;
import pl.bb.fight.armor.NoArmor;
import pl.bb.fight.damage.Damage;
import pl.bb.fight.weapon.WarriorFist;
import pl.bb.fight.weapon.Weapon;

public class Warrior {

	private final int maximumLife;
	private int currentLife;

	private final String name;

	private Weapon weapon;
	private Armor armor;

	public Warrior(String name, int maximumLife) {
		this.maximumLife = maximumLife;
		this.currentLife = maximumLife;
		this.name = name;

		weapon = new WarriorFist();
		armor = new NoArmor();
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
		int amount = getDamageReducedByArmor(damage);

		if (amount >= currentLife) {
			currentLife = 0;
		} else {
			currentLife -= amount;
		}
	}

	private int getDamageReducedByArmor(Damage damage) {
		int amount = damage.getAmount();
		amount = Math.max(amount - armor.getPhisicalDamageReductionAmount(), 0);
		return amount;
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

	@Override
	public String toString() {
		return new StringBuilder("Warrior ").append(name).toString();

	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}
}
