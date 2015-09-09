package git.lab.equipment.sensor;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {

	private final AtomicLong value = new AtomicLong();

	public void inc() {
		value.incrementAndGet();
	}

	public void inc(int delta) {
		if (delta <= 0) {
			throw new IllegalArgumentException("Parameter 'delta' must be >= 0");
		}

		value.addAndGet(delta);
	}

}
