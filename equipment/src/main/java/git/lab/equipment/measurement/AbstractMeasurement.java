package git.lab.equipment.measurement;

public abstract class AbstractMeasurement implements Measurement {

	abstract protected void startMeasurement();

	abstract protected void stopMeasurement();
	
	enum State {
		INITIAL,
		RUNNING,
		STOPPED		
	}
	
	private State state = State.INITIAL;

	public State getState() {
		return state;
	}
	
	@Override
	public void start() {
		if (getState() != State.INITIAL) {
			throw new IllegalStateException("State must be 'INITIAL'");			
		}
		
		startMeasurement();
		state=State.RUNNING;
	}
	
	@Override
	public void stop() {
		if (getState() != State.RUNNING) {
			throw new IllegalStateException("State must be 'RUNNING'");			
		}
		
		stopMeasurement();
		state=State.STOPPED;
	}
	
}
