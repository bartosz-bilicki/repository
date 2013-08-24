package pl.bb.fight;

import pl.bb.fight.armor.Armor;
import pl.bb.fight.armor.NoArmor;
import pl.bb.fight.damage.Damage;
import pl.bb.fight.damage.PhisicalDamage;
import pl.bb.fight.statistics.Strength;
import pl.bb.fight.statistics.Vitality;
import pl.bb.fight.weapon.WarriorFist;
import pl.bb.fight.weapon.Weapon;

public class Warrior {
	private static final int VITALITY_DEFAULT = 100;
	private static final int STRENGHT_DEFAULT = 1;

	private final String name;

	private final Vitality vitality;
	private int currentLife;

	private Strength strenght;

	private Weapon weapon;
	private Armor armor;
	private int level = 0;

	public Warrior(String name) {
		this.name = name;

		this.vitality = new Vitality(VITALITY_DEFAULT);
		this.currentLife = vitality.getValue();

		this.strenght = new Strength(STRENGHT_DEFAULT);

		weapon = new WarriorFist();
		armor = new NoArmor();
	}

	public int getMaximumLife() {
		return vitality.getValue();
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

	public Damage getDamage() {
		return new PhisicalDamage(weapon.getDamageAmount() + getStrengthValue());
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

	void setStrength(Strength strenght) {
		this.strenght = strenght;

	}

	public int getStrengthValue() {
		return strenght.getValue();
	}

	public void levelUp() {
		level++;
		strenght.levelUp();
		vitality.levelUp();
		currentLife = vitality.getValue();

	}

	public int getLevel() {
		return level;
	}

	public int getVitalityValue() {
		return vitality.getValue();
	}
}
