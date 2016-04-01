package sp.sparky4j.core.graphics.layers;

import java.util.ArrayList;
import java.util.List;

import sp.sparky4j.core.graphics.Renderable2D;
import sp.sparky4j.core.graphics.Renderer2D;
import sp.sparky4j.core.maths.Matrix4;

public class Group extends Renderable2D {
	
	private List<Renderable2D> renderables;
	private Matrix4 transformationMatrix;
	
	public Group(Matrix4 transformationMatrix) {
		renderables = new ArrayList<>();
		this.transformationMatrix = transformationMatrix;
	}
	
	public void add(Renderable2D renderable) {
		renderables.add(renderable);
	}
	
	public void submit(Renderer2D renderer) {
		renderer.push(transformationMatrix);
		
		for(Renderable2D renderable : renderables)
			renderable.submit(renderer);
		
		renderer.pop();
	}
	
}
