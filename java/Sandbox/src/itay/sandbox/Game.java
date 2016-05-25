package itay.sandbox;

import sp.sparky4j.core.Log;
import sp.sparky4j.core.Sparky;
import sp.sparky4j.core.graphics.BatchRenderer2D;
import sp.sparky4j.core.graphics.FontManager;
import sp.sparky4j.core.graphics.Label;
import sp.sparky4j.core.graphics.Shader;
import sp.sparky4j.core.graphics.Sprite;
import sp.sparky4j.core.graphics.Texture;
import sp.sparky4j.core.graphics.Window;
import sp.sparky4j.core.graphics.layers.Layer;
import sp.sparky4j.core.input.Keys;
import sp.sparky4j.core.maths.Matrix4;
import sp.sparky4j.core.maths.Vector2;

public class Game extends Sparky {
	
	private Window window;
	private Layer layer;
	private Label fps;
	private Sprite sprite;
	private Shader shader;
	
	protected void init() {
		window = createWindow("Test Game", 960, 540);
		FontManager.get().setScale(window.getWidth() / 32.0f, window.getHeight() / 32.0f);
		shader = new Shader("shaders/basic.vert", "shaders/basic.frag");
		layer = new Layer(new BatchRenderer2D(), shader, Matrix4.orthographic(-16.0f, 16.0f, -9.0f, 9.0f, -1.0f, 1.0f));
		sprite = new Sprite(0.0f, 0.0f, 4, 4, new Texture("textures/tb.png"));
		layer.add(sprite);
		
		fps = new Label("", -15.5f, 7.8f, 0xffffffff);
		layer.add(fps);
	}
	
	protected void tick() {
		fps.text = getFPS() + " fps";
		Log.SPARKY_LOG_INFO(getUPS() + " ups, " + getFPS() + " fps \n");
	}
	
	protected void update() {
		float speed = 0.5f;
		if(window.isKeyPressed(Keys.UP)) {
			sprite.move(0, speed);
		}else if(window.isKeyPressed(Keys.DOWN)) {
			sprite.move(0, -speed);
		}
		if(window.isKeyPressed(Keys.LEFT)) {
			sprite.move(-speed, 0);
		}else if(window.isKeyPressed(Keys.RIGHT)) {
			sprite.move(speed, 0);
		}
		
		double x = window.getMouseX();
		double y = window.getMouseY();
		shader.setUniform2f("light_pos", new Vector2((float)(x * 32.0f / window.getWidth() - 16.0f), (float)(9.0f - y * 18.0f / window.getHeight())));
	}

	protected void render() {
		layer.render();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

}
