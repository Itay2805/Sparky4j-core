# Sparky4j-core
A Java wrapper for the Cherno's Game Enigne!

This uses the original code and some JNI(Java Native Interface) for using the Engine inside Java!

# How to use
First of all, you can simply copy the Java project and edit it. This is the best way to use the library right now!

If you want to use it in a new project, simply compile all the files inside the package (and sub packages) of ```sp.sparky4j.core``` to a jar file, After it make sure to attach the ```glfw3.dll``` and ```sparky4j-core.dll``` to the project.

To load the native libraries add this to your main class inside Java 
```sh
	static {
		System.loadLibrary("glfw3");
		System.loadLibrary("Sparky4j-core");
	}
```

* Note that the project is configured for running at a 64 bit machine! If you want to use it on 32 bit machine you will have to compile it yourself (both natives and Java files)!
