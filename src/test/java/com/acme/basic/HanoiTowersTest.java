package com.acme.basic;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HanoiTowersTest {

    /**
     * It verifies that the output of the method matches the expected sequence of moves for a given number of disks.
     * Note: it relies in the system.out of the hanoi class, not good :(
     */
    @Test
    public void testSolve() {
        // Arrange
        HanoiTowers hanoi = new HanoiTowers();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // Act
            hanoi.solve(3, 'A', 'B', 'C');

            // Assert
            String expectedOutput = String.join(System.lineSeparator(),
                    "Move disk 1 from A to C",
                    "Move disk 2 from A to B",
                    "Move disk 1 from C to B",
                    "Move disk 3 from A to C",
                    "Move disk 1 from B to A",
                    "Move disk 2 from B to C",
                    "Move disk 1 from A to C"
            ) + System.lineSeparator();
            assertEquals(expectedOutput, outputStream.toString());
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
}