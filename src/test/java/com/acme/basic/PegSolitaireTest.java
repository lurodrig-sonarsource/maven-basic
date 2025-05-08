package com.acme.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PegSolitaireTest {

    @Test
    void testSolveSolvableBoard() {
        int[][] board = {
                {-1, -1, 1, 1, 1, -1, -1},
                {-1, -1, 1, 1, 1, -1, -1},
                { 1,  1, 1, 1, 1,  1,  1},
                { 1,  1, 1, 0, 1,  1,  1},
                { 1,  1, 1, 1, 1,  1,  1},
                {-1, -1, 1, 1, 1, -1, -1},
                {-1, -1, 1, 1, 1, -1, -1}
        };
        assertTrue(PegSolitaire.solve(board));
    }

    @Test
    void testSolveUnsolvableBoard() {
        int[][] board = {
                {-1, -1, 1, 1, 1, -1, -1},
                {-1, -1, 1, 1, 1, -1, -1},
                { 1,  1, 1, 1, 1,  1,  1},
                { 1,  1, 1, 1, 1,  1,  1},
                { 1,  1, 1, 1, 1,  1,  1},
                {-1, -1, 1, 1, 1, -1, -1},
                {-1, -1, 1, 1, 1, -1, -1}
        };
        assertFalse(PegSolitaire.solve(board));
    }

    @Test
    void testSolveAlreadySolvedBoard() {
        int[][] board = {
                {-1, -1, 0, 0, 0, -1, -1},
                {-1, -1, 0, 0, 0, -1, -1},
                { 0,  0, 0, 0, 0,  0,  0},
                { 0,  0, 0, 1, 0,  0,  0},
                { 0,  0, 0, 0, 0,  0,  0},
                {-1, -1, 0, 0, 0, -1, -1},
                {-1, -1, 0, 0, 0, -1, -1}
        };
        assertTrue(PegSolitaire.solve(board));
    }

    @Test
    void testSolveEmptyBoard() {
        int[][] board = {
                {-1, -1, 0, 0, 0, -1, -1},
                {-1, -1, 0, 0, 0, -1, -1},
                { 0,  0, 0, 0, 0,  0,  0},
                { 0,  0, 0, 0, 0,  0,  0},
                { 0,  0, 0, 0, 0,  0,  0},
                {-1, -1, 0, 0, 0, -1, -1},
                {-1, -1, 0, 0, 0, -1, -1}
        };
        assertFalse(PegSolitaire.solve(board));
    }

    @Test
    void testSolveSinglePegBoard() {
        int[][] board = {
                {-1, -1, 0, 0, 0, -1, -1},
                {-1, -1, 0, 0, 0, -1, -1},
                { 0,  0, 0, 0, 0,  0,  0},
                { 0,  0, 0, 1, 0,  0,  0},
                { 0,  0, 0, 0, 0,  0,  0},
                {-1, -1, 0, 0, 0, -1, -1},
                {-1, -1, 0, 0, 0, -1, -1}
        };
        assertTrue(PegSolitaire.solve(board));
    }
}