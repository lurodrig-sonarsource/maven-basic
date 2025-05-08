package com.acme.basic;

import java.util.ArrayList;
import java.util.List;

public class PegSolitaire {

    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1} // Up, Down, Left, Right
    };

    public static boolean solve(int[][] board) {
        return backtrack(board);
    }

    private static boolean backtrack(int[][] board) {
        if (isSolved(board)) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) { // Find a peg
                    for (int[] dir : DIRECTIONS) {
                        int x1 = i + dir[0];
                        int y1 = j + dir[1];
                        int x2 = i + 2 * dir[0];
                        int y2 = j + 2 * dir[1];

                        if (canJump(board, i, j, x1, y1, x2, y2)) {
                            makeMove(board, i, j, x1, y1, x2, y2);
                            if (backtrack(board)) {
                                return true;
                            }
                            undoMove(board, i, j, x1, y1, x2, y2);
                        }
                    }
                }
            }
        }

        return false;
    }

    private static boolean isSolved(int[][] board) {
        int pegCount = 0;
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 1) {
                    pegCount++;
                }
            }
        }
        return pegCount == 1; // Solved when only one peg remains
    }

    private static boolean canJump(int[][] board, int x, int y, int x1, int y1, int x2, int y2) {
        return isValid(board, x1, y1) && isValid(board, x2, y2) &&
                board[x1][y1] == 1 && board[x2][y2] == 0;
    }

    private static boolean isValid(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != -1;
    }

    private static void makeMove(int[][] board, int x, int y, int x1, int y1, int x2, int y2) {
        board[x][y] = 0;   // Remove peg from the starting position
        board[x1][y1] = 0; // Remove the jumped peg
        board[x2][y2] = 1; // Place peg in the new position
    }

    private static void undoMove(int[][] board, int x, int y, int x1, int y1, int x2, int y2) {
        board[x][y] = 1;   // Restore peg to the starting position
        board[x1][y1] = 1; // Restore the jumped peg
        board[x2][y2] = 0; // Remove peg from the new position
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, 1, 1, 1, -1, -1},
                {-1, -1, 1, 1, 1, -1, -1},
                { 1,  1, 1, 1, 1,  1,  1},
                { 1,  1, 1, 0, 1,  1,  1},
                { 1,  1, 1, 1, 1,  1,  1},
                {-1, -1, 1, 1, 1, -1, -1},
                {-1, -1, 1, 1, 1, -1, -1}
        };

        if (solve(board)) {
            System.out.println("Solved!");
        } else {
            System.out.println("No solution found.");
        }
    }
}