package sp.app;

import java.util.ArrayList;

import sp.graphics.Window;
import sp.graphics.layers.Layer;
import sp.utils.Timer;

public class Application {
	
	private static boolean init = false;
	
	private static Application instance;
	
	public Window window;
	
	@SuppressWarnings("unused")
	private boolean running, suspended;
	private Timer Timer;
	private int updatesPerSecond, framesPerSecond;
	
	private String name;
	private int width, height;
	
	private ArrayList<Layer> layerStack = new ArrayList<>();
	
	public Application(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		instance = this;
		
		if(!init) {
			System.loadLibrary("FreeImage");
			System.loadLibrary("OpenAL32");
			System.loadLibrary("Sparky4j-core");
			init = true;
		}
	}
	
	public void init() {
		window = new Window(name, width, height);
	}
	
	public void pushLayer(Layer layer) {
		layerStack.add(layer);
		layer.init();
	}
	
	public Layer popLayer() {
		int index = layerStack.size() - 1;
		if(index < 0) return null;
		Layer layer = layerStack.get(index);
		layerStack.remove(index);
		return layer;
	}
	
	public void start() {
		init();
		running = true;
		suspended = false;
		run();
	}
	
	public void suspend() {
		suspended = true;
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void stop() {
		running = false;
	}
	
	private final void onTick() {
		for(Layer layer : layerStack)
			layer.onTick();
	}
	
	private final void onUpdate() {
		for(Layer layer : layerStack)
			layer.onUpdate();
	}
	
	private final void onRender() {
		for(Layer layer : layerStack)
			layer.onRender();
	}
	
	public int getFPS() {
		return framesPerSecond;
	}
	
	public int getUPS() {
		return updatesPerSecond;
	}
	
	private void run() {
		Timer = new Timer();
		float timer = 0.0f;
		float updateTimer = 0.0f;
		float updateTick = 1.0f / 60.0f;
		int frames = 0;
		int updates = 0;
		while(running) {
			window.clear();
			if(Timer.elapsed() - updateTimer > updateTick) {
				window.updateInput();
				onUpdate();
				updates++;
				updateTimer += updateTick;
			}
			onRender();
			frames++;
			window.update();
			if(Timer.elapsed() - timer > 1.0f) {
				timer += 1.0f;
				framesPerSecond = frames;
				updatesPerSecond = updates;
				frames = 0;
				updates = 0;
				onTick();
			}
			if(window.closed())
				running = false;
		}
	}
	
	public static Application getApplication() {
		return instance;
	}
	
}
