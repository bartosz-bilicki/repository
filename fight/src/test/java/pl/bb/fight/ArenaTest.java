package pl.bb.fight;

import static org.hamcrest.Matchers.lessThan;

import org.junit.Assert;
import org.testng.annotations.Test;

public class ArenaTest {

	private final Arena arena = new Arena();
	private final Warrior w1 = arena.getWarrior1();
	private final Warrior w2 = arena.getWarrior2();

	@Test
	public void hasFighters() {
		Assert.assertNotNull(w1);
		Assert.assertNotNull(w2);
	}

	@Test
	public void damageIsTaken() {
		int w2LifeBefore = w2.getCurrentLife();
		w2.takeDamage(w1.dealDamage());
		Assert.assertThat(w2.getCurrentLife(), lessThan(w2LifeBefore));
	}
}
