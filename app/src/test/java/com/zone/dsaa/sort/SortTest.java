package com.zone.dsaa.sort;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortTest {
    private static final String TAG = "SortTest";
    private Integer[] srcArr = new Integer[]{101, 11, 200, 99, 3, 10, 16, 14, 9, 11};
    private int[] srcArr2 = new int[]{101, 11, 200, 99, 3, 10, 16, 14, 9, 11};


    public void printMethodName() {
        System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Test
    public void insertionSort() {
        printMethodName();
        Sort.insertionSort(srcArr);
        System.out.println(Utils.toString(srcArr));
    }

    @Test
    public void insertSort1() {
        printMethodName();
        Sort.insertionSort1(srcArr);
        System.out.println(Utils.toString(srcArr));
    }

    @Test
    public void heapSort() {
        printMethodName();
        Sort.heapSort(srcArr);
        System.out.println(Utils.toString(srcArr));
    }

    @Test
    public void shellSort() {
        printMethodName();
        Sort.shellSort(srcArr);
        System.out.println(Utils.toString(srcArr));
    }

    @Test
    public void shellSort2() {
        printMethodName();
        Sort.shellSort2(srcArr);
        System.out.println(Utils.toString(srcArr));
    }

    @Test
    public void mergetSort() {
        printMethodName();
        Sort.mergeSort(srcArr);
        System.out.println(Utils.toString(srcArr));
    }

    @Test
    public void mergetSort2() {
        printMethodName();
        Sort.mergetSort2(srcArr2);
        System.out.println(Utils.toString(srcArr2));
    }

    @Test
    public void quickSort1() {
        printMethodName();
        Sort.quickSort1(srcArr, 0, srcArr.length - 1);
        System.out.println(Utils.toString(srcArr));
    }

    @Test
    public void quickSort2() {
        printMethodName();
        Sort.quickSort2(srcArr, 0, srcArr.length - 1);
        System.out.println(Utils.toString(srcArr));
    }


    @Test
    public void quickSort3() {
        printMethodName();
        Sort.quickSort3(srcArr2, 0, srcArr2.length - 1);
        System.out.println(Utils.toString(srcArr2));
    }
}