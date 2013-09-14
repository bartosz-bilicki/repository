package pl.bb.beust.slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.joda.time.Duration;
import org.joda.time.Instant;

/**
 * http://beust.com/weblog/2012/09/02/coding-challenge-a-sliding-window-map/
 * 
 * 
 */
public class SlidingWindowMap {
	private final int maxCount;
	private final Duration period;
	private final Map<SlidingWindowKey, Entry> map;

	public TimeProvider timeProvider;

	private class Entry {
		public Instant firstUsed;
		public int usedCount = 0;

		public void use() {
			firstUsed = timeProvider.getCurrentTime();
			usedCount++;
		}
	}

	public SlidingWindowMap(Set<SlidingWindowKey> keys, int maxCount, Duration period) {
		this.maxCount = maxCount;
		this.period = period;
		map = new HashMap<SlidingWindowKey, SlidingWindowMap.Entry>();
		for (SlidingWindowKey key : keys) {
			map.put(key, new Entry());
		}
	}

	/**
	 * at first, any key is good. - has 'maxCount' uses. Each 'getNextKey' marks
	 * key as used once, and timestamp that ussage. After 'periodMs' that key is
	 * free.
	 * 
	 * No entry- not used. Entry- key=key, value {used count, timestamp of first
	 * ussage of that key}
	 * 
	 * Lets make it simple. Lets try to free keys only when we have all keys
	 * used. Lets iterate keys, find first set of used and expired keys, and
	 * mark it as free.
	 * 
	 */

	/**
	 * @return a key that has been used less than `maxCount` times during the
	 *         past `periodMs` milliseconds or null if no such key exists.
	 */
	public SlidingWindowKey getNextKey() {
		for (java.util.Map.Entry<SlidingWindowKey, Entry> entry : map.entrySet()) {
			Entry value = entry.getValue();
			if (isNotCompetlyUsed(value) || isToBeReused(value.firstUsed)) {
				value.use();
				return entry.getKey();
			}
		}
		return SlidingWindowKey.NOT_AVAILABLE;
	}

	private boolean isNotCompetlyUsed(Entry value) {
		return value.usedCount < maxCount;
	}

	private boolean isToBeReused(Instant firstUsed) {
		Instant currentTime = timeProvider.getCurrentTime();
		return firstUsed.plus(period).isBefore(currentTime.plus(1));
	}

	public void setTimeProvider(TimeProvider timeProvider) {
		this.timeProvider = timeProvider;
	}
}
