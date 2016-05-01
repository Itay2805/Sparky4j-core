package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector3;

public class Label extends Renderable2D {
	
	public String text;
	private Vector3 position;
	private int color;
	
	public Label(String text, float x, float y, int color) {
		this.text = text;
		this.position = new Vector3(x, y, 0);
		this.color = color;
	}
	
	public void submit(Renderer2D renderer) {
		renderer.drawString(text, position, color);
	}
	
}
