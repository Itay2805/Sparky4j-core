package sp.sparky4j.core.audio;

import sp.sparky4j.core.Log;

/**
 * 
 * @deprecated
 *
 */
public class SoundManager {
	
	private SoundManager() {}
	
	//private static List<Sound> sounds = new ArrayList<>();
	
	/**
	 * @deprecated this is already called natively by default. Calling this may reduce performance
	 */
	public static void init() {
		Log.SPARKY_LOG_WARN("Please do not use this class, it has no native side yet");
		//native_init();
	}
	
	public static void add(Sound sound) {
		Log.SPARKY_LOG_WARN("Please do not use this class, it has no native side yet");
		/*sounds.add(sound);
		native_add();*/
	}
	
	public static Sound get(String name) {
		Log.SPARKY_LOG_WARN("Please do not use this class, it has no native side yet");
		/*for(Sound sound : sounds) {
			if(sound.getName().equalsIgnoreCase(name)) {
				return sound;
			}
		}*/
		return null;
	}
	
	/**
	 * @deprecated this is already called natively by default. Calling this may reduce performance
	 */
	public static void update() {
		Log.SPARKY_LOG_WARN("Please do not use this class, it has no native side yet");
		//native_update();
	}
	
	public static void clean() {
		Log.SPARKY_LOG_WARN("Please do not use this class, it has no native side yet");
		//native_clean();
		//sounds.clear();
	}
	
	//private static native void native_init();
	//private static native void native_add();
	//private static native void native_update();
	//private static native void native_clean();	
	
}
