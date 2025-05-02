package com.acme.basic;

import org.springframework.stereotype.Service;

@Service
public class AreaCalculator {

    public double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * radius * radius;
    }

    public double calculateSquareArea(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side length cannot be negative");
        }
        return side * side;
    }

    public double calculateTriangleArea(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Base and height cannot be negative");
        }
        return 0.5 * base * height;
    }

    public double calculateHexagonArea(double side) {
        if (side < 0) {
            throw new IllegalArgumentException("Side length cannot be negative");
        }
        return (3 * Math.sqrt(3) * side * side) / 2;
    }
}