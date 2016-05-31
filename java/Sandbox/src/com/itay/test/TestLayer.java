package com.itay.test;
import sp.app.Application;
import sp.events.Event;
import sp.graphics.FontManager;
import sp.graphics.Label;
import sp.graphics.Mask;
import sp.graphics.Renderer2D;
import sp.graphics.Renderer2D.RenderTarget;
import sp.graphics.Sprite;
import sp.graphics.Texture;
import sp.graphics.Texture.TextureFilter;
import sp.graphics.Texture.TextureWrap;
import sp.graphics.Window;
import sp.graphics.layers.Layer2D;
import sp.graphics.postfx.PostEffectsPass;
import sp.graphics.shaders.Shader;
import sp.graphics.shaders.ShaderFactory;
import sp.maths.Matrix4;
import sp.maths.Vector3;
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
		renderer.addPostEffectsPass(new PostEffectsPass(Shader.fromFile("Horizontal Blur", "shaders/postfx.shader")));
		renderer.setPostEffects(false);
		
		Texture.setFilter(TextureFilter.NEAREST);
		add(new Sprite(0.0f, 0.0f, 8, 8, new Texture("Tex", "res/tb.png")));
		add(new Sprite(-8.0f, -8.0f, 6, 6, 0xffff00ff));
		
		fps = new Label("", -15.5f, 7.8f, 0xffffffff);
		add(fps);
		
		debugInfo = new Label[10];
		debugInfo[0] = new Label("", -15.5f, 6.8f, 0xffffffff);
		debugInfo[1] = new Label("", -15.5f, 5.8f, 0xffffffff);
		add(debugInfo[0]);
		add(debugInfo[1]);

		Texture.setWrap(TextureWrap.CLAMP_TO_BORDER);
		Mask mask = new Mask(new Texture("mask", "res/mask.png"));
		mask.setTransform(Matrix4.translate(new Vector3(-16.0f, -9.0f, 0.0f)).multiply(Matrix4.scale(new Vector3(32, 18, 1))));
		// layer.setMask(mask);
	}
	
	public void onTick() {
		Application app = Application.getApplication();
		fps.text = app.getFPS() + " fps";
		Log.SPARKY_INFO(app.getUPS() + " ups," + app.getFPS() + " fps");
	}
	
	public void onUpdate() {}
	
	public boolean onEvent(Event event) {
		return false;
	}
	
	public void onRender(Renderer2D renderer) {
		if(window.isKeyTyped(Window.VK_T))
			renderer.setRenderTarget(renderer.getRenderTarget() == RenderTarget.SCREEN ? RenderTarget.BUFFER : RenderTarget.SCREEN);
		if(window.isKeyTyped(Window.VK_P))
			renderer.setPostEffects(!renderer.getPostEffects());
			
		debugInfo[0].text = "Target: " + (renderer.getRenderTarget() == RenderTarget.SCREEN ? "Screen" : "Buffer");
		debugInfo[1].text = "PostFX: " + (renderer.getPostEffects() ? "On" : "Off");
	}

}
