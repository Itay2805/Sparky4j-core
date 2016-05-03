package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector2;

public class Window {
	
	/**
	 * Max number of keys
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public static final int MAX_KEYS = 1024;
	
	/**
	 * Max number of mouse buttons
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public static final int MAX_BUTTONS = 32;
	
	/**
	 * The pointer of the native object
	 * 
	 * @since Indev
	 * @author Itay Almog 
	 */
	private long nativeHandler;
	
	/**
	 * 
	 * Creates a new window
	 * 
	 * @param title the title of the window
	 * @param width the width of the window
	 * @param height the height of the window
	 *
	 * @since Indev
	 * @author Itay Almog
	 */
	public Window(String title, int width, int height) {
		nativeHandler = bind(title, width, height);
		FontManager.add(new Font("SourceSansPro", "engine/SourceSansPro-Light.ttf", 32));
	}
	
	private static native long bind(String title, int width, int height);
	
	/**
	 * Clears the window <br>
	 *
	 * @since Indev
	 * @author Itay Almog
	 */
	public void clear() {
		native_clear(nativeHandler);
	}
	
	/**
	 * Updates the window
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public void update() {
		native_update(nativeHandler);
	}
	
	/**
	 * Checks if the window is closed
	 * @return is the window closed
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public boolean closed() {
		return native_closed(nativeHandler);
	}
	
	
	/**
	 * Return true if the key is pressed and false if isn't
	 * @param keycode the key code
	 * @return if the key is pressed
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public boolean isKeyPressed(int keycode) {
		return native_isKeyPressed(nativeHandler, keycode);
	}
	
	/**
	 * Return true if the key was typed and false if isn't
	 * @param keycode the key code
	 * @return if the key was typed
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public boolean isKeyTyped(int keycode) {
		return native_isKeyTyped(nativeHandler, keycode);
	}
	
	/**
	 * Return true if the mouse button is pressed and false if isn't
	 * @param keycode the button
	 * @return if the button is pressed
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public boolean isMouseButtonPressed(int button) {
		return native_isMouseButtonPressed(nativeHandler, button);
	}
	
	/**
	 * Return true if the mouse button was clicked and false if isn't
	 * @param keycode the button
	 * @return if the button was clicked
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public boolean isMouseButtonClicked(int button) {
		return native_isMouseButtonClicked(nativeHandler, button);
	}
	
	/**
	 * Return the mouse x
	 * @return the mouse x
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public double getMouseX() {
		return native_getMouseX(nativeHandler);
	}
	
	/**
	 * Return the mouse y
	 * @return the mouse y
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public double getMouseY() {
		return native_getMouseY(nativeHandler);
	}
	
	/**
	 * Return vector of the mouse x, y
	 * @return vector of the x, y
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public Vector2 getMousePosition() {
		return new Vector2((float) getMouseX(), (float) getMouseY());
	}
	

	/**
	 * @return the window initial width
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public int getWidth() {
		return native_get_width(nativeHandler);
	}
	
	/**
	 * @return the window initial height
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public int getHeight() {
		return native_get_height(nativeHandler);
	}
	
	/*
	 * This is the native command, To help performance we directly give the values, so no reflection will be used
	 */
	private static native void native_clear(long handle);
	private static native void native_update(long handle);
	private static native boolean native_closed(long handle);
	private static native boolean native_isKeyPressed(long handle, int keycode);
	private static native boolean native_isKeyTyped(long handle, int keycode);
	private static native boolean native_isMouseButtonPressed(long handle, int button);
	private static native boolean native_isMouseButtonClicked(long handle, int button);
	private static native double native_getMouseX(long handle);
	private static native double native_getMouseY(long handle);
	private static native int native_get_width(long handle);
	private static native int native_get_height(long handle);
	
	/**
	 * This returns the pointer of the handled native class. this is so we won't need to use reflection which can lower the performance
	 * @return The native handler
	 * 
	 * @since Indev
	 * @author Itay Almog
	 */
	public long getNativeHandler() {
		return nativeHandler;
	}
	
}
