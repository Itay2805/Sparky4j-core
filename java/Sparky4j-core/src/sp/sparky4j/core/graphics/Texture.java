package sp.sparky4j.core.graphics;

public class Texture {
	
	private long nativeHandler;
	
	public Texture(String filename) {
		nativeHandler = bind(filename);
	}
	
	private static native long bind(String filename);
	
	public void bind() {
		native_bind(nativeHandler);
	}
	
	public void unbind() {
		native_unbind(nativeHandler);
	}
	
	public int getWidth() {
		return native_getWidth(nativeHandler);
	}
	
	public int getHeight() {
		return native_getHeight(nativeHandler);
	}
	
	protected void finalize() throws Throwable {
		native_delete(nativeHandler);
	}
	
	private static native void native_bind(long handle);
	private static native void native_unbind(long handle);
	private static native int native_getWidth(long handle);
	private static native int native_getHeight(long handle);
	private static native void native_delete(long handle);

	public long getNativeHandler() {
		return nativeHandler;
	}
	
}
