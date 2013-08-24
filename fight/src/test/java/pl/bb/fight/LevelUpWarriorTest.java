package pl.bb.fight;

import static org.fest.assertions.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.bb.fight.damage.Damage;

@Test
public class LevelUpWarriorTest {
	private static final int ANY_DAMAGE = 15;

	private final String NAME = "ANY_NAME";

	private Warrior warriorSut;

	@BeforeMethod
	public void setupSut() {
		warriorSut = new Warrior(NAME);
	}

	public void shouldlevelUpAddLevel() {
		// given
		int levelBefore = warriorSut.getLevel();

		// when
		warriorSut.levelUp();

		// then
		assertThat(warriorSut.getLevel()).isGreaterThan(levelBefore);
	}

	public void shouldLevelUpIncreaseStatistics() {
		Warrior beforeLevelUp = new Warrior(NAME);

		// when
		warriorSut.levelUp();

		// then
		assertThat(warriorSut.getStrengthValue()).isGreaterThan(beforeLevelUp.getStrengthValue());
		assertThat(warriorSut.getVitalityValue()).isGreaterThan(beforeLevelUp.getVitalityValue());
	}

	public void shouldHaveMaxHealthAfterLevelUp() {
		// given damaged warrior
		Damage damageMock = mock(Damage.class);
		when(damageMock.getAmount()).thenReturn(ANY_DAMAGE);
		warriorSut.takeDamage(damageMock);

		// when level up
		warriorSut.levelUp();

		// then
		assertThat(warriorSut.getCurrentLife()).isEqualTo(warriorSut.getMaximumLife());
	}
}
