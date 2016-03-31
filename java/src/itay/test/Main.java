package itay.test;

import sp.sparky4j.core.graphics.Renderable2D;
import sp.sparky4j.core.graphics.Shader;
import sp.sparky4j.core.graphics.Simple2DRenderer;
import sp.sparky4j.core.graphics.Window;
import sp.sparky4j.core.maths.Matrix4;
import sp.sparky4j.core.maths.Vector2;
import sp.sparky4j.core.maths.Vector3;
import sp.sparky4j.core.maths.Vector4;

public class Main {
	
	// Loading libraries
	static {
		// GLFW library
		System.loadLibrary("glfw3");

		// The basic library
		/* For right now we will store the core stuff in sparky4j-core
		 * Might change in the future
		System.loadLibrary("sparky-core");
		*/
		
		// The native wrapper
		System.loadLibrary("Sparky4j-core");
	}
	
	public static void main(String[] args) {	
		Window window = new Window("Sparky4J", 960, 540);
		
		Matrix4 ortho = Matrix4.orthographic(0.0f, 16.0f, 0.0f, 9.0f, -1.0f, 1.0f);
		
		Shader shader = new Shader("shaders/basic.vert", "shaders/basic.frag");
		shader.enable();
		shader.setUniformMat4("pr_matrix", ortho);
		shader.setUniformMat4("ml_matrix", Matrix4.translation(new Vector3(4, 3, 0)));
		
		Renderable2D sprite = new Renderable2D(new Vector3(5, 5, 0), new Vector2(4, 4), new Vector4(1, 0, 1, 1), shader);
		Renderable2D sprite2 = new Renderable2D(new Vector3(7, 1, 0), new Vector2(2, 3), new Vector4(0.2f, 0, 1, 1), shader);
		
		Simple2DRenderer renderer = new Simple2DRenderer();
		
		shader.setUniform2f("light_pos", new Vector2(4.0f, 1.5f));
		shader.setUniform4f("colour", new Vector4(0.2f, 0.3f, 0.8f, 1.0f));
		
		while(!window.closed()) {
			window.clear();
			
			double x = window.getMouseX();
			double y = window.getMouseY();
			shader.setUniform2f("light_pos", new Vector2((float)(x * 16.0f / 960.0f), (float)(9.0f - y * 9.0f / 540.0f)));
			renderer.submit(sprite);
			renderer.submit(sprite2);
			renderer.flush();
			
			window.update();
		}
		
	}
	
}
