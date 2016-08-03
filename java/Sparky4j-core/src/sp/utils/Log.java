package sp.utils;

public class Log {
	
	public static void SPARKY_ASSERT(boolean x, String message) {
		if(!x) {
			SPARKY_FATAL("");
			SPARKY_FATAL("*************************");
			SPARKY_FATAL("    ASSERTION FAILED!    ");
			SPARKY_FATAL("*************************");
			SPARKY_FATAL("");
			SPARKY_FATAL(message);
			SPARKY_FATAL("");
			for(int i = 2; i < Thread.currentThread().getStackTrace().length; i++) {				
				StackTraceElement element = Thread.currentThread().getStackTrace()[i];
				SPARKY_FATAL("-> " + element.getClassName() + "." + element.getMethodName() + "(" + element.getFileName() + ":" + element.getLineNumber() + ")");
			}
			SPARKY_FATAL("");
			System.exit(-1);
		}
	}
	
	public static native void SPARKY_FATAL(String message);
	public static native void SPARKY_ERROR(String message);
	public static native void SPARKY_WARN(String message);
	public static native void SPARKY_INFO(String message);
	
}
