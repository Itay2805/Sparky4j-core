package sp.audio;

import com.itay.wrapper.NativeClass;

public class Sound extends NativeClass {
	
	private String name, filename;
	private float gain = Float.NEGATIVE_INFINITY;
	
	public Sound(String name, String filename) {
		super(bind(filename));
		this.name = name;
		this.filename = filename;
	}
	
	private static native long bind(String filename);
	
	public String getName() { return name; }
	public String getFilename() { return filename; }
	
	public void setGain(float gain) {
		this.gain = gain;
		native_setGain(getNativeHandler(), gain);
	}
	
	public float getGain() {
		if(gain == Float.NEGATIVE_INFINITY)
			gain = native_getGain(getNativeHandler());
		return gain;
	}
	
	public void play() { native_play(getNativeHandler()); };
	public void loop() { native_loop(getNativeHandler()); };
	public void pause() { native_pause(getNativeHandler()); };
	public void resume() { native_resume(getNativeHandler()); };
	public void stop() { native_stop(getNativeHandler()); };
	public boolean isPlaying() { return native_isPlaying(getNativeHandler()); }
	
	private static native void native_play(long handler);
	private static native void native_loop(long handler);
	private static native void native_pause(long handler);
	private static native void native_resume(long handler);
	private static native void native_stop(long handler);

	private static native void native_setGain(long handler, float gain);

	private static native boolean native_isPlaying(long handler);
	private static native float native_getGain(long handler);
}
