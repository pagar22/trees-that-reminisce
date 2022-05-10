package com.injectors;

import com.implementations.Maze;
import com.trees.AVLTree;
import com.trees.BinaryTreeBase;

public class MazeInjector implements BinaryTreeInjector {

    public Maze getBase() {
        return new Maze(new BinaryTreeBase<>());
    }

    public Maze getAVL() {
        return new Maze(new AVLTree<>());
    }
}
