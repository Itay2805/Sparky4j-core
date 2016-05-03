package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Matrix4;
import sp.sparky4j.core.maths.Vector3;

public abstract class Renderer2D {
	
	public void push(Matrix4 matrix) { push(matrix, false); }
	public abstract void push(Matrix4 matrix, boolean override);
	public abstract void pop();
	
	public void begin() {}
	public abstract void submit(Renderable2D renderable);
	public void drawString(String text, Vector3 position, Font font, int color) {}
	public void end() {}
	public abstract void flush();
	
	public abstract long getNativeHandler();
	
}
