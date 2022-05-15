package com.injectors;

import com.applications.Maze;
import com.trees.AVLTree;
import com.trees.BinaryTreeBase;

public class MazeInjector implements BinaryTreeInjector {

    @Override
    public Maze getBaseTreeInstance() {
        return new Maze(new BinaryTreeBase<>());
    }

    @Override
    public Maze getAVLTreeInstance() {
        return new Maze(new AVLTree<>());
    }
}
