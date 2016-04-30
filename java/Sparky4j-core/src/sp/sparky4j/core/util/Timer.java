package sp.sparky4j.core.util;

public class Timer {
	
	private long startTime;
	
	public Timer() {
		startTime = System.currentTimeMillis();
	}
	
	public void reset() {
		startTime = System.currentTimeMillis();
	}
	
	public long elapsed() {
		return System.currentTimeMillis() - startTime;
	}
	
}
