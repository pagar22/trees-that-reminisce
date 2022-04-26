package com.app;

import com.implementations.ChangeGiver;
import com.trees.AVLTree;
import com.trees.KeyValuePair;

//TODO Key value pair scales very badly, possibly due to numerous constant time operations

public class ChangeGiverDriver {

    public static void main(String[] args) {
        int[] denoms = {1, 2, 5, 10, 20, 50};
        int amount = 67;

        AVLTree<KeyValuePair<Integer, Integer>> memo = new AVLTree<>();

        ChangeGiver change = new ChangeGiver();
        System.out.println(change.pettyChange(denoms, amount, memo));

    }
}
