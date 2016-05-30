import sp.app.Application;
import sp.events.Event;
import sp.graphics.FontManager;
import sp.graphics.Label;
import sp.graphics.Renderer2D;
import sp.graphics.Renderer2D.RenderTarget;
import sp.graphics.Texture;
import sp.graphics.Texture.TextureFilter;
import sp.graphics.Texture.TextureWrap;
import sp.graphics.Window;
import sp.graphics.layers.Layer2D;
import sp.graphics.shaders.Shader;
import sp.graphics.shaders.ShaderFactory;
import sp.maths.Matrix4;
import sp.utils.Log;

public class TestLayer extends Layer2D {
	
	private Label fps;
	private Label[] debugInfo;
	
	public TestLayer() {
		super(ShaderFactory.defaultShader(), Matrix4.orthographic(-16.0f, 16.0f, -9.0f, 9.0f, -1.0f, 1.0f));
	}
	
	public void onInit(Renderer2D renderer, Shader shader) {
		FontManager.get().setScale(window.getWidth() / 32.0f, window.getHeight() / 18.0f);
		renderer.setRenderTarget(RenderTarget.BUFFER);
		// TODO post effects
		
		Texture.setFilter(TextureFilter.NEAREST);
		// TODO sprite
		
		fps = new Label("", -15.5f, 7.8f, 0xffffffff);
		add(fps);
		
		debugInfo = new Label[10];
		debugInfo[0] = new Label("", -15.5f, 6.8f, 0xffffffff);
		add(debugInfo[0]);
		
		Texture.setWrap(TextureWrap.CLAMP_TO_BORDER);
		// TODO mask
	}
	
	public void onTick() {
		Application app = Application.getApplication();
		fps.text = app.getFPS() + " fps";
		Log.SPARKY_LOG(app.getUPS() + " ups," + app.getFPS() + " fps");
	}
	
	public void onUpdate() {}
	
	public boolean onEvent(Event event) {
		return false;
	}
	
	public void onRender(Renderer2D renderer) {
		if(window.isKeyTyped(Window.VK_T))
			renderer.setRenderTarget(renderer.getRenderTarget() == RenderTarget.SCREEN ? RenderTarget.BUFFER : RenderTarget.SCREEN);
		
		debugInfo[0].text = "Target: " + (renderer.getRenderTarget() == RenderTarget.SCREEN ? "Screen" : "Buffer");
	}

}
