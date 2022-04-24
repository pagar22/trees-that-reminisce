package com.implementations;

import com.trees.BinaryTreeBase;

public class Maze {

    char[][] maze = {
                    {'x','x','x','x','x',},
                    {'x',' ','x',' ','x',},
                    {'x',' ',' ',' ','x',},
                    {'x',' ','x',' ','x',},
                    {'x','x','x','x','x',},
                    };

    int rows = maze.length;
    int cols = maze[0].length;

    BinaryTreeBase<String> visited = new BinaryTreeBase<>();

    public boolean escape(int row, int col) {
        //if exited the maze, return true
        if (row > rows || col > cols || row < 0 || col < 0) return true;

        //if already visited or in border, return false
        if (visited.search(parse(row, col)) != null || maze[row][col] == 'x') return false;

        else {
            visited.insert(parse(row, col));
            return escape(row + 1, col) || escape(row - 1, col)
                    || escape(row, col + 1) || escape(row, col - 1);
        }
    }

    private String parse(int row, int col) {
        return row + ", " + col;
    }

}
