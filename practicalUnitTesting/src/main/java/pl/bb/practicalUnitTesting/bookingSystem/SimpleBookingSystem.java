package pl.bb.practicalUnitTesting.bookingSystem;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.Hours;

public class SimpleBookingSystem {
	private final boolean[] bookings = new boolean[24];

	public void makeReservation(Hours from) {
		checkIfAnyHourInRangeBooked(from);
		bookings[from.getHours()] = true;
	}

	private void checkIfAnyHourInRangeBooked(Hours from) {
		if (isBooked(from)) {
			throw new AlreadyBookedException();
		}
	}

	public boolean isBooked(Hours hour) {
		return isBooked(hour.getHours());
	}

	private boolean isBooked(int hour) {
		return bookings[hour];
	}

	public Hours[] getBookedHours() {
		Set<Hours> ret = new HashSet<Hours>();
		for (int i = 0; i < 24; i++) {
			if (isBooked(i)) {
				ret.add(Hours.hours(i));
			}
		}
		return ret.toArray(new Hours[0]);
	}
}
