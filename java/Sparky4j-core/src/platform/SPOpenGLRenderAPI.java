package platform;

import sp.graphics.SPRenderAPI;

public class SPOpenGLRenderAPI implements SPRenderAPI {

	public native int createVertexArray();
	public native int createBuffer();
	public native int createFramebuffer();
	public native int createRenderbuffer();

	public native void ceateVertexArrays(int size, int[] arrays);
	public native void createVertexBuffer(int size, int[] buffers);
	public native void createFramebuffers(int size, int[] buffers);
	public native void createRenderbuffers(int size, int[] buffers);

	public native void bindVertexArray(int array);
	public native void bindBuffer(int target, int buffer);
	public native void bindFramebuffer(int target, int buffer);
	public native void bindRenderbuffer(int target, int buffer);

	public native void framebufferTexture2D(int target, int attachment, int textarget, int texture, int level);
	public native void framebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer);
	public native void renderbufferStorage(int target, int format, int width, int height);
	public native int getScreenBuffer();

	public native void setViewport(int x, int y, int width, int height);
	public native void clear(int flags);
	public native void setClearColor(float r, float g, float b, float a);

	public native int createTexture();
	public native void createTextures(int size, int[] textures);
	public native void bindTexture(int target, int texure);
	public native void unbindTexture(int target);
	public native void setTextureParamater(int target, int parameter, int value);
	public native void setTextureData(int target, int internalformat, int width, int height, int format, int type, int[] pixels);
	public native void setActiveTexture(int texture);

	public native void unbindVertexArrays();
	public native void unbindBuffers(int target);

	public native void enableVertexAttribute(int index);
	public native void disableVertexAttribute(int index);
	public native void setVertexAttributePointer(int index, int size, int type, boolean normalized, int stride, int offset);

	public native void freeVertexArray(int array);
	public native void freeBuffer(int buffer);
	public native void freeFramebuffer(int buffer);

	public native void freeVertexArrays(int size, int[] arrays);
	public native void freeBuffers(int size, int[] buffers);
	public native void freeFramebuffers(int size, int[] buffers);

	public native void freeTexture(int texture);
	public native void freeTextures(int size, int[] textures);

	public native void drawElements(int mode, int count, int type, int[] indices);
	public native void drawElements(int mode, int count, int type, short[] indices);
	
	
	
}
