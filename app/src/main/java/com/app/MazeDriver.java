package com.app;

import com.implementations.Maze;
import com.injectors.MazeInjector;

public class MazeDriver {

    public static void main(String[] args) {
        MazeInjector mazeInjector = new MazeInjector();
        Maze maze = mazeInjector.getMazeAVL();
        System.out.println(maze.escape(1,1));
    }
}
