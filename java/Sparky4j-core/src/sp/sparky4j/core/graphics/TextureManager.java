package sp.sparky4j.core.graphics;

import java.util.ArrayList;
import java.util.List;

public class TextureManager {
	
	public TextureManager() { }
	
	private static List<Texture> textures = new ArrayList<>();
	
	public static void add(Texture texture) {
		textures.add(texture);
	}
	
	public static Texture getTexture(String name) {
		for(Texture texture : textures) {
			if(texture.getName().equals(name))
				return texture;
		}
		
		return null;
	}
	
	public static void clear() {
		textures.clear();
	}
	
}
