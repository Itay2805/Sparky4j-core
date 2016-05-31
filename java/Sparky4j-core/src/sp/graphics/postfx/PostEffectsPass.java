package sp.graphics.postfx;

import com.itay.wrapper.NativeClass;

import sp.graphics.Framebuffer;
import sp.graphics.shaders.Shader;

public class PostEffectsPass extends NativeClass {
		
	public PostEffectsPass(Shader shader) {
		super(bind(shader.getNativeHandler()));
	}
	
	private static native long bind(long shader);
	
	public void renderPass(Framebuffer target) {
		native_renderPass(getNativeHandler(), target.getNativeHandler());
	}
	
	private static native void native_renderPass(long handler, long target);
	
}
