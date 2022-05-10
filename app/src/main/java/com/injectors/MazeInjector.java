package com.injectors;

import com.implementations.Maze;
import com.trees.AVLTree;
import com.trees.BinaryTreeBase;

public class MazeInjector{

    char[][] maze = new char[][]{
            {'x', 'x', 'x', 'x', 'x',},
            {'x', ' ', 'x', ' ', 'x',},
            {'x', ' ', ' ', ' ', 'x',},
            {'x', ' ', 'x', ' ', 'x',},
            {'x', 'x', 'x', ' ', 'x',},
    };

    public Maze getMazeBase() {
        return new Maze(maze, new BinaryTreeBase<>());
    }

    public Maze getMazeAVL() {
        return new Maze(maze, new AVLTree<>());
    }
}
