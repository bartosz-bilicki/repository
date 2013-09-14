package pl.bb.beust.slidingWindow;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.Duration;
import org.joda.time.Instant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class SlidingWindowMapTest {

	private SlidingWindowMap slidingWindowMapSut;

	@BeforeMethod
	public void init() {
	}

	@Test
	public void simpleTest() {
		Set<SlidingWindowKey> keys = new HashSet<SlidingWindowKey>();
		for (int i = 0; i < 100; i++) {
			SlidingWindowKey newKey = new SlidingWindowKey(i);
			keys.add(newKey);
		}

		slidingWindowMapSut = new SlidingWindowMap(keys, 2, Duration.standardHours(1));

		// real collabolator
		slidingWindowMapSut.setTimeProvider(new TimeProvider());

		for (int i = 0; i < 200; i++) {
			SlidingWindowKey nextKey = slidingWindowMapSut.getNextKey();
			assertThat(nextKey).isNotNull().isNotEqualTo(SlidingWindowKey.NOT_AVAILABLE);
		}

		SlidingWindowKey nextKey = slidingWindowMapSut.getNextKey();
		assertThat(nextKey).isNotNull().isEqualTo(SlidingWindowKey.NOT_AVAILABLE);
	}

	@Test
	public void durationTest() throws InterruptedException {
		Set<SlidingWindowKey> keys = new HashSet<SlidingWindowKey>();
		for (int i = 0; i < 2; i++) {
			SlidingWindowKey newKey = new SlidingWindowKey(i);
			keys.add(newKey);
		}

		TimeProvider timeProviderMock = mock(TimeProvider.class);
		Instant someDate = new Instant();
		when(timeProviderMock.getCurrentTime()).thenReturn(someDate);

		Duration someDuration = Duration.standardHours(1);
		slidingWindowMapSut = new SlidingWindowMap(keys, 1, someDuration);
		slidingWindowMapSut.setTimeProvider(timeProviderMock);

		for (int i = 0; i < 2; i++) {
			SlidingWindowKey nextKey = slidingWindowMapSut.getNextKey();
			assertThat(nextKey).isNotNull().isNotEqualTo(SlidingWindowKey.NOT_AVAILABLE);
		}

		// all keys should be free again
		when(timeProviderMock.getCurrentTime()).thenReturn(someDate.plus(someDuration));

		for (int i = 0; i < 2; i++) {
			SlidingWindowKey nextKey = slidingWindowMapSut.getNextKey();
			assertThat(nextKey).isNotNull().isNotEqualTo(SlidingWindowKey.NOT_AVAILABLE);
		}
	}
}
