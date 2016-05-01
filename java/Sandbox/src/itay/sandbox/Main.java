package itay.sandbox;

import java.util.Random;

import sp.sparky4j.core.Sparky;
import sp.sparky4j.core.graphics.Label;
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
	
	public static void main(String[] args) {
		// Initialize Sparky
		Sparky.init();
		
		Window window = new Window("Sparky4j!", 960, 540);
		
		Shader shader = new Shader("shaders/basic.vert", "shaders/basic.frag");
		shader.enable();
		shader.setUniform2f("light_pos", new Vector2(4.0f, 1.5f));
		
		TileLayer layer = new TileLayer(shader);
		
		Texture[] textures = {
				new Texture("textures/test.png"),
				new Texture("textures/tb.png"),
				new Texture("textures/tc.png")
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
		
		Group g = new Group(Matrix4.translation(new Vector3(-15.8f, 7.0f, 0.0f)));
		Label fps = new Label("", 0.4f ,0.4f, new Vector4(1, 0, 1, 1));
		g.add(new Sprite(0, 0, 5, 1.5f, new Vector4(0.3f, 0.3f, 0.3f, 0.9f)));
		g.add(fps);
		
		layer.add(g);
		
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
				fps.text = frames + " fps";
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
