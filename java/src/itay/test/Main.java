package itay.test;

import java.util.Random;

import sp.sparky4j.core.graphics.Shader;
import sp.sparky4j.core.graphics.Sprite;
import sp.sparky4j.core.graphics.Texture;
import sp.sparky4j.core.graphics.Window;
import sp.sparky4j.core.maths.Matrix4;
import sp.sparky4j.core.maths.Vector2;
import sp.sparky4j.core.maths.Vector4;
import sp.sparky4j.core.util.Timer;

public class Main {
	
	// Loading libraries
	static {
		// GLFW library
		System.loadLibrary("glfw3");
		
		// FreeImage library
		System.loadLibrary("FreeImage");
		
		// The native wrapper
		System.loadLibrary("Sparky4j-core");
	}

	public static void main(String[] args) {
		Window window = new Window("Sparky4j!", 960, 540);
		
		Shader shader = new Shader("shaders/basic.vert", "shaders/basic.frag");
		shader.enable();
		shader.setUniform2f("light_pos", new Vector2(4.0f, 1.5f));
		
		TileLayer layer = new TileLayer(shader);
		
		Texture[] textures = {
				new Texture("test.png"),
				new Texture("tb.png"),
				new Texture("tc.png")
		};
		
		for(float y = -9.0f; y < 9.0f; y++) {
			for(float x = -16.0f; x < 16.0f; x++) {
				if(rand() % 4 == 0) {
					layer.add(new Sprite(x, y, 0.9f, 0.9f, new Vector4(rand() % 1000 / 1000.0f, 0, 1, 1)));
				}else {
					layer.add(new Sprite(x, y, 0.9f, 0.9f, textures[rand() % 3]));
				}
			}
		}
		
		int[] texIDs = {
				0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		};
		
		shader.enable();
		shader.setUniform1iv("textures", texIDs, 10);
		shader.setUniformMat4("pr_matrix", Matrix4.orthographic(-16.0f, 16.0f, -9.0f, 9.0f, -1.0f, 1.0f));
		
		Timer timer = new Timer();
		int frames = 0;
		while(!window.closed()) {
			window.clear();
			
			double x = window.getMouseX();
			double y = window.getMouseY();
			shader.setUniform2f("light_pos", new Vector2((float)(x * 32.0f / 960.0f - 16.0f), (float)(9.0f - y * 18.0f / 540.0f)));
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
	private static Random random = new Random();
	public static int rand() {
		return random.nextInt(0x7fff);
	}
	
}

