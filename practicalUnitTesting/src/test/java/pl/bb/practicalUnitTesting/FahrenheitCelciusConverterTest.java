package pl.bb.practicalUnitTesting;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class FahrenheitCelciusConverterTest {
	@Test(dataProvider = "celciusToFahrenheit")
	public void shouldConvertCelciusToFahrenheit(int celcius, int fahrenheit) {
		assertEquals(FahrenheitCelciusConverter.toFahrenheit(celcius), fahrenheit);
	}

	@DataProvider
	public Object[][] celciusToFahrenheit() {
		return new Object[][] { { 0, 32 }, { 37, 98 }, { 100, 212 } };
	}

	@Test(dataProvider = "fahrenheitToCelcius")
	public void shoulFahrenheitToCelcius(int celcius, int fahrenheit) {
		assertEquals(FahrenheitCelciusConverter.toCelcius(fahrenheit), celcius);
	}

	@DataProvider
	public Object[][] fahrenheitToCelcius() {
		return new Object[][] { { 0, 32 }, { 37, 100 }, { 100, 212 } };
	}
}
