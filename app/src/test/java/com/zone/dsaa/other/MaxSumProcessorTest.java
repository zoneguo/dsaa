package com.zone.dsaa.other;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumProcessorTest {

    private int arr1[] = new int[]{-2, -3, -1};
    private int arr2[] = new int[]{-2, 10, 23, 1, -2, -9, -111, 20, -90, 102};

    @Test
    public void maxSubSum1() {
        System.out.println("arr1 max subsum = " + MaxSumProcessor.maxSubSum1(arr1));
        System.out.println("arr2 max subsum = " + MaxSumProcessor.maxSubSum1(arr2));
    }

    @Test
    public void maxSubSum2() {
        System.out.println("arr1 max subsum2 = " + MaxSumProcessor.maxSubSum2(arr1));
        System.out.println("arr2 max subsum2 = " + MaxSumProcessor.maxSubSum2(arr2));
    }

    @Test
    public void maxSubSum3() {
        System.out.println("arr1 max subsum3 = " + MaxSumProcessor.maxSubSum3(arr1));
        System.out.println("arr2 max subsum3 = " + MaxSumProcessor.maxSubSum3(arr2));
    }

    @Test
    public void maxSubSum4() {
        System.out.println("arr1 max subsum4 = " + MaxSumProcessor.maxSubSum4(arr1));
        System.out.println("arr2 max subsum4 = " + MaxSumProcessor.maxSubSum4(arr2));
    }
}