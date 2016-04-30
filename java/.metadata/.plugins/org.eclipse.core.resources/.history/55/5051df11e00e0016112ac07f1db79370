package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector4;

public class StaticSprite extends Renderable2D {
	
	public StaticSprite(float x, float y, float width, float height, Vector4 color, Shader shader) {
		nativeHandle = bind(x, y,
							width, height,
							color.x, color.y, color.z, color.w,
							shader.getNativeHandler());
	}
	
	private static native long bind(float x, float y,
									float width, float height,
									float xColor, float yColor, float zColor, float wColor,
									long shader);
	
}
