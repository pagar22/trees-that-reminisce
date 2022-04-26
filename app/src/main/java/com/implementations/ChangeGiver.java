package com.implementations;

import com.trees.AVLTree;
import com.trees.BinaryTreeBase;
import com.trees.KeyValuePair;
import com.trees.Node;

public class ChangeGiver {


    public int pettyChange(int[] denoms, int amount, BinaryTreeBase<KeyValuePair<Integer, Integer>> calculated) {
        int minCoins = amount;

        //If there is a deno equal to amount, return 1 (only 1 deno needed)
        for(int i : denoms) if(i==amount) {
            calculated.insert(new KeyValuePair<>(1, amount));
            return 1;
        }

        //If value is already calculated for this amount, don't calculate again
        Node<KeyValuePair<Integer, Integer>> memo = calculated.search(new KeyValuePair<>(amount));
        if (memo != null) return memo.key.key;

        //Else go through all the denoms and find and store min required values recursively
        for(int i : denoms) {
            int numCoins = Integer.MAX_VALUE;
            if(i < amount)
                numCoins = 1 + pettyChange(denoms, amount-i, calculated);
            if (numCoins < minCoins) {
                minCoins = numCoins;
                calculated.insert(new KeyValuePair<>(minCoins, amount));
            }
        }
        return minCoins;
    }

}
