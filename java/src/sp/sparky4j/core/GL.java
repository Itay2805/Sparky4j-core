package sp.sparky4j.core;

/**
 * 	Generated from `GL.h1` and `https://www.khronos.org/registry/gles/api/1.0/gl.h` 
 * 
 * 	Arguments:
 * 		 -methods $readfile_"methods_to_export.txt" -defines $readfile_"defines_to_export.txt"
 *  
 *  Result:
 *  	Generated this class and the JNI bindings for it
 *  	All the methods and defines were found and exported
 *  
 *  Comment:
 *  	This is only used for testing if the engine works when there is not a full implementation yet!
 *  	In the future I might create a proper OpenGL bindings for all the versions!
 *  
 *  @deprecated used for testing only!
 */
public class GL {
	
	/* BeginMode */
	public static final int GL_POINTS			 		= 0x0000;
	public static final int GL_LINES				 	= 0x0001;
	public static final int GL_LINE_LOOP		 	 	= 0x0002;
	public static final int GL_LINE_STRIP		 		= 0x0003;
	public static final int GL_TRIANGLES		 		= 0x0004;
	public static final int GL_TRIANGLE_STRIP	 		= 0x0005;
	public static final int GL_TRIANGLE_FAN		 		= 0x0006;
	public static final int GL_QUADS 			 		= 0x0007;
	public static final int GL_QUAD_STRIP		 		= 0x0008;
	public static final int GL_POLYGON			 		= 0x0009;
	
	/* Texture Unit */
	public static final int GL_TEXTURE0          		= 0x84C0;
	public static final int GL_TEXTURE1          		= 0x84C1;
	public static final int GL_TEXTURE2          		= 0x84C2;
	public static final int GL_TEXTURE3          		= 0x84C3;
	public static final int GL_TEXTURE4          		= 0x84C4;
	public static final int GL_TEXTURE5                 = 0x84C5;
	public static final int GL_TEXTURE6                 = 0x84C6;
	public static final int GL_TEXTURE7                 = 0x84C7;
	public static final int GL_TEXTURE8                 = 0x84C8;
	public static final int GL_TEXTURE9                 = 0x84C9;
	public static final int GL_TEXTURE10                = 0x84CA;
	public static final int GL_TEXTURE11                = 0x84CB;
	public static final int GL_TEXTURE12                = 0x84CC;
	public static final int GL_TEXTURE13                = 0x84CD;
	public static final int GL_TEXTURE14                = 0x84CE;
	public static final int GL_TEXTURE15                = 0x84CF;
	public static final int GL_TEXTURE16                = 0x84D0;
	public static final int GL_TEXTURE17                = 0x84D1;
	public static final int GL_TEXTURE18                = 0x84D2;
	public static final int GL_TEXTURE19                = 0x84D3;
	public static final int GL_TEXTURE20                = 0x84D4;
	public static final int GL_TEXTURE21                = 0x84D5;
	public static final int GL_TEXTURE22                = 0x84D6;
	public static final int GL_TEXTURE23                = 0x84D7;
	public static final int GL_TEXTURE24                = 0x84D8;
	public static final int GL_TEXTURE25                = 0x84D9;
	public static final int GL_TEXTURE26                = 0x84DA;
	public static final int GL_TEXTURE27                = 0x84DB;
	public static final int GL_TEXTURE28                = 0x84DC;
	public static final int GL_TEXTURE29                = 0x84DD;
	public static final int GL_TEXTURE30                = 0x84DE;
	public static final int GL_TEXTURE31                = 0x84DF;
	
	/* *********************************************************** */
	
	public static native void glActiveTexture(int texture);
	public static native void glBegin(int mode);
	public static native void glClearColor(float r, float g, float b, float a);
	public static native void glEnd();
	public static native void glVertex2f(float x, float y);


}
