package pl.bb.practicalUnitTesting;

public class FahrenheitCelciusConverter {

	public static int toFahrenheit(int i) {
		return i * 9 / 5 + 32;
	}

	public static int toCelcius(int i) {
		return (i - 32) * 5 / 9;
	}

}
