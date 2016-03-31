package sp.sparky4j.core.graphics;

public class BatchRenderer2D implements Renderer2D {
	
	private long nativeHandle;
	
	public BatchRenderer2D() {
		bind();
	}
	
	public void submit(Renderable2D renderable2d) {
		nativeSubmit(renderable2d);
	}

	public void flush() {
		nativeFlush();
	}
	
	private native void bind();
	private native void nativeSubmit(Renderable2D renderable2d);
	private native void nativeFlush();
	
	public native void begin();
	public native void end();

}
