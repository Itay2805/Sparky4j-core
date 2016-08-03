package com.itay.wrapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.itay.wrapper.util.Base64;

public class CreateEmbedData {
	
	public static void main(String[] args) throws IOException {
		String[] toEmbedStrings = { "embed/SourceSansPro-Light.ttf" };

		for(String file : toEmbedStrings) {
			Path path = Paths.get(file);
			byte[] data = Files.readAllBytes(path);
			String encoded = Base64.encode(data);
			FileOutputStream fos = new FileOutputStream(file + ".embed");
			fos.write(encoded.getBytes());
			fos.close();
		}
	}
	
}
