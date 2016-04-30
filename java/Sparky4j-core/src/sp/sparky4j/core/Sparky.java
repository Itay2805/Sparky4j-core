package sp.sparky4j.core;

public class Sparky {
	
	private static boolean init = false;
	
	public static void init() {
		if(init) {
			System.err.println("Sparky already initialized!");
			return;
		}
		System.loadLibrary("FreeImage");
		System.loadLibrary("glfw3");
		System.loadLibrary("Sparky4j-core");
		init = true;
	}
	
	public static boolean isInit() {
		return init;
	}
	
}