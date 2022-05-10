package com.app;

import com.implementations.ChangeGiver;
import com.injectors.ChangeGiverInjector;

//TODO Key value pair scales very badly, possibly due to numerous constant time operations

public class ChangeGiverDriver {

    public static void main(String[] args) {
        ChangeGiverInjector changeGiverInjector = new ChangeGiverInjector();
        ChangeGiver changeGiverAVL = changeGiverInjector.getAVLTreeInstance();

        int[] denoms = {1, 2, 5, 10, 20, 50};
        int amount = 67;
        System.out.println(changeGiverAVL.pettyChange(denoms, amount));
    }
}
