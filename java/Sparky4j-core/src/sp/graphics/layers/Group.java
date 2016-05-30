package sp.graphics.layers;

import java.util.List;

import sp.graphics.Renderable2D;
import sp.graphics.Renderer2D;
import sp.maths.Matrix4;

public class Group extends Renderable2D {
	
	private List<Renderable2D> renderables;
	private Matrix4 transformationMatrix;
	
	// TODO maybe i should make this native (?)
	public Group(Matrix4 transformationMatrix) {
		super(-1);
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
	
	public Matrix4 getTransformRef() {
		return transformationMatrix;
	}
	
}
