package sp.graphics;

import java.util.ArrayList;
import java.util.List;

public class FontManager {
	
	private static List<Font> fonts = new ArrayList<>();
	
	private FontManager() {}
	
	public static void add(Font font) {
		fonts.add(font);
	}
	
	public static Font get() {
		return fonts.get(0);
	}
	
	public static Font get(String name) {
		for(Font font : fonts)
			if(font.getName().equals(name))
				return font;
		return null;
	}
	
	public static Font get(String name, int size) {
		for(Font font : fonts)
			if(font.getSize() == size && font.getName().equals(name))
				return font;
		return null;
	}
	
	public static void clean() {
		fonts.clear();
	}
	
}
