# Sparky4j-core
The First Java wrapper for The Cherno's Game Enigne!

This uses the original code and some JNI(Java Native Interface) for using the Engine inside Java!

* The engine is a bit slower than the C++ version. This is because of how Java handles JNI. For example in the 50k test I got on my computer 300+ FPS (TheCherno got 600+).

# How to use
Just download the code and use the Java Sandbox project!

* Note that the project is configured for running at a 64 bit machine! If you want to use it on 32 bit machine you will have to compile it yourself (both natives and Java files)!
* If you are compiling the C++ code yourself you might need to change in the project properties the location of the includes, libraries.

# Changes
Some changes have to be made because of Java's diffrence from C/C++

* In the window class the method `getMousePosition(double &x, double &y)` is now splited to two methods
  ` getMouseX() ` and ` getMouseY() `. You can also use `getMousePosition()` to get the position in a Vector2

# Currently in progress
* Java Side Font rendering
* Trying to optimize the engine even more
* Some Java Doc, I will do this from time to time.

# Links
* sparky game engine - https://github.com/TheCherno/Sparky
* The Cherno youtube channel - https://www.youtube.com/user/TheChernoProject
