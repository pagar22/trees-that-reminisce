package com.injectors;

import com.implementations.ChangeGiver;
import com.trees.AVLTree;
import com.trees.BinaryTreeBase;

public class ChangeGiverInjector implements BinaryTreeInjector{

    @Override
    public ChangeGiver getBaseTreeInstance() {
        return new ChangeGiver(new BinaryTreeBase<>());
    }

    @Override
    public ChangeGiver getAVLTreeInstance() {
        return new ChangeGiver(new AVLTree<>());
    }

}
