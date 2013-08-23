package pl.bb.fight.weapon;

import javax.annotation.concurrent.Immutable;

import pl.bb.fight.damage.Damage;

@Immutable
public interface Weapon {
	Damage getDamage();

	int getDamageAmount();
}
