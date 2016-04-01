package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Matrix4;

public class Simple2DRenderer implements Renderer2D {
	
	private long nativeHandle;
	
	public Simple2DRenderer() {
		bind();
	}
	
	private native void bind();
	
	public native void submit(Renderable2D renderable2d);
	public native void flush();

	public void begin() {}
	public void end() {}
	
	public void push(Matrix4 matrix) {
		push(matrix, false);
	}

	public native void push(Matrix4 matrix, boolean override);
	public native void pop();
	
	

}
