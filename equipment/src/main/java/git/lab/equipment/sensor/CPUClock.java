package git.lab.equipment.sensor;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Clock that is based on the current threads CPU time, if supported by the
 * system. This clock assumes that all measurements take place in the same
 * thread.
 */
public class CPUClock implements Clock {

	private final ThreadMXBean threadMXBean;

	public CPUClock() {
		threadMXBean = ManagementFactory.getThreadMXBean();

		if (!threadMXBean.isCurrentThreadCpuTimeSupported()) {
			throw new IllegalStateException("Information about thread CPU times not supported");
		}
	}

	@Override
	public long getTime() {
		return threadMXBean.getCurrentThreadCpuTime();
	}

}
