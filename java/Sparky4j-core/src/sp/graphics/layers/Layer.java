package sp.graphics.layers;

import sp.events.Event;
import sp.events.IEventListener;
import sp.graphics.Window;

public abstract class Layer implements IEventListener {
	
	protected Window window;
	
	public Layer() {
		this.window = Window.instance;
	}
	
	public boolean onEvent(Event event) {
		return false;
	}
	
	public void init() {}
	public void onTick() {}
	public void onUpdate() {}
	public void onRender() {}
	
}
