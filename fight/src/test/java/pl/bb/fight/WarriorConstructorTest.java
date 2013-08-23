package pl.bb.fight;

import static org.fest.assertions.api.Assertions.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.bb.fight.armor.NoArmor;
import pl.bb.fight.weapon.WarriorFist;

@Test
public class WarriorConstructorTest {

	private Warrior warriorSut;
	private final int LIFE = 99;
	private final int DAMAGE = 12;
	private final String NAME = "NAME";

	@BeforeMethod
	public void setupSut() {
		warriorSut = new Warrior(NAME, LIFE);
	}

	public void shouldNewWariorActualLifeEqualToMaximumLife() {
		assertThat(warriorSut.getMaximumLife()).isEqualTo(warriorSut.getCurrentLife());
	}

	public void shouldNewWariorHaveWarriorFistWeapon() {
		assertThat(warriorSut.getWeapon()).isNotNull();
		assertThat(warriorSut.getWeapon()).isInstanceOf(WarriorFist.class);
	}

	public void shouldNewWarriorBeAlive() {
		assertThat(warriorSut.isAlive()).isTrue();
	}

	public void shouldNewWarriorHaveNoArmor() {
		assertThat(warriorSut.getArmor()).isNotNull();
		assertThat(warriorSut.getArmor()).isInstanceOf(NoArmor.class);
	}

}
