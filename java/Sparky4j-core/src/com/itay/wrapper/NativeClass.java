package com.itay.wrapper;

public class NativeClass {
	
	private final long nativeHandler;
	
	public NativeClass(long handler) {
		this.nativeHandler = handler;
	}
	
	public long getNativeHandler() {
		return nativeHandler;
	}
	
	protected void finalize() throws Throwable {
		native_delete(nativeHandler);
		super.finalize();
	}
	
	protected static native void native_delete(long handler);
	
}
