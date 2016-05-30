package sp.graphics;

import com.itay.wrapper.NativeClass;

import sp.maths.Vector2;

public class Window extends NativeClass {
	
	public static final int MAX_KEYS = 1024;
	public static final int MAX_BUTTONS = 32;
	
	public static final int SP_MOUSE_LEFT	  = 0x00;
	public static final int SP_MOUSE_MIDDLE	  = 0x01;
	public static final int SP_MOUSE_RIGHT    = 0x02;

	public static final int SP_NO_CURSOR	  = 0;

	public static final int VK_0			  = 0x30;
	public static final int VK_1			  = 0x31;
	public static final int VK_2			  = 0x32;
	public static final int VK_3			  = 0x33;
	public static final int VK_4			  = 0x34;
	public static final int VK_5			  = 0x35;
	public static final int VK_6			  = 0x36;
	public static final int VK_7			  = 0x37;
	public static final int VK_8			  = 0x38;
	public static final int VK_9			  = 0x39;

	public static final int VK_A			  = 0x41;
	public static final int VK_B			  = 0x42;
	public static final int VK_C			  = 0x43;
	public static final int VK_D			  = 0x44;
	public static final int VK_E			  = 0x45;
	public static final int VK_F			  = 0x46;
	public static final int VK_G			  = 0x47;
	public static final int VK_H			  = 0x48;
	public static final int VK_I			  = 0x49;
	public static final int VK_J			  = 0x4A;
	public static final int VK_K			  = 0x4B;
	public static final int VK_L			  = 0x4C;
	public static final int VK_M			  = 0x4D;
	public static final int VK_N			  = 0x4E;
	public static final int VK_O			  = 0x4F;
	public static final int VK_P			  = 0x50;
	public static final int VK_Q			  = 0x51;
	public static final int VK_R			  = 0x52;
	public static final int VK_S			  = 0x53;
	public static final int VK_T			  = 0x54;
	public static final int VK_U			  = 0x55;
	public static final int VK_V			  = 0x56;
	public static final int VK_W			  = 0x57;
	public static final int VK_X			  = 0x58;
	public static final int VK_Y			  = 0x59;
	public static final int VK_Z			  = 0x5A;

	public static final int VK_LBUTTON        = 0x01;
	public static final int VK_RBUTTON        = 0x02;
	public static final int VK_CANCEL         = 0x03;
	public static final int VK_MBUTTON        = 0x04;

	public static final int VK_ESCAPE         = 0x1B;
	public static final int VK_SHIFT          = 0x10;
	public static final int VK_CONTROL        = 0x11;
	public static final int VK_MENU           = 0x12;
	public static final int VK_PAUSE          = 0x13;
	public static final int VK_CAPITAL        = 0x14;

	public static final int VK_SPACE          = 0x20;
	public static final int VK_PRIOR          = 0x21;
	public static final int VK_NEXT           = 0x22;
	public static final int VK_END            = 0x23;
	public static final int VK_HOME           = 0x24;
	public static final int VK_LEFT           = 0x25;
	public static final int VK_UP             = 0x26;
	public static final int VK_RIGHT          = 0x27;
	public static final int VK_DOWN           = 0x28;
	public static final int VK_SELECT         = 0x29;
	public static final int VK_PRINT          = 0x2A;
	public static final int VK_EXECUTE        = 0x2B;
	public static final int VK_SNAPSHOT       = 0x2C;
	public static final int VK_INSERT         = 0x2D;
	public static final int VK_DELETE         = 0x2E;
	public static final int VK_HELP           = 0x2F;

