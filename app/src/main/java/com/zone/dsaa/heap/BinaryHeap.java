package com.zone.dsaa.heap;

public class BinaryHeap {
    private static final int DEF_CAPACITY = 100;
    private Comparable[] array;
    private int currentSize = 0;

    public BinaryHeap() {
        this(DEF_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = new Comparable[capacity + 1];
    }

    public void insert(Comparable x) {
        if (isFull()) {
            enlargeArray(array.length*2 + 1);
        }

        int hole = ++currentSize;
        for (; hole > 1 && x.compareTo(array[hole/2]) < 0; hole /= 2) {
            array[hole] = array[hole/2];
        }

        array[hole] = x;
    }

    public Comparable findMin() {
        if (isEmpty()) {
            return null;
        }

        return array[1];
    }

    public Comparable deleteMin() {
        if (isEmpty()) {
            return null;
        }

        Comparable minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }


    public boolean isFull() {
        return currentSize == array.length - 1;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }

    private void enlargeArray(int capacity) {
        if (capacity <= array.length) {
            throw new IllegalArgumentException();
        }

        Comparable[] newArr = new Comparable[capacity];
        System.arraycopy(array, 0, newArr, 0, array.length);
    }

    private void percolateDown(int hole) {
        Comparable tmp = array[hole];

        int child = 0;

        for (; hole*2 <= currentSize; hole = child) {
            child = hole*2;

            if (child != currentSize && array[child].compareTo(array[child + 1]) > 0) {
                child++;
            }

            if (tmp.compareTo(array[child]) < 0) {
                break;
            } else {
                array[hole] = array[child];
            }
        }

        array[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize /2; i > 0; i--) {
            percolateDown(i);
        }
    }
}
