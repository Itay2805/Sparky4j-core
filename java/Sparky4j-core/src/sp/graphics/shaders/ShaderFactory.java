package sp.graphics.shaders;

import sp.utils.FileUtils;

public class ShaderFactory {
	
	// TODO make so the files will be already included here
	
	private static final String DEFAULT_SHADER = FileUtils.readFile("shaders/default/Default.shader");
	
	private static final String SIMPLE_SHADER = FileUtils.readFile("shaders/default/Simple.shader");
	
	private static final String BASIC_LIGHT_SHADER = FileUtils.readFile("shaders/default/BasicLight.shader");
	
	public static Shader defaultShader() {
		return Shader.fromSource("Default Shader", DEFAULT_SHADER);
	}
	
	public static Shader simpleShader() {
		return Shader.fromSource("Simple Shader", SIMPLE_SHADER);
	}
	
	public static Shader basicLightShader() {
		return Shader.fromSource("Default Shader", BASIC_LIGHT_SHADER);		
	}	
}
