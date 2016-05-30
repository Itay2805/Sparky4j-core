package sp.graphics.layers;

import java.util.ArrayList;
import java.util.List;

import sp.graphics.BatchRenderer2D;
import sp.graphics.Renderable2D;
import sp.graphics.Renderer2D;
import sp.graphics.Window;
import sp.graphics.shaders.Shader;
import sp.maths.Matrix4;

public class Layer2D extends Layer {
	
	private Renderer2D renderer;
	
	protected List<Renderable2D> renderables = new ArrayList<>();
	protected Shader shader;
	protected Matrix4 projectionMatrix;
	
	public Layer2D(Shader shader, Matrix4 projectionMatrix) {
		renderer = new BatchRenderer2D(Window.instance.getWidth(), Window.instance.getHeight());
		this.shader = shader;
		this.projectionMatrix = projectionMatrix;
		shader.bind();
		shader.setUniformMat4("pr_matrix", projectionMatrix);
	
		int texIDs[] = {
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
			10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
			20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
			30, 31
		};
		shader.setUniform1iv("textures", texIDs, 32);
		
		shader.unbind();
	}
	
	public void init() {
		onInit(renderer, shader);
	}
	
	public void onInit(Renderer2D renderer, Shader shader) {}
	
	// TODO mask
	
	public Renderable2D add(Renderable2D renderable) {
		renderables.add(renderable);
		return renderable;
	}
	
	public List<Renderable2D> getRenderables() {
		return renderables;
	}
	
	public void onRender() {
		shader.bind();
		renderer.begin();
		
		for(Renderable2D renderable : renderables)
			renderable.submit(renderer);
	
		renderer.end();
		renderer.flush();
		
		onRender(renderer);
	}
	
	public void onRender(Renderer2D renderer) {}
	
}
