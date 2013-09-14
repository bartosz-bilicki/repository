package pl.bb.beust.counter;

import static org.assertj.core.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Range;

@Test
public class CounterTest {

	@Test(dataProvider = "uniueDigits")
	public void shouldReturnTrueTest(int number) {
		Counter c = new Counter();
		assertThat(c.hasUniqueDigits(number)).isTrue();
	}

	@DataProvider
	private Object[][] uniueDigits() {
		return new Object[][] { { 1 }, { 12 }, { 0 }, { 34689 }, { 123 } };
	}

	@Test(dataProvider = "sameDigits")
	public void shouldReturnFalseForSameDigits(int number) {
		Counter c = new Counter();
		assertThat(c.hasUniqueDigits(number)).isFalse();
	}

	@DataProvider
	private Object[][] sameDigits() {
		return new Object[][] { { 11 }, { 22 }, { 3333 }, { 999 } };
	}

	public void t1() {
		Counter c = new Counter();
		assertThat(c.countNumberwithUniueDigits(Range.closed(1, 10))).isEqualTo(10);
		assertThat(c.countNumberwithUniueDigits(Range.closed(11, 20))).isEqualTo(9);
	}
}
