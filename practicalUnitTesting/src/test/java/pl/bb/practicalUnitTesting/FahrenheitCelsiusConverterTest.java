package pl.bb.practicalUnitTesting;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class FahrenheitCelsiusConverterTest {
	@Test(dataProvider = "fahrenheitToCelsius")
	public void shouldConvertCelsiusToFahrenheit(int celsius, int fahrenheit) {
		assertEquals(FahrenheitCelsiusConverter.toFahrenheit(celsius), fahrenheit);
	}

	@DataProvider
	public Object[][] celsiusToFahrenheit() {
		return new Object[][] { { 0, 32 }, { 37, 98 }, { 100, 212 } };
	}

	@Test(dataProvider = "fahrenheitToCelsius")
	public void shouldFahrenheitToCelsius(int celsius, int fahrenheit) {
		assertEquals(FahrenheitCelsiusConverter.toCelsius(fahrenheit), celsius);
	}

	@DataProvider
	public Object[][] fahrenheitToCelsius() {
		return new Object[][] { { 0, 32 }, { 37, 100 }, { 100, 212 } };
	}
}
