package sp.graphics;

import com.itay.wrapper.NativeClass;

import sp.maths.Vector4;

public abstract class Renderable2D extends NativeClass {
	
	private boolean knowColor = false;
	private int color = -1;
	
	public Renderable2D(long handler) {
		super(handler);
	}
	
	public void submit(Renderer2D renderer) {
		renderer.submit(this);
	}
	
	public void setColor(int color) {
		native_setColor(getNativeHandler(), color);
		knowColor = true;
		this.color = color;
	}
	
	public void setColor(Vector4 color) {
		int r = (int)(color.x * 255.0f);
		int g = (int)(color.y * 255.0f);
		int b = (int)(color.z * 255.0f);
		int a = (int)(color.w * 255.0f);
		this.color = a << 24 | b << 16 | g << 8 | r;
		native_setColor(getNativeHandler(), this.color);
		knowColor = true;
	}
	
	// TODO get position, get size, get color, get uv
	
	public int getTID() {
		long handler = native_getTexture(getNativeHandler());
		return handler != 0 ? new Texture(handler).getID() : 0;
	}
	
	public Texture getTexture() {
		return new Texture(native_getTexture(getNativeHandler()));
	}
	
	public int getColor() {
		if(!knowColor) {
			color = native_getColor(getNativeHandler());
		}
		return color;
	}
	
	private static native long native_getTexture(long handler);
	private static native void native_setColor(long handler, int color);
	private static native int  native_getColor(long handler);

	//private static native void setColor();
	
}
