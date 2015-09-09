package git.lab.equipment.sensor;

/**
 * Clock that is based on the system time
 */
public final class SystemClock implements Clock {

	@Override
	public long getTime() {
		return System.nanoTime();
	}

}
