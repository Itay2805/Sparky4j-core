package sp.graphics;

import sp.maths.Vector3;
import sp.maths.Vector4;

public class Label extends Renderable2D {
	
	public Font font;
	public String text;
	public Vector3 position;
	public float x, y;
	public int color;
	
	public Label(String text, float x, float y, int color) {
		super(-1);
		this.text = text;
		this.position = new Vector3(x, y, 0.0f);
		this.color = color;
		this.font = FontManager.get();
	}
	
	public Label(String text, float x, float y, Font font, int color) {
		super(-1);
		this.text = text;
		this.position = new Vector3(x, y, 0.0f);
		this.color = color;
		this.font = font;
	}
	
	public Label(String text, float x, float y, String font, int color) {
		super(-1);
		this.text = text;
		this.position = new Vector3(x, y, 0.0f);
		this.color = color;
		this.font = FontManager.get(font);
		
		validateFont(font);
	}
	
	public Label(String text, float x, float y, String font, int size, int color) {
		super(-1);
		this.text = text;
		this.position = new Vector3(x, y, 0.0f);
		this.color = color;
		this.font = FontManager.get(font, size);
		
		validateFont(font, size);
	}
	
	public void submit(Renderer2D renderer) {
		renderer.drawString(text, position, font, color);
	}
	
	public void setColor(int color) { this.color = color; }
	public void setColor(Vector4 color) {
		int r = (int)(color.x * 255.0f);
		int g = (int)(color.y * 255.0f);
		int b = (int)(color.z * 255.0f);
		int a = (int)(color.w * 255.0f);
		this.color = a << 24 | b << 16 | g << 8 | r;
	}
	
	public int getColor() {
		return color;
	}
	
	public void validateFont(String name) { validateFont(name, -1); }
	public void validateFont(String name, int size) {
		if(font != null)
			return;
		
		System.err.print("NULL FONT! Font=" + name);
		if(size > 0)
			System.err.print(", Size=" + size);
		System.err.println();
		
		font = FontManager.get();
	}
	
}
