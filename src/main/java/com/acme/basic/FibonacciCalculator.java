package com.acme.basic;

import java.util.ArrayList;
import java.util.List;

public class FibonacciCalculator {

    public List<Integer> calculateFibonacci(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        List<Integer> fibonacciSequence = new ArrayList<>();
        if (n >= 1) {
            fibonacciSequence.add(0);
        }
        if (n >= 2) {
            fibonacciSequence.add(1);
        }

        for (int i = 2; i < n; i++) {
            int nextFibonacci = fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2);
            fibonacciSequence.add(nextFibonacci);
        }
        return fibonacciSequence;
    }

    public static void main(String[] args) {
        FibonacciCalculator calculator = new FibonacciCalculator();
        int count = 20;
        List<Integer> fibonacciNumbers = calculator.calculateFibonacci(count);
        System.out.println("The first " + count + " Fibonacci numbers are: " + fibonacciNumbers);
    }
}
