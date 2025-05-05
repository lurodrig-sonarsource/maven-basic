package com.acme.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Puzzle16Test {

    @Test
    void testSolveSolvablePuzzle() {
        int[][] board = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };
        String solution = Puzzle16.solve(board);
        assertNotEquals("Unsolvable", solution);
    }

    @Test
    void testSolveAlreadySolvedPuzzle() {
        int[][] board = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };
        String solution = Puzzle16.solve(board);
        assertEquals("", solution); // No moves needed
    }

    @Test
    void testSolveUnsolvablePuzzle() {
        int[][] board = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 15, 14, 0} // Swapped 14 and 15 makes it unsolvable
        };
        String solution = Puzzle16.solve(board);
        assertEquals("Unsolvable", solution);
    }

    @Test
    void testSolveEmptyTileInCorner() {
        int[][] board = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {0, 13, 14, 15}
        };
        String solution = Puzzle16.solve(board);
        assertNotEquals("Unsolvable", solution);
    }

    @Test
    void testSolveEmptyTileInCenter() {
        int[][] board = {
                {1, 2, 3, 4},
                {5, 6, 0, 8},
                {9, 10, 7, 12},
                {13, 14, 11, 15}
        };
        String solution = Puzzle16.solve(board);
        assertNotEquals("Unsolvable", solution);
    }
}