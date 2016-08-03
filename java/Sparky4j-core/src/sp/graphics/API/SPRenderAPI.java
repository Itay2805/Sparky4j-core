package sp.graphics.API;

import java.nio.Buffer;
import java.nio.ByteBuffer;

import platform.SPOpenGLRenderAPI;

/**
 * SPRenderAPI is a low-level platform-independent and api-independent rendering API.
 * This should contain the lowest-level functions. The VertexBuffer, IndexBuffer,
 * VertexArray, and Renderer classes contain higher-level implementations which should
 * be used whenever possible.
 */
public interface SPRenderAPI {
	
	public static final SPRenderAPI API = new SPOpenGLRenderAPI();
	public static final int SP_FLOAT = API.getValue("float");
	public static final int SP_UNSIGNED_SHORT = API.getValue("unsigned_short");
	
	int createVertexArray();
	int createBuffer();
	int createFramebuffer();
	int createRenderbuffer();
	
	void ceateVertexArrays(int size, int[] arrays);
	void createVertexBuffers(int size, int[] buffers);
	void createFramebuffers(int size, int[] buffers);
	void createRenderbuffers(int size, int[] buffers);
	
	void bindVertexArray(int array);
	void bindBuffer(int target, int buffer);
	void bindFramebuffer(int target, int buffer);
	void bindRenderbuffer(int target, int buffer);
	
	void setBufferData(int target, int size, Buffer data, int usage);
	void setBufferSubData(int target, int offset, int size, Buffer data);
	ByteBuffer getBufferPointer(int target, int access);
	void releaseBufferPointer(int target);
	
	void framebufferTexture2D(int target, int attachment, int textarget, int texture, int level);
	void framebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer);
	void renderbufferStorage(int target, int format, int width, int height);
	int getScreenBuffer();
	
	void setViewport(int x, int y, int width, int height);
	void clear(int flags);
	void setClearColor(float r, float g, float b, float a);
	
	int createTexture();
	void createTextures(int size, int[] textures);
	void bindTexture(int target, int texure);
	void unbindTexture(int target);
	void setTextureParamater(int target, int parameter, int value);
	void setTextureData(int target, int internalformat, int width, int height, int format, int type, int[] pixels);
	void setActiveTexture(int texture);
	
	void unbindVertexArrays();
	void unbindBuffers(int target);
	
	void enableVertexAttribute(int index);
	void disableVertexAttribute(int index);
	void setVertexAttributePointer(int index, int size, int type, boolean normalized, int stride, int offset);

	void freeVertexArray(int array);
	void freeBuffer(int buffer);
	void freeFramebuffer(int buffer);

	void freeVertexArrays(int size, int[] arrays);
	void freeBuffers(int size, int[] buffers);
	void freeFramebuffers(int size, int[] buffers);

	void freeTexture(int texture);
	void freeTextures(int size, int[] textures);
	
	void drawElements(int mode, int count, int type, Buffer indices);
	
	int getValue(String name);
}
