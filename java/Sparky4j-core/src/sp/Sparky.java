package sp;

import sp.graphics.Window;
import sp.utils.Timer;

/**
 * 
 * This is an old class, Please use Application instead
 * 
 * @deprecated
 *
 */
public abstract class Sparky {
	
	private static boolean init = false;
	
	private Window window;
	private Timer timer, updateTimer;
	private int framesPerSecond, updatesPerSecond;
	
	protected Sparky() {
		framesPerSecond = 0;
		updatesPerSecond = 0;
		
		if(!init) {
			System.loadLibrary("FreeImage");
			System.loadLibrary("OpenAL32");
			System.loadLibrary("Sparky4j-core");
			init = true;
		}
	}
	
	protected Window createWindow(String name, int width, int height) {
		window = new Window(name, width, height);
		return window;
	}
	
	public void start() {
		init();
		run();
	}
	
	/** Runs once upon initialization */
	protected abstract void init();
	
	/** Runs once per second */
	protected void tick() {}
	
	/** Runs 60 times per second */
	protected void update() {}
	
	/** Runs as fast as possible (unless vsync is enabled) */
	protected abstract void render();
	
	protected int getFPS() {
		return framesPerSecond;
	}
	
	protected int getUPS() {
		return updatesPerSecond;
	}
	
	private void run() {
		timer = new Timer();
		updateTimer = new Timer();
		int frames = 0;
		int updates = 0;
		while(!window.closed()) {
			window.clear();
			
			if(updateTimer.elapsed() > (1.0f / 60.0f)) {
				window.updateInput();
				update();
				updates++;
				updateTimer.reset();
			}
			
			render();
			frames++;
			window.update();
			
			if(timer.elapsed() > 1) {
				framesPerSecond = frames;
				updatesPerSecond = updates;
				frames = 0;
				updates = 0;
				tick();
				timer.reset();
			}
		}
	}
	
}
