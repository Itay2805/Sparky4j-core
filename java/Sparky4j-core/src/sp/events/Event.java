package sp.events;

public class Event {
	
	public enum Type {
		MOUSE_PRESSED,
		MOUSE_RELEASED,
		MOUSE_MOVED,
		KEY_PRESSED,
		KEY_RELEASED
	}
	
	protected boolean handled;
	protected Type type;
	
	protected Event(Type type) {
		this.type = type;
		handled = false;
	}
	
	public Type getType() {
		return type;
	}
	
}
