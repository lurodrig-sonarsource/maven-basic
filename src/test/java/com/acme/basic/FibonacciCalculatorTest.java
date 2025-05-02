package com.acme.basic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciCalculatorTest {

    @Test
    public void testFibonacci() {
        FibonacciCalculator calculator = new FibonacciCalculator();
        assertEquals(0, calculator.fibonacci(0));
        assertEquals(1, calculator.fibonacci(1));
        assertEquals(1, calculator.fibonacci(2));
        assertEquals(2, calculator.fibonacci(3));
        assertEquals(3, calculator.fibonacci(4));
        assertEquals(5, calculator.fibonacci(5));
        assertEquals(8, calculator.fibonacci(6));
        assertEquals(13, calculator.fibonacci(7));
        assertEquals(21, calculator.fibonacci(8));
        assertEquals(34, calculator.fibonacci(9));
    }
}
