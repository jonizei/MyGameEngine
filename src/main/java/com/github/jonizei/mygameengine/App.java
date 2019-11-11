package com.github.jonizei.mygameengine;

public class App
{
    public static void main( String[] args )
    {
        // Set GameObject coordinates to center not to up left corner
        GameLauncher launcher = new GameLauncher(new MyGame());
    }
}
