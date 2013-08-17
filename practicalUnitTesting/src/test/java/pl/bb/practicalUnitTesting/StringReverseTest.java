package pl.bb.practicalUnitTesting;

import static pl.bb.practicalUnitTesting.StringReverse.reverse;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class StringReverseTest {

	@Test(expectedExceptions = NullPointerException.class)
	public void reverseNull() {
		Assert.assertEquals(null, reverse(null));
	}

	public void reverseEmpty() {
		Assert.assertEquals("", reverse(""));
	}

	@Test(dataProvider = "oneCharacter")
	public void reversOneChar(String oneCharString) {
		Assert.assertEquals(oneCharString, reverse(oneCharString));
	}

	@DataProvider
	private static final Object[][] oneCharacter() {
		return new Object[][] { { "a" }, { "A" }, { "x" } };
	}

	@DataProvider
	private static final Object[][] threeCharacters() {
		return new Object[][] { { "aaa" }, { "aAa" }, { "XXX" } };
	}

	@Test(dataProvider = "threeCharacters")
	public void reversThreeeChar(String threeCharacters) {
		Assert.assertEquals(threeCharacters, reverse(threeCharacters));
	}

	@DataProvider
	private static final Object[][] simple() {
		return new Object[][] { { "abc", "cba" }, { "aA", "Aa" }, { "1234567890", "0987654321" } };
	}

	@Test(dataProvider = "simple")
	public void reverseSimple(String actual, String expected) {
		Assert.assertEquals(reverse(actual), expected);
		Assert.assertEquals(reverse(expected), actual);
	}
}
