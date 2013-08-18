package pl.bb.practicalUnitTesting.bookingSystem;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.joda.time.Hours;

public class SimpleBookingSystem {
	private final SortedSet<Hours> bookings = new TreeSet<Hours>();

	public void makeReservation(Hours from) {
		checkIfAnyHourInRangeBooked(from);
		bookings.add(from);
	}

	private void checkIfAnyHourInRangeBooked(Hours from) {
		if (isBooked(from)) {
			throw new AlreadyBookedException();
		}
	}

	public boolean isBooked(Hours hour) {
		return bookings.contains(hour);
	}

	public Set<Hours> getBookedHours() {
		return Collections.unmodifiableSet(bookings);
	}
}
