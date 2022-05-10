package com.app;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.*;

import com.implementations.ChangeGiver;
import com.implementations.Maze;
import com.injectors.BinaryTreeInjector;
import com.injectors.ChangeGiverInjector;
import com.injectors.MazeInjector;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class ImplementationTests {

    private BinaryTreeInjector treeInjector;

    @BeforeClass(alwaysRun = true)
    void testSetup() {
        System.out.println("Implementation Suite Starting Up...");

    }

    //reset the injector after every use
    @AfterMethod(alwaysRun = true)
    void resetInjector() {
        treeInjector = null;
    }

    @BeforeGroups("maze")
    char[][] initMaze() {
        return new char[][]{
                {'x', 'x', 'x', 'x', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', ' ', ' ', ' ', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', 'x', 'x', ' ', 'x',},
        };
    }

    @Test(groups = {"implementation", "maze"})
    public void mazeMockTestBaseTree() {
        treeInjector = new MazeInjector();
        Maze mazeBase = (Maze) treeInjector.getBaseTreeInstance();
        mazeBase.setMaze(initMaze());
        assertTrue(mazeBase.escape(1, 1));
    }

    @Test(groups = {"implementation", "change_giver"})
    public void changeGiverMockTest() {
        treeInjector = new ChangeGiverInjector();
        ChangeGiver changeGiver = (ChangeGiver) treeInjector.getAVLTreeInstance();
        ChangeGiver changeGiverBase = (ChangeGiver) treeInjector.getBaseTreeInstance();
        int[] denoms = {1, 2, 5, 10, 20, 50};
        int amount = 67;
        assertEquals(changeGiver.pettyChange(denoms, amount), 4);
        assertEquals(changeGiverBase.pettyChange(denoms, amount), 4);
    }

}
