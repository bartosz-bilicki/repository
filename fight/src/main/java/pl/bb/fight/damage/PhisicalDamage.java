package pl.bb.fight.damage;

import javax.annotation.concurrent.Immutable;

@Immutable
public class PhisicalDamage implements Damage {

	private final int amount;

	public PhisicalDamage(int amount) {
		this.amount = amount;
	}

	@Override
	public int getAmount() {
		return amount;
	}

}
