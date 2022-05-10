package com.injectors;

import com.implementations.Maze;
import com.trees.AVLTree;
import com.trees.BinaryTreeBase;

public class MazeInjector implements BinaryTreeInjector {

    @Override
    public Maze getBaseTreeInstance() {
        return new Maze(new char[][]{
                {'x', 'x', 'x', 'x', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', ' ', ' ', ' ', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', 'x', 'x', ' ', 'x',},
        }, new BinaryTreeBase<>());
    }

    @Override
    public Maze getAVLTreeInstance() {
        return new Maze(new char[][]{
                {'x', 'x', 'x', 'x', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', ' ', ' ', ' ', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', 'x', 'x', ' ', 'x',},
        }, new AVLTree<>());
    }
}
