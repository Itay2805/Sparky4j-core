package sp.sparky4j.core;

public class Log {
	public static final int SPARKY_LOG_LEVEL_FATAL 	= 0;
	public static final int SPARKY_LOG_LEVEL_ERROR 	= 1;
	public static final int SPARKY_LOG_LEVEL_WARN 	= 2;
	public static final int SPARKY_LOG_LEVEL_INFO 	= 3;
	
	public static int SPARKY_LOG_LEVEL = SPARKY_LOG_LEVEL_INFO;
	
	public static void SPARKY_ASSERT(boolean x, String message) {
		StackTraceElement element = Thread.currentThread().getStackTrace()[2];
		if(!x) {
			System.err.println();
			System.err.println("*************************");
			System.err.println("    ASSERTION FAILED!    ");
			System.err.println("*************************");
			if(message != null && !message.isEmpty())
				System.err.println(message);
			System.err.print("-> ");
			System.err.println(element.getClassName() + "(" + element.getFileName() + ":" + element.getLineNumber() + ")");
		}
	}
	
	public static void SPARKY_LOG_FATAL(String x, Object... more) {
		StackTraceElement element = Thread.currentThread().getStackTrace()[2];
		if(SPARKY_LOG_LEVEL >= SPARKY_LOG_LEVEL_FATAL) {
			System.err.print("[SPARKY4J][FATAL]: ");
			System.err.printf(x, more);
			
			System.err.println();
			System.err.println("*************************");
			System.err.println("    ASSERTION FAILED!    ");
			System.err.println("*************************");
			System.err.print("-> ");
			System.err.println(element.getClassName() + "." + element.getMethodName() + "(" + element.getFileName() + ":" + element.getLineNumber() + ")");
			System.exit(-1);
		}
	}
	
	public static void SPRAKY_LOG_ERROR(String x, Object... more) {
		if(SPARKY_LOG_LEVEL >= SPARKY_LOG_LEVEL_ERROR) {
			System.err.print("[SPARKY4J][ERROR]: ");
			System.err.printf(x, more);
		}
	}
	
	public static void SPARKY_LOG_WARN(String x, Object... more) {
		if(SPARKY_LOG_LEVEL >= SPARKY_LOG_LEVEL_ERROR) {
			System.out.print("[SPARKY4J][WARN]: ");
			System.out.printf(x, more);
		}
	}
	
	public static void SPARKY_LOG_INFO(String x, Object... more) {
		if(SPARKY_LOG_LEVEL >= SPARKY_LOG_LEVEL_ERROR) {
			System.out.print("[SPARKY4J][INFO]: ");
			System.out.printf(x, more);
		}
	}

}
