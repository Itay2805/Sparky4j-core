package sp.sparky4j.core.graphics;

public class Texture {
	
	private long nativeHandle;
	
	public Texture(String filename) {
		bind(filename);
	}
	
	private native void bind(String filename);
	
	public native int getWidth();
	public native int getHeight();
	
}
