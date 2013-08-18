package pl.bb.practicalUnitTesting.bookingSystem;

import java.util.Arrays;

public class SimpleBookingSystem {
	private final boolean[] bookings = new boolean[24];

	public void makeReservation(int hourFrom, int hourTo) {
		for (int i = hourFrom; i < hourTo; i++) {
			if (bookings[i]) {
				throw new AlreadyBookedException();
			}
		}

		Arrays.fill(bookings, hourFrom, hourTo, true);
	}

	public boolean isBooked(int i) {
		return bookings[i];
	}

}
