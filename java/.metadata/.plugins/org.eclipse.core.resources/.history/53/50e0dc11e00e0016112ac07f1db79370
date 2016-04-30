package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Matrix4;

public class Simple2DRenderer extends Renderer2D {
	
	private long nativeHandler;
	
	public Simple2DRenderer() {
		nativeHandler = bind();
	}
	
	private static native long bind();
	
	public void submit(Renderable2D renderable) {
		native_submit(nativeHandler, renderable.getNativeHandle());
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
	
	private static native void native_submit(long handle, long renderable);
	private static native void native_flush(long handle);
	private static native void native_push(long handle, float[] elements, boolean override);
	private static native void native_pop(long handle);
	
	public long getNativeHandler() {
		return nativeHandler;
	}

}
