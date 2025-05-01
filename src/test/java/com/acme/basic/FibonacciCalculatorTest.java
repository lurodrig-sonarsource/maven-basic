package com.acme.basic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class FibonacciCalculatorTest {

    FibonacciCalculator calculator = new FibonacciCalculator();

    @Test
    void calculateFibonacci_zeroElements() {
        List<Integer> result = calculator.calculateFibonacci(0);
        assertTrue(result.isEmpty());
    }

    @Test
    void calculateFibonacci_oneElement() {
        List<Integer> result = calculator.calculateFibonacci(1);
        assertEquals(Arrays.asList(0), result);
    }

    @Test
    void calculateFibonacci_twoElements() {
        List<Integer> result = calculator.calculateFibonacci(2);
        assertEquals(Arrays.asList(0, 1), result);
    }

    @Test
    void calculateFibonacci_multipleElements() {
        List<Integer> result = calculator.calculateFibonacci(10);
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), result);
    }

    @Test
    void calculateFibonacci_twentyElements() {
        List<Integer> result = calculator.calculateFibonacci(20);
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181), result);
    }

    @Test
    void calculateFibonacci_negativeInput() {
        List<Integer> result = calculator.calculateFibonacci(-5);
        assertTrue(result.isEmpty());
    }
}
