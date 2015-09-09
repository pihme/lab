package git.lab.equipment.measurement;

import java.util.Objects;

import git.lab.equipment.sensor.Clock;
import git.lab.equipment.sensor.ClockFactory;

public class TimeMeasurement extends AbstractMeasurement {

	private final Clock clock;
	private long startTime;
	private long elapsedTime;

	public TimeMeasurement() {
		clock = ClockFactory.buildDefaultClock();
	}

	public TimeMeasurement(Clock clock) {
		Objects.requireNonNull(clock);

		this.clock = clock;
	}

	@Override
	protected void startMeasurement() {
		this.startTime = clock.getTime();
	}

	@Override
	protected void stopMeasurement() {
		this.elapsedTime = clock.getTime() - startTime;
	}

	/**
	 * Returns the elapsed time in ns
	 * @return elapsed time in ns
	 */
	public long getElapsedTime() {
		return elapsedTime;
	}
}
