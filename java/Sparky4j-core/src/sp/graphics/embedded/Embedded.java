package sp.graphics.embedded;

import com.itay.wrapper.util.Base64;

public class Embedded {
	
	private static final String fontString = "";
	
	public static final byte[] DEFAULT_FONT;
	public static final int DEFAULT_FONT_SIZE;
	
	static {
		DEFAULT_FONT = Base64.decode(fontString);
		DEFAULT_FONT_SIZE = DEFAULT_FONT.length;
	}
	
}
