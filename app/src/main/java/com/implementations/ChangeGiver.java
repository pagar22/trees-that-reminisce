package com.implementations;

import com.trees.AVLTree;
import com.trees.BinaryTreeBase;
import com.trees.KeyValuePair;

import java.util.ArrayList;

public class ChangeGiver {


    public int minCoins (ArrayList<Integer> denoms, int amount, BinaryTreeBase<KeyValuePair<Integer, Integer>> memo) {
        int minValue = amount;

        if (denoms.contains(amount)) {
            memo.insert(new KeyValuePair<>(1, amount));
            //memo[amount] = 1;
            return 1;
        }
        if ((memo.search(new KeyValuePair<>(amount)) != null))
            return (memo.search(new KeyValuePair<>(amount))).key.value;

        for(int i : denoms) {
            int numValue = Integer.MAX_VALUE;
            if(i < amount)
                numValue = 1 + minCoins(denoms, amount-i, memo);
            if (numValue < minValue) {
                minValue = numValue;
                memo.insert(new KeyValuePair<>(minValue, amount));
                //memo[amount] = minValue;
            }
        }

        return minValue;
    }

    public static void main(String[] args) {
        ArrayList<Integer> denoms = new ArrayList<>();
        denoms.add(1);
        denoms.add(2);
        denoms.add(3);
        denoms.add(5);
        int amount = 8;

        /*int[] memo = new int[amount+1];
        Arrays.fill(memo, 0);*/

        AVLTree<KeyValuePair<Integer, Integer>> memo = new AVLTree<>();

        ChangeGiver change = new ChangeGiver();
        System.out.println(change.minCoins(denoms, amount, memo));

    }
}
