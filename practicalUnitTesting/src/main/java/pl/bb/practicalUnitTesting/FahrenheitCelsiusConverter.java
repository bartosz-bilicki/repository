package pl.bb.practicalUnitTesting;

public class FahrenheitCelsiusConverter {

	private FahrenheitCelsiusConverter() {

	}

	public static int toFahrenheit(int i) {
		return i * 9 / 5 + 32;
	}

	public static int toCelsius(int i) {
		return (i - 32) * 5 / 9;
	}

}
