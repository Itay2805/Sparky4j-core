cl.exe /D_USRDLL /D_WINDLL 

src\graphics\window.cpp 
jni\sp_sparky4j_core_graphics_Window.cpp

"C:\Users\home\Documents\Visual Studio 2015\Projects\Sparky4j\dependencies\libs\glfw3.dll"
opengl32.dll

 /link /DLL /OUT:sparky4j-core.dll


SET PATH=C:\Program Files (x86)\Microsoft Visual Studio 14.0\VC\bin
cl.exe /D_USRDLL /D_WINDLL -I "C:\Program Files\Java\jdk1.8.0_73\include\win32" -I "C:\Program Files\Java\jdk1.8.0_73\include" -I "C:\Users\home\Documents\Visual Studio 2015\Projects\Sparky4j\dependencies\include" src\graphics\window.cpp jni\sp_sparky4j_core_graphics_Window.cpp "C:\Users\home\Documents\Visual Studio 2015\Projects\Sparky4j\dependencies\libs\glfw3.lib" opengl32.lib /link /DLL /OUT:sparky4j-core.dll
