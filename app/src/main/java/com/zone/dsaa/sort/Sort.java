package com.zone.dsaa.sort;

public class Sort {
    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Comparable tmp = arr[i];
            int cmpIndex;

            for (cmpIndex = i - 1; cmpIndex >= 0; cmpIndex--) {
                if (tmp.compareTo(arr[cmpIndex]) < 0) {
                    arr[cmpIndex+1] = arr[cmpIndex];
                } else {
                    break;
                }
            }

            arr[cmpIndex+1] = tmp;
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

    public static void shellSort2(Integer[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int gap = arr.length/2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                int curItem = arr[i];
                int j = i;
                for (; j >= gap&&curItem < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = curItem;
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

    /**
     * 归并排序
     * @param arr
     */
    public static void mergeSort(Comparable[] arr) {
        Comparable[] tmpArr = new Comparable[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length -1 );
    }

    public static void mergetSort2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] tmpArr = new int[arr.length];
        mergetSort2(arr, tmpArr, 0, arr.length - 1);
    }

    private static void mergeSort(Comparable[] arr, Comparable[] tmpArr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, tmpArr, left, center);
            mergeSort(arr, tmpArr, center + 1, right);
            merge(arr, tmpArr, left, center + 1, right);
        }
    }

    private static void mergetSort2(int[] arr, int[] tmpArr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergetSort2(arr, tmpArr, left, center);
            mergetSort2(arr, tmpArr, center + 1, right);
            merge2(arr, tmpArr, left, center + 1, right);
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
    private static void merge2(int[] arr, int[] tmpArr, int leftStart, int rightStart, int rightEnd) {
        int leftEnd = rightStart - 1;
        int leftPos = leftStart;
        int rightPos = rightStart;
        int tmpPos = leftPos;

        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos]) {
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

        for (int i = leftStart; i <= rightEnd; i++) {
            arr[i] = tmpArr[i];
        }

    }

    private static final int CUTOFF = 10;

    private static Comparable median3(Comparable[] arr, int left, int right) {
        int center = (left + right) /2;
        if (arr[center].compareTo(arr[left]) < 0) {
            swapReferences(arr, left, center);
        }

        if (arr[right].compareTo(arr[left]) < 0) {
            swapReferences(arr, left, right);
        }

        if (arr[right].compareTo(arr[center]) < 0) {
            swapReferences(arr, center, right);
        }

        //place pivot at position right-1
        swapReferences(arr, center, right -1);
        return arr[right - 1];
    }


    public static void quickSort1(Integer[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length == 1) {
            return;
        }

        int left = head;
        int right = tail;
        int pivot = arr[head];

        while(true) {
            while(arr[left] < pivot) {
                left++;
            }

            while(arr[right] > pivot) {
                right--;
            }

            if (left >= right) {
                break;
            }

            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            left++;
            right--;
        }

        quickSort1(arr, head, left - 1);
        quickSort1(arr, right + 1, tail);
    }


    public static void quickSort2(Integer[] arr, int start, int end) {
        if (start >= end || arr == null || arr.length <= 1) {
            return;
        }

        int mid = partition(arr, start, end);
        quickSort2(arr, start, mid - 1);
        quickSort2(arr, mid + 1, end);
    }

    private static int partition(Integer[] arr, int left, int right) {
        if (left >= right || arr == null || arr.length <= 1) {
            return left;
        }

        int pivot = arr[left];

        while(true) {
            while(arr[left] < pivot) {
                left++;
            }

            while(arr[right] > pivot) {
                right--;
            }

            if (left >= right) {
                break;
            }

            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;

            left++;
            right--;
        }

        return left;
    }


    private static int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp = arr[left];
        while (i < j) {
            while (i < j && arr[j] > tmp) {
                j--;
            }

            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            while (i < j && arr[i] < tmp) {
                i++;
            }

            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = tmp;
        return i;
    }

    public static void quickSort3(int arr[], int left, int right) {
        if(left >= right || arr == null || arr.length <= 1) {
            return;
        }

        int mid = partition(arr, left, right);
        quickSort3(arr, left, mid - 1);
        quickSort3(arr, mid + 1, right);
    }

}
