package com.github.jonizei.mygameengine;

public class App
{
    public static void main( String[] args )
    {
        // CREATE SEPARATE LAUNCHER
        // GAME FILE USES SOME KIND OF TEMPLATE
        GameLauncher launcher = new GameLauncher(new MyGame());
    }
}
