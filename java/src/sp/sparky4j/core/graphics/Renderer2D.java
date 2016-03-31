package sp.sparky4j.core.graphics;

public interface Renderer2D {
	
	void submit(Renderable2D renderable2d);
	void flush();
	
}
