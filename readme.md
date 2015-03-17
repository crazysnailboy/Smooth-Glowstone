# Smooth Glowstone

A mod which adds smooth glowstone to Minecraft. 

![Screenshot of Smooth Glowstone](http://i.imgur.com/ja68DcK.png)


## Download

[SmoothGlowstone-0.1.jar]()

*Requires Minecraft Forge 11.14.1.1336*



## Build Instructions

1. Execute `gradlew setupDecompWorkspace`. This sets up Forge and downloads the necessary libraries to build the mod. This might take some time, be patient.
    * You will generally only have to do this once until the Forge version in `build.properties` changes.
2. Execute `gradlew build`. If you did everything right, `BUILD SUCCESSFUL` will be displayed after it finishes. This should be relatively quick.
    * If you see `BUILD FAILED`, check the error output (it should be right around `BUILD FAILED`), fix everything (if possible), and try again.
3. Go to '~\SmoothGlowstone\build\libs'.
    * You should see a `.jar` file named 'SmoothGlowstone-<version>.jar`.
4. Copy the jar into your Minecraft mods folder, and you are done!
