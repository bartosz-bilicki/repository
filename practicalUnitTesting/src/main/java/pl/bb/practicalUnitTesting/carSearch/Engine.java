package pl.bb.practicalUnitTesting.carSearch;

public class Engine {

	private final int cylindersCount;

	public Engine(int cylindersCount) {
		this.cylindersCount = cylindersCount;
	}

	int getCylindersCount() {
		return 0;
	}

	public boolean isSportEngine() {
		return cylindersCount > 6;
	}
}
