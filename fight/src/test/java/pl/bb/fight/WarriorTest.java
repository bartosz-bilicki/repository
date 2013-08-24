package pl.bb.fight;

import static org.fest.assertions.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.bb.fight.armor.Armor;
import pl.bb.fight.damage.Damage;
import pl.bb.fight.statistics.Strength;

@Test
public class WarriorTest {

	private Warrior warriorSut;
	private final int LIFE = 99;
	private final int DAMAGE = 12;
	private final String NAME = "NAME";

	@BeforeMethod
	public void setupSut() {
		warriorSut = new Warrior(NAME);
	}

	public void shouldDemageTakenReduceLife() {
		// given
		Damage damageMock = mock(Damage.class);
		when(damageMock.getAmount()).thenReturn(12);
		int w2LifeBefore = warriorSut.getCurrentLife();

		// when
		warriorSut.takeDamage(damageMock);

		// then
		assertThat(warriorSut.getCurrentLife()).isLessThan(w2LifeBefore);
	}

	public void shouldMoreDemageThanLifeSetLiveTo0() {
		// given
		Damage damageMock = mock(Damage.class);
		when(damageMock.getAmount()).thenReturn(LIFE + DAMAGE);

		// when
		warriorSut.takeDamage(damageMock);

		// then
		assertThat(warriorSut.getCurrentLife()).isZero();
		assertThat(warriorSut.isAlive()).isFalse();
	}

	public void shouldToStringContainName() {
		assertThat(warriorSut.toString()).contains(NAME);
	}

	public void shouldArmorReduceDamage() {
		// given warrior with armor
		Armor armorMock = mock(Armor.class);
		when(armorMock.getPhisicalDamageReductionAmount()).thenReturn(1);
		warriorSut.setArmor(armorMock);

		// given damage
		Damage damageMock = mock(Damage.class);
		when(damageMock.getAmount()).thenReturn(15);

		// when take damage
		warriorSut.takeDamage(damageMock);

		// then recieves less damage than dealt
		assertThat(warriorSut.getCurrentLife()).isEqualTo(
				warriorSut.getMaximumLife() - damageMock.getAmount() + armorMock.getPhisicalDamageReductionAmount());

	}

	public void shouldDealDamageUseWeaponAndStrenght() {
		// given warior has Strength
		Strength strenghtMock = mock(Strength.class);
		when(strenghtMock.getValue()).thenReturn(10);
		warriorSut.setStrength(strenghtMock);

		// when
		Damage damage = warriorSut.getDamage();

		// then
		assertThat(damage.getAmount()).isEqualTo(
				warriorSut.getWeaponDamage().getAmount() + warriorSut.getStrengthValue());

	}
}
