package sp.graphics;

import com.itay.wrapper.NativeClass;

public abstract class Renderable2D extends NativeClass {

	public Renderable2D(long handler) {
		super(handler);
	}
	
	public void submit(Renderer2D renderer) {
		
	}
	
	//private static native void setColor();
	
}
