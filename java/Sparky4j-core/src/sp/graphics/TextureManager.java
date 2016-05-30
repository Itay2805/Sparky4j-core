package sp.graphics;

import java.util.ArrayList;
import java.util.List;

public class TextureManager {
	
	private static List<Texture> textures = new ArrayList<>();
	
	private TextureManager() {}
	
	public static void add(Texture texture) {
		textures.add(texture);
	}
	
	public static Texture get(String name) {
		for(Texture texture : textures)
			if(texture.getName().equals(name)) return texture;
		return null;
	}
	
	public static void clean() {
		textures.clear();
	}
	
}
