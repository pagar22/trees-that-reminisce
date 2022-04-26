package com.app;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import com.implementations.Maze;
import org.mockito.Mock;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ImplementationTests {

    private Maze maze;

    @BeforeClass(alwaysRun = true)
    void testSetup() {
        int row = 10; //never less than 5
        int col = 10; //never less than 5
        assert(row >= 5);
        assert(col >= 5);

        char[][] maze = new char[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                maze[i][j] = 'x';
            }
        }

    }

    @Test(groups = {"maze"})
    public void exitZero() {
        Maze mockMaze = mock(Maze.class);
        System.out.println(mockMaze);
    }

}
