package sp.sparky4j.core.util;

/**
 * 
 * This is used for me to test what takes the most time in the engine when testing.
 * This is not included in the sparky core engine!
 * 
 * @author Itay Almog
 *
 */
public class Profier {
	
	public enum ProfilerType {
		
		LOOP,
		NORMAL
		
	}
	
	private long startTime;
	private long avg;
	
	private int amount;
	private boolean running;
	private ProfilerType type;
	
	public Profier() {
	}
	
	public void start(ProfilerType type) {
		this.type = type;
		running = true;
		amount = 0;
		avg = 0;
		startTime = System.currentTimeMillis();
	}
	
	public void loop() {
		if(!running) return;
		if(type != ProfilerType.LOOP) return;
		amount++;
		avg += System.currentTimeMillis() - startTime;
		startTime = System.currentTimeMillis();
	}
	
	public void end(String prefix) {
		if(!running) return;
		switch(type) {
		case LOOP:
			System.out.println("[PROFILER] " + prefix + " -> took " + avg / amount + " in avarage, " + avg + " in total");
			break;
		case NORMAL:
			System.out.println("[PROFILER] " + prefix + " -> took " + avg);
			break;
		}
		running = false;
	}
	
}
