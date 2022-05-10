package com.app;

import com.implementations.Maze;
import com.injectors.MazeInjector;

public class MazeDriver {

    public static void main(String[] args) {
        MazeInjector mazeInjector = new MazeInjector();
        Maze mazeAVL = mazeInjector.getAVLTreeInstance();

        System.out.println(mazeAVL.escape(1,1));
    }
}
