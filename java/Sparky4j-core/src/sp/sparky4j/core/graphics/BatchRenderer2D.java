package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Matrix4;
import sp.sparky4j.core.maths.Vector3;
import sp.sparky4j.core.maths.Vector4;

public class BatchRenderer2D extends Renderer2D {
	
	private long nativeHandler;
	
	public BatchRenderer2D() {
		nativeHandler = bind();
	}
	
	private static native long bind();
	
	public void begin() {
		native_begin(nativeHandler);
	}
	
	public void submit(Renderable2D renderable) {
		native_submit(nativeHandler, renderable.getNativeHandle());
	}
	
	public void drawString(String text, Vector3 position, Vector4 color) {
		native_draw_string(nativeHandler, text, position.x, position.y, position.z, color.x, color.y, color.z, color.w);
	}
	
	public void end() {
		native_end(nativeHandler);
	}

	public void flush() {
		native_flush(nativeHandler);
	}
	
	public void push(Matrix4 matrix, boolean override) {
		native_push(nativeHandler, matrix.elements, override);
	}

	public void pop() {
		native_pop(nativeHandler);
	}
	
	private static native void native_begin(long handle);
	private static native void native_submit(long handle, long renderable);
	private static native void native_draw_string(long handle, String text, float xPos, float yPos, float zPos, float xColor, float yColor, float zColor, float wColor);
	private static native void native_end(long handle);
	private static native void native_flush(long handle);
	private static native void native_push(long handle, float[] elements, boolean override);
	private static native void native_pop(long handle);
	
	public long getNativeHandler() {
		return nativeHandler;
	}
	
}
