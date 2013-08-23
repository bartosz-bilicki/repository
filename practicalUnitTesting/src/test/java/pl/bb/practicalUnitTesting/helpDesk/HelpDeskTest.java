package pl.bb.practicalUnitTesting.helpDesk;

import static org.fest.assertions.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;

import org.testng.IObjectFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

public class HelpDeskTest {
	private final static int ANY_HOUR = 1;

	private Issue issueMock;

	@ObjectFactory
	public IObjectFactory getObjectFactory() {
		return new org.powermock.modules.testng.PowerMockObjectFactory();
	}

	@BeforeMethod
	public void initMocks() {
		issueMock = mock(Issue.class);
	}

	private TimeProvider getTimeProviderMockForDayOfWeek(int dayOfWeek, int hour) {
		TimeProvider timeProviderMock = mock(TimeProvider.class);
		when(timeProviderMock.getTime()).thenReturn(getCalendar(dayOfWeek, hour));
		return timeProviderMock;
	}

	private Calendar getCalendar(int dayOfWeek, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		return cal;
	}

	@Test(dataProvider = "weekendDaysOfWeek")
	public void shouldNotHandleOnWeekend(int weekendDayOfWeek) throws Exception {
		HelpDesk helpDeskSut = new HelpDesk(getTimeProviderMockForDayOfWeek(weekendDayOfWeek, ANY_HOUR));

		assertThat(helpDeskSut.willHandleIssue(issueMock)).isFalse();
	}

	@DataProvider
	private Object[][] weekendDaysOfWeek() {
		return new Object[][] { { Calendar.SATURDAY }, { Calendar.SUNDAY } };
	}

	@Test(dataProvider = "aferCobHours")
	public void shouldNotHandleFridayAfterCOB(int afterCobHour) throws Exception {
		HelpDesk helpDeskSut = new HelpDesk(getTimeProviderMockForDayOfWeek(Calendar.FRIDAY, afterCobHour));

		assertThat(helpDeskSut.willHandleIssue(issueMock)).isFalse();
	}

	@DataProvider
	private Object[][] aferCobHours() {
		return new Object[][] { { 18 }, { 22 } };
	}

	@Test(dataProvider = "cobHours")
	public void shouldHandleFridayCOB(int afterCobHour) throws Exception {
		HelpDesk helpDeskSut = new HelpDesk(getTimeProviderMockForDayOfWeek(Calendar.FRIDAY, afterCobHour));

		assertThat(helpDeskSut.willHandleIssue(issueMock)).isTrue();
	}

	@DataProvider
	private Object[][] cobHours() {
		return new Object[][] { { 1 }, { 11 } };
	}

}
