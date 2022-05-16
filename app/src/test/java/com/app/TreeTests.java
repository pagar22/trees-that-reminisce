package com.app;

import com.trees.AVLTree;
import com.trees.BinaryTreeBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.testng.Assert.*;

public class TreeTests {

    private final ArrayList<Integer> expected = new ArrayList<>();
    private final BinaryTreeBase<Integer> actualTree = new AVLTree<>();
    int size = 10;
    int randSize;

    @BeforeClass (alwaysRun = true)
    void testSetup() {
        System.out.println("Tree Test Suite Starting Up...");

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int i = size;
        while(i > 0) {
            i--;
            int x = Math.abs(rand.nextInt() % 256);
            if(!expected.contains(x)) {
                expected.add(x);
                actualTree.insert(x);
            } else i++;
        }

        expected.sort(null);
        randSize = rand.nextInt(size);
        System.out.println("Randomized Sorted Array Generated: " + expected);
        System.out.println("Randomized BST Generated (Preorder): " + actualTree);
    }

    @Test(groups = {"tree", "random", "insert"}, priority = 1)
    public void InsertRandomElementInBST() {
        assertEquals(actualTree.inOrder(actualTree.root, new ArrayList<>()).toString(), expected.toString());
    }

    @Test(groups = {"tree", "insert"}, priority = 1)
    public void InsertDuplicateElementInBST() {
        //assertNull(actualTree.insert(expected.get(randSize)));
    }

    //Right Heavy Skewed Tree
    @Test(groups = {"tree", "skewed", "insert"}, priority = 2)
    public void InsertRightHeavySkewedElementsInBST() {
        ArrayList<Integer> expectedLocal = new ArrayList<>(expected);
        BinaryTreeBase<Integer> actualLocal = actualTree;
        actualLocal.clear();
        expectedLocal.sort(null); //sort in ascending order to make right heavy tree
        for (int x : expectedLocal)
            actualLocal.insert(x);

        assertEquals(actualLocal.inOrder(actualLocal.root, new ArrayList<>()).toString(), expectedLocal.toString());
    }

    //Left Heavy Skewed Tree
    @Test(groups = {"tree", "skewed", "insert"}, priority = 3)
    public void InsertLeftHeavySkewedElementsInBST() {
        ArrayList<Integer> expectedLocal = new ArrayList<>(expected);
        BinaryTreeBase<Integer> actualLocal = actualTree;
        actualLocal.clear();
        expectedLocal.sort(Collections.reverseOrder()); //sort in descending order to make left heavy tree
        for (int x : expectedLocal)
            actualLocal.insert(x);
        expectedLocal.sort(null); //sort back to compare with inorder traversal

        assertEquals(actualLocal.inOrder(actualLocal.root, new ArrayList<>()).toString(), expectedLocal.toString());
    }

    @Test(groups = {"tree", "search", "exists"}, priority = 4)
    public void SearchForExistentElementInBST() {
        int x = expected.get(randSize);
        assertEquals((int) actualTree.search(x).key, x);
    }

    @Test (groups = {"tree", "search", "not_exists"}, priority = 5)
    public void SearchForNonExistentElementInBST() {
        assertNull(actualTree.search(-1)); //since negative numbers aren't inserted
    }

    @Test(groups = {"tree", "delete", "exists"}, priority = 6)
    public void DeleteExistentElementFromBST() {
        ArrayList<Integer> expectedLocal = new ArrayList<>(expected);
        BinaryTreeBase<Integer> actualLocal = actualTree;
        int x = expectedLocal.get(randSize);
        expectedLocal.remove((Object) x);
        actualLocal.delete(x);
        assertEquals(actualLocal.inOrder(actualLocal.root, new ArrayList<>()).toString(), expectedLocal.toString());
    }

    /*@Test(groups = {"binary_base", "delete", "not_exists"}, priority = 7)
    public void BSTDeleteDoesNotExist() {
        assertNull(binaryTree.delete(-1)); //since negative numbers aren't inserted
    }*/

    //TODO optimize runtime
    @Test(groups = {"tree", "delete", "exists"}, priority = 8)
    public void DeleteAllElementsInBST() {
        BinaryTreeBase<Integer> actualLocal = actualTree;
        for (Integer key : expected)
            actualLocal.delete(key);
        assertEquals(actualLocal.inOrder(actualLocal.root, new ArrayList<>()).toString(), "[]");
    }

    @AfterClass (alwaysRun = true)
    void testTeardown() {
        System.out.println("Test suite tearing down...");
        expected.clear();
        actualTree.clear();
    }

}
