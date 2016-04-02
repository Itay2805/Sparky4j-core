package itay.test;

import java.util.Random;

import sp.sparky4j.core.graphics.Shader;
import sp.sparky4j.core.graphics.Sprite;
import sp.sparky4j.core.graphics.Texture;
import sp.sparky4j.core.graphics.Window;
import sp.sparky4j.core.graphics.layers.Group;
import sp.sparky4j.core.maths.Matrix4;
import sp.sparky4j.core.maths.Vector2;
import sp.sparky4j.core.maths.Vector3;
import sp.sparky4j.core.maths.Vector4;
import sp.sparky4j.core.util.Timer;

public class Main {
	
	// Loading libraries
	static {
		// GLFW library
		System.loadLibrary("glfw3");
		
		// FreeImage library
		System.loadLibrary("FreeImage");

		// The basic library
		/* For right now we will store the core stuff in sparky4j-core
		 * Might change in the future
		System.loadLibrary("sparky-core");
		*/
		
		// The native wrapper
		// You can use Sparky4j-core-debug to use the unoptimized version of the DLL
		System.loadLibrary("Sparky4j-core");
	}
	
	public static final boolean TEST_50K_SPRITES = false;
	public static final boolean BATCH_RENDERER = true;

	public static void main(String[] args) {
		Random random = new Random();
		Window window = new Window("Sparky4J!", 960, 540);
		
		Shader shader = new Shader("shaders/basic.vert", "shaders/basic.frag");
		Shader shader2 = new Shader("shaders/basic.vert", "shaders/basic.frag");
		shader.enable();
		shader2.enable();
		shader.setUniform2f("light_pos", new Vector2(4.0f, 1.5f));
		shader2.setUniform2f("light_pos", new Vector2(4.0f, 1.5f));
		
		TileLayer layer = new TileLayer(shader);
		if(TEST_50K_SPRITES) {			
			for (float y = -9.0f; y < 9.0f; y += 0.1) { 
				for (float x = -16.0f; x < 16.0f; x += 0.1) { 
					layer.add(new Sprite(x, y, 0.09f, 0.09f, new Vector4(random.nextInt(0x7fff) % 1000 / 1000.0f, 0, 1, 1))); 
				} 
			} 
		}
		
		Group group = new Group(Matrix4.translation(new Vector3(-15.0f, 5.0f, 0.0f)));
		Group button = new Group(Matrix4.translation(new Vector3(0.5f, 0.5f, 0.0f)));
		
		if(!TEST_50K_SPRITES) {
			group.add(new Sprite(0, 0, 6, 3, new Vector4(1, 1, 1, 1)));
			
			button.add(new Sprite(0, 0, 5.0f, 2.0f, new Vector4(1, 0, 1, 1)));
			button.add(new Sprite(0.5f, 0.5f, 3.0f, 1.0f, new Vector4(0.2f, 0.3f, 0.8f, 1)));
			group.add(button);
			
			layer.add(group);
		}
		
		Texture texture = new Texture("test.png");
		System.out.println(texture.getWidth() + ", " + texture.getHeight());
		
		Timer timer = new Timer();
		int frames = 0;
		while(!window.closed()) {
			window.clear();
			double x = window.getMouseX();
			double y = window.getMouseY();
			shader.enable();
			shader.setUniform2f("light_pos", new Vector2((float)(x * 32.0f / 960.0f - 16.0f), (float)(9.0f - y * 18.0f / 540.0f)));
			shader2.enable();
			
			layer.render();
			
			window.update();
			frames++;
			if(timer.elapsed() >= 1000) {
				System.out.printf("%d fps\n", frames);
				frames = 0;
				timer.reset();
			}
		}
	}
	
}
