package sp.graphics.shaders;

public class ShaderFactory {
	
	// TODO make so the files will be already included here
	
	private static final String DEFAULT_SHADER = 
			"#shader vertex\r\n#version 330 core\r\n\r\nlayout (location = 0) in vec4 position;\r\nlayout (location = 1) in vec2 uv;\r\nlayout (location = 2) in vec2 mask_uv;\r\nlayout (location = 3) in float tid;\r\nlayout (location = 4) in float mid;\r\nlayout (location = 5) in vec4 color;\r\n\r\nuniform mat4 pr_matrix;\r\nuniform mat4 vw_matrix = mat4(1.0);\r\nuniform mat4 ml_matrix = mat4(1.0);\r\n\r\nuniform mat4 mask_matrix;\r\n\r\nout DATA\r\n{\r\n\tvec4 position;\r\n\tvec2 uv;\r\n\tvec2 mask_uv;\r\n\tfloat tid;\r\n\tfloat mid;\r\n\tvec4 color;\r\n} vs_out;\r\n\r\nvoid main()\r\n{\r\n\tgl_Position = pr_matrix * vw_matrix * ml_matrix * position;\r\n\tvs_out.position = ml_matrix * position;\r\n\tvs_out.uv = uv;\r\n\tvs_out.tid = tid;\r\n\tvs_out.mid = mid;\r\n\tvs_out.color = color;\r\n\tvs_out.mask_uv = mask_uv;\r\n};\r\n\r\n#shader fragment\r\n#version 330 core\r\n\r\nlayout (location = 0) out vec4 color;\r\n\r\nin DATA\r\n{\r\n\tvec4 position;\r\n\tvec2 uv;\r\n\tvec2 mask_uv;\r\n\tfloat tid;\r\n\tfloat mid;\r\n\tvec4 color;\r\n} fs_in;\r\n\r\nuniform sampler2D textures[32];\r\n\r\nvoid main()\r\n{\r\n\tvec4 texColor = fs_in.color;\r\n\tvec4 maskColor = vec4(1.0, 1.0, 1.0, 1.0);\r\n\tif (fs_in.tid > 0.0)\r\n\t{\r\n\t\tint tid = int(fs_in.tid - 0.5);\r\n\t\ttexColor = fs_in.color * texture(textures[tid], fs_in.uv);\r\n\t}\r\n\tif (fs_in.mid > 0.0)\r\n\t{\r\n\t\tint mid = int(fs_in.mid - 0.5);\r\n\t\tmaskColor = texture(textures[mid], fs_in.mask_uv);\r\n\t}\r\n\tcolor = texColor * maskColor; // vec4(1.0 - maskColor.x, 1.0 - maskColor.y, 1.0 - maskColor.z, 1.0);\r\n};";
	
	private static final String SIMPLE_SHADER = 
			"#shader vertex\r\n#version 330 core\r\n\r\nlayout (location = 0) in vec4 position;\r\nlayout (location = 1) in vec2 uv;\r\nlayout (location = 2) in vec2 mask_uv;\r\nlayout (location = 3) in float tid;\r\nlayout (location = 4) in float mid;\r\nlayout (location = 5) in vec4 color;\r\n\r\nuniform mat4 pr_matrix;\r\n\r\nout DATA\r\n{\r\n\tvec2 uv;\r\n} vs_out;\r\n\r\nvoid main()\r\n{\r\n\tgl_Position = pr_matrix * position;\r\n\tvs_out.uv = uv;\r\n};\r\n\r\n#shader fragment\r\n#version 330 core\r\n\r\nlayout (location = 0) out vec4 color;\r\n\r\nuniform sampler2D tex;\r\n\r\nin DATA\r\n{\r\n\tvec2 uv;\r\n} fs_in;\r\n\r\nvoid main()\r\n{\r\n\tcolor = texture(tex, fs_in.uv);\r\n};";
	
	private static final String BASIC_LIGHT_SHADER = 
			"#shader vertex\r\n#version 330 core\r\n\r\nlayout (location = 0) in vec4 position;\r\nlayout (location = 1) in vec2 uv;\r\nlayout (location = 2) in float tid;\r\nlayout (location = 3) in vec4 color;\r\n\r\nuniform mat4 pr_matrix;\r\nuniform mat4 vw_matrix = mat4(1.0);\r\nuniform mat4 ml_matrix = mat4(1.0);\r\n\r\nout DATA\r\n{\r\n\tvec4 position;\r\n\tvec2 uv;\r\n\tfloat tid;\r\n\tvec4 color;\r\n} vs_out;\r\n\r\nvoid main()\r\n{\r\n\tgl_Position = pr_matrix * vw_matrix * ml_matrix * position;\r\n\tvs_out.position = ml_matrix * position;\r\n\tvs_out.uv = uv;\r\n\tvs_out.tid = tid;\r\n\tvs_out.color = color;\r\n};\r\n\r\n#shader fragment\r\n#version 330 core\r\n\r\nlayout (location = 0) out vec4 color;\r\n\r\nuniform vec4 colour;\r\nuniform vec2 light_pos;\r\n\r\nin DATA\r\n{\r\n\tvec4 position;\r\n\tvec2 uv;\r\n\tfloat tid;\r\n\tvec4 color;\r\n} fs_in;\r\n\r\nuniform sampler2D textures[32];\r\n\r\nvoid main()\r\n{\r\n\tfloat intensity = 1.0 / length(fs_in.position.xy - light_pos);\r\n\tvec4 texColor = fs_in.color;\r\n\tif (fs_in.tid > 0.0)\r\n\t{\r\n\t\tint tid = int(fs_in.tid - 0.5);\r\n\t\ttexColor = fs_in.color * texture(textures[tid], fs_in.uv);\r\n\t}\r\n\tcolor = texColor * intensity;\r\n};";
	
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
