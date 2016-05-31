package com.itay.test;
import sp.app.Application;

public class Game extends Application {
	
	public static final int WIDTH = 960;
	public static final int HEIGHT = 540;
	
	public Game() {
		super("Sandbox", WIDTH, HEIGHT);
	}
	
	public void init() {
		super.init();
		pushLayer(new TestLayer());
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

}