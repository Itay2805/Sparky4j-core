package sp.sparky4j.core.graphics;

import sp.sparky4j.core.maths.Vector3;

public class Label extends Renderable2D {
	
	public String text;
	private Vector3 position;
	private Font font;
	private int color;
	
	public Label(String text, float x, float y, Font font, int color) {
		this.text = text;
		this.position = new Vector3(x, y, 0);
		this.color = color;
		this.font = font;
	}
	
	public Label(String text, float x, float y, int color) {
		this(text, x, y, FontManager.get("SourceSansPro"), color);
	}
	
	public Label(String text, float x, float y, String font, int size, int color) {
		this(text, x, y, FontManager.get(font), color);
		validateFont(font, size);
	}
	
	public Label(String text, float x, float y, String font, int color) {
		this(text, x, y, FontManager.get(font), color);
		validateFont(font);
	}
	
	public void submit(Renderer2D renderer) {
		renderer.drawString(text, position, font, color);
	}
	
	public void validateFont(String name) { validateFont(name, -1); }
	public void validateFont(String name, int size) {
		if(font != null)
			return;
		
		System.err.print("NULL FONT! Font=" + name);
		if(size > 0)
			System.err.print("Size=" + size);
		System.err.println();
		
		font = FontManager.get("SourceSansPro");
	}
	
}
