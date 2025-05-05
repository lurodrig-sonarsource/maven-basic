package com.acme.basic;

import java.util.*;

/**
 * This class implements a solution to the 15-puzzle problem using the A* search algorithm.
 * The puzzle consists of a 4x4 grid with 15 numbered tiles and one empty space.
 * The goal is to arrange the tiles in order by making sliding moves into the empty space.
 *
 *
 State Class: Represents the current state of the board, including the position of the empty tile, the number of moves, and the path taken.
 Heuristic Function: Uses the Manhattan distance to estimate the cost to the goal.
 A Algorithm*: Explores states using a priority queue, prioritizing states with the lowest cost (moves + heuristic).
 Direction Encoding: Encodes moves as "U" (up), "D" (down), "L" (left), and "R" (right).
 */

public class Puzzle16 {

    private static final int SIZE = 4;
    private static final int[] DX = {-1, 1, 0, 0};
    private static final int[] DY = {0, 0, -1, 1};

    static class State {
        int[][] board;
        int emptyX, emptyY;
        int moves;
        String path;

        State(int[][] board, int emptyX, int emptyY, int moves, String path) {
            this.board = board;
            this.emptyX = emptyX;
            this.emptyY = emptyY;
            this.moves = moves;
            this.path = path;
        }

        int[][] copyBoard() {
            int[][] copy = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                System.arraycopy(board[i], 0, copy[i], 0, SIZE);
            }
            return copy;
        }

        int heuristic() {
            int h = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    int value = board[i][j];
                    if (value != 0) {
                        int targetX = (value - 1) / SIZE;
                        int targetY = (value - 1) % SIZE;
                        h += Math.abs(i - targetX) + Math.abs(j - targetY);
                    }
                }
            }
            return h;
        }
    }

    public static String solve(int[][] initialBoard) {
        int emptyX = -1, emptyY = -1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (initialBoard[i][j] == 0) {
                    emptyX = i;
                    emptyY = j;
                }
            }
        }

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.moves + s.heuristic()));
        Set<String> visited = new HashSet<>();
        pq.add(new State(initialBoard, emptyX, emptyY, 0, ""));

        while (!pq.isEmpty()) {
            State current = pq.poll();
            if (isSolved(current.board)) {
                return current.path;
            }

            String boardKey = Arrays.deepToString(current.board);
            if (visited.contains(boardKey)) {
                continue;
            }
            visited.add(boardKey);

            for (int d = 0; d < 4; d++) {
                int newX = current.emptyX + DX[d];
                int newY = current.emptyY + DY[d];
                if (isValid(newX, newY)) {
                    int[][] newBoard = current.copyBoard();
                    newBoard[current.emptyX][current.emptyY] = newBoard[newX][newY];
                    newBoard[newX][newY] = 0;
                    String newPath = current.path + direction(d);
                    pq.add(new State(newBoard, newX, newY, current.moves + 1, newPath));
                }
            }
        }

        return "Unsolvable";
    }

    private static boolean isSolved(int[][] board) {
        int value = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - 1 && j == SIZE - 1) {
                    return board[i][j] == 0;
                }
                if (board[i][j] != value++) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    private static String direction(int d) {
        return switch (d) {
            case 0 -> "U";
            case 1 -> "D";
            case 2 -> "L";
            case 3 -> "R";
            default -> "";
        };
    }

    public static void main(String[] args) {
        int[][] board = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        String solution = solve(board);
        System.out.println("Solution: " + solution);
    }
}