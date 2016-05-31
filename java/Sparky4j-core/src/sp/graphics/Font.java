package sp.graphics;

import com.itay.wrapper.NativeClass;

import sp.maths.Vector2;

public class Font extends NativeClass {
	
	private String name, filename;
	private float size;
	
	public Font(String name, String filename, float size) {
		super(bind(filename, size));
		this.name = name;
		this.size = size;
	}
	
	/**
	 * This method was not implemented yet. Please load from file instead
	 * @deprecated
	 */
	public Font(String name, byte[] data, int datasize, float size) {
		super(bind(data, datasize, size));
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFilename() {
		return filename;
	}
	
	private static native long bind(String filename, float size);
	private static native long bind(byte[] data, int datasize, float size);
	
	public int getID() {
		return native_getID(getNativeHandler());
	}
	
	public float getSize() {
		return size;
	}
	
	public void setScale(float x, float y) {
		native_setScale(getNativeHandler(), x, y);
	}
	
	public Vector2 getScale() {
		float x = native_getScaleX(getNativeHandler());
		float y = native_getScaleX(getNativeHandler());
		return new Vector2(x, y);
	}
	
	private static native void native_setScale(long handler, float x, float y);
	
	private static native int native_getID(long handler);
	private static native int native_getScaleX(long handler);
	private static native int native_getScaleY(long handler);
	
}
