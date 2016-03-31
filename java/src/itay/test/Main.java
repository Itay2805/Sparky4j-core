package itay.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sp.sparky4j.core.graphics.BatchRenderer2D;
import sp.sparky4j.core.graphics.Renderable2D;
import sp.sparky4j.core.graphics.Shader;
import sp.sparky4j.core.graphics.Sprite;
import sp.sparky4j.core.graphics.StaticSprite;
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

		// The basic library
		/* For right now we will store the core stuff in sparky4j-core
		 * Might change in the future
		System.loadLibrary("sparky-core");
		*/
		
		// The native wrapper
		System.loadLibrary("Sparky4j-core");
	}
	
	public static final boolean BATCH_RENDERER = true;
	
	public static void main(String[] args) {
		Random random = new Random();
		Window window = new Window("Sparky4J", 960, 540);
		
		Matrix4 ortho = Matrix4.orthographic(0.0f, 16.0f, 0.0f, 9.0f, -1.0f, 1.0f);
		
		Shader shader = new Shader("shaders/basic.vert", "shaders/basic.frag");
		shader.enable();
		shader.setUniformMat4("pr_matrix", ortho);
		
		List<Renderable2D> sprites = new ArrayList<>();
		
		for(float y = 0; y < 9.0f; y+= 0.05) {
			for(float x = 0; x < 16.0f; x += 0.05) {
				if(BATCH_RENDERER) {
					sprites.add(new Sprite(x, y, 0.04f, 0.04f, new Vector4((float) (random.nextInt(0x7fff) % 1000 / 1000.0f), 0, 1, 1)));
				}else {
					sprites.add(new StaticSprite(x, y, 0.04f, 0.04f, new Vector4((float) (random.nextInt(0x7fff) % 1000 / 1000.0f), 0, 1, 1), shader));
				}
			}
		}
		
		System.out.println(sprites.size());
		
		shader.setUniform2f("light_pos", new Vector2(4.0f, 1.5f));
		shader.setUniform4f("colour", new Vector4(0.2f, 0.3f, 0.8f, 1.0f));
		
		BatchRenderer2D renderer = new BatchRenderer2D();
		
		Timer timer = new Timer();
		int frames = 0;
		while(!window.closed()) {
			window.clear();
			
			double x = window.getMouseX();
			double y = window.getMouseY();
			shader.setUniform2f("light_pos", new Vector2((float)(x * 16.0f / 960.0f), (float)(9.0f - y * 9.0f / 540.0f)));
			
			renderer.begin();
			
			for(int i = 0; i < sprites.size(); i++) {
				renderer.submit(sprites.get(i));
			}
			
			renderer.end();
			
			renderer.flush();
			
			window.update();
			frames++;
			if(timer.elapsed() >= 1000) {
				System.out.println(frames + " fps");
				timer.reset();
				frames = 0;
			}
		}
		
	}
	
}
