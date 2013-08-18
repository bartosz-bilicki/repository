package pl.bb.practicalUnitTesting.bookingSystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimpleBookingSystem {
	private final boolean[] bookings = new boolean[24];

	public void makeReservation(int hourFrom, int hourTo) {
		checkIfAnyHourInRangeBooked(hourFrom, hourTo);
		Arrays.fill(bookings, hourFrom, hourTo, true);
	}

	private void checkIfAnyHourInRangeBooked(int hourFrom, int hourTo) {
		for (int i = hourFrom; i < hourTo; i++) {
			if (isBooked(i)) {
				throw new AlreadyBookedException();
			}
		}
	}

	public boolean isBooked(int i) {
		return bookings[i];
	}

	public Integer[] getBookedHours() {
		Set<Integer> ret = new HashSet<Integer>();
		for (int i = 0; i < 24; i++) {
			if (isBooked(i)) {
				ret.add(i);
			}
		}
		return ret.toArray(new Integer[0]);
	}
}
