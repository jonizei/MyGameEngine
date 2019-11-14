package com.github.jonizei.mygameengine;

import com.github.jonizei.mygameengine.gamescene.GameScene;

import java.util.List;

/**
 * This interface ensures that the game has all required methods
 *
 * @author Joni Koskinen
 * @version 2019-11-14
 */
public interface GameAdapter {
    List<GameScene> create();
}
