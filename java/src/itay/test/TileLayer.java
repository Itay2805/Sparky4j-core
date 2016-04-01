package itay.test;

import sp.sparky4j.core.graphics.BatchRenderer2D;
import sp.sparky4j.core.graphics.Shader;
import sp.sparky4j.core.graphics.layers.Layer;
import sp.sparky4j.core.maths.Matrix4;

public class TileLayer extends Layer {

	protected TileLayer(Shader shader) {
		super(new BatchRenderer2D(), shader, Matrix4.orthographic(-16.0f, 16.0f, -9.0f, 9.0f, -1.0f, 1.0f));
		// TODO Auto-generated constructor stub
	}

}
