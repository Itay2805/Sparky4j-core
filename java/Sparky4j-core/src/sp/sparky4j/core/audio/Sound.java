package sp.sparky4j.core.audio;

import sp.sparky4j.core.Log;

/**
 * 
 * No native side implementation yet
 * 
 * @deprecated
 *
 */
public class Sound {
	
	//private long nativeHandler;
	
	// quick access
	private String name, filename;
	
	public Sound(String name, String filename) {
		Log.SPARKY_LOG_WARN("The Sound class has no native implmentation right now, please do not use it.");
		//nativeHandler = bind(name, filename);
		//this.name = name;
		//this.filename = filename;
	}
	
	//private static native long bind(String name, String filename);
	
	public void play() {
		//native_play(nativeHandler);
	}
	
	public void loop() {
		//native_loop(nativeHandler);
	}
	
	public void pause() {
		//native_pause(nativeHandler);
	}
	
	public void resume() {
		//native_resume(nativeHandler);
	}
	
	public void stop() {
		//native_stop(nativeHandler);
	}
	
	public String getFilename() {
		return filename;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isPlaying() {
		//return native_isPlaying(nativeHandler);
		return false;
	}
	
	public float getGain() {
		//return native_getGain(nativeHandler);
		return -1;
	}
	
	protected void finalize() throws Throwable {
		//native_delete(nativeHandler);
	}
	
	/*private static native void native_play(long handle);
	private static native void native_loop(long handle);
	private static native void native_pause(long handle);
	private static native void native_resume(long handle);
	private static native void native_stop(long handle);
	private static native boolean native_isPlaying(long handle);
	private static native float native_getGain(long handle);
	private static native void native_delete(long handle);*/
	
	public long getNativeHandler() {
		//return nativeHandler;
		return -1;
	}
	
}
