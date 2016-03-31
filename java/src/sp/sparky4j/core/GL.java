package sp.sparky4j.core;

/**
 * 	Generated from GL.h
 * 
 * 	Arguments:
 * 		 -methods $readfile_"methods_to_export.txt" -defines $readfile_"defines_to_export.txt"
 *  
 *  Result:
 *  	Generated this class and the JNI bindings for it
 *  	All the methods and defines were found and exported
 *  
 *  @deprecated
 */
public class GL {
	
	/* Version */
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_VERSION_1_1		 = 1;
	
	/* BeginMode */
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_POINTS			 = 0x0000;
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_LINES			 = 0x0001;
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_LINE_LOOP		 = 0x0002;
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_LINE_STRIP		 = 0x0003;
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_TRIANGLES		 = 0x0004;
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_TRIANGLE_STRIP	 = 0x0005;
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_TRIANGLE_FAN		 = 0x0006;
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_QUADS 			 = 0x0007;
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_QUAD_STRIP		 = 0x0008;
	/** @deprecated Used for testing! not needed anymore */
	public static final int GL_POLYGON			 = 0x0009;
	
	/* *********************************************************** */
	
	/** @deprecated Used for testing! not needed anymore */
	public static native void glClearColor(float r, float g, float b, float a);
	/** @deprecated Used for testing! not needed anymore */
	public static native void glBegin(int mode);
	/** @deprecated Used for testing! not needed anymore */
	public static native void glVertex2f(float x, float y);
	/** @deprecated Used for testing! not needed anymore */
	public static native void glEnd();


}
