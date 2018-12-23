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

    }

    public boolean isFull() {
        return currentSize == array.length - 1;
    }

    private void enlargeArray(int capacity) {
        if (capacity <= array.length) {
            throw new IllegalArgumentException();
        }

        Comparable[] newArr = new Comparable[capacity];

    }
}
