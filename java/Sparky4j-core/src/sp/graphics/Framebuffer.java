package sp.graphics;

import com.itay.wrapper.NativeClass;

import sp.maths.Vector2I;
import sp.maths.Vector4;

public class Framebuffer extends NativeClass {
	
	private Vector2I size;
	
	public Framebuffer(Vector2I size) {
		super(bind(size.x, size.y));
	}
	
	public Framebuffer(int width, int height) {
		super(bind(width, height));
	}
	
	public Vector2I getSize() {
		return size;
	}
	
	public int getWidth() {
		return size.x;
	}
	
	public int getHeight() {
		return size.y;
	}
	
	private static native long bind(int x, int y);
	
	public void bind() { native_bind(getNativeHandler()); }
	public void clear() { native_clear(getNativeHandler()); }
	public Texture getTexture() { return new Texture(native_getTexture(getNativeHandler())); }
	public void setClearColor(Vector4 color) { native_setClearColor(getNativeHandler(), color.x, color.y, color.z, color.w); };
	
	private static native void native_bind(long handler);
	private static native void native_clear(long handler);
	private static native long native_getTexture(long handler);
	private static native void native_setClearColor(long handler, float x, float y, float z, float w);
	
}
