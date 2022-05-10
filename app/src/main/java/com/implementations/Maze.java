package com.implementations;
import com.trees.BinaryTreeInterface;

public class Maze implements Application{

    private char[][] maze;
    private int rows;
    private int cols;
    private final BinaryTreeInterface<String> visited;

    public Maze(BinaryTreeInterface<String> visited) {
        this.visited = visited;
    }

    public boolean escape(int row, int col) {
        if (maze == null) throw new IllegalStateException("Maze must be instantiated first :(");
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

    public void setMaze(char[][] maze) {
        this.maze = maze;
        this.rows =  maze.length - 1;
        this.cols = maze[0].length - 1;
    }

    private String parse(int row, int col) {
        return row + ", " + col;
    }

}
