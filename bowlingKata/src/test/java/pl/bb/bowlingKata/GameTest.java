package pl.bb.bowlingKata;

import static org.fest.assertions.api.Assertions.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class GameTest {

	private Game gameSut;

	@BeforeMethod
	public void setupSut() {
		gameSut = new Game();
	}

	public void shouldGameWithNoRollsHaveScore0() {
		assertThat(gameSut.score()).isZero();
	}

	@Test(dataProvider = "noSpareNoStrikeRollsWithScore")
	public void shouldScoreNoSpareNoStrike(int expectedScore, int[] rolls) {
		int score = rollAndComputeScore(rolls);
		assertThat(score).isEqualTo(expectedScore);
	}

	private int rollAndComputeScore(int[] rolls) {
		for (int roll : rolls) {
			gameSut.roll(roll);
		}
		return gameSut.score();
	}

	@DataProvider
	private Object[][] noSpareNoStrikeRollsWithScore() {
		return new Object[][] { { 0, new int[] { 0 } }, { 1, new int[] { 1 } }, { 2, new int[] { 1, 1 } } };
	}

	@Test(dataProvider = "spareScore")
	public void shouldScoreSpares(int expectedScore, int[] rolls) {
		int score = rollAndComputeScore(rolls);
		assertThat(score).isEqualTo(expectedScore);
	}

	@DataProvider
	private Object[][] spareScore() {
		return new Object[][] { { 12, new int[] { 5, 5, 1 } }, { 12, new int[] { 3, 7, 1 } },
				{ 20, new int[] { 9, 1, 5 } } };
	}
}
