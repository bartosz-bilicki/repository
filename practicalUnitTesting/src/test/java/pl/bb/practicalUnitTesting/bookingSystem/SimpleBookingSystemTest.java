package pl.bb.practicalUnitTesting.bookingSystem;

import org.joda.time.Hours;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class SimpleBookingSystemTest {

	public void shouldMakeReservation_book() {
		SimpleBookingSystem booking = new SimpleBookingSystem();
		booking.makeReservation(Hours.hours(12));

		Assert.assertTrue(booking.isBooked(Hours.hours(12)));
		Assert.assertFalse(booking.isBooked(Hours.hours(0)));
		Assert.assertFalse(booking.isBooked(Hours.hours(13)));
	}

	@Test(expectedExceptions = AlreadyBookedException.class)
	public void shouldNotBookAlreadyBookedHour() {
		SimpleBookingSystem booking = new SimpleBookingSystem();
		booking.makeReservation(Hours.hours(12));
		booking.makeReservation(Hours.hours(12));
	}

	@Test(dataProvider = "bookedHoursDataProvider")
	public void bookedHoursTest(Hours[] hours) {
		SimpleBookingSystem booking = new SimpleBookingSystem();

		for (int i = 0; i < hours.length; i++) {
			booking.makeReservation(hours[i]);
		}

		Hours[] bookedHours = booking.getBookedHours();
		Assert.assertEqualsNoOrder(bookedHours, hours);
	}

	@DataProvider
	private Object[][] bookedHoursDataProvider() {
		return new Object[][] { { new Hours[] { Hours.hours(1), Hours.hours(2) } },
				{ new Hours[] { Hours.hours(12), Hours.hours(11), Hours.hours(10) } } };
	}
}
