package pl.bb.practicalUnitTesting.bookingSystem;

import junit.framework.Assert;

import org.testng.annotations.Test;

@Test
public class SimpleBookingSystemTest {

	public void shouldMakeReservation_book() {
		SimpleBookingSystem booking = new SimpleBookingSystem();
		booking.makeReservation(12, 13);

		Assert.assertTrue(booking.isBooked(12));
		Assert.assertFalse(booking.isBooked(0));
		Assert.assertFalse(booking.isBooked(13));
	}

	@Test(expectedExceptions = AlreadyBookedException.class)
	public void shouldNotBookAlreadyBookedHour() {
		SimpleBookingSystem booking = new SimpleBookingSystem();
		booking.makeReservation(12, 13);
		booking.makeReservation(12, 13);
	}
}
