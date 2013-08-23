package pl.bb.practicalUnitTesting.carSearch;

public enum Color {
	RED(true), BLUE;

	boolean isSport = false;

	Color() {

	}

	Color(boolean isSport) {
		this.isSport = isSport;
	}

	public boolean isSport() {
		return isSport;
	}
}
