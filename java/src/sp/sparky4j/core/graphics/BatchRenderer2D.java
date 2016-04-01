package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Matrix4;

public class BatchRenderer2D implements Renderer2D {
	
	private long nativeHandle;
	
	public BatchRenderer2D() {
		bind();
	}
	
	private native void bind();
	
	public void push(Matrix4 matrix) {
		push(matrix, false);
	}
	
	public native void push(Matrix4 matrix, boolean override);
	public native void pop();
	
	public native void submit(Renderable2D renderable2d);
	public native void flush();
	
	public native void begin();
	public native void end();
	
}
