package sp.graphics;

import com.itay.wrapper.NativeClass;

import sp.maths.Matrix4;

public class Mask extends NativeClass{
	
	public Mask(Texture texture) {
		super(bind(texture.getNativeHandler(), Matrix4.identity().elements));
	}
	
	public Mask(Texture texture, Matrix4 transform) {
		super(bind(texture.getNativeHandler(), transform.elements));
	}
	
	private static native long bind(long texture, float[] elements);
	
	public void setTransform(Matrix4 matrix) {
		native_setTransform(getNativeHandler(), matrix.elements);
	}
	
	private static native void native_setTransform(long handler, float[] elements);
	
}
