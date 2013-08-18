package pl.bb.practicalUnitTesting.bookingSystem;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

	@Test(dataProvider = "bookedHoursDataProvider")
	public void bookedHoursTest(Integer[] hours) {
		SimpleBookingSystem booking = new SimpleBookingSystem();

		for (int i = 0; i < hours.length; i++) {
			booking.makeReservation(hours[i], hours[i] + 1);
		}

		Integer[] bookedHours = booking.getBookedHours();
		Assert.assertEqualsNoOrder(bookedHours, hours);
	}

	@DataProvider
	private Object[][] bookedHoursDataProvider() {
		return new Object[][] { { new Integer[] { 1, 2 } }, { new Integer[] { 12, 11, 10 } } };
	}
}
