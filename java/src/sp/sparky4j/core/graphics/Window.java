package sp.sparky4j.core.graphics;

public class Window {
	
	public static final int MAX_KEYS = 1024;
	public static final int MAX_BUTTONS = 32;
	
	private long nativeHandle;
	
	public Window(String title, int width, int height) {
		bindWindow(title, width, height);
	}
	
	private native void bindWindow(String title, int width, int height);
	
	public native void clear();
	public native void update();
	public native boolean closed();
	
	public native int getWidth();
	public native int getHeight();
	
	public native boolean isKeyPressed(int keycode);
	public native boolean isMouseButtonPressed(int button);
	
	public native double getMouseX();
	public native double getMouseY();
	
}
