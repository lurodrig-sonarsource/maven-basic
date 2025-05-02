package com.acme.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    @Test
    void testBubbleSortWithUnsortedArray() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSortWithAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSortWithReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSortWithSingleElementArray() {
        int[] arr = {42};
        int[] expected = {42};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSortWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testBubbleSortWithDuplicateElements() {
        int[] arr = {4, 2, 4, 3, 2};
        int[] expected = {2, 2, 3, 4, 4};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }
}