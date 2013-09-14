package pl.bb.beust.slidingWindow;

public class SlidingWindowKey {
	public static final SlidingWindowKey NOT_AVAILABLE = new SlidingWindowKey();
	public final String key;

	public SlidingWindowKey(int key) {
		this.key = Integer.toString(key);
	}

	private SlidingWindowKey() {
		this.key = "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SlidingWindowKey other = (SlidingWindowKey) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (this == NOT_AVAILABLE) {
			return "NOT_AVAILABLE";
		}
		return this.key;
	}

}