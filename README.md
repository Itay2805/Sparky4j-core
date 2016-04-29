# Sparky4j-core
The First Java wrapper for The Cherno's Game Enigne!

This uses the original code and some JNI(Java Native Interface) for using the Engine inside Java!

* Note, The engine is slower than the C/C++ version because of the way Java and JNI works. For example in the 50K test this engine getts only 35 FPS, but I am working on optimizing the engine so it will be faster!

# How to use
First of all, you can simply copy the Java project and edit it. This is the best way to use the library right now!

To load the native libraries add this to your main class inside Java 
```sh
	static {
		System.loadLibrary("FreeImage");
		System.loadLibrary("glfw3");
		System.loadLibrary("Sparky4j-core");
	}
```

* Note that the project is configured for running at a 64 bit machine! If you want to use it on 32 bit machine you will have to compile it yourself (both natives and Java files)!

# Changes
Some changes have to be made because of Java's diffrence from C/C++

* In the window class the method ` getMousePosition(double &x, double &y) ` is now splited to two methods
  ` getMouseX() ` and ` getMouseY() `.
* In all the vectors I had to change so instead of variables you will call a function to set and get the value, for example in the vector2 class you will find `x()` and `x(float x)` which are used to set and get the value of x.
* In the matrix class I changed so to get the value at a point you call the `elements(int index)` method and to set the value you call the `elements(int index, float value)`.
* All the buffer stuff are not included on the Java side, they are only used internally!
* The Texture class does not contains the `bind()` and `unbind()` methods.

# Currently in progress
* Remaking of the backend so instead of using reflection to get the native handle it will send the long directly; also it avoids objects as parameters and we send raw data. This should increase the engine performance!
* Changing so Vectors and Matrix will be handled in the Java side; this will allow for better performance and easier use.
* Some Java Doc, I will do this from time to time.

# Links
* sparky game engine - https://github.com/TheCherno/Sparky
* The Cherno youtube channel - https://www.youtube.com/user/TheChernoProject
