package pl.bb.fight.weapon;

import static org.fest.assertions.api.Assertions.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.bb.fight.damage.PhisicalDamage;

@Test
public class WarriorFistTest {

	private WarriorFist warriorFistSut;

	@BeforeMethod
	public void setupSut() {
		warriorFistSut = new WarriorFist();
	}

	public void shouldNewWarriorFistDealPhisicalDamage() {
		assertThat(warriorFistSut.getDamage()).isInstanceOf(PhisicalDamage.class);
	}

	public void shouldNewWarriorFistDealNon0Damage() {
		assertThat(warriorFistSut.getDamageAmount()).isGreaterThan(0);
	}
}
