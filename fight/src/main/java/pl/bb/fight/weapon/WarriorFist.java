package pl.bb.fight.weapon;

import javax.annotation.concurrent.Immutable;

import pl.bb.fight.damage.Damage;
import pl.bb.fight.damage.PhisicalDamage;

@Immutable
public class WarriorFist implements Weapon {

	private final Damage phisicalDamage = new PhisicalDamage(1);

	@Override
	public Damage getDamage() {
		return phisicalDamage;
	}

	@Override
	public int getDamageAmount() {
		return phisicalDamage.getAmount();
	}

}
