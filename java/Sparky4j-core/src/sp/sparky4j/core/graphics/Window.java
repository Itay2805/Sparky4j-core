package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector2;

public class Window {
	
	public static final int MAX_KEYS = 1024;
	public static final int MAX_BUTTONS = 32;
	
	private long nativeHandler;
	
	public Window(String title, int width, int height) {
		nativeHandler = bind(title, width, height);
		FontManager.add(new Font("SourceSansPro", "engine/SourceSansPro-Light.ttf", 32));
	}
	
	private static native long bind(String title, int width, int height);
	
	public void clear() {
		native_clear(nativeHandler);
	}
	
	public void update() {
		native_update(nativeHandler);
	}
	
	public void updateInput() {
		native_updateInput(nativeHandler);
	}
	
	public boolean closed() {
		return native_closed(nativeHandler);
	}
	
	public boolean isKeyPressed(int keycode) {
		return native_isKeyPressed(nativeHandler, keycode);
	}
	 boolean isKeyTyped(int keycode) {
		return native_isKeyTyped(nativeHandler, keycode);
	}
	
	public boolean isMouseButtonPressed(int button) {
		return native_isMouseButtonPressed(nativeHandler, button);
	}
	
	public boolean isMouseButtonClicked(int button) {
		return native_isMouseButtonClicked(nativeHandler, button);
	}
	
	public double getMouseX() {
		return native_getMouseX(nativeHandler);
	}
	
	public double getMouseY() {
		return native_getMouseY(nativeHandler);
	}
	
	public Vector2 getMousePosition() {
		return new Vector2((float) getMouseX(), (float) getMouseY());
	}
	
	public int getWidth() {
		return native_get_width(nativeHandler);
	}
	
	public int getHeight() {
		return native_get_height(nativeHandler);
	}
	
	private static native void native_clear(long handle);
	private static native void native_update(long handle);
	private static native void native_updateInput(long handle);
	private static native boolean native_closed(long handle);
	private static native boolean native_isKeyPressed(long handle, int keycode);
	private static native boolean native_isKeyTyped(long handle, int keycode);
	private static native boolean native_isMouseButtonPressed(long handle, int button);
	private static native boolean native_isMouseButtonClicked(long handle, int button);
	private static native double native_getMouseX(long handle);
	private static native double native_getMouseY(long handle);
	private static native int native_get_width(long handle);
	private static native int native_get_height(long handle);
	private static native void native_delete(long handle);
	
	protected void finalize() throws Throwable {
		FontManager.clean();
		TextureManager.clear();
		//SoundManager.clean();
		native_delete(nativeHandler);
	}
	
	public long getNativeHandler() {
		return nativeHandler;
	}
	
}
