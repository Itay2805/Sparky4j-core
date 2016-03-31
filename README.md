# Sparky4j-core
The First Java wrapper for The Cherno's Game Enigne!

This uses the original code and some JNI(Java Native Interface) for using the Engine inside Java!

# How to use
First of all, you can simply copy the Java project and edit it. This is the best way to use the library right now!

If you want to use it in a new project, simply compile all the files inside the package (and sub packages) of `sp.sparky4j.core` to a jar file, After it make sure to attach the `glfw3.dll` and `sparky4j-core.dll` to the project.

To load the native libraries add this to your main class inside Java 
```sh
	static {
		System.loadLibrary("glfw3");
		System.loadLibrary("Sparky4j-core");
	}
```

* Note that the project is configured for running at a 64 bit machine! If you want to use it on 32 bit machine you will have to compile it yourself (both natives and Java files)!

# Changes
Some changes have to be made because of Java's diffrence from C/C++

* In the window class the method ` getMousePosition(double &x, double &y) ` is now slited to two methods
  ` getMouseX() ` and ` getMouseY() `.
* In all the vectors I had to change so instead of variables you will call a function to set and get the value, for example in the vector2 class you will find `x()` and `x(float x)` which are used to set and get the value of x.
* In the matrix class I changed so to get the value at a point you call the `elements(int index)` method and to set the value you call the `elements(int index, float value)`.

# Links
* sparky game engine - https://github.com/TheCherno/Sparky
* The Cherno youtube channel - https://www.youtube.com/channel/UCQ-W1KE9EYfdxhL6S4twUNw
