package pl.bb.fight;

import static org.fest.assertions.api.Assertions.*;

import org.testng.annotations.Test;

public class ArenaTest {

	private final Arena arenaSut = new Arena();
	private final Warrior w1 = arenaSut.getWarrior1();
	private final Warrior w2 = arenaSut.getWarrior2();

	@Test
	public void shouldArenaHaveWarriors() {
		assertThat(arenaSut.getWarrior1()).isNotNull();
		assertThat(arenaSut.getWarrior2()).isNotNull();
	}

}
