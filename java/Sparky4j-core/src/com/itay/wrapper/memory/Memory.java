package com.itay.wrapper.memory;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class Memory {
	
	private Memory() {
	}
	
	public static ByteBuffer malloc(int numBytes) {
		ByteBuffer buffer = mallocJni(numBytes);
		if(buffer == null) return null;
		buffer.order(ByteOrder.nativeOrder());
		return buffer;
	}
	
	private static native ByteBuffer mallocJni(int numBytes);
	
	public static native void free(Buffer buffer);
	
	public static native long getBufferAddress(Buffer buffer);
	
	public static int getPosition(Buffer buffer) {
		if(buffer instanceof ByteBuffer) return buffer.position();
		if(buffer instanceof CharBuffer) return buffer.position() << 1;
		if(buffer instanceof DoubleBuffer) return buffer.position() << 3;
		if(buffer instanceof FloatBuffer) return buffer.position() << 2;
		if(buffer instanceof IntBuffer) return buffer.position() << 2;
		if(buffer instanceof LongBuffer) return buffer.position() << 3;
		if(buffer instanceof ShortBuffer) return buffer.position() << 1;
		if(buffer == null) return 0;
		return buffer.position();
	}
	
}
