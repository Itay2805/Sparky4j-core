# Sparky4j-core
The First Java wrapper for The Cherno's Game Enigne!

This uses the original code and some JNI(Java Native Interface) for using the Engine inside Java!

After alot of optimization, The engine has about the same as the if you would to use the C++ engine! Of course I am still working to optimize the engine even more!

# How to use
Just download the code, and compile the Java project. Also the java project has a Game class and a Test Layer class for you to try out

* Note that the DLLs are compiled for 32bit. So you might need to download 32bit JDK

# Tips for Optimizations
* Try to create your objects outside of the main loop , This is so the there won't be a need to call to native methods of delete and bind.
* Try to avoid changing values inside renderables, this is because there is a need to call a native method to update it nativly.
* Whenever you get a value from a native objects, save it in a temp variable so you won't have to recall the method.

# Changes
Some changes have to be made because of Java's diffrence from C/C++

# Currently in progress
- [x] Wrap the Mask class
- [ ] Wrap the Renderable2D class
- [ ] Wrap the Sprite class
- [x] Wrap all of the PostFX stuff
- [ ] Wrap the SPRenderAPI and make SPOpenGLRenderAPI
- [ ] Optimize (Probably will stay in this list forever :P)

# Links
* sparky game engine - https://github.com/TheCherno/Sparky
* The Cherno youtube channel - https://www.youtube.com/user/TheChernoProject
