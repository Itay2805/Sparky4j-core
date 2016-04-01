package sp.sparky4j.core.graphics.layers;

import java.util.ArrayList;
import java.util.List;

import sp.sparky4j.core.graphics.Renderable2D;
import sp.sparky4j.core.graphics.Renderer2D;
import sp.sparky4j.core.graphics.Shader;
import sp.sparky4j.core.maths.Matrix4;

public class Layer {
	
	protected Renderer2D renderer;
	protected List<Renderable2D> renderables;
	protected Shader shader;
	protected Matrix4 projectionMatrix;
	
	protected Layer(Renderer2D renderer, Shader shader, Matrix4 projectionMatrix) {
		this.renderer = renderer;
		this.shader = shader;
		this.projectionMatrix = projectionMatrix;
		this.renderables = new ArrayList<>();
		shader.enable();
		shader.setUniformMat4("pr_matrix", projectionMatrix);
		shader.disable();
	}
	
	public void add(Renderable2D renderable) {
		renderables.add(renderable);
	}
	
	public void render() {
		shader.enable();
		
		renderer.begin();
		for(Renderable2D renderable : renderables)
			renderable.submit(renderer);
		renderer.end();
		
		renderer.flush();
	}
	
}
