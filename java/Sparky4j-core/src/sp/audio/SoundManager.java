package sp.audio;

import java.util.ArrayList;
import java.util.List;

public class SoundManager {
	
	private static List<Sound> sounds = new ArrayList<>();
	
	private SoundManager() {}
	
	/**
	 * Already called at the native side, call only when you don't have a window
	 * @deprecated
	 */
	public static native void init();
	
	public static Sound add(Sound sound) {
		sounds.add(sound);
		return sound;
	}
	
	public static Sound get(String name) {
		for(Sound sound : sounds)
			if(sound.getName().equals(name))
				return sound;
		return null;
	}
	
	/**
	 * Already called at the native side, call only when you don't have a window
	 * @deprecated
	 */
	public static native void update();
	
	public static void clean() {
		sounds.clear();
		native_clean();
	}
	
	private static native void native_clean();
	
}
