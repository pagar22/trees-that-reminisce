package com.app;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import com.implementations.ChangeGiver;
import com.implementations.Maze;
import com.injectors.BinaryTreeInjector;
import com.injectors.ChangeGiverInjector;
import com.injectors.MazeInjector;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ImplementationTests {

    @InjectMocks BinaryTreeInjector mazeInjector = new MazeInjector();
    @InjectMocks BinaryTreeInjector changeGiverInjector = new ChangeGiverInjector();
    @Mock Maze maze = (Maze) mazeInjector.getBaseTreeInstance();

    @BeforeClass(alwaysRun = true)
    void testSetup() {
        System.out.println("Implementation Suite Starting Up...");
        MockitoAnnotations.openMocks(this);
    }

    //TODO attributes (depends on, etc.)

    @Test(groups = {"implementation", "maze", "base"})
    public void mazeMockTestBaseTree() {
        doThrow(new InstantiationError()).when(maze).setMaze(new char[][]{
                {'x', 'x', 'x', 'x', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', ' ', ' ', ' ', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', 'x', 'x', ' ', 'x',},
        });
        boolean escaped = maze.escape(1, 1);
        assertTrue(escaped);
    }

    @Test(groups = {"implementation", "maze", "avl"})
    public void mazeMockTestAVLTree() {
        /*doReturn(true).when(maze).setMaze(new char[][]{
                {'x', 'x', 'x', 'x', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', ' ', ' ', ' ', 'x',},
                {'x', ' ', 'x', ' ', 'x',},
                {'x', 'x', 'x', ' ', 'x',},
        });
        boolean escaped = maze.escape(1, 1);
        assertTrue(escaped);*/
    }

    @Test(groups = {"implementation", "change_giver", "base"})
    public void changeGiverMockTestBaseTree() {
        assertEquals(executeChangeGiver((ChangeGiver) changeGiverInjector.getAVLTreeInstance()), 4);
    }

    @Test(groups = {"implementation", "change_giver", "avl"})
    public void changeGiverMockTestAVLTree() {
        assertEquals(executeChangeGiver((ChangeGiver) changeGiverInjector.getAVLTreeInstance()), 4);
    }

    private int executeChangeGiver(ChangeGiver changeGiver) {
        int[] denoms = {1, 2, 5, 10, 20, 50};
        int amount = 67;
        return changeGiver.pettyChange(denoms, amount);
    }


}
