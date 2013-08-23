package pl.bb.fight;

import static org.fest.assertions.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.bb.fight.damage.Damage;
import pl.bb.fight.weapon.WarriorFist;

@Test
public class WarriorTest {

	private Warrior warriorSut;
	private final int LIFE = 99;
	private final int DAMAGE = 12;

	@BeforeMethod
	public void setupSut() {
		warriorSut = new Warrior(LIFE);
	}

	public void shouldNewWariorActualLifeEqualToMaximumLife() {
		assertThat(warriorSut.getMaximumLife()).isEqualTo(warriorSut.getCurrentLife());
	}

	public void shouldNewWarriorBeAlive() {
		assertThat(warriorSut.isAlive()).isTrue();
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

	public void shouldNewWariorHaveWarriorFistWeapon() {
		assertThat(warriorSut.getWeapon()).isNotNull();
		assertThat(warriorSut.getWeapon()).isInstanceOf(WarriorFist.class);
	}

	public void shouldWarriorDealWeaponDamage() {
		assertThat(warriorSut.dealDamage()).isEqualTo(warriorSut.getWeaponDamage());
	}

}
