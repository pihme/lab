package git.lab.equipment.sensor;

public class ClockFactory {

	public static Clock buildDefaultClock() {
		Clock result;
		try {
			result = new CPUClock();
		} catch (IllegalStateException ise) {
			result = new SystemClock();
		}

		return result;
	}
}
