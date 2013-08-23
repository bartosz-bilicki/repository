package pl.bb.fight.armor;

import javax.annotation.concurrent.Immutable;

@Immutable
public class NoArmor implements Armor {

	@Override
	public int getPhisicalDamageReductionAmount() {
		return 0;
	}

}