	public static final int VK_NUMPAD0        = 0x60;
	public static final int VK_NUMPAD1        = 0x61;
	public static final int VK_NUMPAD2        = 0x62;
	public static final int VK_NUMPAD3        = 0x63;
	public static final int VK_NUMPAD4        = 0x64;
	public static final int VK_NUMPAD5        = 0x65;
	public static final int VK_NUMPAD6        = 0x66;
	public static final int VK_NUMPAD7        = 0x67;
	public static final int VK_NUMPAD8        = 0x68;
	public static final int VK_NUMPAD9        = 0x69;
	public static final int VK_MULTIPLY       = 0x6A;
	public static final int VK_ADD            = 0x6B;
	public static final int VK_SEPARATOR      = 0x6C;
	public static final int VK_SUBTRACT       = 0x6D;
	public static final int VK_DECIMAL        = 0x6E;
	public static final int VK_DIVIDE         = 0x6F;
	public static final int VK_F1             = 0x70;
	public static final int VK_F2             = 0x71;
	public static final int VK_F3             = 0x72;
	public static final int VK_F4             = 0x73;
	public static final int VK_F5             = 0x74;
	public static final int VK_F6             = 0x75;
	public static final int VK_F7             = 0x76;
	public static final int VK_F8             = 0x77;
	public static final int VK_F9             = 0x78;
	public static final int VK_F10            = 0x79;
	public static final int VK_F11            = 0x7A;
	public static final int VK_F12            = 0x7B;
	public static final int VK_F13            = 0x7C;
	public static final int VK_F14            = 0x7D;
	public static final int VK_F15            = 0x7E;
	public static final int VK_F16            = 0x7F;
	public static final int VK_F17            = 0x80;
	public static final int VK_F18            = 0x81;
	public static final int VK_F19            = 0x82;
	public static final int VK_F20            = 0x83;
	public static final int VK_F21            = 0x84;
	public static final int VK_F22            = 0x85;
	public static final int VK_F23            = 0x86;
	public static final int VK_F24            = 0x87;

	public static final int VK_NUMLOCK        = 0x90;
	public static final int VK_SCROLL         = 0x91;

	public static final int VK_LSHIFT         = 0xA0;
	public static final int VK_RSHIFT         = 0xA1;
	public static final int VK_LCONTROL       = 0xA2;
	public static final int VK_RCONTROL       = 0xA3;
	public static final int VK_LMENU          = 0xA4;
	public static final int VK_RMENU          = 0xA5;
	
	// TODO change to the other thing
	public static Window instance;
	
	public Window(String name, int width, int height) {
		super(bind(name, width, height));
		FontManager.add(new Font("SourceSansPro", "res/SourceSansPro-Light.ttf", 32));
		instance = this;
	}
	
	private static native long bind(String name, int width, int height);
	
	public void clear() { native_clear(getNativeHandler()); }
	public void update() { native_update(getNativeHandler()); }
	public void updateInput() { native_updateInput(getNativeHandler()); }
	public boolean closed() { return native_closed(getNativeHandler()); }
	
	public int getWidth() { return native_getWidth(getNativeHandler()); }
	public int getHeight() { return native_getHeight(getNativeHandler()); }
	
	public boolean isKeyPressed(int keycode) { return native_isKeyPressed(getNativeHandler(), keycode); }
	public boolean isKeyTyped(int keycode) { return native_isKeyTyped(getNativeHandler(), keycode); }
	public boolean isMouseButtonPressed(int button) { return native_isMouseButtonPressed(getNativeHandler(), button); }
	public boolean isMouseButtonClicked(int button) { return native_isMouseButtonClicked(getNativeHandler(), button); }
	
	public Vector2 getMousePosition() { return new Vector2(native_getMouseX(getNativeHandler()), native_getMousey(getNativeHandler())); }
	public void setMousePosition(Vector2 position) { native_setMousePosition(getNativeHandler(), position.x, position.y); }
	public boolean isMouseGrabbed() { return native_isMouseGrabbed(getNativeHandler()); }
	public void setMouseGrabbed(boolean grabbed) { native_setMouseGrabbed(getNativeHandler(), grabbed); }
	public void setMouseCursor(int cursor) { native_setMouseCursor(getNativeHandler(), cursor); }
	
	public void setVsync(boolean enabled) { native_setVsync(getNativeHandler(), enabled); }
	public boolean isVsync() { return native_isVsync(getNativeHandler()); }
	
	private static native void native_clear(long handler);
	private static native void native_update(long handler);
	private static native void native_updateInput(long handler);
	private static native boolean native_closed(long handler);
	
	private static native int native_getWidth(long handler);
	private static native int native_getHeight(long handler);
	
	private static native boolean native_isKeyPressed(long handler, int keycode);
	private static native boolean native_isKeyTyped(long handler, int keycode);
	private static native boolean native_isMouseButtonPressed(long handler, int button);
	private static native boolean native_isMouseButtonClicked(long handler, int button);
	
	private static native float native_getMouseX(long handler);
	private static native float native_getMousey(long handler);
	private static native void native_setMousePosition(long handler, float x, float y);
	private static native boolean native_isMouseGrabbed(long handler);
	private static native void native_setMouseGrabbed(long handler, boolean grabbed);
	private static native void native_setMouseCursor(long handler, int cursor);
	
	private static native void native_setVsync(long handler, boolean enabled);
	private static native boolean native_isVsync(long handler);
	
}
