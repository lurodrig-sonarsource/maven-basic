package com.acme.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortTest {

    @Test
    void testHeapSortWithUnsortedArray() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testHeapSortWithAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testHeapSortWithReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testHeapSortWithSingleElementArray() {
        int[] arr = {42};
        int[] expected = {42};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testHeapSortWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testHeapSortWithDuplicateElements() {
        int[] arr = {4, 2, 4, 3, 2};
        int[] expected = {2, 2, 3, 4, 4};
        HeapSort.heapSort(arr);
        assertArrayEquals(expected, arr);
    }
}