package com.app;

import com.implementations.ChangeGiver;
import com.injectors.ChangeGiverInjector;
import com.trees.AVLTree;
import com.trees.KeyValuePair;

//TODO Key value pair scales very badly, possibly due to numerous constant time operations

public class ChangeGiverDriver {

    public static void main(String[] args) {
        int[] denoms = {1, 2, 5, 10, 20, 50};
        int amount = 67;

        ChangeGiverInjector changeGiverInjector = new ChangeGiverInjector();
        ChangeGiver changeGiver = changeGiverInjector.getChangeGiverAVL();
        System.out.println(changeGiver.pettyChange(denoms, amount));
    }
}
