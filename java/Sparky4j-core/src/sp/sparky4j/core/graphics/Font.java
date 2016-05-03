package sp.sparky4j.core.graphics;

public class Font {
	private long nativeHandler;
	
	/* We keep reference for fast accesing, these will never be changed */
	private String name, filename;
	private int size;
	
	public Font(String name, String filename, int size) {
		nativeHandler = bind(name, filename, size);
		this.name = name;
		this.filename = filename;
		this.size = size;
	}
	
	private static native long bind(String name, String filename, int size);
	
	public String getName() {
		return name;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public int getSize() {
		return size;
	}
	
	public long getNativeHandler() {
		return nativeHandler;
	}
	
	protected void finalize() throws Throwable {
		native_delete(nativeHandler);
	}
	
	private static native void native_delete(long handle);

	
}
