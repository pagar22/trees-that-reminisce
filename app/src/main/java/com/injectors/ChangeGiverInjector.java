package com.injectors;

import com.implementations.ChangeGiver;
import com.trees.AVLTree;
import com.trees.BinaryTreeBase;
import org.checkerframework.checker.units.qual.C;

public class ChangeGiverInjector {

    public ChangeGiver getChangeGiverBase() {
        return new ChangeGiver(new BinaryTreeBase<>());
    }

    public ChangeGiver getChangeGiverAVL() {
        return new ChangeGiver(new AVLTree<>());
    }

}
