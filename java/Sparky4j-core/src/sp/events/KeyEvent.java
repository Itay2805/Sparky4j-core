package sp.events;

public class KeyEvent extends Event {
	
	private int keycode;
	
	public KeyEvent(int keycode, Type type) {
		super(type);
	}
	
	public int getKeycode() {
		return keycode;
	}
	
	public class KeyPressedEvent extends KeyEvent {
		
		int repeat;
		
		public KeyPressedEvent(int button, int repeat) {
			super(button, Type.KEY_PRESSED);
		}
		
		public int getRepeat() {
			return repeat;
		}
	}
	
	public class KeyReleasedEvent extends KeyEvent {
		
		public KeyReleasedEvent(int button) {
			super(button, Type.KEY_RELEASED);
		}
	}

}
