package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Matrix4;

/* TODO change this to abstract class (?) */
public interface Renderer2D {
	
	/* 
	 * TODO Change these so not every class will need 
	 * to implement a native function for this!
	 */
	void push(Matrix4 matrix);
	void push(Matrix4 matrix, boolean override);
	void pop();
	
	void begin();
	void submit(Renderable2D renderable2d);
	void end();
	void flush();
	
}
