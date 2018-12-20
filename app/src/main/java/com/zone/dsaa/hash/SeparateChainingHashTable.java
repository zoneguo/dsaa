package com.zone.dsaa.hash;

import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<Type> {
    private static final int DEF_TABLE_SIZE = 101;

    private List<Type>[] theLists;
    private int currentSize;

    public SeparateChainingHashTable() {
        this(DEF_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    public void insert(Type x) {
        List<Type> targetList = theLists[myHash(x)];
        if (!targetList.contains(x)) {
            targetList.add(x);
        }

        if (++currentSize > theLists.length) {
            // TODO 为什么元素数量超过HashMap的链表数量，就重新hash
            reHash();
        }
    }

    public void remove(Type x) {
        List<Type> targetList = theLists[myHash(x)];
        if (targetList.contains(x)) {
            targetList.remove(x);
            currentSize--;
        }
    }

    public boolean contains(Type x) {
        return theLists[myHash(x)].contains(x);
    }

    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }

        currentSize = 0;
    }

    private void reHash() {

    }

    private int myHash(Type x) {
        int hashVal = x.hashCode();

        hashVal = hashVal%theLists.length;
        if (hashVal < 0) {
            hashVal += theLists.length;
        }
        return hashVal;
    }

    private static int nextPrime(int n) {
        return -1;
    }

    private static boolean isPrime(int n) {
        return false;
    }
}
