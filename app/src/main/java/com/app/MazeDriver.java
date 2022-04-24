package com.app;

import com.implementations.Maze;

public class MazeDriver {

    public static void main(String[] args) {
        Maze maze = new Maze();
        System.out.println(maze.escape(1,1));
    }
}
