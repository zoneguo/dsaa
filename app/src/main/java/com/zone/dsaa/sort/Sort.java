package com.zone.dsaa.sort;

public class Sort {
    /**
     * 插入排序，这个排序有问题need fix
     * @param arr
     */
    public static void insertionSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (tmp.compareTo(arr[j]) < 0) {
                    arr[j+1] = arr[j];
                } else {
                    arr[j+1] = tmp;
                    break;
                }
            }
            if (j == -1) {
                arr[j+1] = tmp;
            }
        }
    }

    /**
     * 插入排序标准实现
     * @param arr
     */
    public static void insertionSort1(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable tmp = arr[i];

            int j;
            for (j = i; j > 0 && tmp.compareTo(arr[j-1]) < 0; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }

    /**
     * 希尔排序：插入排序的一种改进版本
     * @param arr
     */
    public static void shellSort(Comparable[] arr) {
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j;
                Comparable tmp = arr[i];
                for (j =i; j>= gap && tmp.compareTo(arr[j-gap]) < 0; j -= gap) {
                    arr[j] = arr[j-gap];
                }
                arr[j] = tmp;
            }
        }
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(Comparable[] arr) {
        // build heap arr.lenght/2的选择很重要
        for (int i = arr.length/2; i >= 0; i--) {
            percolateDown(arr, i, arr.length);
        }

        // delete max
        for (int i = arr.length- 1; i > 0; i--) {
            swapReferences(arr, 0, i);
            percolateDown(arr, 0, i);
        }
    }

    private static void swapReferences(Object[] arr, int index1, int index2) {
        Object tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private static int leftChild(int i) {
        return 2*i +1;
    }

    private static void percolateDown(Comparable[] arr, int hole, int size) {
        int child;
        Comparable tmp = arr[hole];

        for (; leftChild(hole) < size; hole = child) {
            child = leftChild(hole);

            // 1. 查找两个孩子中较大者index
            if (child != size-1 && arr[child].compareTo(arr[child+1]) < 0) {
                child++;
            }

            if (tmp.compareTo(arr[child]) < 0) {
                arr[hole] = arr[child];
            } else {
                break;
            }

            arr[hole] = tmp;
        }
    }

    public static void mergeSort(Comparable[] arr) {
        Comparable[] tmpArr = new Comparable[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length -1 );
    }

    private static void mergeSort(Comparable[] arr, Comparable[] tmpArr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, tmpArr, left, center);
            mergeSort(arr, tmpArr, center + 1, right);
            merge(arr, tmpArr, left, center + 1, right);
        }
    }

    private static void merge(Comparable[] arr, Comparable[] tmpArr, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int num = rightEnd - leftPos + 1;

        while( leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos].compareTo(arr[rightPos]) <= 0) {
                tmpArr[tmpPos++] = arr[leftPos++];
            } else {
                tmpArr[tmpPos++] = arr[rightPos++];
            }
        }

        while(leftPos <= leftEnd) {
            tmpArr[tmpPos++] = arr[leftPos++];
        }

        while(rightPos <= rightEnd) {
            tmpArr[tmpPos++] = arr[rightPos++];
        }

        for (int i = 0; i < num; i++, rightEnd--) {
            arr[rightEnd] = tmpArr[rightEnd];
        }
    }

}
