package sp.sparky4j.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
	
	public static String readFile(String filename) {
		Path path = Paths.get(filename);
		try (BufferedReader br = Files.newBufferedReader(path)) {
			String content = "";
			String currentLine;
			while((currentLine = br.readLine()) != null) { 
				content += currentLine +"\n";
			}
			return content;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
