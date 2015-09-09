package git.lab.equipment.sensor;

public interface Clock {

	/**
	 * Returns current time in ns
	 * 
	 * @return current time in ns
	 */
	long getTime();
}
