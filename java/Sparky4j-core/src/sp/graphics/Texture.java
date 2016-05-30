package sp.graphics;

import com.itay.wrapper.NativeClass;

public class Texture extends NativeClass {
	
	public enum TextureWrap {
		REPEAT(0x2901),
		CLAMP(0x2900),
		MIRRORED_REPEAT(0x8370),
		CLAMP_TO_EDGE(0x812F),
		CLAMP_TO_BORDER(0x812D);
		
		final int id;
		private TextureWrap(int id) {
			this.id = id;
		}
	}
	
	public enum TextureFilter {
		LINEAR(0x2601),
		NEAREST(0x2600);
		
		final int id;
		private TextureFilter(int id) {
			this.id = id;
		}
	}
	
	private String name;
	
	public Texture(int width, int height, int bits) {
		super(bind(width, height, bits));
		this.name = "";
	}
	
	public Texture(int width, int height) {
		super(bind(width, height, 24));
		this.name = "";
	}
	
	private static native long bind(int width, int height, int bits);
	private static native long bind(String filename);

	public Texture(String name, String filename) {
		super(bind(filename));
		this.name = name;
	}
	
	public String getName() { return name; }
	public void bind() { native_bind(getNativeHandler()); }
	public void unbind() { native_unbind(getNativeHandler()); }
	public int getID() { return native_getID(getNativeHandler()); }
	public int getWidth() { return native_getWidth(getNativeHandler()); }
	public int getHeight() { return native_getHeight(getNativeHandler()); }
	public static void setWrap(TextureWrap mode) { native_setWrap(mode.id); }
	public static void setFilter(TextureFilter mode) { native_setFilter(mode.id); }
	
	private static native void native_bind(long handler);
	private static native void native_unbind(long handler);
	private static native int native_getID(long handler);
	private static native int native_getWidth(long handler);
	private static native int native_getHeight(long handler);
	private static native void native_setWrap(int mode);
	private static native void native_setFilter(int mode);
	
}
