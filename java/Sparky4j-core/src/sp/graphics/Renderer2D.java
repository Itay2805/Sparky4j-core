package sp.graphics;

import com.itay.wrapper.NativeClass;

import sp.graphics.postfx.PostEffectsPass;
import sp.maths.Matrix4;
import sp.maths.Vector3;

public abstract class Renderer2D extends NativeClass {
	
	public enum RenderTarget {
		SCREEN(0),
		BUFFER(1);
		
		final int id;
		private RenderTarget(int id) {
			this.id = id;
		}
	}
	
	public Renderer2D(long handler) {
		super(handler);
	}
	
	/* */
	public void push(Matrix4 matrix) { native_push(getNativeHandler(), matrix.elements, false); }
	public void push(Matrix4 matrix, boolean override) { native_push(getNativeHandler(), matrix.elements, override); }
	public void pop() { native_pop(getNativeHandler()); }
	
	private static native void native_push(long handler, float[] elements, boolean override);
	private static native void native_pop(long handler);
	/* */
	
	/* */
	public void setRenderTarget(RenderTarget target) { native_setRenderTarget(getNativeHandler(), target.id); }
	public RenderTarget getRenderTarget() {
		int target = native_getRenderTarget(getNativeHandler());
		switch(target) {
		case 1:
			return RenderTarget.BUFFER;
		case 0:
		default:
			return RenderTarget.SCREEN;
		}
	}
	
	private static native void native_setRenderTarget(long handler, int target);
	private static native int native_getRenderTarget(long handler);
	/* */
	
	/* */
	public void setPostEffects(boolean enabled) { native_setPostEffects(getNativeHandler(), enabled); }
	public boolean getPostEffects() { return native_getPostEffects(getNativeHandler()); }
	public void addPostEffectsPass(PostEffectsPass pass) { native_AddPostEffectsPass(getNativeHandler(), pass.getNativeHandler()); }
	
	private static native void native_setPostEffects(long handler, boolean enabled);
	private static native boolean native_getPostEffects(long handler);
	private static native void native_AddPostEffectsPass(long handler, long pass);
	/* */
	
	/* */
	public void setMask(Mask mask) { native_setMask(getNativeHandler(), mask.getNativeHandler()); }
	
	private static native void native_setMask(long handler, long mask);
	/* */
	
	
	/* */
	public void begin() { native_begin(getNativeHandler()); }
	public void submit(Renderable2D renderable) { native_submit(getNativeHandler(), renderable.getNativeHandler()); }
	public void drawString(String text, Vector3 position, Font font, int color) {
		native_drawString(getNativeHandler(), text, position.x, position.y, position.z, font.getNativeHandler(), color);
	}
	public void end() { native_end(getNativeHandler()); }
	public void flush() { native_flush(getNativeHandler()); }
	
	private static native void native_begin(long handler);
	private static native void native_submit(long handler, long renderable);
	private static native void native_drawString(long handler, String text, float x, float y, float z, long font, int color);
	private static native void native_end(long handler);
	private static native void native_flush(long handler);
	/* */
	
}
