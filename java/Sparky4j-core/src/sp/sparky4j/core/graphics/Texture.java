package sp.sparky4j.core.graphics;

public class Texture {
	
	private long nativeHandler;
	
	private String name;
	
	public Texture(String name, String filename) {
		nativeHandler = bind(filename);
		this.name = name;
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
	
	public String getName() {
		return name;
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
