package sp.utils;

public class Timer {
	
	private long startTime;
	
	public Timer() {
		startTime = System.currentTimeMillis();
	}
	
	public void reset() {
		startTime = System.currentTimeMillis();
	}
	
	public float elapsed() {
		return (System.currentTimeMillis() - startTime) / 1000.0f;
	}
	
}
