package com.app;

import com.implementations.Maze;
import com.injectors.MazeInjector;

public class MazeDriver {

    public static void main(String[] args) {
        MazeInjector mazeInjector = new MazeInjector();
        Maze maze = mazeInjector.getAVL();
        maze.setMaze(new char[][]{
                {'x', 'x', 'x', 'x', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', ' ', ' ', ' ', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', 'x', 'x', ' ', 'x',},
        });

        System.out.println(maze.escape(1,1));
    }
}
