package com.acme.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaCalculatorTest {

    private final AreaCalculator areaCalculator = new AreaCalculator();

    @Test
    void testCalculateCircleArea() {
        assertEquals(Math.PI * 4, areaCalculator.calculateCircleArea(2), 0.0001);
    }

    @Test
    void testCalculateCircleAreaWithNegativeRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                areaCalculator.calculateCircleArea(-1)
        );
        assertEquals("Radius cannot be negative", exception.getMessage());
    }

    @Test
    void testCalculateSquareArea() {
        assertEquals(16, areaCalculator.calculateSquareArea(4), 0.0001);
    }

    @Test
    void testCalculateSquareAreaWithNegativeSide() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                areaCalculator.calculateSquareArea(-1)
        );
        assertEquals("Side length cannot be negative", exception.getMessage());
    }

    @Test
    void testCalculateTriangleArea() {
        assertEquals(10, areaCalculator.calculateTriangleArea(4, 5), 0.0001);
    }

    @Test
    void testCalculateTriangleAreaWithNegativeBase() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                areaCalculator.calculateTriangleArea(-1, 5)
        );
        assertEquals("Base and height cannot be negative", exception.getMessage());
    }

    @Test
    void testCalculateTriangleAreaWithNegativeHeight() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                areaCalculator.calculateTriangleArea(4, -1)
        );
        assertEquals("Base and height cannot be negative", exception.getMessage());
    }

    @Test
    void testCalculateHexagonArea() {
        assertEquals((3 * Math.sqrt(3) * 4 * 4) / 2, areaCalculator.calculateHexagonArea(4), 0.0001);
    }

    @Test
    void testCalculateHexagonAreaWithNegativeSide() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                areaCalculator.calculateHexagonArea(-1)
        );
        assertEquals("Side length cannot be negative", exception.getMessage());
    }
}