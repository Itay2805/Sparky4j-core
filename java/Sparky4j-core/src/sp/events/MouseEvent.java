package sp.events;

import sp.maths.Vector2;

public class MouseEvent {

	public class MouseButtonEvent extends Event {
		
		protected int button;
		protected Vector2 position;
		
		protected MouseButtonEvent(int button, float x, float y, Type type) {
			super(type);
			this.button = button;
			this.position = new Vector2(x, y);
		}
		
		public int getButton() {
			return button;
		}
		
		public Vector2 getPosition() {
			return position;
		}
		
		public float getX() {
			return position.x;
		}
		
		public float getY() {
			return position.y;
		}
		
	}
	
	public class MousePressedEvent extends MouseButtonEvent {

		protected MousePressedEvent(int button, float x, float y) {
			super(button, x, y, Type.MOUSE_PRESSED);
		}
		
	}
	
	public class MouseReleasedEvent extends MouseButtonEvent {

		protected MouseReleasedEvent(int button, float x, float y) {
			super(button, x, y, Type.MOUSE_RELEASED);
		}
		
	}
	
	public class MouseMovedEvent extends Event {
		
		private Vector2 position;
		private boolean dragged;
		
		protected MouseMovedEvent(float x, float y, boolean dragged) {
			super(Type.MOUSE_MOVED);
			this.position = new Vector2(x, y);
			this.dragged = dragged;
		}
		
		public boolean isDragged() {
			return dragged;
		}
		
		public Vector2 getPosition() {
			return position;
		}
		
		public float getX() {
			return position.x;
		}
		
		public float getY() {
			return position.y;
		}
		
	}
	
}
