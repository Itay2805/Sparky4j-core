# Sparky4j-core
The First Java wrapper for The Cherno's Game Enigne!

This uses the original code and some JNI(Java Native Interface) for using the Engine inside Java!

* The engine is a bit slower than the C++ version. This is because of how Java handles JNI (Calling JNI method is about 3 times slower than normal Java method).

# How to use
Just download the code, and compile the Java project. Also the java project has a Game class and a Test Layer class for you to try out

* Note that the DLLs are compiled for 32bit. So you might need to download 32bit JDK

# Tips for Optimizations
* Try to create your objects outside of the main loop , This is so the there won't be a need to call to native methods of delete and bind.
* Try to avoid changing values inside renderables, this is because there is a need to call a native method to update it nativly.
* If I will implement the LowLevel Render API, avoid using it, Only if you really need to use it use it, Calling a native method is about 3 times slower than calling a Java method.
* Whenever you get a value from a native objects, save it in a temp variable so you won't have to recall the method.

# Changes
Some changes have to be made because of Java's diffrence from C/C++

# Currently in progress
* Wrap the Mask class
* Wrap the Renderable2D class (finish)
* Wrap the Sprite class
* Wrap all of the PostFX stuff
* Optimize

# Links
* sparky game engine - https://github.com/TheCherno/Sparky
* The Cherno youtube channel - https://www.youtube.com/user/TheChernoProject
