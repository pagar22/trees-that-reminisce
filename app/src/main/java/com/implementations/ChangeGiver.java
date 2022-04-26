package com.implementations;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeGiver {


    public int minCoins (ArrayList<Integer> denoms, int amount, int[] memo) {
        int minValue = amount;

        if (denoms.contains(amount)) {
            memo[amount] = 1;
            return 1;
        }
        if (memo[amount] > 0) return memo[amount];

        for(int i : denoms) {
            int numValue = Integer.MAX_VALUE;
            if(i < amount)
                numValue = 1 + minCoins(denoms, amount-i, memo);
            if (numValue < minValue) {
                minValue = numValue;
                memo[amount] = minValue;
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

        int[] memo = new int[amount+1];
        Arrays.fill(memo, 0);

        //BinaryTreeBase<>

        ChangeGiver change = new ChangeGiver();
        System.out.println(change.minCoins(denoms, amount, memo));

    }
}
